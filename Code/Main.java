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
                System.out.println("1. Start Game       : command yang dapat Anda gunakan untuk memulai permainan");
                System.out.println("2. Help             : command yang dapat memberikan Anda bantuan dan petunjuk terkait permainan");
                System.out.println("3. Exit             : command yang dapat Anda gunakan untuk keluar dari permainan");
            } else if(op.equals("Exit")){
                System.out.println("Game akan berakhir.. Terimakasih telah bermain!! ^^");
                finished = true;
            } else {
                System.out.println("Command tersebut belum dapat diakses karena anda belum memulai permainan");
            }
        }
        
        while(started && (!finished)){
            System.out.print(">> ");
            String o;
            o = scan.nextLine();
            if(o.equals("View Sim Info")){
                currentSim.displayInfo();
            } else if(o.equals("Help")){
                System.out.println("permainan ini merupakan permainan karakter virtual yaitu Sim yang dapat anda jalankan kegiatannya.");
                System.out.println("Terdapat beberapa command yang dapat Anda berikan setelah memulai permainan :");
            } else if(o.equals("Exit")){
                finished = true;
            } else if(o.equals("View Current Location")){
                System.out.println("Saat ini sim berada di rumah dengan lokasi " + "("+currentSim.getLokSimRumah().getX() + ","+currentSim.getLokSimRumah().getY() + ") pada World, tepatnya pada ruangan " + currentSim.getLokRuang().getNamaRuangan());
            } else if(o.equals("View Inventory")){
                currentSim.lihatInventory();
            } else if(o.equals("Upgrade House")){
                if(currentSim.getLokSimRumah() == currentSim.getRumah().getLokRumah()){
                    String namaRbaru = scan.nextLine();
                    int tempx = scan.nextInt();
                    int tempy = scan.nextInt();
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

                    currentSim.beliBarang(opsi, null, opsi);
                } else if(opsi == 2){

                } else {
                    System.out.println("X X Opsi tersebut tidak tersedia X X");
                }
            }else if(o.equals("Add Sim")){
                System.out.println("Siapa nama sim baru?");
                String nama = scan.nextLine();
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
                    } else {
                        System.out.println("Lokasi tersebut telah terisi oleh rumah lain! Silahkan pilih lokasi lain:<");
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
                Ruangan temp = currentSim.getRumah().getRoom(currentSim.getLokRuang().getNamaRuangan());
                int i = 1;
                System.out.println("Berikut merupakan daftar objek di dalam ruangan");
                for(ObjectSim ob : temp.getObjects()){
                    System.out.println(i + ". " + ob.getNama());
                    i++;
                }
            } else if(o.equals("Go To Object")){

            } else if(o.equals("Action")){
                System.out.println("pilih aksi yang dapat dilakukan oleh benda");
            } else {
                System.out.println("command tersebut tidak tersedia");
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
