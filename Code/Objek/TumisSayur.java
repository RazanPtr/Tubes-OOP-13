public class TumisSayur extends Masakan{
    
    public TumisSayur(){
        super("Tumis Sayur", 5);
        this.addBahan(new Wortel());
        this.addBahan(new Bayam());
    }
}
