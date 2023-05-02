import java.util.Scanner;
import util.*;
import objek.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Sim> pemain = new ArrayList<Sim>();
        Sim currentSim = null;
        boolean started = false;
        boolean finished = false;
        World w = null;

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
            //Main Menu
            String title =  
"░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
"░           ░   ░░░░   ░         ░░░░░░░░░      ░░░   ░   ░░░░░░░   ░        ░░░   ░░░░░░░░   ░░░░░   ░░░░   ░           ░   ░░░░░░   \n" +
"▒▒▒▒▒   ▒▒▒▒▒   ▒▒▒▒   ▒   ▒▒▒▒▒▒▒▒▒▒▒▒▒   ▒▒▒▒   ▒   ▒  ▒   ▒▒▒    ▒   ▒▒▒▒   ▒   ▒▒▒▒▒▒▒▒   ▒▒   ▒▒▒   ▒   ▒▒▒▒▒   ▒▒▒▒▒▒   ▒▒▒▒   ▒\n" +
"▒▒▒▒▒   ▒▒▒▒▒   ▒▒▒▒   ▒   ▒▒▒▒▒▒▒▒▒▒▒▒▒▒   ▒▒▒▒▒▒▒   ▒   ▒   ▒ ▒   ▒   ▒▒▒▒   ▒   ▒▒▒▒▒▒▒▒   ▒   ▒▒▒▒▒▒▒▒   ▒▒▒▒▒   ▒▒▒▒▒▒▒   ▒   ▒▒▒\n" +
"▓▓▓▓▓   ▓▓▓▓▓          ▓       ▓▓▓▓▓▓▓▓▓▓▓▓   ▓▓▓▓▓   ▓   ▓▓   ▓▓   ▓        ▓▓▓   ▓▓▓▓▓▓▓▓   ▓   ▓▓▓▓▓▓▓▓   ▓▓▓▓▓   ▓▓▓▓▓▓▓▓▓   ▓▓▓▓▓\n" +
"▓▓▓▓▓   ▓▓▓▓▓   ▓▓▓▓   ▓   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓   ▓▓   ▓   ▓▓▓  ▓▓   ▓   ▓▓▓▓▓▓▓▓   ▓▓▓▓▓▓▓▓   ▓   ▓▓▓▓▓▓▓▓   ▓▓▓▓▓   ▓▓▓▓▓▓▓▓▓   ▓▓▓▓▓\n" +
"▓▓▓▓▓   ▓▓▓▓▓   ▓▓▓▓   ▓   ▓▓▓▓▓▓▓▓▓▓▓▓▓   ▓▓▓▓   ▓   ▓   ▓▓▓▓▓▓▓   ▓   ▓▓▓▓▓▓▓▓   ▓▓▓▓▓▓▓▓   ▓▓   ▓▓▓   ▓   ▓▓▓▓▓   ▓▓▓▓▓▓▓▓▓   ▓▓▓▓▓\n" +
"█████   █████   ████   █         █████████      ███   █   ███████   █   ████████          █   ████     ███   █████   █████████   █████\n" +
"██████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████████\n";
                             
            System.out.println(title);
            System.out.println("Selamat datang di permainan The Simplicity!");
                System.out.println("Permainan ini merupakan permainan karakter virtual yaitu Sim yang dapat anda jalankan kegiatannya.");
                System.out.println("Terdapat beberapa command yang dapat Anda berikan sebelum permainan :");
                System.out.println("1. Start Game       : memulai permainan");
                System.out.println("2. Help             : bantuan dan petunjuk terkait permainan");
                System.out.println("3. Exit             : keluar dari permainan\n");
            System.out.print(">> ");
            String op = scan.nextLine();
            if(op.equalsIgnoreCase("Start Game")){
                w = World.getInstance();
                System.out.print("Permainan dimulai!! Selamat bermain^^\nSiapa nama simmu? ");
                String namaLengkap = scan.nextLine();
            
                boolean rumahValid = false;
                while(!rumahValid){
                    System.out.println("Tentukan lokasi rumah Sim (x, y)");
                    System.out.print("x: ");
                    int lokRx = scan.nextInt();
                    System.out.print("y: ");
                    int lokRy = scan.nextInt();
                    String temp = scan.nextLine();
                    if(w.isRumahAvailable(lokRx, lokRy)){
                        rumahValid = true;
                        Sim s = new Sim(namaLengkap, lokRx, lokRy);
                        currentSim = s;
                        pemain.add(s);
                        w.addRumah(currentSim.getRumah());
                        started = true;
                    }
                }
                System.out.println("Sim dengan nama "+ currentSim.getNamaLengkap() + " telah siap dimainkan!");
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
                System.out.println("Command tersebut belum dapat diakses karena anda belum memulai permainan");
            }
        }
        
        while(started && (!finished)){
            while(!currentSim.getKesejahteraan().getIsMati()){
                System.out.println("");
                System.out.println("---MAIN MENU---");
                System.out.println("Untuk info lanjut, pilih help!");
                System.out.println("1.  View Sim Info");
                    System.out.println("2.  View Current Location");
                    System.out.println("3.  View Inventory");
                    System.out.println("4.  Upgrade House");
                    System.out.println("5.  Move Room");
                    System.out.println("6.  Edit Room");
                    System.out.println("7.  Add Sim");
                    System.out.println("8.  Change Sim");
                    System.out.println("9.  List Object");
                    System.out.println("10. Go To Object");
                    System.out.println("11. Action");
                    System.out.println("12. Exit");
                if (currentSim.durasiTidakBuangAir % 240 == 0 && currentSim.sudahBuangAir){
                    currentSim.tidakBuangAir();
                } 
                System.out.print(">> ");
                String o;
                o = scan.nextLine();
                if(o.equals("View Sim Info")){
                    currentSim.displayInfo();
                } else if(o.equals("Help")){
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
                    System.out.println("12. Exit                     : Keluar dari permainan");
                } else if(o.equals("Exit")){
                    finished = true;
                } else if(o.equals("View Current Location")){
                    System.out.println("Saat ini sim berada di rumah dengan lokasi " + "("+currentSim.getLokSimRumah().getX() + ","+currentSim.getLokSimRumah().getY() + ") pada World, tepatnya pada ruangan " + currentSim.getLokRuang().getNamaRuangan());
                } else if(o.equals("View Inventory")){
                    currentSim.lihatInventory();
                } else if(o.equals("Upgrade House")){
                    if(currentSim.getLokSimRumah() == currentSim.getRumah().getLokRumah()){
                        //String namaRbaru = scan.nextLine();
                        //int tempx = scan.nextInt();
                        //int tempy = scan.nextInt();
                        if(currentSim.getUang() >= 1500){
                            currentSim.upgradeRumah();
                        } else {
                            System.out.println("Saldo Simmu tidak mencukupi untuk melakukan upgrade rumah! silahkan bekerja terlebih dahulu");
                        }
                    } else {
                        System.out.println("Anda sedang berada di rumah Sim lain. Anda tidak dapat melakukan upgrade terhadap rumah ini.");
                        System.out.println("Silahkan kembali ke rumah Anda terlebih dahulu untuk melakukan upgrade rumah");
                    }
                } else if(o.equals("Move Room")){
                    System.out.println("Ruangan apakah yang ingin kamu tuju?");
                    w.getRumah(currentSim.getLokSimRumah()).displayListRuangan();
                    String ruang = scan.nextLine();
                    if(w.getRumah(currentSim.getLokSimRumah()).getRoom(ruang) != null){
                        currentSim.setLokSimRuang(w.getRumah(currentSim.getLokSimRumah()).getRoom(ruang));
                    } else {
                        System.out.println("Ruangan tersebut tidak tersedia di dalam posisi rumah saat ini");
                    }
                } else if(o.equals("Edit Room")){
                    if(currentSim.getLokSimRumah() == currentSim.getRumah().getLokRumah()){
                        System.out.println("Opsi edit rumah apa yang ingin Anda lakukan? (Pilih dengan angka)");
                        System.out.println("1. Pembelian barang");
                        System.out.println("2. Pemindahan barang");
                        System.out.println("3. Pemasangan Barang");
                        System.out.println("4. Penyimpanan Barang");
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
                        } else if (opsi==3) {
                            //kode
                        } else if (opsi==4) {
                            //kode
                        } else {
                            System.out.println("Opsi tidak valid!");
                        }
                    }
                    else{
                        System.out.println("Anda sedang berada di rumah Sim lain. Anda tidak dapat melakukan edit terhadap rumah ini.");
                    }
                } else if(o.equals("Add Sim")) {
                    boolean namaValid = false;
                    System.out.println("Siapa nama sim baru?");
                    String nama = scan.nextLine();
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
                            Sim s = new Sim(nama, x, y);
                            pemain.add(s);
                            w.addRumah(s.getRumah());
                            System.out.println("Sim telah berhasil dibuat!");
                        }
                    }
                } else if(o.equals("Change Sim")){
                    int i = 1;
                    for(Sim s : pemain){
                        System.out.println(i + ". " + s.getNamaLengkap());
                        i++;
                    }
                    System.out.println("Siapa nama Sim yang ingin dimainkan? ");
                    String nama = scan.nextLine();
                    for(Sim s : pemain){
                        if(s.getNamaLengkap().equals(nama)){
                            currentSim = s;
                        }
                    }
                    if(!currentSim.getNamaLengkap().equals(nama)){
                        System.out.println("Sim tersebut belum terdaftar pada permainan Simplicity");
                    }
                } else if(o.equals("List Object")){
                    Ruangan temp = w.getRumah(currentSim.getLokSimRumah()).getRoom(currentSim.getLokRuang().getNamaRuangan());//currentSim.getRumah().getRoom(currentSim.getLokRuang().getNamaRuangan());
                    temp.displayRuangan();
                    int i = 1;
                    System.out.println("Berikut merupakan daftar objek di dalam ruangan saat ini");
                    for(ObjectSim ob : temp.getObjects()){
                        System.out.println(i + ". " + ob.getNama());
                        i++;
                    }
                } else if(o.equals("Go To Object")){
                    int temp = currentSim.getLokRuang().displayObjects();
                    if (temp==1) {
                        System.out.println("Tidak ada barang di ruangan ini!");
                    } else {
                        Boolean valid1 = false;
                        while (!valid1) {
                            System.out.println("Pilih objek yang ingin didatangi!");
                            System.out.println("Masukkan angka sesuai objek yang dipilih: ");
                            int choice = scan.nextInt();
                            String tempstr = scan.nextLine();
                            if (choice >= 1 && choice < temp) {
                                ObjectSim objTemp = currentSim.getLokRuang().getObjects().get(choice-1);
                                System.out.println("Berhasil pindah ke Object " + objTemp.getNama());
                                currentSim.move(objTemp);
                                valid1 = true;
                            } else {
                                System.out.println("Opsi tidak valid!");
                                System.out.println("");
                            }
                        }
                    }
                } else if(o.equals("Action")){
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

                    int ops=0;

                    Boolean validasi = false;
                    while (!validasi) {
                        System.out.println("");
                        System.out.println("Masukkan aksi yang ingin kamu lakukan dalam opsi ANGKA (1-13)");
                        int num = scan.nextInt();
                        String tempp = scan.nextLine();
                        if (num>=1 && num<14) {
                            ops = num;
                            validasi = true;
                        }
                    }
                    
                    if (ops==1) {
                        System.out.println("Sim akan bekerja!");
                        System.out.println("Berapa lama anda ingin Sim bekerja? (Input dalam detik)");
                        int dur = scan.nextInt();
                        String tempp = scan.nextLine();
                        currentSim.kerja(dur);
                    } else if (ops==2) {
                        System.out.println("Sim akan berolahraga!");
                        System.out.println("Berapa lama anda ingin Sim berolahraga? (Input dalam detik)");
                        int dur = scan.nextInt();
                        String tempp = scan.nextLine();
                        currentSim.olahraga(dur);
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
                            System.out.println("Berapa lama ingin mengunjungi rumah "+pemain.get(opsi-1).getNamaLengkap()+"?");
                            int dura = scan.nextInt();
                            String tempii = scan.nextLine();
                            currentSim.berkunjung(dura,lokSimKunjung);
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
                    } else { //ops==13
                        System.out.println("Kunjungi objek Kanvas!");
                    } 
                } else {
                    System.out.println("Command tersebut tidak tersedia");
                }
            }
            if(currentSim.getKesejahteraan().getIsMati()){
                System.out.println("Ooops... " + currentSim.getKesejahteraan().getStatusMati());
                pemain.remove(currentSim);
                w.getPerumahan().remove(currentSim.getRumah());
                currentSim = null;
                System.out.println("Apakah masih ingin melanjutkan permainan? (Yes/No)");
                String pil = scan.next();
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
                            if(s.getNamaLengkap().equals(nama)){
                                currentSim = s;
                            }
                        }
                        if(currentSim == null || (!currentSim.getNamaLengkap().equals(nama))){
                            System.out.println("Sim tersebut belum terdaftar pada permainan Simplicity");
                        }
                    } else {
                        System.out.println("Tidak ada Sim lain pada permainan ini. Silahkan menambahkan Sim baru!");
                        System.out.println("Siapa nama sim baru?");
                        String nama = scan.nextLine();
                        boolean namaValid = false;
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
                                Sim s = new Sim(nama, x, y);
                                pemain.add(s);
                                w.addRumah(s.getRumah());
                                currentSim = s; 
                                System.out.println("Sim telah berhasil dibuat!");
                            }
                        } 
                    }
                } else {
                    finished = true;
                }
            } else {
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

