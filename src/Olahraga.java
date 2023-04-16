public class Olahraga extends Aksi {
    public Olahraga(Sim playedSim, int durasi){
        super("Olahraga", playedSim, durasi);
    }

    public void efek(){
        this.getSim().updateKesehatan("inc", 5*(this.getDurasi()/20));
        this.getSim().updateMood("inc", 10*(this.getDurasi()/20));
        this.getSim().updateMood("dec", (-5)*(this.getDurasi()/20));    
    }
}
