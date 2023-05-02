package util;
import java.util.Random;
import java.util.*;
import objek.*;
import java.lang.Math;

public class Sim implements Aksi{
    private String namaLengkap;
    private WorkObject pekerjaan;
    private int uang;
    private Inventory<ObjectSim> inventory;
    private String status;
    private Rumah rumah;
    private Lokasi lokSimRumah;
    private Ruangan lokSimRuang;
    private ObjectSim curObject;
    private Time time;
    private int awalKerja;
    private int lamaKerja;
    private int durasiTidur;
    public int durasiTidakBuangAir;
    private boolean sudahTidur;
    private boolean sudahMakan;
    public boolean sudahBuangAir;
    private int activeDuration;
    private int timeRemainingDelivery;
    private boolean isItemInDelivery = false;
    Kesejahteraan kesejahteraan;

    public Sim(String name, int x, int y){
        this.namaLengkap = name;
        pekerjaan = new WorkObject();
        uang = 100;
        inventory = new Inventory<ObjectSim>();
        kesejahteraan = new Kesejahteraan();
        status = null;
        rumah = new Rumah(x,y);
        curObject = null;
        lokSimRuang = rumah.getRoom("Kamar"); 
        lokSimRumah = rumah.getLokRumah(); //ini lokasi awal rumahnya input dari pengguna kan?!
        durasiTidur = 0;
        sudahTidur = false;
        timeRemainingDelivery = 0;
        isItemInDelivery = false;
        inventory.addItem(new KasurSingle(), 1);
        inventory.addItem(new Toilet(), 1);
        inventory.addItem(new KomporGas(), 1);
        inventory.addItem(new Jam(), 1);
        inventory.addItem(new MejaKursi(), 1);
        time = new Time();
    }

    public String getNamaLengkap(){
        return namaLengkap;
    }


    public void setNamalengkap(String namaLengkap){
        this.namaLengkap = namaLengkap;
    }

    public int getUang(){
        return uang;
    }

    public void setUang(int uang){
        this.uang = uang;
    }

    public int getActiveDuration(){
        return activeDuration;
    }

    public void setActiveDuration(int amount){
        activeDuration = amount*1000;
    }

