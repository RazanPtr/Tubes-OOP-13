package objek;
import java.util.ArrayList;

public class Masakan extends ObjectSim{
    private ArrayList<BahanMakanan> bahan;
    private int tingkatKenyang;

    public Masakan(String nama, int tingkatKenyang){
        super(nama);
        this.tingkatKenyang = tingkatKenyang;
        bahan = new ArrayList<BahanMakanan>();
    }

    public void addBahan(BahanMakanan b){
        bahan.add(b);
    }

    public ArrayList<BahanMakanan> getBahan(){
        return bahan;
    }

    public int getTingkatKenyang(){
        return tingkatKenyang;
    }   
}
