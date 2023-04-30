package util;
import java.util.*;
import objek.*;

public class Ruangan {
    private String nama;
    private static int width = 6;
    private static int length = 6;
    private ArrayList<ObjectSim> objects;
    private boolean grid[][];
    private Ruangan up;
    private Ruangan down;
    private Ruangan left;
    private Ruangan right;

    public Ruangan(String nama){
        this.nama = nama;
        this.objects = new ArrayList<>();
        this.grid = new boolean[width][length];
        up = null;
        down = null;
        left = null;
        right = null;
    }

    public void changeNama(String nama) {
        this.nama = nama;
    }

    public Ruangan getRuangan(){
        return this;
    }
    public String getNamaRuangan(){
        return nama;
    }

    public void setNamaRuangan(String nama){
        this.nama = nama;
    }

    public ArrayList<ObjectSim> getObjects(){
        return objects;
    }

    public Ruangan getUp() {
        return up;
    }

    public Ruangan getDown() {
        return down;
    }

    public Ruangan getLeft() {
        return left;
    }

    public Ruangan getRight() {
        return right;
    }

    public void setUp(Ruangan ruang) {
        up = ruang;
    }

    public void setDown(Ruangan ruang) {
        down = ruang;
    }

    public void setLeft(Ruangan ruang) {
        left = ruang;
    }

    public void setRight(Ruangan ruang) {
        right = ruang;
    }

    public void placeObject(Lokasi lok, Furniture obj){
        if (canPlaceObj(lok, obj)) {
            // Tandai seluruh sel yang ditempati dengan True
            for (int i = lok.getX(); i < lok.getX() + obj.getLength(); i++) {
                for (int j = lok.getY(); j < lok.getY() + obj.getWidth(); j++) {
                    grid[i][j] = true;
                }
            }
        
            // Set posisi objek
            obj.setLokDiRuangan(lok);
        } else {
            System.out.println("Barang tidak dapat diletakkan disitu");
        }
        
    }

    public void rotateObj(ObjectSim ob){
        if(ob instanceof Furniture){
            Furniture f = (Furniture) ob;
            int temp = f.getWidth();
            f.setWidth(f.getLength());
            f.setLength(temp);
        }
    }

    public boolean canPlaceObj(Lokasi lok, Furniture obj){
        // Periksa apakah ukuran objek cukup di ruangan
        if (lok.getX() + obj.getLength() > length || lok.getY() + obj.getWidth() > width) {
            return false;
        }

        // Periksa apakah sel yang akan ditempati objek kosong
        for (int i = lok.getX(); i < lok.getX() + obj.getLength(); i++) {
            for (int j = lok.getY(); j <lok.getY() + obj.getWidth(); j++) {
                if (grid[i][j]) {
                    return false;
                }
            }
        }

        return true; // Aman untuk diletakkan
    }

    public void displayRuangan(){
        for(int i = 0; i < 6; i++){
            if(i == 0){
                System.out.println("--------------------------");
            }
            for(int j = 0; j < 6; j++){
                if(j == 0){
                    System.out.print("|");
                }
                if(grid[j][i]){
                    System.out.print(" X |");
                } else {
                    System.out.print(" V |");
                }
            }
            System.out.print("\n-------------------------\n");
        }
    }

    public int displayObjects() {
        System.out.println("Berikut adalah objek-objek yang terletak di ruangan ini:");
        int i = 1;
        for (ObjectSim obj : objects) {
            System.out.println(i+".");
            System.out.println(obj.getNama());
            i++;
        }
        return i;
    }
}
