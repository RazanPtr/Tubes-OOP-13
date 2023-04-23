import java.util.Random;
import java.util.Scanner;

public class PekerjaanSim {
    
    static String[] pekerjaan = {"Badut Sulap", "Koki", "Polisi", "Programmer", "Dokter"}; //daftar pekerjaan
    static int[] gajiHarian = {15, 30, 35, 45, 50}; //gaji harian dalam satuan 4 menit
    
    static int waktuKerja = 0; //jumlah waktu kerja dalam satuan 4 menit
    static int hariGantiPekerjaan = 0; //hari ketika Sim dapat mengganti pekerjaannya
    
    public static void main(String[] args) {
        
        Random rand = new Random();
        int pekerjaanIndex = rand.nextInt(pekerjaan.length); //menentukan pekerjaan secara acak
        
        System.out.println("Selamat datang di Sim Career!");
        System.out.println("Pekerjaan Sim anda adalah: " + pekerjaan[pekerjaanIndex]);
        System.out.println("Gaji harian anda adalah: " + gajiHarian[pekerjaanIndex] + " per 4 menit kerja.");
        
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Lihat daftar pekerjaan");
            System.out.println("2. Ganti pekerjaan");
            System.out.println("3. Lanjutkan bekerja");
            System.out.println("4. Keluar");
            System.out.print("Pilihan anda: ");
            int pilihan = input.nextInt();
            
            switch (pilihan) {
                case 1:
                    lihatPekerjaan();
                    break;
                case 2:
                    gantiPekerjaan();
                    break;
                case 3:
                    lanjutBekerja();
                    break;
                case 4:
                    System.out.println("Terima kasih telah bermain!");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
                    break;
            }
        }
    }
    
    //method untuk menampilkan daftar pekerjaan beserta gaji harian mereka
    static void lihatPekerjaan() {
        System.out.println("\nDaftar Pekerjaan:");
        for (int i = 0; i < pekerjaan.length; i++) {
            System.out.println((i+1) + ". " + pekerjaan[i] + " - " + gajiHarian[i] + " per 4 menit kerja.");
        }
    }

static void gantiPekerjaan() {
    if (waktuKerja < 12) {
            System.out.println("Anda harus bekerja setidaknya 12 menit sebelum dapat mengganti pekerjaan.");
            return;
        }
        if (hariGantiPekerjaan == 0) {
            hariGantiPekerjaan = 1; //Sim dapat mengganti pekerjaan setelah 1 hari
        } else {
            System.out.println("Anda sudah mengganti pekerjaan hari ini.");
            return;
        }
        Scanner input = new Scanner(System.in);
        if (hariGantiPekerjaan > 0) {
            System.out.println("Anda belum bisa mengganti pekerjaan. Anda harus menunggu " + hariGantiPekerjaan + " hari lagi.");
            return;
        }
        System.out.println("Daftar Pekerjaan:");
        for (int i = 0; i < pekerjaan.length; i++) {
            System.out.println((i+1) + ". " + pekerjaan[i] + " - " + gajiHarian[i] + " per 4 menit kerja.");
        }
        System.out.print("Pilih pekerjaan baru (masukkan nomor): ");
        int pekerjaanBaru = input.nextInt() - 1;
        if (pekerjaanBaru == pekerjaanIndex) {
            System.out.println("Anda memilih pekerjaan yang sama dengan pekerjaan saat ini.");
            hariGantiPekerjaan = 0; //reset hari ganti pekerjaan
        } else {
            int biayaGantiPekerjaan = gajiHarian[pekerjaanBaru] * 3 / 4; //biaya ganti pekerjaan adalah setengah dari gaji harian baru
            if (biayaGantiPekerjaan > 0) {
                System.out.println("Anda akan dikenakan biaya sebesar " + biayaGantiPekerjaan + " untuk mengganti pekerjaan.");
                System.out.print("Apakah anda ingin melanjutkan (y/n)? ");
                String jawaban = input.next();
                if (jawaban.equalsIgnoreCase("y")) {
                    int gajiHarianLama = gajiHarian[pekerjaanIndex];
                    pekerjaanIndex = pekerjaanBaru;
                    System.out.println("Pekerjaan berhasil diganti!");
                    if (waktuKerja >= 12) {
                        int biayaGantiPekerjaanLama = gajiHarianLama / 2; //biaya ganti pekerjaan lama adalah setengah dari gaji harian lama
                        System.out.println("Anda bisa mengganti pekerjaan lagi dalam 1 hari dengan membayar biaya sebesar " + biayaGantiPekerjaanLama + ".");
                        hariGantiPekerjaan = 1;
                    }
                } else {
                    System.out.println("Pekerjaan tidak diganti.");
                    hariGantiPekerjaan = 0; //reset hari ganti pekerjaan
                }
            } else {
                int gajiHarianLama = gajiHarian[pekerjaanIndex];
                pekerjaanIndex = pekerjaanBaru;
                System.out.println("Pekerjaan berhasil diganti!");
                if (waktuKerja >= 12) {
                    int biayaGantiPekerjaanLama = gajiHarianLama / 2; //biaya ganti pekerjaan lama adalah setengah dari gaji harian lama
                    System.out.println("Anda bisa mengganti pekerjaan lagi dalam 1 hari dengan membayar biaya sebesar " + biayaGantiPekerjaanLama + ".");
                    hariGantiPekerjaan = 1;
                }
            }
        }
    }

static void lanjutBekerja() {
    int waktuKerjaSekarang = (waktuKerja % 15) * 15 + 4; //menentukan waktu kerja saat ini dalam satuan detik
    int waktuPengiriman = (new Random().nextInt(5) + 1) * 30; //waktu pengiriman dalam satuan detik
    System.out.println("Barang sedang dalam pengiriman. Mohon tunggu " + waktuPengiriman + " detik...");
    try {
        Thread.sleep(waktuPengiriman * 1000L); //menghentikan program selama waktu pengiriman
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    System.out.println("Barang sudah masuk ke dalam inventory.");
    waktuKerja += waktuKerjaSekarang; //menambahkan waktu kerja saat ini ke total waktu kerja
    if (waktuKerja >= 60) {
        int gajiHarianSim = gajiHarian[pekerjaanIndex] * 15; //gaji harian dalam satuan 1 menit
        int gajiSim = gajiHarianSim * waktuKerja / 60; //gaji total dalam satuan 1 menit
        System.out.println("Selamat! Anda telah bekerja selama 1 jam.");
        System.out.println("Gaji yang anda terima adalah: " + gajiSim + " kredit.");
        waktuKerja = waktuKerja % 60; //reset waktu kerja
    }
}}