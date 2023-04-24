import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Inventory<T> {
    private Map<Object, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(Object item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity harus lebih besar dari 0");
        }

        int currQuantity = items.getOrDefault(item, 0);
        items.put(item, currQuantity + quantity);
    }

    public void removeItem(Object item, int quantity) {
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

    public int getQuantity(Object item) {
        return items.getOrDefault(item, 0);
    }

    public Set<Object> getItem() {
        return items.keySet();
    }

    public void showInventory(){
        System.out.println("Inventory: ");
        Set <Object> keys = items.keySet();
        for (Object key : keys){
            int quantity = items.get(key);
            System.out.println(key + ": " + quantity);
        }
    }
}


//beda
