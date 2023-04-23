import java.util.Random;

public class Sim implements Aksi{
    private String namaLengkap;
    private WorkObject pekerjaan;
    private int uang;
    //private Inventory inventory;
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
        rumah = new Rumah(x, y);
        //buat ruangan kamar barunya di Rumah.java ??
        lokSimRuang = new Lokasi(0,0); // ini awalnya pasti di kamar,, tp lokasinya (0,0) kah
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
    }

    public void makan(int durasi){
    //implementasi makan
    }

    public void memasak(int durasi){
    //implementasi memasak
    }

    public void berkunjung(int durasi){
    //implementasi berkunjung
    }

    public void buangAir(int durasi){
        //implementasi buangAir
    }

    public void upgradeRumah(Lokasi lokSimRumah, int durasi){
    //implementasi upgradeRumah
    }

    public void beliBarang(){
        Random rand = new Random();
        int waktuPengiriman = rand.nextInt(1.5) * 30;
        System.out.println("Barang akan tiba dalam " + waktuPengiriman + " detik.");
        try {
            Thread.sleep(waktuPengiriman * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Barang telah masuk ke dalam inventory.");
    }

    public void pindahRuangan(){
    //implementasi pindahRuangan
    }

    public void karaoke(int durasi){
    //implementasi karaoke
    }

    public void melukis(int durasi){
    //implementasi melukis
    }

    public void simpanBarang(){
    //implementasi simpanBarang
    }

    public void pindahBarang(){
    //implementasi pindhBarang 
    }

    public void sholat(int durasi){
    //implementasi sholat
    }

    public void mandi(int durasi){
    //implementasi mandi
    }

    public void nontonNetflix(int durasi){
    //implementasi nontonNetflix
    }

    public void lihatInventory(){
    //implementasi lihat Inventory
    }

    public void pasangBarang(){
    //implementasi pasangBarang
    }

    public void lihatWaktu(){
    //implementasi lihatWaktu
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