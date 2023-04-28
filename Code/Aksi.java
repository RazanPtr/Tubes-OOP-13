public interface Aksi {
    public void kerja(int durasi);

    public void olahraga(int durasi);
    
    public void tidur(int durasi);

    public void makan(int durasi, ObjectSim ob);

    public void memasak(ObjectSim ob);

    public void berkunjung(int durasi, Lokasi lokasiTujuan);

    public void buangAir(int durasi);

    public void upgradeRumah(Lokasi lokSimRumah, Lokasi lokSimRuangan, String nama, int x, int y);

    public void beliBarang(int durasi, ObjectSim ob, int kuantitas);

    public void pindahRuangan(Lokasi lok);

    public void karaoke(int durasi);

    public void melukis(int durasi);

    public void simpanBarang(Lokasi lok, ObjectSim ob);

    public void pindahBarang(Lokasi lokAwal, ObjectSim ob, Lokasi lokAkhir, Lokasi lokRuang);

    public void sholat(int durasi);

    public void mandi(int durasi);

    public void nontonNetflix(int durasi);

    public void lihatInventory();
    
    public void pasangBarang(Lokasi lokRuang, ObjectSim ob, Lokasi lokBarang);

    public void lihatWaktu();
}