    public void updateUang(int uang){
        this.uang += uang;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public WorkObject getPekerjaan(){
        return pekerjaan;
    }

    public void setPekerjaan(WorkObject p){
        this.pekerjaan = p;
    }

    public Lokasi getLokSimRumah(){
        return lokSimRumah;
    }

    public Ruangan getLokRuang(){
        return lokSimRuang;
    }

    public void setCurObject(ObjectSim obj) {
        curObject = obj;
    }

    public ObjectSim getCurObject() {
        return curObject;
    }
    
    public Rumah getRumah(){
        return rumah;
    }

    public void setLokSimRumah(Lokasi lok){
        this.lokSimRumah = lok;
    }

    public void setLokSimRuang(Ruangan r){
        this.lokSimRuang = r;
    }

    public int getTimeRemainingDelivery() { 
        return timeRemainingDelivery;
    }

    public boolean getIsItemInDelivery() { 
        return isItemInDelivery;
    }

    public void move(ObjectSim obj) {
        curObject = obj;
        Boolean valops = false;
        Scanner scan = new Scanner(System.in);
        if (obj.getNama().equals("Kasur Single")||obj.getNama().equals("Kasur Queen Size")||obj.getNama().equals("Kasur King Size")) {
            System.out.println("Apakah kamu mau tidur? (Y/N)");
            while (!valops) {
                String ops = scan.nextLine();
                if (ops.equals("Y")) {
                    System.out.println("Berapa lama kamu ingin tidur? (Dalam Detik)");
                    int dur = scan.nextInt();
                    String temp = scan.nextLine();
                    try {
                        tidur(dur);
                        valops = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Silahkan masukkan durasi yang valid");
                    }
                } else if (ops.equals("N")){
                    System.out.println("Baik. Jangan lupa untuk tidur secukupnya!");
                    valops = true;
                } else {
                    System.out.println("Tolong masukkan opsi yang tepat!");
                }
            }
        } else if (obj.getNama().equals("Toilet")) {
            System.out.println("Apakah kamu mau buang air? (Y/N)");
            while (!valops) {
                String ops = scan.nextLine();
                if (ops.equals("Y")) {
                    System.out.println("Berapa lama kamu ingin buang air? (Dalam Detik)");
                    int dur = scan.nextInt();
                    String temp = scan.nextLine();
                    try {
                        buangAir(dur);
                        valops = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Silahkan masukkan durasi yang valid");
                    }
                } else if (ops.equals("N")){
                    System.out.println("Baik. Jangan lupa untuk buang air setelah makan!");
                    valops = true;
                } else {
                    System.out.println("Tolong masukkan opsi yang tepat!");
                }
            }
        } else if (obj.getNama().equals("Kompor Gas")||obj.getNama().equals("Kompor Listrik")) {
            System.out.println("Apakah kamu mau memasak? (Y/N)");
            while (!valops) {
                String ops = scan.nextLine();
                if (ops.equals("Y")) {
                    System.out.println("Apa yang ingin kau masak? Berikut adalah masakan yang dapat dibuat:");
                    System.out.println("1. Nasi Ayam");
                    System.out.println("2. Nasi Kari");
                    System.out.println("3. Susu Kacang");
                    System.out.println("4. Tumis Sayur");
                    System.out.println("5. Bistik");
                    System.out.println("");
                    Boolean valmenu = false;
                    while (!valmenu) {
                        System.out.println("Pilihlah menu dengan memasukkan nomor menu (1/2/3/4/5!)");
                        int menu = scan.nextInt();
                        String tempnext = scan.nextLine();
                        if (menu==1) {
                            System.out.println("Kamu memilih Nasi Ayam!");
                            memasak(new NasiAyam());
                            valmenu = true;
                        } else if (menu==2) {
                            System.out.println("Kamu memilih Nasi Kari!");
                            memasak(new NasiKari());
                            valmenu = true;
                        } else if (menu==3) {
                            System.out.println("Kamu memilih Susu Kacang!");
                            memasak(new SusuKacang());
                            valmenu = true;
                        } else if (menu==4) {
                            System.out.println("Kamu memilih Tumis Sayur!");
                            memasak(new TumisSayur());
                            valmenu = true;
                        } else if (menu==5) {
                            System.out.println("Kamu memilih Bistik!");
                            memasak(new Bistik());
                            valmenu = true;
                        } else {
                            System.out.println("Tolong masukkan opsi yang valid!");
                        }
                    }
                    valops = true;
                } else if (ops.equals("N")){
                    System.out.println("Baik. Kunjungi lagi kompor apabila ingin memasak!");
                    valops = true;
                } else {
                    System.out.println("Tolong masukkan opsi yang tepat!");
                } 
            }
        } else if (obj.getNama().equals("Meja dan Kursi")) {
            System.out.println("Apakah kamu mau makan? (Y/N)");
            while (!valops) {
                String ops = scan.nextLine();
                if (ops.equals("Y")) {
                    System.out.println("Apa yang ingin kamu makan?");
                    //kode
                } else if (ops.equals("N")){
                    System.out.println("Baik. Jangan lupa untuk makan secukupnya!");
                    valops = true;
                } else {
                    System.out.println("Tolong masukkan opsi yang tepat!");
                }
            }
        } else if (obj.getNama().equals("Jam")) {
            System.out.println("Apakah kamu mau melihat waktu? (Y/N)");
            while (!valops) {
                String ops = scan.nextLine();
                if (ops.equals("Y")) {
                    System.out.println("Waktu sekarang adalah sebagai berikut:");
                    lihatWaktu();
                    valops = true;
                } else if (ops.equals("N")){
                    System.out.println("Baik. Kunjungi lagi jam jika ingin melihat waktu!");
                    valops = true;
                } else {
                    System.out.println("Tolong masukkan opsi yang tepat!");
                }
            }
        } else if (obj.getNama().equals("Sajadah")) {
            System.out.println("Apakah kamu ingin Shalat? (Y/N)");
            while (!valops) {
                String ops = scan.nextLine();
                if (ops.equals("Y")) {
                    System.out.println("Berapa lama kamu ingin Shalat? (Dalam Detik)");
                    int dur = scan.nextInt();
                    String temp = scan.nextLine();
                    try {
                        sholat(dur);
                        valops = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Silahkan masukkan durasi yang valid");
                    }
                } else if (ops.equals("N")){
                    System.out.println("Baik. Jangan lupa Shalat!");
                    valops = true;
                } else {
                    System.out.println("Tolong masukkan opsi yang tepat!");
                }
            }
        } else if (obj.getNama().equals("Kanvas")) {
            System.out.println("Apakah kamu ingin melukis? (Y/N)");
            while (!valops) {
                String ops = scan.nextLine();
                if (ops.equals("Y")) {
                    System.out.println("Berapa lama kamu ingin melukis? (Dalam Detik)");
                    int dur = scan.nextInt();
                    String temp = scan.nextLine();
                    try {
                        melukis(dur);
                        valops = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Silahkan masukkan durasi yang valid");
                    }
                } else if (ops.equals("N")){
                    System.out.println("Baik. Jika ingin melukis, kunjungi lagi kanvas!");
                    valops = true;
                } else {
                    System.out.println("Tolong masukkan opsi yang tepat!");
                }
            }
        } else if (obj.getNama().equals("Mic")) {
            System.out.println("Apakah kamu ingin karaoke? (Y/N)");
            while (!valops) {
                String ops = scan.nextLine();
                if (ops.equals("Y")) {
                    System.out.println("Berapa lama kamu ingin karaoke? (Dalam Detik)");
                    int dur = scan.nextInt();
                    String temp = scan.nextLine();
                    try {
                        karaoke(dur);
                        valops = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Silahkan masukkan durasi yang valid");
                    }
                } else if (ops.equals("N")){
                    System.out.println("Baik. Jika ingin karaoke, kunjungi lagi mic!");
                    valops = true;
                } else {
                    System.out.println("Tolong masukkan opsi yang tepat!");
                }
            }
        } else if (obj.getNama().equals("Laptop")) {
            System.out.println("Apakah kamu ingin nonton netflix? (Y/N)");
            while (!valops) {
                String ops = scan.nextLine();
                if (ops.equals("Y")) {
                    System.out.println("Berapa lama kamu ingin nonton netflix? (Dalam Detik)");
                    int dur = scan.nextInt();
                    String temp = scan.nextLine();
                    try {
                        nontonNetflix(dur);
                        valops = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Silahkan masukkan durasi yang valid");
                    }
                } else if (ops.equals("N")){
                    System.out.println("Baik. Jika ingin nonton netflix, kunjungi lagi laptop!");
                    valops = true;
                } else {
                    System.out.println("Tolong masukkan opsi yang tepat!");
                }
            }
        } else if (obj.getNama().equals("Shower")) {
            System.out.println("Apakah kamu ingin mandi? (Y/N)");
            while (!valops) {
                String ops = scan.nextLine();
                if (ops.equals("Y")) {
                    System.out.println("Berapa lama kamu ingin mandi? (Dalam Detik)");
                    int dur = scan.nextInt();
                    String temp = scan.nextLine();
                    try {
                        mandi(dur);
                        valops = true;
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                        System.out.println("Silahkan masukkan durasi yang valid");
                    }
                } else if (ops.equals("N")){
                    System.out.println("Baik. Jangan lupa mandi supaya higienis selalu!");
                    valops = true;
                } else {
                    System.out.println("Tolong masukkan opsi yang tepat!");
                }
            }
        } else {
            System.out.println("Objek tidak valid!");
            valops = true;
        }

    }
    

    public void kerja(int durasi){
        awalKerja = time.getTimeInSec();
        if(durasi <= 0){
            throw new IllegalArgumentException("durasi harus lebih dari 0 detik");
        }
        if(durasi %120 != 120){
            throw new IllegalArgumentException("durasi kerja harus kelipatan 120 detik");
        }
        setActiveDuration(durasi);
        
        this.setStatus("kerja");
        kesejahteraan.updateKekenyangan((-10)*(durasi/30));
        kesejahteraan.updateMood((-10)*(durasi/30));
        if(durasi >= (4*60)){
            this.uang += getPekerjaan().getJob().getPayRate();
        }
        //Untuk selalu nambahin durasi gak buang air
        durasiTidakBuangAir += durasi;
    }

    public void olahraga(int durasi){
        if(durasi <= 0){
            throw new IllegalArgumentException("durasi harus lebih dari 0 detik");
        }
        if(durasi % 20 != 0){
            throw new IllegalArgumentException("durasi harus kelipatan 20 detik");
        }
        setActiveDuration(durasi);
        
        this.setStatus("olahraga");
        kesejahteraan.updateKesehatan(5*(durasi/20));
        kesejahteraan.updateKekenyangan((-5)*(durasi/20));
        kesejahteraan.updateMood(10*(durasi/20));

        //Untuk selalu nambahin durasi gak buang air
        durasiTidakBuangAir += durasi;
    }

    public void tidur(int durasi){
        if(durasi <= 0){
            throw new IllegalArgumentException("durasi harus lebih dari 0 detik");
        }
        
        this.setStatus("tidur");
        setActiveDuration(durasi);
        durasiTidur += durasi;
        checkTidur();

        //Untuk selalu nambahin durasi gak buang air
        durasiTidakBuangAir += durasi;
    }

    public void checkTidur(){
        if(durasiTidur >= (4*60)){
            kesejahteraan.updateKesehatan(20*(durasiTidur/(4*60)));
            kesejahteraan.updateMood(30*(durasiTidur/(4*60)));
            durasiTidur -= (durasiTidur/(4*60));
            sudahTidur = true;
        } 
    }

    public boolean getTidur(){
        return sudahTidur;
    }

    public void resetHarian(){
        durasiTidur = 0;
        sudahTidur = false;
        sudahBuangAir = false;
        sudahMakan = false;
    }

    public void tidakTidur(){
        kesejahteraan.updateKesehatan(-5);
        kesejahteraan.updateMood(-5);
    }

    public void makan(int durasi, ObjectSim ob){
    //implementasi makan
        if(ob instanceof Masakan){   
            Masakan m = (Masakan) ob; 
            if(inventory.getItem().contains(m)){
                setActiveDuration(durasi);
                
                this.setStatus("Makan");
                inventory.removeItem(m, 1);
                kesejahteraan.updateKekenyangan((m.getTingkatKenyang())*(durasi/30));
                sudahMakan = true;
                durasiTidakBuangAir = 0;
            }
        }
    }

    public void memasak(ObjectSim ob){ 
    //implementasi memasak
        if(ob instanceof Masakan){
            Masakan m = (Masakan) ob;
            ArrayList<BahanMakanan> listResep = new ArrayList<BahanMakanan>(m.getBahan());
            ArrayList<String> yangKurang = new ArrayList<>();
            boolean bisa = true;
            for(BahanMakanan bm : listResep){
                if(!inventory.getItem().contains(bm)){
                    bisa = false;
                    yangKurang.add(bm.getNama());
                }
            }
            if(bisa){
                this.setStatus("memasak");
                try {
                    Thread.sleep((3/2)*m.getTingkatKenyang()* 1000);
                    time.updateTime((3/2)*m.getTingkatKenyang()* 1000);
                    setActiveDuration((3/2)*m.getTingkatKenyang()* 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                for(BahanMakanan bm : listResep){
                    inventory.removeItem(ob, 1);
                    uang -= bm.getPrice();
                }
                inventory.addItem(ob, 1);
                kesejahteraan.updateMood(10);
                double durasiMasak = (1.5) * m.getTingkatKenyang();
                
                //Untuk selalu nambahin durasi gak buang air
                int durasiMasakInt ;
                durasiMasakInt = (int) Math.floor(durasiMasak);
                durasiTidakBuangAir += durasiMasakInt;
            } else {
                System.out.println("Maaf, bahannya tidak lengkap!");
                System.out.println("Kamu kekurangan bahan berikut:");
                int i = 1;
                for (String s: yangKurang) {
                    System.out.println(i+". "+s);
                }
                System.out.println("");
            }
        }
        
    }
    
    public void berkunjung(int durasi, Lokasi lokasiTujuan) { // cek rumah yang dituju ada di main
        double waktuKunjungan = Math.sqrt(Math.pow(lokasiTujuan.getX() - lokSimRumah.getX(), 2) + Math.pow(lokasiTujuan.getY() - lokSimRumah.getY(), 2));
        durasi += waktuKunjungan;
        setActiveDuration(durasi);
        
        kesejahteraan.updateMood(10 * (durasi / 30));
        kesejahteraan.updateKekenyangan(-10 * (durasi / 30));
        
        //Untuk selalu nambahin durasi gak buang air
        durasiTidakBuangAir += durasi;
    }

    //public void 

    public void buangAir(int durasi){
        //implementasi buangAir
        if(durasi <= 0 && durasi % 10 != 0){
            throw new IllegalArgumentException("durasi tidak sesuai");
        }
        if(sudahMakan){
            setActiveDuration(durasi);
            
            kesejahteraan.updateKekenyangan((-20)*(durasi/10));
            kesejahteraan.updateMood((10)*(durasi/10));
            sudahBuangAir = true;
        } else {
            System.out.println("Sim belum makan pada hari ini");
        }
            
    }

    public void tidakBuangAir(){
        //implementasi tidak buangAir
        // nanti di main selalu ngecek durasiTidakBuangAir aja
        System.out.println("Sim belum buang air setelah makan!");
        kesejahteraan.updateKesehatan(-5);
        kesejahteraan.updateMood(-5);
        durasiTidakBuangAir = 0;

    }

    public void upgradeRumah(){
        if(rumah.isAddRoomAvailable(lokSimRuang)){
            rumah.addRuangan(lokSimRuang);
            uang -= 1500;
        } else {
            System.out.println("Upgrade rumah tidak dapat dilakukan karena sudah tersedia ruangan disekeliling ruangan saat ini.");
            System.out.println("Silahkan pindah ke ruangan lain terlebih dahulu untuk melakukan upgrade rumah");
        }
        
    }

    public synchronized void beliBarang(Map<String, PurchasableObject> objectMap, String itemName, int amount) throws negativeParameterException, invalidMultitudeNumber, InterruptedException {
        if (amount < 0) {
            throw new negativeParameterException(amount);
        } else if (amount == 0) {
            throw new invalidMultitudeNumber(amount);
        } else {
            PurchasableObject object = objectMap.get(itemName);

            if (object != null) {
                Thread thread = new Thread(new Runnable() {
                    public synchronized void run(){

                        if (object.getPrice() * amount <= getUang() && !getIsItemInDelivery()) {
                            timeRemainingDelivery = new Random().nextInt(1, 5) * 30 * 1000;
                                    try {
                                            timeRemainingDelivery = new Random().nextInt(1, 5) * 30 * 1000;
                                            isItemInDelivery = true;
                                            System.out.println("\nAnda telah membeli " + ((ObjectSim) object).getNama() + " dengan harga " + object.getPrice() + ".");
                                            System.out.println("Mohon menunggu selama " + (float) timeRemainingDelivery / 60000 + " menit...");
                                            time.AksiSleep(activeDuration);
                                            int timeTemp = getTimeRemainingDelivery();
                                            timeRemainingDelivery -= activeDuration;
                                            if (timeRemainingDelivery < activeDuration) {
                                                time.AksiSleep(timeTemp);
                                                setUang(getUang()-object.getPrice() * amount);
                                                inventory.addItem((ObjectSim) object, amount);
                                                System.out.println("\nItem anda sudah masuk ke inventory!");
                                                System.out.println("Anda memiliki uang sebanyak " + getUang() + ".");
                                                System.out.println();
                                                isItemInDelivery = false;
                                            } 
                                            else {
                                                try{beliBarang(objectMap, itemName, amount);}
                                                catch(negativeParameterException n){
                                                    System.out.println(n.getMessage());
                                                }
                                                catch(invalidMultitudeNumber i){
                                                    System.out.println(i.getMessage());
                                                }
                                            } 
                                    }
                                    catch (InterruptedException e) {
                                        System.out.println(e.getMessage());
                                    }
                        }
                        else if(object.getPrice() * amount <= getUang() && getIsItemInDelivery()){
                            try {
                                System.out.println("\n\n###BARANG SEDANG DIKIRIM###");
                                System.out.println("Anda masih memiliki barang yang sedang dikirim, silahkan menunggu");
                                System.out.println("Mohon menunggu selama " + (float) timeRemainingDelivery / 60000 + " menit...");
                                System.out.println("###BARANG SEDANG DIKIRIM###\n");
                                time.AksiSleep(activeDuration);
                                int timeTemp = getTimeRemainingDelivery();
                                timeRemainingDelivery -= activeDuration;
                                if (timeRemainingDelivery < activeDuration) {
                                    time.AksiSleep(timeTemp);
                                    setUang(getUang()-object.getPrice() * amount);
                                    inventory.addItem((ObjectSim) object, amount);
                                    System.out.println("\nItem anda sudah masuk ke inventory!");
                                    System.out.println("Anda memiliki uang sebanyak " + getUang() + ".");
                                    System.out.println();
                                    isItemInDelivery = false;
                                } 
                                else {
                                    try{beliBarang(objectMap, itemName, amount);}
                                    catch(negativeParameterException n){
                                        System.out.println(n.getMessage());
                                    }
                                    catch(invalidMultitudeNumber i){
                                        System.out.println(i.getMessage());
                                    }
                                } 
                            }
                            catch (InterruptedException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        else {
                            System.out.println("Uang Anda tidak cukup untuk membeli " + ((ObjectSim) object).getNama());
                        }
                    }
                });

            thread.start();   
            } else {
                System.out.println("Item tidak ditemukan!");
            }
        }
    }

    public void karaoke(int durasi){
    //implementasi karaoke
        if(durasi <= 0 && durasi % 30 != 0){
            throw new IllegalArgumentException("durasi tidak sesuai");
        }
        setActiveDuration(durasi);
        
        this.setStatus("karaoke");
        kesejahteraan.updateMood(10*(durasi/30));
        kesejahteraan.updateKekenyangan((-10)*(durasi/30));
        System.out.println("baby shark dudurudduduuu");
         //Untuk selalu nambahin durasi gak buang air
         durasiTidakBuangAir += durasi;
    }

    public void melukis(int durasi){
    //implementasi untuk melukis
        if(durasi <= 0 && durasi % 20 != 0){
            throw new IllegalArgumentException("durasi tidak sesuai");
        }
        setActiveDuration(durasi);
        
        this.setStatus("Melukis");
        kesejahteraan.updateMood(5*(durasi/20));
        kesejahteraan.updateKekenyangan(5*(durasi/20));
         //Untuk selalu nambahin durasi gak buang air
         durasiTidakBuangAir += durasi;
    }

    public void simpanBarang(String lok, ObjectSim ob){
    //implementasi simpanBarang
        if(ob instanceof Furniture){
            this.setStatus("simpan barang");
            if(rumah.getRoom(lok) != null){
                rumah.getRoom(lok).getObjects().remove(ob);
            }
            inventory.addItem(ob, 1);
        }
    }

    public void pindahBarang(String lokAwal, ObjectSim ob, Lokasi lokAkhir, String lokRuang){
    //implementasi pindhBarang
        simpanBarang(lokAwal, ob);
        pasangBarang(lokRuang, ob, lokAkhir);
    }

    public void sholat(int durasi){
    //implementasi sholat
        if(durasi <= 0){
            throw new IllegalArgumentException("durasi tidak sesuai");
        }
        setActiveDuration(durasi);
        
        this.setStatus("sholat");
        kesejahteraan.updateMood(30);
         //Untuk selalu nambahin durasi gak buang air
        durasiTidakBuangAir += durasi;
    }

    public void mandi(int durasi){
    //implementasi mandi
        if(durasi <= 0){
            throw new IllegalArgumentException("durasi tidak sesuai");
        }
        setActiveDuration(durasi);
        
        this.setStatus("mandi");
        kesejahteraan.updateKesehatan(30);
        kesejahteraan.updateMood(10);
         //Untuk selalu nambahin durasi gak buang air
         durasiTidakBuangAir += durasi;
    }

    public void nontonNetflix(int durasi){
    //implementasi nontonNetflix
        if(durasi <= 0 && durasi % 40 != 0){
            throw new IllegalArgumentException("durasi tidak sesuai");
        }
        setActiveDuration(durasi);
        
        this.setStatus("menonton netflix");
        kesejahteraan.updateMood(15*(durasi/40));
        kesejahteraan.updateKekenyangan((-10)*(durasi/40));
        kesejahteraan.updateKesehatan((-2)*(durasi/40));
         //Untuk selalu nambahin durasi gak buang air
         durasiTidakBuangAir += durasi;
    }

    public void lihatInventory(){
    //implementasi lihat Inventory
        inventory.showInventory();
    }

    public void pasangBarang(String lokRuang, ObjectSim ob, Lokasi lokBarang){
    //implementasi pasangBarang
        this.setStatus("memasang barang");
        if(ob instanceof Furniture){
            Furniture f = (Furniture) ob;
            boolean can = rumah.getRoom(lokRuang).canPlaceObj(lokBarang, f);
            if(can){
                rumah.getRoom(lokRuang).getObjects().add(f);
                inventory.addItem(ob, -1);
            }
            else{
                System.out.println("Tidak dapat memasang barang di lokasi tersebut. Coba rotate barang atau pindahkan ke ruangan lain.");
            }
        }
        
        
    }

    public void lihatWaktu(){
    //implementasi lihatWaktu
        time.CetakWaktu();
    }

    public void gantiPekerjaan(WorkObject w){
        lamaKerja = time.getTimeInSec()-awalKerja;
        if(lamaKerja > 12*60 && uang >= (1/2*w.getJob().getPayRate())){    
            setPekerjaan(w);
            uang -= 1/2*w.getJob().getPayRate();
        } else{
            System.out.println("Lama bekerja belum 1 hari atau uang tidak mencukupi!");
        }
    }

    public void displayInfo(){
        System.out.println("Nama Lengkap          : " + namaLengkap);
        System.out.println("Pekerjaan             : "+ getPekerjaan().getJob().getTitle());
        System.out.println("Tingkat Kesehatan     : " + kesejahteraan.getKesehatan());
        System.out.println("Tingkat Kekenyangan   : " + kesejahteraan.getKekenyangan());
        System.out.println("Tingkat Mood          : " + kesejahteraan.getMood());
        System.out.println("Jumlah uang saat ini  :" + uang);
    }

    public Kesejahteraan getKesejahteraan(){
        return kesejahteraan;
    }

    public class Kesejahteraan {
        private int mood;
        private int kekenyangan;
        private int kesehatan;
        private boolean isMati;
        private String statusMati;

        public Kesejahteraan() {
            mood = 80;
            kekenyangan = 80;
            kesehatan = 80;
        }

        public int getMood(){
            return mood;
        }

        public int getKesehatan(){
            return kesehatan;
        }

        public int getKekenyangan(){
            return kekenyangan;
        }

        public void updateKesehatan(int kesehatan){
            this.kesehatan += kesehatan;
            if(this.kesehatan > 100){
                this.kesehatan = 100;
            }  else if(this.mood <= 0){
                isMati = true;
                statusMati = "Sim mati karena sakit :<";
            }
        }

        public void updateKekenyangan(int kekenyangan){
            this.kekenyangan += kekenyangan;
            if(this.kekenyangan > 100){
                this.kekenyangan = 100;
            }  else if(this.mood <= 0){
                isMati = true;
                statusMati = "Sim mati karena kelaparan :<";
            }
        }

        public void updateMood(int mood){
            this.mood += mood;
            if(this.mood > 100){
                this.mood = 100;
            } else if(this.mood <= 0){
                isMati = true;
                statusMati = "Sim mati karena mengalami depresi :<";
            }
        }

        public boolean getIsMati(){
            return isMati;
        }

        public String getStatusMati(){
            return statusMati;
        }

        public void setStatusMati(String s){
            this.statusMati = s;
        }

        public void displayKesejahteraan(){
            System.out.println("Mood : " + mood);
            System.out.println("Kekenyangan : " + kekenyangan);
            System.out.println("Kesehatan : " + kesehatan);
        }
    }
}
