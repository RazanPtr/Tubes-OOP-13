public class Tidur extends Aksi {
    private int terakhirTidur; //ini dalam bentuk apa ya...

    public Tidur(Sim playedSim, int durasi){
        super("Tidur", playedSim, durasi);
    }

    public void efek(){
        this.getSim().updateKesehatan("inc", 20*(this.getDurasi()/4));
        this.getSim().updateMood("inc", 30*(this.getDurasi()/4)); 
    }

    public int getTerakhirTidur(){
        return terakhirTidur;
    }
}
