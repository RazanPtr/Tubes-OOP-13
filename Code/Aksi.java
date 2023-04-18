public interface Aksi {
    public void kerja(int durasi);

    public void olahraga(int durasi);
    
    public void tidur(int durasi);

    public void makan(int durasi);

    public void memasak(int durasi);

    public void berkunjung(int durasi);

    public void buangAir(int durasi);

    public void upgradeRumah(Lokasi lokSimRuang, int durasi);

    public void beliBarang(int durasi);

    public void pindahRuangan();

    public void karaoke(int durasi);

    public void melukis(int durasi);

    public void simpanBarang();

    public void pindahBarang();

    public void sholat(int durasi);

    public void mandi(int durasi);

    public void nontonNetflix(int durasi);

    public void lihatInventory();
    
    public void pasangBarang();

    public void lihatWaktu();
}