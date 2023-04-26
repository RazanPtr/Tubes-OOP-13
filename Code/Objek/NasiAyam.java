public class NasiAyam extends Masakan{
    
    public NasiAyam(){
        super("Nasi Ayam", 16);
        this.addBahan(new Nasi());
        this.addBahan(new Ayam());
    }
}
