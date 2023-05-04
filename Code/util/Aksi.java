package util;
import objek.*;
import java.util.Map;

public interface Aksi {
    public void kerja(int durasi);

    public void olahraga(int durasi);
    
    public void tidur(int durasi);

    public void makan(int durasi, ObjectSim ob);

    public void memasak(ObjectSim ob);

    public void berkunjung(int durasi, Lokasi lokasiTujuan);

    public void buangAir(int durasi);

    public void upgradeRumah();

    public void beliBarang(Map<String, PurchasableObject> objectMap, String itemName, int amount) throws negativeParameterException, invalidMultitudeNumber, InterruptedException;

    public void karaoke(int durasi);

    public void melukis(int durasi);

    public void simpanBarang(String lok, Map<String, PurchasableObject> objectMap, String itemName);

    public void pindahBarang(String lokAwal, ObjectSim ob, Lokasi lokAkhir, String lokRuang);

    public void sholat(int durasi);

    public void mandi(int durasi);

    public void nontonNetflix(int durasi);

    public void lihatInventory();
    
    public void pasangBarang(Map<String, PurchasableObject> objectMap, String lokRuang, String itemName, Lokasi lokBarang);
    
    public void lihatWaktu();
}