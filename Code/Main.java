import java.util.Scanner;
import util.*;
import objek.*;
import java.util.*;
import display.*;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException{
        Scanner scan = new Scanner(System.in);
        ArrayList<Sim> pemain = new ArrayList<Sim>();
        Sim currentSim = null;
        boolean started = false;
        boolean finished = false;
        World w = null;
        boolean cTidakTidur = false;

        //Jobs
        Job badut = new Job("Badut Sulap", 15);
        Job koki = new Job("Koki", 30);
        Job polisi = new Job("Polisi", 100);
        Job programmer = new Job("Programmer", 40);
        Job dokter = new Job("Dokter", 45);
        Job[] allJobs = Job.getAllJobs(badut,koki,polisi,programmer,dokter);

        //Furniture
        Jam jam = new Jam();
        Kanvas kanvas = new Kanvas();
        KasurKing kasurKing = new KasurKing();
        KasurQueen kasurQueen = new KasurQueen();
        KasurSingle kasurSingle = new KasurSingle();
        KomporGas komporGas = new KomporGas();
        KomporListrik komporListrik = new KomporListrik();
        Laptop laptop = new Laptop();
        MejaKursi mejaKursi = new MejaKursi();
        Mic mic = new Mic();
        Sajadah sajadah = new Sajadah();
        Shower shower = new Shower();
        Toilet toilet = new Toilet();

        //Bahan Makanan
        Ayam ayam = new Ayam();
        Bayam bayam = new Bayam();
        Kacang kacang = new Kacang();
        Kentang kentang = new Kentang();
        Nasi nasi = new Nasi();
        Sapi sapi = new Sapi();
        Susu susu = new Susu();
        Wortel wortel = new Wortel();

        //Display
        Ascii display = new Ascii();

        //OBJECTS
        Map<String, PurchasableObject> purchasableMap = new HashMap<String, PurchasableObject>(){{
            put(jam.getNama(), jam);
            put(kanvas.getNama(), kanvas);
            put(kasurKing.getNama(), kasurKing);
            put(kasurQueen.getNama(), kasurQueen);
            put(kasurSingle.getNama(), kasurSingle);
            put(komporGas.getNama(), komporGas);
            put(komporListrik.getNama(), komporListrik);
            put(laptop.getNama(), laptop);
            put(mejaKursi.getNama(), mejaKursi);
            put(mic.getNama(), mic);
            put(sajadah.getNama(), sajadah);
            put(shower.getNama(), shower);
            put(toilet.getNama(), toilet);
            put(ayam.getNama(), ayam);
            put(bayam.getNama(), bayam);
            put(kacang.getNama(), kacang);
            put(kentang.getNama(), kentang);
            put(nasi.getNama(), nasi);
            put(sapi.getNama(), sapi);
            put(susu.getNama(), susu);
            put(wortel.getNama(), wortel);
        }};

        while(!started && !finished){

            //STARTING MENU
            display.title();
            System.out.println("Selamat datang di permainan The Simplicity! (ﾉ´ヮ`)ﾉ*: ･ﾟ");
                System.out.println("Permainan ini merupakan permainan karakter virtual yaitu Sim yang dapat anda jalankan kegiatannya!");
                System.out.println("Terdapat beberapa command yang dapat Anda berikan sebelum permainan :");
                System.out.println("1. Start Game       : Memulai permainan");
                System.out.println("2. Help             : Bantuan dan petunjuk terkait permainan");
                System.out.println("3. Exit             : Keluar dari permainan\n");
            System.out.println("Ketikkan commandmu dalam bentuk String! (Contoh: Start Game)");
            System.out.print(">> ");
            String op = scan.nextLine();

            //Option Handling
            if(op.equalsIgnoreCase("Start Game")){
                w = World.getInstance();
                System.out.println("");
                System.out.println("CREATING WORLD....( ´ ▿ ` )");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("");
                System.out.print("Permainan dimulai! Selamat bermain ^^\nKetikkan nama Sim-mu! ");
                String namaLengkap = scan.nextLine();
            
                //Sim Creation
                boolean rumahValid = false;
                while(!rumahValid){
                    System.out.println("");
                    System.out.println("Tentukan lokasi rumah Sim dalam koordinat(x,y)");
                    System.out.println("Lokasi koordinat minimum adalah (0,0) dan maksimum adalah (63,63)");
                    System.out.print("x: ");
                    int lokRx = scan.nextInt();
                    System.out.print("y: ");
                    int lokRy = scan.nextInt();
                    String temp = scan.nextLine();
                    if(w.isRumahAvailable(lokRx, lokRy)){
                        rumahValid = true;
                        Sim s = new Sim(namaLengkap, allJobs, lokRx, lokRy);
                        currentSim = s;
                        pemain.add(s);
                        w.addRumah(currentSim.getRumah());
                        started = true;
                    }
                }
                System.out.println("CREATING SIM....( ´ ▿ ` )");
                System.out.println("");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("Sim dengan nama "+ currentSim.getNamaLengkap() + " telah siap dimainkan! ＼(＾▽＾)／");
                System.out.println("");
                System.out.println("LOADING MAIN MENU....( ´ ▿ ` )");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException ex){
                    ex.printStackTrace();
                }
                System.out.println("");

            } else if(op.equalsIgnoreCase("Help")){
                System.out.println("Selamat datang di permainan Simplicity!");
                System.out.println("permainan ini merupakan permainan karakter virtual yaitu Sim yang dapat anda jalankan kegiatannya.");
                System.out.println("Terdapat beberapa command yang dapat Anda berikan sebelum permainan :");
                System.out.println("1. Start Game       : memulai permainan");
                System.out.println("2. Help             : bantuan dan petunjuk terkait permainan");
                System.out.println("3. Exit             : keluar dari permainan");
            } else if(op.equalsIgnoreCase("Exit")){
                System.out.println("Game akan berakhir.. Terimakasih telah bermain!! ^^");
                finished = true;
            } else {
                System.out.println("Command tersebut belum dapat diakses karena anda belum memulai permainan!");
            }
        }
        
        while(started && !finished){
            while(!currentSim.getKesejahteraan().getIsMati() && !finished){
                System.out.println("");
                display.menu();
                System.out.println("Untuk info lanjut, pilih help!");
                System.out.println("1.  View Sim Info");
                    System.out.println("2.  View Current Location");
                    System.out.println("3.  View Inventory");
                    System.out.println("4.  Upgrade House");
                    System.out.println("5.  View House");
                    System.out.println("6.  Move Room");
                    System.out.println("7.  Edit Room");
                    System.out.println("8.  Add Sim");
                    System.out.println("9.  Change Sim");
                    System.out.println("10. List Object");
                    System.out.println("11. Go To Object");
                    System.out.println("12. Action");
                    System.out.println("13. Change Job");
                    System.out.println("14. Exit");
                    System.out.println("");
                
                //Tidak buang air
                // if (currentSim.durasiTidakBuangAir >= 240 && !currentSim.sudahBuangAir && currentSim.sudahMakan){
                //     currentSim.tidakBuangAir();
                //     System.out.println(currentSim.getNamaLengkap() + " tidak buang air selama 4 menit, kesejahteraan berkurang");
                // }
                
                for (Sim s : pemain){
                    if(s.sudahMakan){
                        if(Sim.time.getMin()*60 + Sim.time.getSec() - s.waktuTerakhirMakan >= 240 && !s.sudahBuangAir){
                            s.tidakBuangAir();
                            System.out.println(s.getNamaLengkap()+ " sudah makan tetapi belum buang air dalam 4 menit");
                        }
                    }
                } 

                // ini reset harian
                if(Sim.time.getCheck() == 2){
                    for(Sim s : pemain){
                        s.resetHarian();
                    }
                    cTidakTidur = false;
                    Sim.time.setCheck(1);
                }

                // ini tidur kalo kaya gini kalo misal menit ke 10nya ke skip gmn cara ngeceknya?!
                //System.out.println((Sim.time.getMin()*60)+ Sim.time.getSec()); //ini walaupun uda di jalanin aksi apapun, hasilnya ttp 0
                if((((Sim.time.getMin()*60)+ Sim.time.getSec() >= 600)) && (!cTidakTidur)){
                    //System.out.println("tes123");
                    for(Sim s : pemain){
                        //System.out.println(s.sudahTidur);
                        if(!s.sudahTidur){
                            int kel = ((Sim.time.getMin()*60)+ Sim.time.getSec())/600;
                            s.tidakTidur(kel);
                            //System.out.println(s.getNamaLengkap() + " belum tidur setelah "+10*kel+" menit, kesehatan akan berkurang");
                            //System.out.println();
                        }
                    }
                    cTidakTidur = true;
                }

                if(Sim.time.getTimeSec() - currentSim.awalGantiKerja > 60){
                    currentSim.baruKerja=false;
                }

                //Cek Kematian yang dimainkan
                for(Sim s : pemain){
                    if(s.getKesejahteraan().getIsMati()){
                        System.out.println("Ooops... Sim bernama " + s.getNamaLengkap() + " " + s.getKesejahteraan().getStatusMati());
                        pemain.remove(s);
                        w.getPerumahan().remove(s.getRumah());
                    }
                }
            
                //Cek Kematian yang dikunjungi
                if (currentSim.getStatus().equals("Berkunjung")){
                    Sim dikunjungi = null;
                    for (Sim player : pemain) {
                        if (player.getRumah()==w.getRumah(currentSim.getLokSimRumah())) {
                            dikunjungi = player;
                        }
                    }
                    if (dikunjungi.getKesejahteraan().getIsMati()) {
                        System.out.println("Sim yang sedang kau kunjungi sudah mati. Kembali ke rumahmu...");
                        currentSim.setLokSimRumah(currentSim.getRumah().getLokRumah());
                        currentSim.setLokSimRuang(currentSim.getRumah().getRoom("Kamar"));
                    }
                }
            
                System.out.print(">> ");
                String o;
                o = scan.nextLine();
                if(o.equalsIgnoreCase("View Sim Info")){
                    currentSim.displayInfo();
                } else if(o.equalsIgnoreCase("Help")){
                    System.out.println("permainan ini merupakan permainan karakter virtual yaitu Sim yang dapat anda jalankan kegiatannya.");
                    System.out.println("Terdapat beberapa command yang dapat Anda berikan setelah memulai permainan :");
                    System.out.println("1.  View Sim Info            : Melihat informasi kondisi Sim saat ini");
                    System.out.println("2.  View Current Location    : Informasi posisi Sim saat ini");
                    System.out.println("3.  View Inventory           : Melihat isi inventory milik Sim");
                    System.out.println("4.  Upgrade House            : Melakukan perbaikan rumah, yaitu menambah ruangan");
                    System.out.println("5.  Move Room                : Berpindah menuju ruangan lain");
                    System.out.println("6.  Edit Room                : Melakukan perubahan terhadap ruangan saat ini");
                    System.out.println("7.  Add Sim                  : Menciptakan karakter Sim baru");
                    System.out.println("8.  Change Sim               : Mengganti Sim yang dimainkan");
                    System.out.println("9.  List Object              : Menampilkan daftar Objek di dalam ruangan");
                    System.out.println("10. Go To Object             : Sim berjalan menuju objek");
                    System.out.println("11. Action                   : Melakukan aksi pada suatu objek");
                    System.out.println("12. Change Job               : Mengganti pekerjaan yang dimiliki oleh Sim");
                    System.out.println("13. Exit                     : Keluar dari permainan");
                } else if(o.equalsIgnoreCase("Exit")){
                    System.out.println("Game akan berakhir.. Terimakasih telah bermain!! ^^");
                    finished = true;
                } else if(o.equalsIgnoreCase("View Current Location")){
                    String format = "+-----------------------+-----------------------+\n";
                    System.out.print(format);
                    System.out.printf("|%-23s|%-23s|\n", "Lokasi", "Ruang");
                    System.out.print(format);
                    System.out.printf("|%-23s|%-23s|\n", "(" + currentSim.getLokSimRumah().getX() + "," + currentSim.getLokSimRumah().getY() + ")", currentSim.getLokRuang().getNamaRuangan());
                    System.out.print(format);
                } else if(o.equalsIgnoreCase("View Inventory")){
                    currentSim.lihatInventory();
                } else if(o.equalsIgnoreCase("Upgrade House")){
                    if(currentSim.getLokSimRumah() == currentSim.getRumah().getLokRumah()){
                        //String namaRbaru = scan.nextLine();
                        //int tempx = scan.nextInt();
                        //int tempy = scan.nextInt();
                        currentSim.upgradeRumah();
                    } else {
                        System.out.println("Anda sedang berada di rumah Sim lain. Anda tidak dapat melakukan upgrade terhadap rumah ini.");
                        System.out.println("Silahkan kembali ke rumah Anda terlebih dahulu untuk melakukan upgrade rumah");
                    }
                } else if(o.equalsIgnoreCase("View House")){
                    System.out.println("");
                    System.out.println(currentSim.getNamaLengkap()+"'s House");
                    System.out.println("");
                    currentSim.getRumah().displayRumah();
                } else if(o.equalsIgnoreCase("Move Room")){
                    System.out.println("Ruangan apakah yang ingin kamu tuju? Ketik dalam string!");
                    w.getRumah(currentSim.getLokSimRumah()).displayListRuangan();
                    String ruang = scan.nextLine();
                    if(w.getRumah(currentSim.getLokSimRumah()).getRoom(ruang) != null){
                        System.out.println("Moving to "+w.getRumah(currentSim.getLokSimRumah()).getRoom(ruang).getNamaRuangan()+"....( ´ ▿ ` )");
                        try {
                            Thread.sleep(3000);
                        } catch (InterruptedException ex){
                            ex.printStackTrace();
                        }
                        System.out.println("");
                        currentSim.setLokSimRuang(w.getRumah(currentSim.getLokSimRumah()).getRoom(ruang));
                        System.out.println("Berhasil pindah ke "+currentSim.getLokRuang().getNamaRuangan());
                    } else {
                        System.out.println("Ruangan tersebut tidak tersedia di dalam posisi rumah saat ini");
                    }
                } else if(o.equalsIgnoreCase("Edit Room")){
                    if(currentSim.getLokSimRumah() == currentSim.getRumah().getLokRumah()){
                        System.out.println("Opsi edit rumah apa yang ingin Anda lakukan? (Pilih dengan angka)");
                        System.out.println("1. Pembelian barang");
                        System.out.println("2. Pemasangan Barang");
                        System.out.println("3. Penyimpanan Barang");
                        System.out.print(">> ");
                        int opsi = scan.nextInt();
                        String tempp = scan.nextLine();
                        if(opsi == 1){
                            //tampilin
                            System.out.println("Barang apa yang ingin anda beli?");
                            Scanner scanBarang = new Scanner(System.in);
                            String inputBarang = scanBarang.nextLine();
                            int inputJumlahBarang = scanBarang.nextInt();
                            try{
                                currentSim.beliBarang(purchasableMap, inputBarang, inputJumlahBarang);
                            }
                            catch (invalidMultitudeNumber n){
                                System.out.println(n.getMessage());
                            }
                            catch (negativeParameterException e){
                                System.out.println(e.getMessage());
                            }
                            catch (InterruptedException p){
                                System.out.println(p.getMessage());
                            }                           
                        } else if (opsi==2) {
                            //kode
                            currentSim.lihatInventory();
                            System.out.println("Barang apa yang ingin anda pasang?");
                            Scanner scanBarang = new Scanner(System.in);
                            String inputBarang = scanBarang.nextLine();
                            System.out.println("Di Ruang apa anda ingin memasang barang tersebut?");
                            String inputRuang = scanBarang.nextLine();
                            System.out.println("Berikut adalah display ruangan "+inputRuang);
                            currentSim.getRumah().getRoom(inputRuang).displayRuangan();
                            System.out.println("Di posisi berapa anda ingin memasang barang tersebut?");
                            System.out.print("x: ");
                            int lokX = scanBarang.nextInt();
                            System.out.print("y: ");
                            int lokY = scanBarang.nextInt();
                            String temp = scanBarang.nextLine();
                            Lokasi lokTemp = new Lokasi(lokX, lokY);
                            System.out.println("Tentukan kondisi vertikal/horizontal barang tersebut (v/h)");
                            String inputKondisi = scanBarang.nextLine();
                        
                            currentSim.pasangBarang(purchasableMap, inputRuang, inputBarang, lokTemp, inputKondisi);
                            
                        } else if (opsi==3) {
                            //kode
                            Ruangan temp = w.getRumah(currentSim.getLokSimRumah()).getRoom(currentSim.getLokRuang().getNamaRuangan());//currentSim.getRumah().getRoom(currentSim.getLokRuang().getNamaRuangan());
                            temp.displayRuangan();
                            int i = 1;
                            System.out.println("Berikut merupakan daftar objek di dalam ruangan saat ini");
                            for(ObjectSim ob : temp.getObjects()){
                                System.out.println(i + ". " + ob.getNama());
                                i++;
                            }
                            System.out.println("Barang apa yang ingin anda simpan?");
                            Scanner scanBarang = new Scanner(System.in);
                            String inputBarang = scanBarang.nextLine();
                            currentSim.simpanBarang(currentSim.getLokRuang().getNamaRuangan(), purchasableMap, inputBarang);
                        } else {
                            System.out.println("Opsi tidak valid!");
                        }
                    }
                    else{
                        System.out.println("Anda sedang berada di rumah Sim lain. Anda tidak dapat melakukan edit terhadap rumah ini.");
                    }
                } else if(o.equalsIgnoreCase("Add Sim")) {
                    if (!currentSim.sudahAddSim){
                        boolean namaValid = false;
                        System.out.println("Add a new friend for your Sim(s) °˖✧◝(⁰▿⁰)◜✧˖°");
                        System.out.println("Siapa nama sim baru? Inputkan Stringnya!");
                        String nama = scan.nextLine();
                        System.out.println("");
                        while(!namaValid){
                            for(Sim s : pemain){
                                if(s.getNamaLengkap().equals(nama)){
                                    namaValid = false;
                                    break;
                                } else {
                                    namaValid = true;
                                }
                            }
                            if(!namaValid){
                                System.out.println("Sim dengan nama tersebut telah tersedia. Silahkan masukkan nama lain");
                                System.out.println("Siapa nama sim baru?");
                                nama = scan.nextLine();
                            }
                        }
                        boolean rumahValid = false;
                        while(!rumahValid){
                            System.out.println("Dimana lokasi rumah yang diinginkan? (x, y) ");
                            System.out.print("x: ");
                            int x = scan.nextInt();
                            System.out.print("y: ");
                            int y = scan.nextInt();
                            String temp = scan.nextLine();
                            if(w.isRumahAvailable(x, y)){
                                rumahValid = true;
                                Sim s = new Sim(nama, allJobs, x, y);
                                pemain.add(s);
                                w.addRumah(s.getRumah());
                                System.out.println("");
                                System.out.println("Sim dengan nama " + nama + " telah berhasil dibuat!");
                                System.out.println("Untuk memainkan Sim ini, ingat untuk memilih opsi Change Sim!");
                            }
                        }
                        currentSim.sudahAddSim = true;
                    }
                    else{
                        System.out.println("Hari ini anda sudah melakukan Add Sim. Kembali lagi besok yaa!");
                    }
                    
                } else if(o.equalsIgnoreCase("Change Sim")){
                    int i = 1;
                    for(Sim s : pemain){
                        System.out.println(i + ". " + s.getNamaLengkap());
                        i++;
                    }
                    System.out.println("Siapa nama Sim yang ingin dimainkan? ");
                    String nama = scan.nextLine();
                    for(Sim s : pemain){
                        if(s.getNamaLengkap().equalsIgnoreCase(nama)){
                            currentSim = s;
                            System.out.println("Kamu akan bermain sebagai Sim "+currentSim.getNamaLengkap()+" !");
                        }
                    }
                    if(!currentSim.getNamaLengkap().equalsIgnoreCase(nama)){
                        System.out.println("Sim tersebut belum terdaftar pada permainan Simplicity");
                    }
                } else if(o.equalsIgnoreCase("List Object")){
                    Ruangan temp = w.getRumah(currentSim.getLokSimRumah()).getRoom(currentSim.getLokRuang().getNamaRuangan());//currentSim.getRumah().getRoom(currentSim.getLokRuang().getNamaRuangan());
                    temp.displayRuangan();
                    int i = 1;
                    System.out.println("Berikut merupakan daftar objek di dalam ruangan saat ini");
                    for(ObjectSim ob : temp.getObjects()){
                        System.out.println(i + ". " + ob.getNama());
                        i++;
                    }
                } else if(o.equalsIgnoreCase("Go To Object")){
                    int temp = currentSim.getLokRuang().displayObjects();
                    if (temp==1) {
                        System.out.println("Tidak ada barang di ruangan ini!");
                    } else {
                        Boolean valid1 = false;
                        while (!valid1) {
                            try{
                                System.out.println("Pilih objek yang ingin didatangi!");
                                System.out.println("Masukkan angka sesuai objek yang dipilih: ");
                                int choice = scan.nextInt();
                                scan.nextLine();
                                if (choice >= 1 && choice < temp) {
                                    ObjectSim objTemp = currentSim.getLokRuang().getObjects().get(choice-1);
                                    System.out.println("Berhasil pindah ke Object " + objTemp.getNama());
                                    currentSim.move(objTemp);
                                    if (objTemp.getNama().equals("Meja dan Kursi")){
                                        currentSim.waktuTerakhirMakan = currentSim.time.getMin()*60 + currentSim.time.getSec();
                                    }
                                    valid1 = true;
                                } else {
                                    System.out.println("Opsi tidak valid!");
                                    System.out.println("");
                                }
                            } catch (Exception e) {
                                System.out.println("Input harus berupa angka, silakan coba lagi.");
                                System.out.println();
                                scan.nextLine();
                            }
                        } 
                    }
                } else if(o.equalsIgnoreCase("Action")){
                    System.out.println("");
                    System.out.println("---A C T I O N---");
                    System.out.println("Berikut adalah aksi yang dapat kamu lakukan di game ini!");
                    System.out.println("1. Kerja");
                    System.out.println("2. Olahraga");
                    System.out.println("3. Tidur");
                    System.out.println("4. Makan");
                    System.out.println("5. Memasak");
                    System.out.println("6. Berkunjung");
                    System.out.println("7. Buang Air");
                    System.out.println("8. Melihat Waktu");
                    System.out.println("9. Mandi");
                    System.out.println("10. Sholat");
                    System.out.println("11. Karaoke");
                    System.out.println("12. Nonton Netflix");
                    System.out.println("13. Melukis");
                    System.out.println("14. Menjual Furnitur");
                    System.out.println("15. Exit Menu Action");


                    int ops=0;

                    Boolean validasi = false;
                    while (!validasi) {
                        Boolean validInput1=false;
                        System.out.println("Masukkan aksi yang ingin kamu lakukan dalam opsi ANGKA (1-15)");
                        int num=0;
                        while (!validInput1) {
                            try {
                                num = scan.nextInt();
                                System.out.println();
                                validInput1 = true;
                            } catch (Exception e) {
                                System.out.println("Input harus berupa angka, silakan coba lagi.");
                                scan.nextLine();
                            }
                        }
                        String tempp = scan.nextLine();
                        if (num>=1 && num<=15) {
                            ops = num;
                            validasi = true;
                        }
                    }
                    
                    if (ops==1) {
                        if(currentSim.baruKerja == false){
                            if(!currentSim.sudahKerja){
                                System.out.println("Sim akan bekerja!");
                                System.out.println("Berapa lama anda ingin Sim bekerja? (Input dalam detik)");
                                Boolean validInput3 = false;
                                int dur=0;
                                while (!validInput3) {
                                    try {
                                        dur = scan.nextInt();
                                        scan.nextLine();
                                        if(dur <= 0){
                                            throw new IllegalArgumentException("durasi harus lebih dari 0 detik");
                                        }
                                        if(dur != 120){
                                            throw new IllegalArgumentException("durasi kerja harus 120 detik");
                                        } else {
                                        validInput3 = true;
                                        }
                                    } catch (Exception e) {
                                        System.out.println();
                                        System.out.println("Input tidak valid, silakan masukan durasi dengan angka kelipatan 120 detik dan lebih dari 0");
                                    }
                                } 
                                currentSim.kerja(dur);
                                currentSim.sudahKerja = true;
                            } else {
                                System.out.println("Hari ini sudah bekerja, silahkan bekerja lagi besok.");
                            }
                        } else {
                            System.out.println("Sim baru berganti pekerjaan dan baru bisa bekerja setelah 1 hari");
                        }
                    } else if (ops==2) {
                        System.out.println("Sim akan berolahraga!");
                        System.out.println("Berapa lama anda ingin Sim berolahraga? (Input dalam detik)");
                        Boolean validInput3 = false;
                        int dur=0;
                        while (!validInput3) {
                            try {
                                dur = scan.nextInt();
                                scan.nextLine();
                                if(dur <= 0){
                                    throw new IllegalArgumentException("durasi harus lebih dari 0 detik");
                                }
                                else if(dur % 20 != 0){
                                    throw new IllegalArgumentException("durasi harus kelipatan 20 detik");
                                } else {
                                validInput3 = true;
                                }
                            } catch (Exception e) {
                                System.out.println();
                                System.out.println("Input tidak valid, silakan masukan durasi dengan angka kelipatan 20 detik dan lebih dari 0");
                            }
                        } currentSim.olahraga(dur);
                    } else if (ops==3) {
                        System.out.println("Kunjungi objek Kasur!");
                    } else if (ops==4) {
                        System.out.println("Kunjungi objek Meja dan Kursi!");
                    } else if (ops==5) {
                        System.out.println("Kunjungi objek Kompor!");
                    } else if (ops==6) {
                        if (pemain.size()==1) {
                            System.out.println("Hanya terdapat 1 Sim di dunia ini :( Coba add Sim lain supaya Sim mu tidak kesepian!");
                        } else {
                            System.out.println("Kamu ingin mengunjungi rumah siapa?");
                            int j = 1;
                            for (Sim sim : pemain) {
                                System.out.println(j+". "+sim.getNamaLengkap());
                                j++;
                            }

                            int opsi = 0;

                            Boolean validasii = false;
                            while (!validasii) {
                                System.out.println("Masukkan pilihanmu dengan ANGKA");
                                opsi = scan.nextInt();
                                String tempi = scan.nextLine();
                                if (opsi>=1 && opsi<=pemain.size()) {
                                    validasii=true;
                                }
                            }
                            Lokasi lokSimKunjung = pemain.get(opsi-1).getLokSimRumah();
                            currentSim.berkunjung(lokSimKunjung);
                        }
                    } else if (ops==7) {
                        System.out.println("Kunjungi objek Toilet!");
                    } else if (ops==8) {
                        System.out.println("Kunjungi objek Jam!");
                    } else if (ops==9) {
                        System.out.println("Kunjungi objek Shower!");
                    } else if (ops==10) {
                        System.out.println("Kunjungi objek Sajadah!");
                    } else if (ops==11) {
                        System.out.println("Kunjungi objek Mic!");
                    } else if (ops==12) {
                        System.out.println("Kunjungi objek Laptop!");
                    } else if (ops==13) { //ops==13
                        System.out.println("Kunjungi objek Kanvas!");
                    } else if (ops ==14){
                        currentSim.lihatInventory();
                        System.out.println("Furnitur apa yang ingin kamu jual?");
                        String namaItem = scan.nextLine();
                        System.out.println("Berapa jumlah yang ingin kamu jual?");
                        int jumlah = scan.nextInt();
                        scan.nextLine();
                        currentSim.jualBarang(purchasableMap, namaItem, jumlah);
                    }
                    else {
                        System.out.println("Kamu sudah keluar dari menu action!");
                    }
                } else if(o.equalsIgnoreCase("Change Job")){ 
                    System.out.println("Saat ini pekerjaanmu adalah " + currentSim.getPekerjaan().getTitle());
                    System.out.println("Berikut merupakan daftar pekerjaan yang ada :");
                    String[] jobs = {"Badut Sulap", "Koki", "Polisi", "Programmer", "Dokter"};
                    int j =1;
                    for(int i = 0; i < jobs.length ;i++ ){
                        if(!jobs[i].equals(currentSim.getPekerjaan().getTitle())){
                            System.out.println(j + ". " + jobs[i]);
                            j++;
                        }
                    }
                    System.out.println("Tentukan pekerjaan apa yang ingin kamu lakukan (nama pekerjaan): ");
                    String jobNew = scan.nextLine();
                    boolean jobValid = false;
                    for(String s : jobs){
                        if(jobNew.equalsIgnoreCase(s)){
                            jobValid = true;
                        }
                    }
                    if(jobValid==true){
                        if(jobNew.equalsIgnoreCase("Badut Sulap")){
                            currentSim.gantiPekerjaan(badut);
                        } if(jobNew.equalsIgnoreCase("Koki")){
                            currentSim.gantiPekerjaan(koki);
                        } if(jobNew.equalsIgnoreCase("Polisi")){
                            currentSim.gantiPekerjaan(polisi);
                        } if(jobNew.equalsIgnoreCase("Programmer")){
                            currentSim.gantiPekerjaan(programmer);
                        } if(jobNew.equalsIgnoreCase("Dokter")){
                            currentSim.gantiPekerjaan(dokter);
                        }
                    } else {
                        System.out.println("Pekerjaan yang kamu pilih tidak valid");
                    }
                } else {
                    System.out.println("Command tersebut tidak tersedia");
                }
                if(!finished){
                    System.out.println("");
                    System.out.println("Ketik BACK untuk kembali ke Main Menu");
                    String inp1 = scan.nextLine();
                    while (!inp1.equalsIgnoreCase("BACK")) {
                        System.out.println("Periksa kembali input stringnya!");
                        inp1 = scan.nextLine();
                    }
                }
                
            }
            if(currentSim.getKesejahteraan().getIsMati()){
                System.out.println("Ooops... Sim bernama " + currentSim.getNamaLengkap() + " " + currentSim.getKesejahteraan().getStatusMati());
                pemain.remove(currentSim);
                w.getPerumahan().remove(currentSim.getRumah());
                currentSim = null;
                System.out.println("Apakah masih ingin melanjutkan permainan? (Yes/No)");
                String pil = scan.nextLine();
                boolean opvalid = false;
                while(!opvalid){
                    if(pil.equals("Yes")){
                        if(pemain.size() > 1){
                            System.out.println("Silahkan pilih Sim lain yang ingin dimainkan: ");
                            int i = 1;
                            for(Sim s : pemain){
                                System.out.println(i + ". " + s.getNamaLengkap());
                                i++;
                            }
                            String nama = scan.nextLine();
                            for(Sim s : pemain){
                                if(s.getNamaLengkap().equalsIgnoreCase(nama)){
                                    currentSim = s;
                                }
                            }
                            if(currentSim == null || (!currentSim.getNamaLengkap().equalsIgnoreCase(nama))){
                                System.out.println("Sim tersebut belum terdaftar pada permainan Simplicity");
                            }
                        } else {
                            System.out.println("Tidak ada Sim lain pada permainan ini. Silahkan menambahkan Sim baru!");
                            System.out.println("Siapa nama sim baru?");
                            String nama = scan.nextLine();
                            boolean namaValid = false;
                            if(pemain.size() <=0){
                                namaValid = true;
                            } 
                            while(!namaValid){
                                for(Sim s : pemain){
                                    if(s.getNamaLengkap().equalsIgnoreCase(nama)){
                                        namaValid = false;
                                        break;
                                    } else {
                                        namaValid = true;
                                    }
                                }
                                if(!namaValid){
                                    System.out.println("Sim dengan nama tersebut telah tersedia. Silahkan masukkan nama lain");
                                    System.out.println("Siapa nama sim baru?");
                                    nama = scan.nextLine();
                                }
                                
                            }
                            boolean rumahValid = false;
                            while(!rumahValid){
                                System.out.println("Dimana lokasi rumah yang diinginkan? (x, y) ");
                                System.out.print("x: ");
                                int x = scan.nextInt();
                                System.out.print("y: ");
                                int y = scan.nextInt();
                                String temp = scan.nextLine();
                                if(w.isRumahAvailable(x, y)){
                                    rumahValid = true;
                                    Sim s = new Sim(nama, allJobs, x, y);
                                    pemain.add(s);
                                    w.addRumah(s.getRumah());
                                    currentSim = s; 
                                    System.out.println("Sim telah berhasil dibuat!");
                                }
                            } 
                        }
                        opvalid = true;
                    } else if(pil.equals("No")) {
                        finished = true;
                        opvalid = true;
                    } else {
                        System.out.println("Opsi yang dipilih tidak valid!");
                        System.out.println("Silahkan pilih antara kedua opsi berikut : (Yes/No)");
                        pil = scan.nextLine();
                    }
                }
            }
        }
        
        // World w = new World();
        // System.out.print("Permainan dimulai\nSiapa nama simmu? ");
        // String namaLengkap = scan.nextLine();
        // System.out.print("Tentukan lokasi rumah Sim (x, y): ");
        // int lokRx = scan.nextInt();
        // int lokRy = scan.nextInt();
        // Sim s = new Sim(namaLengkap, lokRx, lokRy);

        // s.getRumah().getRoom("kamar").displayRuangan();
        // s.olahraga(60);
        // System.out.println(s.getNamaLengkap() + " sedang melakukan " + s.getStatus());
        // s.kesejahteraan.displayKesejahteraan();
        // s.displayInfo();
        // s.beliBarang(200, new KomporGas(), 1);
        // s.lihatInventory();
    }
}

