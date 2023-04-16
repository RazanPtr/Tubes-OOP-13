public abstract class Aksi {
    private String nama;
    private Sim playedSim;
    private int durasi;

    public Aksi(String namaAksi, Sim playedSim, int durasi){
        this.nama = namaAksi;
        this.playedSim = playedSim;
        this.durasi = durasi;
        playedSim.setStatus(namaAksi);
    }

    public Sim getSim(){
        return playedSim;
    }
    
    public String getNamaAksi(){
        return nama;
    }

    public int getDurasi(){
        return durasi;
    }

    public abstract void efek();
}
