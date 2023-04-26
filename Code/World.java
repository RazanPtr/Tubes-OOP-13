import java.util.*;

public class World {
    private int panjang;
    private int lebar;
    private ArrayList<Rumah> perumahan;
    
    //Penerapan Singleton Pattern
    private static World instance = null;

    private World() {
        panjang = 64;
        lebar = 64;
        perumahan = new ArrayList<Rumah>();
    }

    public static World getInstance() {
        if (instance == null) {
            instance = new World();
        }
        return instance;
    }

    public int getArea() {
        return panjang * lebar;
    }

    public int getPanjang() {
        return panjang;
    }

    public int getLebar() {
        return lebar;
    }

    public int sisaKapasitas() {
        int totalSquares = getArea();
        int occupiedSquares = perumahan.size();
        int remainingSquares = totalSquares - occupiedSquares;
        return remainingSquares;
    }
}
