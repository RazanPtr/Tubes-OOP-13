public class Furniture extends ObjectSim implements PurchasableObject{
    private String nama;
    private int length;
    private int width;
    private int price;

    public Furniture(String nama, int length, int width, int price){
        super(nama);
        this.length = length;
        this.width = width;
        this.price = price;
    } 

    public String getNama(){
        return nama;
    }

    public int getLength(){
        return length;
    }

    public int getWidth(){
        return width;
    }

    public int getPrice(){
        return price;
    }
}