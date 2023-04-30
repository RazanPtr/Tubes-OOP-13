package util;
import objek.*;

public interface Aksi {
    public void kerja(int durasi);

    public void olahraga(int durasi);
    
    public void tidur(int durasi);

    public void makan(int durasi, ObjectSim ob);

    public void memasak(ObjectSim ob);

    public void berkunjung(int durasi, Lokasi lokasiTujuan);

    public void buangAir(int durasi);

    public void upgradeRumah();

    public void beliBarang(Map<String, PurchasableObject> objectMap, String itemName, int amount);

    public void pindahRuangan(Lokasi lok);

    public void karaoke(int durasi);

    public void melukis(int durasi);

    public void simpanBarang(String lok, ObjectSim ob);

    public void pindahBarang(String lokAwal, ObjectSim ob, Lokasi lokAkhir, String lokRuang);

    public void sholat(int durasi);

    public void mandi(int durasi);

    public void nontonNetflix(int durasi);

    public void lihatInventory();
    
    public void pasangBarang(String lokRuang, ObjectSim ob, Lokasi lokBarang);

    public void lihatWaktu();
}