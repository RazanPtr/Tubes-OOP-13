public class Furniture{
    public abstract class FurnitureObject implements PurchasableObject{
    //Atributes
    private String name;
    private int price;
    private int length;
    private int width;

    //Constructor
    public FurnitureObject(String name, int price, int length, int width){
        this.name = name;
        this.price = price;
        this.length = length;
        this.width = width;
    }

    //Getter
    public String getName(){
        return name;
    }

    public int getPrice(){
        return price;
    }

    public int getLength(){
        return length;
    }

    public int getWidth(){
        return width;
    }
    }

    public class KasurSingle extends FurnitureObject{
        public KasurSingle(){
            super("Kasur Single", 50, 4, 1);
        }
    }

    public class KasurQueen extends FurnitureObject{
        public KasurQueen(){
            super("Kasur Queen Size", 100, 4, 2);
        }
    }

    public class KasurKing extends FurnitureObject{
        public KasurKing(){
            super("Kasur King Size", 150, 5, 2);
        }
    }

    public class Toilet extends FurnitureObject{
        public Toilet(){
            super("Toilet", 50, 1, 1);
        }
    }

    public class KomporGas extends FurnitureObject{
        public KomporGas(){
            super("Kompor Gas", 100, 2, 1);
        }
    }

    public class KomporListrik extends FurnitureObject{
        public KomporListrik(){
            super("Kompor Listrik", 200, 1, 1);
        }
    }

    public class MejaKursi extends FurnitureObject{
        public MejaKursi(){
            super("Meja dan Kursi", 50, 3, 3);
        }
    }

    public class Jam extends FurnitureObject{
        public Jam(){
            super("Jam", 10, 1, 1);
        }
    }
}