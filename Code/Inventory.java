import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Inventory<T> {
    private Map<ObjectSim, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(ObjectSim item, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity harus lebih besar dari 0");
        }

        int currQuantity = items.getOrDefault(item, 0);
        items.put(item, currQuantity + quantity);
    }

    public void removeItem(ObjectSim item, int quantity) {
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

    public int getQuantity(ObjectSim item) {
        return items.getOrDefault(item, 0);
    }

    public Set<ObjectSim> getItem() {
        return items.keySet();
    }

    public void showInventory(){
        System.out.println("Inventory: ");
        Set <ObjectSim> keys = items.keySet();
        for (ObjectSim key : keys){
            int quantity = items.get(key);
            System.out.println(key + ": " + quantity);
        }
    }
}
