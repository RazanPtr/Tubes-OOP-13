public class SusuKacang extends Masakan{
    
    public SusuKacang(){
        super("Susu Kacang", 5);
        this.addBahan(new Susu());
        this.addBahan(new Kacang());
    }
}
