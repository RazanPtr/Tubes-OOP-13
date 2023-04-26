import java.util.ArrayList;
import java.util.*;

public class Ruangan {
    private String nama;
    private static int width = 6;
    private static int length = 6;
    private ArrayList<ObjectSim> objects;
    private Lokasi lokRuangan;
    private boolean grid[][];

    public Ruangan(String nama, int x, int y){
        this.nama = nama;
        this.objects = new ArrayList<ObjectSim>();
        this.grid = new boolean[width][length];
        lokRuangan = new Lokasi(x, y);
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

    public Lokasi getLokRuangan(){
        return lokRuangan;
    }

    // 
    public boolean isSekitar(Lokasi lok){
        if((lok.getX() == lokRuangan.getX()-1 || lok.getX() == lokRuangan.getX() + 1) && lok.getY() == lokRuangan.getY()){
            return true;
        } else if((lok.getY() == lokRuangan.getY()-1 || lok.getY() == lokRuangan.getY() + 1) && lok.getX() == lokRuangan.getX()){
            return true;
        } else {
            return false;
        }
    }

    public ArrayList<ObjectSim> getObjects(){
        return objects;
    }

    public boolean placeObject(Lokasi lok, ObjectSim ob){
        if(canPlaceObj(lok, ob)){
            Furniture f = (Furniture) ob;
            int wOb = f.getWidth();
            int lOb = f.getLength();
            for(int i = lok.getX(); i < lok.getX() + lOb; i++){
                for(int j = lok.getY(); j < lok.getY() + wOb; j++){
                    grid[j][i] = true;
                }
            }
            objects.add(ob);
            System.out.println(ob.getNama() + " berhasil dipasang");
            return true;
            
        } else {
            //System.out.println(ob.getNama());
            System.out.println("Tidak bisa memasang " + ob.getNama() + " pada lokasi tersebut");
            return false;
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

    public boolean canPlaceObj(Lokasi lok, Object ob){
        if(ob instanceof Furniture){
            Furniture f = (Furniture) ob;
            int wOb = f.getWidth();
            int lOb = f.getLength();
            
            if(lok.getX() < 6 && lok.getY() < 6 && lok.getX() + lOb <= 6 && lok.getY() + wOb <= 6){
                for(int i = lok.getX(); i < lok.getX() + lOb; i++){
                    for(int j = lok.getY(); j < lok.getY() + wOb; j++){
                        if(grid[j][i]){
                            return false;
                        }
                    }
                }
                return true;
            } else {
                System.out.println("Lokasi yang dipilih tidak valid karena melebihi ukuran ruangan");
                return false;
            }
        } else {
            return false;
        }
    }

    public void displayRuangan(){
        for(int i = 0; i < 6; i++){
            if(i == 0){
                System.out.println("-------------------------");
            }
            for(int j = 0; j < 6; j++){
                if(j == 0){
                    System.out.print("|");
                }
                if(grid[i][j]){
                    System.out.print(" X |");
                } else {
                    System.out.print(" V |");
                }
            }
            System.out.print("\n-------------------------\n");
        }
    }
}
