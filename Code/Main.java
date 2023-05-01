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
            if(op.equals("Start Game")){
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
            } else if(op.equals("Help")){
                System.out.println("Selamat datang di permainan Simplicity!");
                System.out.println("permainan ini merupakan permainan karakter virtual yaitu Sim yang dapat anda jalankan kegiatannya.");
                System.out.println("Terdapat beberapa command yang dapat Anda berikan sebelum permainan :");
                System.out.println("1. Start Game       : memulai permainan");
                System.out.println("2. Help             : bantuan dan petunjuk terkait permainan");
                System.out.println("3. Exit             : keluar dari permainan");
            } else if(op.equals("Exit")){
                System.out.println("Game akan berakhir.. Terimakasih telah bermain!! ^^");
                finished = true;
            } else {
                System.out.println("Command tersebut belum dapat diakses karena anda belum memulai permainan");
            }
        }
        
        while(started && (!finished) && !currentSim.getKesejahteraan().getIsMati()){
            while(!currentSim.getKesejahteraan().getIsMati()){
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
                        currentSim.upgradeRumah();
                        
                    }
                } else if(o.equals("Move Room")){
                    System.out.println("Ruangan apakah yang ingin kamu tuju?");
                    String ruang = scan.nextLine();
                    if(w.getRumah(currentSim.getLokSimRumah()).getRoom(ruang) != null){
                        currentSim.setLokSimRuang(w.getRumah(currentSim.getLokSimRumah()).getRoom(ruang));
                    } else {
                        System.out.println("Ruangan tersebut tidak tersedia di dalam posisi rumah saat ini");
                    }
                } else if(o.equals("Edit Room")){
                    System.out.println("Opsi edit rumah apa yang ingin Anda lakukan? (Pilih dengan angka)");
                    System.out.println("1. Pembelian barang");
                    System.out.println("2. Pemindahan barang");
                    System.out.print(">> ");
                    int opsi = scan.nextInt();
                    if(opsi == 1){
                        System.out.println("Barang apa yang ingin anda beli?");
                        //currentSim.beliBarang(opsi, null, opsi);
                    } else if(opsi == 2){

                    } else {
                        System.out.println("X X Opsi tersebut tidak tersedia X X");
                    }
                }else if(o.equals("Add Sim")){
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
                            if (choice >= 1 && choice < temp) {
                                ObjectSim objTemp = currentSim.getLokRuang().getObjects().get(choice-1);
                                currentSim.setCurObject(objTemp);
                                System.out.println("Berhasil pindah ke Object " + objTemp.getNama());
                                //Bantuin set kode buat tampilin aksi si objek dong ges
                                System.out.println("Berikut merupakan aksi yang dapat Anda lakukan terhadap objek:");
                                Furniture f = (Furniture) currentSim.getCurObject(objTemp);
                                f.displayListAksi();
                                String temp1 = scan.nextLine();
                                valid1 = true;
                            } else {
                                System.out.println("Opsi tidak valid!");
                                System.out.println("");
                            }
                        }
                    }
                } else if(o.equals("Action")){
                    Boolean closed = false;
                    while (!closed) {
                        System.out.println("Halo! Apa yang ingin kamu lakukan?");
                        System.out.println("1. Aksi Aktif");
                        System.out.println("2. Aksi Pasif (Time-Consuming)");
                        System.out.println("3. Aksi Instan");
                        System.out.println("4. Tutup Menu Aksi");
                        int opsi = scan.nextInt();
                        if (opsi==4) {
                            closed = true;
                        } else if (opsi<1 || opsi>4) {
                            System.out.println("Mohon masukkan opsi yang valid");
                        } else {
                            if (opsi==1) {
                                //kode aksi aktif
                            } else if (opsi==2) {
                                //kode aksi pasif
                            } else {
                                //kode aksi instan
                            }
                        }
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

