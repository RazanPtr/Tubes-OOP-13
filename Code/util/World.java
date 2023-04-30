package util;
import java.util.*;

public class World {
    private int panjang;
    private int lebar;
    private ArrayList<Rumah> perumahan;
    private Time t;
    
    //Penerapan Singleton Pattern
    private static World instance = null;

    private World() {
        panjang = 64;
        lebar = 64;
        perumahan = new ArrayList<Rumah>();
        t = new Time();
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

    public void addRumah(Rumah r){
        perumahan.add(r);
    }

    public boolean isRumahAvailable(int lokX, int lokY){
        for(Rumah rumah : perumahan){
            if(lokX == rumah.getLokRumah().getX() && lokY == rumah.getLokRumah().getY()){
                return false;
            }
        }
        return true;
    }

    public ArrayList<Rumah> getPerumahan(){
        return perumahan;
    }

    public Rumah getRumah(Lokasi lok){
        for(Rumah rumah : perumahan){
            if(lok == rumah.getLokRumah()){
                return rumah;
            }
        }
        return null;
    }

    public Time getTime(){
        return t;
    }
}
