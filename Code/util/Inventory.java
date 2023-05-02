package util;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Inventory<T> {
    private Map<T, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(T item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity harus lebih besar dari 0");
        }
        if (items.containsKey(item)) {
            items.replace(item, items.get(item) + quantity);
        } else {
            items.put(item, quantity);
        }
        //int currQuantity = items.getOrDefault(item, 0);
        //items.put(item, currQuantity + quantity);
    }

    public void removeItem(T item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity harus lebih besar dari 0");
        }

        int currQuantity = items.getOrDefault(item, 0);
        int newQuantity = currQuantity - quantity;

        if (newQuantity <= 0) {
            items.remove(item);
        } else {
            items.put(item, newQuantity);
        }
    }

    public int getQuantity(T item) {
        return items.getOrDefault(item, 0);
    }

    public Set<T> getItem() {
        return items.keySet();
    }

    public void showInventory(){
        System.out.println("Berikut merupakan isi inventory yang dimiliki oleh Sim");
        System.out.println("+-----------------+---------------+");
        System.out.println("|   Nama Barang   |   Kuantitas   |");
        System.out.println("+-----------------+---------------+");
        if(items.keySet().size()>0){
            for(T t : items.keySet()){
                System.out.print("|" + t.getClass().getSimpleName());
                for(int i = 0; i < (17-t.getClass().getSimpleName().length()); i++){
                    System.out.print(" ");
                }
                System.out.print("|");
                System.out.print(items.get(t));
                for(int i = 0; i < (15-items.get(t).toString().length()); i++){
                    System.out.print(" ");
                }
                System.out.println("|");
            }
            System.out.println("+---------------------------------+");
        } else {
            System.out.println("|        -        |       -       |");
            System.out.println("+-----------------+---------------+");
            System.out.println("inventorymu kosong saat ini");
        }
    }
}
