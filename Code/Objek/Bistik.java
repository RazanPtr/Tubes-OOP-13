package objek;

public class Bistik extends Masakan{
    
    public Bistik(){
        super("Bistik", 22);
        this.addBahan(new Kentang());
        this.addBahan(new Sapi());
    }
}
