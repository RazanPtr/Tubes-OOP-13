package objek;
import util.Lokasi;
import java.util.ArrayList;

public class Furniture extends ObjectSim implements PurchasableObject{
    private String nama;
    private int length;
    private int width;
    private int price;
    private Lokasi lokDiRuangan;
    private ArrayList<String> listAksi;

    public Furniture(String nama, int length, int width, int price){
        super(nama);
        this.length = length;
        this.width = width;
        this.price = price;
        lokDiRuangan = null;
        listAksi = new ArrayList<String>();
    } 

    public String getNama(){
        return nama;
    }

    public Lokasi getLokDiRuangan() {
        return lokDiRuangan;
    }

    public void setLokDiRuangan(Lokasi lok) {
        lokDiRuangan = lok;
    }

    public int getLength(){
        return length;
    }

    public void setLength(int length){
        this.length = length;
    }

    public int getWidth(){
        return width;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public int getPrice(){
        return price;
    }

    public ArrayList<String> getListAksi(){
        return listAksi;
    }

    public void addListAksi(String aksi){
        listAksi.add(aksi);
    }

    public void displayListAksi(){
        int i = 1;
        for(String s : listAksi){
            System.out.println(i + ". " + s);
            i++;
        }
    }
}