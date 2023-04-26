import java.util.Random;

public class Sim implements Aksi{
    private String namaLengkap;
    private WorkObject pekerjaan;
    private int uang;
    private Inventory <Object> inventory;
    private String status;
    private Rumah rumah;
    private Lokasi lokSimRumah;
    private Lokasi lokSimRuang;
    Kesejahteraan kesejahteraan;

    public Sim(String name, int x, int y){
        this.namaLengkap = name;
        pekerjaan = new WorkObject();
        uang = 100;
        //inventory = new Inventory();
        kesejahteraan = new Kesejahteraan();
        status = null;
        //rumah = new Rumah();
        //buat ruangan kamar barunya di Rumah.java ??
        lokSimRuang = new Lokasi(0,0); // ini awalnya pasti di kamar,, tp lokasinya (0, 0) kah
        lokSimRumah = new Lokasi(x, y); //ini lokasi awal rumahnya input dari pengguna kan?!
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

    public Lokasi getLokRuang(){
        return lokSimRuang;
    }
    
    public Rumah getRumah(){
        return rumah;
    }

    public void kerja(int durasi){
        this.setStatus("kerja");
        kesejahteraan.updateKekenyangan((-10)*(durasi/30));
        kesejahteraan.updateMood((-10)*(durasi/30));
    }

    public void olahraga(int durasi){
       //implementasi olahraga
       this.setStatus("olahraga");
       kesejahteraan.updateKesehatan(5*(durasi/20));
       kesejahteraan.updateKekenyangan((-5)*(durasi/20));
       kesejahteraan.updateMood(10*(durasi/20));
    }

    public void tidur(int durasi){
    //implementasi tidur
        if(durasi >= 3*60){
            this.setStatus("tidur");
            kesejahteraan.updateKesehatan(20*(durasi/(4*60)));
            kesejahteraan.updateMood(30*(durasi/(4*60)));
        }
    }

    public void tidaktidur(){
        kesejahteraan.updateKesehatan(-5);
        kesejahteraan.updateMood(-5);
    }

    public void makan(int durasi, ObjectSim ob){
    //implementasi makan
    }

    public void memasak(ObjectSim ob){
    //implementasi memasak
    }

    public void berkunjung(int durasi){
    //implementasi berkunjung
    }

    public void buangAir(int durasi){
        //implementasi buangAir
        kesejahteraan.updateKekenyangan((-20)*(durasi/10));
        kesejahteraan.updateMood((10)*(durasi/10));
    }

    public void tidakBuangAir(){
        //implementasi tidak buangAir
        kesejahteraan.updateKesehatan(-5);
        kesejahteraan.updateMood(-5);

    }

    public void upgradeRumah(Lokasi lokSimRumah, Lokasi lokSimRuangan, String nama, int x, int y){
    //implementasi upgradeRumah
    }

    public void beliBarang(int durasi, ObjectSim ob, int kuantitas){
        Random rand = new Random();
        int waktuPengiriman = rand.nextInt(1.5) * 30;
        System.out.println("Barang akan tiba dalam " + waktuPengiriman + " detik.");
        try {
            Thread.sleep(waktuPengiriman * 1000);
            this.inventory.addItem(ob,kuantitas);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Barang telah masuk ke dalam inventory.");}

    public void pindahRuangan(Lokasi lok){
    //implementasi pindahRuangan
    }

    public void karaoke(int durasi){
    //implementasi karaoke
        this.setStatus("karaoke");
        kesejahteraan.updateMood(10*(durasi/30));
        kesejahteraan.updateKekenyangan((-10)*(durasi/30));
        System.out.println("baby shark duduruddudu");
    }

    public void melukis(int durasi){
    //implementasi melukis
        this.setStatus("melukis");
        kesejahteraan.updateMood(5*(durasi/20));
        kesejahteraan.updateKekenyangan(5*(durasi/20));
    }

    public void simpanBarang(Lokasi lok, ObjectSim ob){
    //implementasi simpanBarang
        if(ob instanceof Furniture){
            this.setStatus("simpan barang");
            rumah.searchRoom(lok).getObjects().remove(ob);
            inventory.addItem(ob, 1);
        }
    }

    public void pindahBarang(Lokasi lokAwal, ObjectSim ob, Lokasi lokAkhir, Lokasi lokRuang){
    //implementasi pindhBarang
        simpanBarang(lokAwal, ob);
        pasangBarang(lokRuang, ob, lokAkhir);
    }

    public void sholat(int durasi){
    //implementasi sholat
        this.setStatus("sholat");
        kesejahteraan.updateMood(30);
    }

    public void mandi(int durasi){
    //implementasi mandi
        this.setStatus("mandi");
        kesejahteraan.updateKesehatan(30);
        kesejahteraan.updateMood(10);
    }

    public void nontonNetflix(int durasi){
    //implementasi nontonNetflix
        this.setStatus("menonton netflix");
        kesejahteraan.updateMood(15*(durasi/40));
        kesejahteraan.updateKekenyangan((-10)*(durasi/40));
        kesejahteraan.updateKesehatan((-2)*(durasi/40));
    }

    public void lihatInventory(){
    //implementasi lihat Inventory
        inventory.showInventory();
        
    }

    public void pasangBarang(Lokasi lokRuang, ObjectSim ob, Lokasi lokBarang){
    //implementasi pasangBarang
        this.setStatus("memasang barang");
        boolean can = rumah.searchRoom(lokRuang).placeObject(ob, lokBarang);
        if(can){
            rumah.searchRoom(lokRuang).getObjects().add(ob);
            inventory.addItem(ob, -1);
        }
        else{
            System.out.println("Tidak dapat memasang barang di lokasi tersebut.");
        }
        
    
        
        
    }

    public void lihatWaktu(){
    //implementasi lihatWaktu
    }

    public void gantiPekerjaan(WorkObject w, int durasiKerja){
    //implementasi ganti pekerjaan
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