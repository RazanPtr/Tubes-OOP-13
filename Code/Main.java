import java.util.Scanner;
import util.*;
import objek.*;
import java.util.*;

public class Main {
    public static void main(String[] args){
        System.out.print(">> ");
        Scanner scan = new Scanner(System.in);
        ArrayList<Sim> pemain = new ArrayList<Sim>();
        Sim currentSim = null;
        String op = scan.nextLine();
        boolean started = false;
        boolean finished = false;
        System.out.println(op);
        if(op.equals("Start Game")&& (!started)){
            World w = World.getInstance();
            System.out.print("Permainan dimulai\nSiapa nama simmu? ");
            String namaLengkap = scan.nextLine();
            System.out.print("Tentukan lokasi rumah Sim (x, y): ");
            int lokRx = scan.nextInt();
            int lokRy = scan.nextInt();
            Sim s = new Sim(namaLengkap, lokRx, lokRy);
            currentSim = s;
            pemain.add(s);
            started = true;
        } else if(op.equals("Help")){
            System.out.println("Buat bantuan");
        } else if(op.equals("Exit")){
            finished = true;
        }
        
        while(started && (!finished)){
            System.out.print(">> ");
            String o = scan.nextLine();
            if(o.equals("View Sim Info")){
                currentSim.displayInfo();
            } else if(o.equals("Help")){
                System.out.println("trial");
            } else if(o.equals("Exit")){
                finished = true;
            } else if(o.equals("View Current Location")){
                System.out.println("Saat ini sim berada di rumah dengan lokasi " + "("+currentSim.getLokSimRumah().getX() + ","+currentSim.getLokSimRumah().getY() + ", tepatnya pada ruangan dengan lokasi" + currentSim.getLokRuang());
            } else if(o.equals("View Inventory")){
                currentSim.lihatInventory();
            } else if(o.equals("Upgrade House")){
                if(currentSim.getLokSimRumah() == currentSim.getRumah().getLokRumah()){
                    String namaRbaru = scan.next();
                    int tempx = scan.nextInt();
                    int tempy = scan.nextInt();
                    currentSim.upgradeRumah();
                }
            } else if(o.equals("Move Room")){
                //ini harus didalem rumahnya apa gimana
            } else if(o.equals("Add Sim")){
                System.out.println("Siapa nama sim baru?");
                String nama = scan.next();
                System.out.println("Dimana lokasi rumah yang diinginkan? ");
                int x = scan.nextInt();
                int y = scan.nextInt();
                pemain.add(new Sim(nama, x, y));
            } else if(o.equals("Change Sim")){
                System.out.println("Siapa nama Sim yang ingin dimainkan? ");
                String nama = scan.next();
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
