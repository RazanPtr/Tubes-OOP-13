package util;
import java.util.*;
import objek.*;

public class Ruangan {
    private String nama;
    private String code;
    private static int width = 6;
    private static int length = 6;
    private ArrayList<Furniture> objects;
    private boolean grid[][];
    private Ruangan up;
    private Ruangan down;
    private Ruangan left;
    private Ruangan right;
    private int x;
    private int y;

    public Ruangan(String nama, String code){
        this.nama = nama;
        this.code = code;
        this.objects = new ArrayList<>();
        this.grid = new boolean[width][length];
        up = null;
        down = null;
        left = null;
        right = null;
        x=0;
        y=0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void changeNama(String nama) {
        this.nama = nama;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public ArrayList<Furniture> getObjects(){
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
            objects.add(obj);
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

    /*public void displayRuangan(){
        for(int i = 0; i < 6; i++){
            if(i == 0){
                System.out.println("----------------------------------");
            }
            for(int j = 0; j < 6; j++){
                if(j == 0){
                    System.out.print("|");
                }
                //kalo true, berati ada objek
                if(grid[j][i]){
                    for(Furniture furni : objects){
                        if((furni.getLokDiRuangan().getX() == i && furni.getLokDiRuangan().getY() == j) && (furni.getLength() > i && furni.getWidth() > j)){
                            System.out.print(" " + furni.getCode() + " |");
                            break;
                        }
                    }
                } else {
                    System.out.print("     |");
                }
            }
            System.out.print("\n----------------------------------\n");
        }
    }*/

    public void displayRuangan() {
        System.out.println("(0,0) terletak pada pojok kiri atas");
        System.out.println(".+:*+.+:*+. Ruang " + nama + " .+*:+.+*:+." );
        for (int i = 0; i < 6; i++) {
            if (i == 0) {
                System.out.println("-------------------------------------");
            }
            for (int j = 0; j < 6; j++) {
                if (j == 0) {
                    System.out.print("|");
                }
                boolean hasFurniture = false;
                for (Furniture furni : objects) {
                    int x = furni.getLokDiRuangan().getX();
                    int y = furni.getLokDiRuangan().getY();
                    int length = furni.getLength();
                    int width = furni.getWidth();
                    if (x <= j && j < x + length && y <= i && i < y + width) {
                        System.out.print(" " + furni.getCode() + " |");
                        hasFurniture = true;
                        break;
                    }
                }
                if (!hasFurniture) {
                    System.out.print("     |");
                }
            }
            System.out.print("\n-------------------------------------\n");
        }
    }
    
    

    public int displayObjects() {
        System.out.println("Berikut adalah objek-objek yang terletak di ruangan ini:");
        int i = 1;
        for (ObjectSim obj : objects) {
            System.out.print(i+".");
            System.out.println(obj.getNama());
            i++;
        }
        return i;
    }
}
