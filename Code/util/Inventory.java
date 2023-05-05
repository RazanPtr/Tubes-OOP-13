package util;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import objek.*;

public class Inventory<T> {
    private Map<T, Integer> items;
    //private Map<Integer, ObjectSim> data;
    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(T item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity harus lebih besar dari 0");
        }

        if (isContain(item) != null) {
            T temp = isContain(item);
            items.replace(temp, items.get(temp) + quantity);
        } else {
            items.put(item, quantity);
        }
        //int currQuantity = items.getOrDefault(item, 0);
        //items.put(item, currQuantity + quantity);
    }

    public T isContain(T obj){
        for (T item : items.keySet()) {
            if (item.getClass().getSimpleName().equals(obj.getClass().getSimpleName())) {
                return item;
            }
        }
        return null;
    }

    public void removeItem(T item, int quantity) {
        T temp = isContain(item);
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity harus lebih besar dari 0");
        }
        if (quantity > items.get(temp)) {
            throw new IllegalArgumentException("Quantity tidak boleh lebih besar dari jumlah item yang ada");
        }
        if (quantity == items.get(temp)) {
            items.remove(temp);
        } else {
            items.replace(temp, items.get(temp) - quantity);
        }
        //if (items.containsKey(item)) {
        //    if (items.get(item) > 1) {
        //        items.put(item, items.get(item) - 1);
        //    } else {
        //        items.remove(item);
        //    }
        //    return item;
        //} else {
        //    System.out.println("Item tidak ada di inventory");
        //    return null;
        //}
    }

    public int getQuantity(T item) {
        return items.getOrDefault(item, 0);
    }

    public Set<T> getItem() {
        return items.keySet();
    }

    public void showInventory(){
        System.out.println("Berikut merupakan isi inventory yang dimiliki oleh Sim!");
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
    // public static void main(String[] args){
    //     Inventory<String> items = new Inventory<>();
    //     KasurKing kasur = new KasurKing();
    //     //items.addItem(kasur, 1);
    //     items.addItem("kasur", 1);
        
        
        
    //     items.showInventory();

    // }
}
