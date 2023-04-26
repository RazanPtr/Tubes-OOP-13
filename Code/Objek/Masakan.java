import java.util.ArrayList;

public class Masakan extends ObjectSim  {
    private String nama;
    private ArrayList<BahanMakanan> bahan;
    private int tingkatKenyang;

    public Masakan(String nama, ArrayList<BahanMakanan> bahan, int tingkatKenyang) {
        super(nama);
        this.bahan = bahan;
        this.tingkatKenyang = tingkatKenyang;
    }

    public String getNama() {
        return nama;
    }

    public ArrayList<BahanMakanan> getBahan() {
        return bahan;
    }

    public int getTingkatKenyang() {
        return tingkatKenyang;
    }
}