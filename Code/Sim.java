public class Sim {
    private String namaLengkap;
    //private Pekerjaan pekerjaan;
    private int uang;
    //private Inventory inventory;
    private int kesehatan;
    private int mood;
    private int kekenyangan;
    private String status;

    public Sim(String name){
        this.namaLengkap = name;
        //pekerjaan = new Pekerjaan();
        uang = 100;
        //inventory = new Inventory();
        kesehatan = 80;
        mood = 80;
        kekenyangan = 80;
        status = "";
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

    public void updateUang(String op, int uang){
        if(op.equals("inc")){
            this.uang += uang;
        } else if(op.equals("dec")){
            this.uang -= uang;
        }
        
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public int getKesehatan(){
        return kesehatan;
    }

    public void updateKesehatan(String op, int kesehatan){
        if(op.equals("inc")){
            this.kesehatan += kesehatan;
        } else if(op.equals("dec")){
            this.kesehatan -= kesehatan;
        }
    }

    public int getMood(){
        return mood;
    }

    public void updateMood(String op, int mood){
        if(op.equals("inc")){
            this.mood += mood;
        } else if(op.equals("dec")){
            this.mood -= mood;
        }
    }

    public int getKekenyangan(){
        return kekenyangan;
    }

    public void updateKekenyangan(String op, int kekenyangan){
        if(op.equals("inc")){
            this.kekenyangan += kekenyangan;
        } else if(op.equals("dec")){
            this.kekenyangan -= kekenyangan;
        }
    }
}