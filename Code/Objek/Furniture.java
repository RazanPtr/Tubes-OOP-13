package objek;
import util.Lokasi;

public class Furniture extends ObjectSim implements PurchasableObject{
    private String nama;
    private int length;
    private int width;
    private int price;
    private Lokasi lokDiRuangan;

    public Furniture(String nama, int length, int width, int price){
        super(nama);
        this.length = length;
        this.width = width;
        this.price = price;
        lokDiRuangan = null;
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
}