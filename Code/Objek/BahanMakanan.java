public class BahanMakanan extends ObjectSim implements PurchasableObject{
    private String nama;
    private int price;
    private int tingkatKenyang;

    public BahanMakanan(String nama, int price, int kekenyangan){
        super(nama);
        this.price = price;
        this.kekenyangan = tingkatKenyang;
    } 

    public String getNama(){
        return nama;
    }

    public int getPrice(){
        return price;
    }

    public int getTingkatKenyang(){
        return tingkatKenyang;
    }
}
