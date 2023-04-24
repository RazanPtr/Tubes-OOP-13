public class Furniture extends ObjectSim implements PurchasableObject{
    private String nama;
    private int length;
    private int width;
    private int price;
    private int x;
    private int y;

    public Furniture(String nama, int length, int width, int price, int x, int y){
        super(nama);
        this.length = length;
        this.width = width;
        this.price = price;
        this.x = x;
        this.y = y;
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