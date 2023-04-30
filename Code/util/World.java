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
                System.out.println("Lokasi tersebut telah terisi oleh rumah lain");
                System.out.println("Silahkan masukkan koordinat lokasi rumah kembali");
                return false;
            }
        }
        if(lokX > 64 || lokY > 64 || lokX <= 0 || lokY <= 0){
            System.out.println("lokasi tersebut tidak tersedia pada World");
            System.out.println("Lokasi yang dapat digunakan adalah lokasi dengan rentang antara (1,1) hingga (64, 64)");
            System.out.println("Silahkan masukkan koordinat lokasi rumah kembali");
            return false;
        }
        return true;
    }

    public ArrayList<Rumah> getPerumahan(){
        return perumahan;
    }

    public Rumah getRumah(Lokasi lok){
        Rumah x = null;
        for(Rumah rumah : perumahan){
            if(lok == rumah.getLokRumah()){
                x = rumah;
            }
        }
        return x;
    }

    public Time getTime(){
        return t;
    }
}
