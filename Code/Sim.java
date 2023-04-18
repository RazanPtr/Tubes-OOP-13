public class Sim implements Aksi{
    private String namaLengkap;
    //private Pekerjaan pekerjaan;
    private int uang;
    //private Inventory inventory;
    private String status;
    //private Rumah rumah;
    private Lokasi lokSimRumah;
    private Lokasi lokSimRuang;
    Kesejahteraan kesejahteraan;

    public Sim(String name, int x, int y){
        this.namaLengkap = name;
        //pekerjaan = new Pekerjaan();
        uang = 100;
        //inventory = new Inventory();
        kesejahteraan = new Kesejahteraan();
        status = null;
        //rumah = new Rumah();
        //buat ruangan kamar barunya di Rumah.java ??
        lokSimRuang = new Lokasi(1,1); // ini awalnya pasti di kamar,, tp lokasinya (1,1) kah
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

    // public Pekerjaan getPekerjaan(){
    //     return pekerjaan;
    // }

    // public void setPekerjaan(Pekerjaan p){
    //     this.pekerjaan = p;
    // }

    public void kerja(int durasi){
    //implementasi kerja
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

    public void beliBarang(int durasi){
    //implementasi beliBarang
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
        }

        public void updateKekenyangan(int kekenyangan){
            this.kekenyangan += kekenyangan;
        }

        public void updateMood(int mood){
            this.mood += mood;
        }

        public boolean getIsMati(){
            return isMati;
        }

        public void displayKesejahteraan(){
            System.out.println("Mood : " + mood);
            System.out.println("Kekenyangan : " + kekenyangan);
            System.out.println("Kesehatan : " + kesehatan);
        }
    }
}