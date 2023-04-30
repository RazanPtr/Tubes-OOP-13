package util;
import java.util.Random;
import java.util.*;
import objek.*;

public class Sim implements Aksi{
    private String namaLengkap;
    private WorkObject pekerjaan;
    private int uang;
    private Inventory<ObjectSim> inventory;
    private String status;
    private Rumah rumah;
    private Lokasi lokSimRumah;
    private Ruangan lokSimRuang;
    private ObjectSim curObject;
    private Time time;
    private int awalKerja;
    private int lamaKerja;
    private int durasiTidur;
    private boolean sudahTidur;
    private boolean sudahMakan;
    private boolean sudahBuangAir;
    Kesejahteraan kesejahteraan;

    public Sim(String name, int x, int y){
        this.namaLengkap = name;
        pekerjaan = new WorkObject();
        uang = 100;
        inventory = new Inventory<ObjectSim>();
        kesejahteraan = new Kesejahteraan();
        status = null;
        rumah = new Rumah(x,y);
        curObject = null;
        lokSimRuang = rumah.getRoom("Kamar"); 
        lokSimRumah = rumah.getLokRumah(); //ini lokasi awal rumahnya input dari pengguna kan?!
        durasiTidur = 0;
        sudahTidur = false;
        inventory.addItem(new KasurSingle(), 1);
        inventory.addItem(new Toilet(), 1);
        inventory.addItem(new KomporGas(), 1);
        inventory.addItem(new Jam(), 1);
        inventory.addItem(new MejaKursi(), 1);
    }

    public String getNamaLengkap(){
        return namaLengkap;
    }


    public void setNamalengkap(String namaLengkap){
        this.namaLengkap = namaLengkap;
    }

    public int getUang(){
        return uang;
    }

    public void setUang(int uang){
        this.uang = uang;
    }

