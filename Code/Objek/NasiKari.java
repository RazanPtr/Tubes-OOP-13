public class NasiKari extends Masakan{
    
    public NasiKari(){
        super("Nasi Kari", 30);
        this.addBahan(new Nasi());
        this.addBahan(new Kentang());
        this.addBahan(new Wortel());
        this.addBahan(new Sapi());
    }
}
