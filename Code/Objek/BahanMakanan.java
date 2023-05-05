package objek;

public class BahanMakanan extends ObjectSim implements PurchasableObject{
    private int price;
    private int tingkatKenyang;

    public BahanMakanan(String nama, int price, int kekenyangan){
        super(nama);
        this.price = price;
        this.tingkatKenyang = kekenyangan;
    } 

    public int getPrice(){
        return price;
    }

    public int getTingkatKenyang(){
        return tingkatKenyang;
    }
}