    public void updateUang(int uang){
        this.uang += uang;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public WorkObject getPekerjaan(){
        return pekerjaan;
    }

    public void setPekerjaan(WorkObject p){
        this.pekerjaan = p;
    }

    public Lokasi getLokSimRumah(){
        return lokSimRumah;
    }

    public Ruangan getLokRuang(){
        return lokSimRuang;
    }

    public void setCurObject(ObjectSim obj) {
        curObject = obj;
    }

    public ObjectSim getCurObject(ObjectSim obj) {
        return curObject;
    }
    
    public Rumah getRumah(){
        return rumah;
    }

    public void setLokSimRumah(Lokasi lok){
        this.lokSimRumah = lok;
    }

    public void setLokSimRuang(Ruangan r){
        this.lokSimRuang = r;
    }

    public void kerja(int durasi){
        awalKerja = time.getTimeInSec();
        if(durasi <= 0){
            throw new IllegalArgumentException("durasi harus lebih dari 0 detik");
        }
        if(durasi %120 != 120){
            throw new IllegalArgumentException("durasi kerja harus kelipatan 120 detik");
        }
        time.AksiSleep(durasi);
        this.setStatus("kerja");
        kesejahteraan.updateKekenyangan((-10)*(durasi/30));
        kesejahteraan.updateMood((-10)*(durasi/30));
        if(durasi >= (4*60)){
            this.uang += getPekerjaan().getJob().getPayRate();
        }
    }

    public void olahraga(int durasi){
        if(durasi <= 0){
            throw new IllegalArgumentException("durasi harus lebih dari 0 detik");
        }
        if(durasi % 20 != 0){
            throw new IllegalArgumentException("durasi harus lebih dari 0 detik");
        }
        time.AksiSleep(durasi);
        this.setStatus("olahraga");
        kesejahteraan.updateKesehatan(5*(durasi/20));
        kesejahteraan.updateKekenyangan((-5)*(durasi/20));
        kesejahteraan.updateMood(10*(durasi/20));
    }

    public void tidur(int durasi){
        if(durasi <= 0){
            throw new IllegalArgumentException("durasi harus lebih dari 0 detik");
        }
        time.AksiSleep(durasi);
        this.setStatus("tidur");
        durasiTidur += durasi;
        checkTidur();
    }

    public void checkTidur(){
        if(durasiTidur >= (4*60)){
            kesejahteraan.updateKesehatan(20*(durasiTidur/(4*60)));
            kesejahteraan.updateMood(30*(durasiTidur/(4*60)));
            durasiTidur -= (durasiTidur/(4*60));
            sudahTidur = true;
        } 
    }

    public boolean getTidur(){
        return sudahTidur;
    }

    public void resetHarian(){
        durasiTidur = 0;
        sudahTidur = false;
        sudahBuangAir = false;
        sudahMakan = false;
    }

    public void tidakTidur(){
        kesejahteraan.updateKesehatan(-5);
        kesejahteraan.updateMood(-5);
    }

    public void makan(int durasi, ObjectSim ob){
    //implementasi makan
        if(ob instanceof Masakan){   
            Masakan m = (Masakan) ob; 
            if(inventory.getItem().contains(m)){
                time.AksiSleep(durasi);
                this.setStatus("Makan");
                inventory.removeItem(m, 1);
                kesejahteraan.updateKekenyangan((m.getTingkatKenyang())*(durasi/30));
                sudahMakan = true;
            }
        }
    }

    public void memasak(ObjectSim ob){ 
    //implementasi memasak
        if(ob instanceof Masakan){
            Masakan m = (Masakan) ob;
            ArrayList<BahanMakanan> listResep = new ArrayList<BahanMakanan>(m.getBahan());
            boolean bisa = true;
            for(BahanMakanan bm : listResep){
                if(!inventory.getItem().contains(bm)){
                    bisa = false;
                }
            }
            if(bisa){
                this.setStatus("memasak");
                try {
                    Thread.sleep((3/2)*m.getTingkatKenyang()* 1000);
                    time.updateTime((3/2)*m.getTingkatKenyang()* 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(BahanMakanan bm : listResep){
                    inventory.removeItem(ob, 1);
                    uang -= bm.getPrice();
                }
                inventory.addItem(ob, 1);
                kesejahteraan.updateMood(10);
                //double durasiMasak = (1.5) * m.getTingkatKenyang();
            }
        }
    }
    
    public void berkunjung(int durasi, Lokasi lokasiTujuan) { // perlu cek rumah yang dituju tuh ada di world (dalem perumahan) apa ngga gasi(??)
        double waktuKunjungan = Math.sqrt(Math.pow(lokasiTujuan.getX() - lokSimRumah.getX(), 2)
                + Math.pow(lokasiTujuan.getY() - lokSimRumah.getY(), 2));

        durasi += waktuKunjungan;
        time.AksiSleep(durasi);
        kesejahteraan.updateMood(10 * (durasi / 30));
        kesejahteraan.updateKekenyangan(-10 * (durasi / 30));
    }

    //public void 

    public void buangAir(int durasi){
        //implementasi buangAir
        if(durasi <= 0){
            throw new IllegalArgumentException("durasi harus lebih dari 0 detik");
        }
        if(sudahMakan){
            time.AksiSleep(durasi);
            kesejahteraan.updateKekenyangan((-20)*(durasi/10));
            kesejahteraan.updateMood((10)*(durasi/10));
            sudahBuangAir = true;
        }
        else{
            System.out.println("Sim belum makan pada hari ini");
        }
            
    }

    public void tidakBuangAir(){
        //implementasi tidak buangAir
        kesejahteraan.updateKesehatan(-5);
        kesejahteraan.updateMood(-5);

    }

    public void upgradeRumah(){
        rumah.addRuangan(lokSimRuang);
    }

    public void beliBarang(int durasi, ObjectSim ob, int kuantitas){
        if(ob instanceof Furniture){
            Furniture obj = (Furniture) ob;
            if(uang-obj.getPrice()*kuantitas>=0){
                uang-=obj.getPrice()*kuantitas;
                Random rand = new Random();
                int waktuPengiriman = rand.nextInt(3/2) * 30;
                System.out.println("Barang akan tiba dalam " + waktuPengiriman + " detik.");
                time.AksiSleep(durasi);
                inventory.addItem(ob, kuantitas);
                System.out.println("Barang telah masuk ke dalam inventory.");
                }
            else{
                System.out.println("Uang sim tidak cukup untuk membeli barang");
            }
            }
        else if(ob instanceof BahanMakanan){
            BahanMakanan obj = (BahanMakanan) ob;
            if(uang-obj.getPrice()*kuantitas>=0){
                uang-=obj.getPrice()*kuantitas;
                 Random rand = new Random();
                int waktuPengiriman = rand.nextInt(3/2) * 30;
                System.out.println("Barang akan tiba dalam " + waktuPengiriman + " detik.");
                time.AksiSleep(durasi);
                System.out.println("Barang telah masuk ke dalam inventory.");
                }
            else{
                System.out.println("Uang sim tidak cukup untuk membeli barang");
                }
            }
        else{
            System.out.println("Barang tersebut tidak bisa dibeli");
        }
        }

    public void pindahRuangan(Lokasi lok){
    //implementasi pindahRuangan
    }

    public void karaoke(int durasi){
    //implementasi karaoke
        time.AksiSleep(durasi);
        this.setStatus("karaoke");
        kesejahteraan.updateMood(10*(durasi/30));
        kesejahteraan.updateKekenyangan((-10)*(durasi/30));
        System.out.println("baby shark dudurudduduuu");
    }

    public void melukis(int durasi){
    //implementasi untuk melukis
        time.AksiSleep(durasi);
        this.setStatus("Melukis");
        kesejahteraan.updateMood(5*(durasi/20));
        kesejahteraan.updateKekenyangan(5*(durasi/20));
    }

    public void simpanBarang(String lok, ObjectSim ob){
    //implementasi simpanBarang
        if(ob instanceof Furniture){
            this.setStatus("simpan barang");
            if(rumah.getRoom(lok) != null){
                rumah.getRoom(lok).getObjects().remove(ob);
            }
            inventory.addItem(ob, 1);
        }
    }

    public void pindahBarang(String lokAwal, ObjectSim ob, Lokasi lokAkhir, String lokRuang){
    //implementasi pindhBarang
        simpanBarang(lokAwal, ob);
        pasangBarang(lokRuang, ob, lokAkhir);
    }

    public void sholat(int durasi){
    //implementasi sholat
        time.AksiSleep(durasi);
        this.setStatus("sholat");
        kesejahteraan.updateMood(30);
    }

    public void mandi(int durasi){
    //implementasi mandi
        time.AksiSleep(durasi);
        this.setStatus("mandi");
        kesejahteraan.updateKesehatan(30);
        kesejahteraan.updateMood(10);
    }

    public void nontonNetflix(int durasi){
    //implementasi nontonNetflix
        time.AksiSleep(durasi);
        this.setStatus("menonton netflix");
        kesejahteraan.updateMood(15*(durasi/40));
        kesejahteraan.updateKekenyangan((-10)*(durasi/40));
        kesejahteraan.updateKesehatan((-2)*(durasi/40));
    }

    public void lihatInventory(){
    //implementasi lihat Inventory
        inventory.showInventory();
    }

    public void pasangBarang(String lokRuang, ObjectSim ob, Lokasi lokBarang){
    //implementasi pasangBarang
        this.setStatus("memasang barang");
        if(ob instanceof Furniture){
            Furniture f = (Furniture) ob;
            boolean can = rumah.getRoom(lokRuang).canPlaceObj(lokBarang, f);
            if(can){
                rumah.getRoom(lokRuang).getObjects().add(f);
                inventory.addItem(ob, -1);
            }
            else{
                System.out.println("Tidak dapat memasang barang di lokasi tersebut. Coba rotate barang atau pindahkan ke ruangan lain.");
            }
        }
        
        
    }

    public void lihatWaktu(){
    //implementasi lihatWaktu
        time.CetakWaktu();
    }

    public void gantiPekerjaan(WorkObject w){
        lamaKerja = time.getTimeInSec()-awalKerja;
        if(lamaKerja > 12*60 && uang >= (1/2*w.getJob().getPayRate())){    
            setPekerjaan(w);
            uang -= 1/2*w.getJob().getPayRate();
        } else{
            System.out.println("Lama bekerja belum 1 hari atau uang tidak mencukupi!");
        }
    }

    public void displayInfo(){
        System.out.println("Nama Lengkap          : " + namaLengkap);
        System.out.println("Pekerjaan             : "+ getPekerjaan().getJob().getTitle());
        System.out.println("Tingkat Kesehatan     : " + kesejahteraan.getKesehatan());
        System.out.println("Tingkat Kekenyangan   : " + kesejahteraan.getKekenyangan());
        System.out.println("Tingkat Mood          : " + kesejahteraan.getMood());
        System.out.println("Jumlah uang saat ini  :" + uang);
    }

    public class Kesejahteraan {
        private int mood;
        private int kekenyangan;
        private int kesehatan;
        private boolean isMati;
        private String statusMati;

        public Kesejahteraan() {
            mood = 80;
            kekenyangan = 80;
            kesehatan = 80;
        }

        public int getMood(){
            return mood;
        }

        public int getKesehatan(){
            return kesehatan;
        }

        public int getKekenyangan(){
            return kekenyangan;
        }

        public void updateKesehatan(int kesehatan){
            this.kesehatan += kesehatan;
            if(this.kesehatan > 100){
                this.kesehatan = 100;
            }  else if(this.mood <= 0){
                isMati = true;
                statusMati = "Sim mati karena sakit :<";
            }
        }

        public void updateKekenyangan(int kekenyangan){
            this.kekenyangan += kekenyangan;
            if(this.kekenyangan > 100){
                this.kekenyangan = 100;
            }  else if(this.mood <= 0){
                isMati = true;
                statusMati = "Sim mati karena kelaparan :<";
            }
        }

        public void updateMood(int mood){
            this.mood += mood;
            if(this.mood > 100){
                this.mood = 100;
            } else if(this.mood <= 0){
                isMati = true;
                statusMati = "Sim mati karena mengalami depresi :<";
            }
        }

        public boolean getIsMati(){
            return isMati;
        }

        public String getStatusMati(){
            return statusMati;
        }

        public void setStatusMati(String s){
            this.statusMati = s;
        }

        public void displayKesejahteraan(){
            System.out.println("Mood : " + mood);
            System.out.println("Kekenyangan : " + kekenyangan);
            System.out.println("Kesehatan : " + kesehatan);
        }
    }
}
