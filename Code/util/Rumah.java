package util;
import java.util.*;
import objek.*;

public class Rumah {
    private ArrayList<Ruangan> rooms;
    private Ruangan[][] layout;
    private Lokasi lokRumah;
    
    public Rumah(int x, int y) {
        this.rooms = new ArrayList<Ruangan>();
        this.lokRumah = new Lokasi(x, y);
        rooms.add(new Ruangan("Kamar","KMR")); // initially add a room
        this.layout = new Ruangan[7][7];
        for (int i = 0; i < layout.length; i++) {
            for (int j = 0; j < layout[i].length; j++) {
                layout[i][j] = null;
            }
        }
        layout[3][3] = getRoom("Kamar");
        getRoom("Kamar").setX(3);
        getRoom("Kamar").setY(3);

        //ini buat trial List Object
        getRoom("Kamar").placeObject(new Lokasi(0, 0), new KasurSingle());
        getRoom("Kamar").placeObject(new Lokasi(0, 1), new Toilet());
        getRoom("Kamar").placeObject(new Lokasi(4, 0), new KomporGas());
        getRoom("Kamar").placeObject(new Lokasi(5, 1), new Jam());
        getRoom("Kamar").placeObject(new Lokasi(0, 3), new MejaKursi());
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
                    while (!isNamaValid(nama)) {
                        System.out.println("Nama sudah terpakai! Beri nama ruangan yang baru:");
                        nama = sc.nextLine();
                    }
                    System.out.println("Beri kode untuk ruangan baru (3 huruf kapital):");
                    String code = sc.nextLine();
                    while (!isCodeValid(code)) {
                        System.out.println("Code sudah terpakai! Beri kode ruangan yang baru:");
                        code = sc.nextLine();
                    }
                    Ruangan rbaru = new Ruangan(nama,code);
                    ruangan.setUp(rbaru);
                    rbaru.setDown(ruangan);
                    rooms.add(rbaru);
                    layout[ruangan.getX()-1][ruangan.getY()] = rbaru;
                } else {
                    System.out.println("Maaf, sudah terdapat ruangan di atas ruangan ini!");
                }
                valid = true;
            } else if (input.equals("Bawah")) {
                if (ruangan.getDown()==null) {
                    System.out.println("Akan dibuat ruangan baru di bawah ruangan ini!");
                    System.out.println("Beri nama untuk ruangan baru:");
                    String nama = sc.nextLine();
                    while (!isNamaValid(nama)) {
                        System.out.println("Nama sudah terpakai! Beri nama ruangan yang baru:");
                        nama = sc.nextLine();
                    }
                    System.out.println("Beri kode untuk ruangan baru (3 huruf kapital):");
                    String code = sc.nextLine();
                    while (!isCodeValid(code)) {
                        System.out.println("Code sudah terpakai! Beri kode ruangan yang baru:");
                        code = sc.nextLine();
                    }
                    Ruangan rbaru = new Ruangan(nama,code);
                    ruangan.setDown(rbaru);
                    rbaru.setUp(ruangan);
                    rooms.add(rbaru);
                    layout[ruangan.getX()+1][ruangan.getY()] = rbaru;
                } else {
                    System.out.println("Maaf, sudah terdapat ruangan di bawah ruangan ini!");
                }
                valid = true;
            } else if (input.equals("Kiri")) {
                if (ruangan.getLeft()==null) {
                    System.out.println("Akan dibuat ruangan baru di kiri ruangan ini!");
                    System.out.println("Beri nama untuk ruangan baru:");
                    String nama = sc.nextLine();
                    while (!isNamaValid(nama)) {
                        System.out.println("Nama sudah terpakai! Beri nama ruangan yang baru:");
                        nama = sc.nextLine();
                    }
                    System.out.println("Beri kode untuk ruangan baru (3 huruf kapital):");
                    String code = sc.nextLine();
                    while (!isCodeValid(code)) {
                        System.out.println("Code sudah terpakai! Beri kode ruangan yang baru:");
                        code = sc.nextLine();
                    }
                    Ruangan rbaru = new Ruangan(nama,code);
                    ruangan.setLeft(rbaru);
                    rbaru.setRight(ruangan);
                    rooms.add(rbaru);
                    layout[ruangan.getX()][ruangan.getY()-1] = rbaru;
                } else {
                    System.out.println("Maaf, sudah terdapat ruangan di kiri ruangan ini!");
                }
                valid = true;
            } else if (input.equals("Kanan")) {
                if (ruangan.getRight()==null) {
                    System.out.println("Akan dibuat ruangan baru di kanan ruangan ini!");
                    System.out.println("Beri nama untuk ruangan baru:");
                    String nama = sc.nextLine();
                    while (!isNamaValid(nama)) {
                        System.out.println("Nama sudah terpakai! Beri nama ruangan yang baru:");
                        nama = sc.nextLine();
                    }
                    System.out.println("Beri kode untuk ruangan baru (3 huruf kapital):");
                    String code = sc.nextLine();
                    while (!isCodeValid(code)) {
                        System.out.println("Code sudah terpakai! Beri kode ruangan yang baru:");
                        code = sc.nextLine();
                    }
                    Ruangan rbaru = new Ruangan(nama,code);
                    ruangan.setRight(rbaru);
                    rbaru.setLeft(ruangan);
                    rooms.add(rbaru);
                    layout[ruangan.getX()][ruangan.getY()+1] = rbaru;
                } else {
                    System.out.println("Maaf, sudah terdapat ruangan di kanan ruangan ini!");
                }
                valid = true;
            } else {
                System.out.println("Opsi yang dimasukkan tidak sesuai pilihan yang ada");
                System.out.println("Masukkan kembali pilihan yang diinginkan");
                input = sc.nextLine();
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

    public void displayListRuangan() {
        int i = 1;
        for (Ruangan ruang: rooms) {
            System.out.println(i+". "+ruang.getNamaRuangan());
            i++;
        }
    }

    public boolean isNamaValid(String nama) {
        Boolean valid = true;
        for (Ruangan ruang : rooms) {
            if (ruang.getNamaRuangan().equals(nama)) {
                valid = false;
            }
        }
        return valid;
    }

    public boolean isCodeValid(String code) {
        Boolean valid = true;
        for (Ruangan ruang : rooms) {
            if (ruang.getCode().equals(code)) {
                valid = false;
            }
        }
        return valid;
    }

    public void displayRumah() {
        System.out.println("\n+-----+-----+-----+-----+-----+-----+-----+");
        for (int i = 0; i < layout.length; i++) {
            System.out.print("|");
            for (int j = 0; j < layout[i].length; j++) {
                if (layout[i][j] != null) {
                    System.out.print(" " + layout[i][j].getCode() + " |");
                } else {
                    System.out.print("     |");
                }
            }
            System.out.println("\n+-----+-----+-----+-----+-----+-----+-----+");
        }
    }
    
}
