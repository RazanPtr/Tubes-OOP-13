package util;
import java.util.*;
import objek.*;

public class Rumah {
    private ArrayList<Ruangan> rooms;
    private Lokasi lokRumah;
    
    public Rumah(int x, int y) {
        this.rooms = new ArrayList<Ruangan>();
        this.lokRumah = new Lokasi(x, y);
        rooms.add(new Ruangan("Kamar")); // initially add a room

        /*ini buat trial List Object
        getRoom("Kamar").placeObject(new Lokasi(0, 0), new KasurSingle());
        getRoom("Kamar").placeObject(new Lokasi(0, 1), new Toilet());
        getRoom("Kamar").placeObject(new Lokasi(4, 0), new KomporGas());
        getRoom("Kamar").placeObject(new Lokasi(5, 1), new Jam());
        getRoom("Kamar").placeObject(new Lokasi(0, 3), new MejaKursi());*/
    }
    
    public int getArea() {
        return 6 * 6 * getNRuangan();
    }
    
    public int getNRuangan() {
        return rooms.size();
    }
    
    public Lokasi getLokRumah() {
        return lokRumah;
    }

    public boolean isAddRoomAvailable(Ruangan ruangan){
        if(ruangan.getUp()==null || ruangan.getDown()== null || ruangan.getLeft()==null || ruangan.getRight()==null){
            return true;
        } else {
            return false;
        }
    }
    
    public void addRuangan (Ruangan ruangan) {
        System.out.println("Mau tambah ruangan di sisi mana?");
        System.out.println("Opsi:");
        if (ruangan.getUp()==null) {
            System.out.println("Atas");
        }
        if (ruangan.getDown()==null) {
            System.out.println("Bawah");
        }
        if (ruangan.getLeft()==null) {
            System.out.println("Kiri");
        }
        if (ruangan.getRight()==null) {
            System.out.println("Kanan");
        }

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Boolean valid = false;
        
        while (!valid) {
            if (input.equals("Atas")) {
                if (ruangan.getUp()==null) {
                    System.out.println("Akan dibuat ruangan baru di atas ruangan ini!");
                    System.out.println("Beri nama untuk ruangan baru:");
                    String nama = sc.nextLine();
                    Ruangan rbaru = new Ruangan(nama);
                    ruangan.setUp(rbaru);
                    rbaru.setDown(ruangan);
                    rooms.add(rbaru);
                    System.out.println("Ruang berhasil ditambahkan!");
                } else {
                    System.out.println("Maaf, sudah terdapat ruangan di atas ruangan ini!");
                }
                valid = true;
            } else if (input.equals("Bawah")) {
                if (ruangan.getDown()==null) {
                    System.out.println("Akan dibuat ruangan baru di bawah ruangan ini!");
                    System.out.println("Beri nama untuk ruangan baru:");
                    String nama = sc.nextLine();
                    Ruangan rbaru = new Ruangan(nama);
                    ruangan.setDown(rbaru);
                    rbaru.setUp(ruangan);
                    rooms.add(rbaru);
                    System.out.println("Ruang berhasil ditambahkan!");
                } else {
                    System.out.println("Maaf, sudah terdapat ruangan di bawah ruangan ini!");
                }
                valid = true;
            } else if (input.equals("Kiri")) {
                if (ruangan.getLeft()==null) {
                    System.out.println("Akan dibuat ruangan baru di kiri ruangan ini!");
                    System.out.println("Beri nama untuk ruangan baru:");
                    String nama = sc.nextLine();
                    Ruangan rbaru = new Ruangan(nama);
                    ruangan.setLeft(rbaru);
                    rbaru.setRight(ruangan);
                    rooms.add(rbaru);
                    System.out.println("Ruang berhasil ditambahkan!");
                } else {
                    System.out.println("Maaf, sudah terdapat ruangan di kiri ruangan ini!");
                }
                valid = true;
            } else if (input.equals("Kanan")) {
                if (ruangan.getRight()==null) {
                    System.out.println("Akan dibuat ruangan baru di kanan ruangan ini!");
                    System.out.println("Beri nama untuk ruangan baru:");
                    String nama = sc.nextLine();
                    Ruangan rbaru = new Ruangan(nama);
                    ruangan.setRight(rbaru);
                    rbaru.setLeft(ruangan);
                    rooms.add(rbaru);
                    System.out.println("Ruang berhasil ditambahkan!");
                } else {
                    System.out.println("Maaf, sudah terdapat ruangan di kanan ruangan ini!");
                }
                valid = true;
            } else {
                System.out.println("Opsi yang dimasukkan tidak sesuai pilihan yang ada");
                System.out.println("Masukkan kembali pilihan yang diinginkan");
            }
        }
    }

    public Ruangan getRoom(String namaRuangan){
        Ruangan temp = null;
        for(Ruangan r : rooms){
            if(r.getNamaRuangan().equals(namaRuangan)){
                temp = r;
            }
        }
        return temp;
    }
}
