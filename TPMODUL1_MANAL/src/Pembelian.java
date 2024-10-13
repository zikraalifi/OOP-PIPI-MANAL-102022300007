import java.util.ArrayList;
import java.util.Scanner;

public class Pembelian {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();
        ArrayList<Penerbangan> pesananPenerbangan = new ArrayList<>();
        Penumpang penumpang = null;

        daftarPenerbangan.add(new Penerbangan("GA101", "CGK, Jakarta", "DPS, Bali", "06:30", "08:15", 1200000));
        daftarPenerbangan.add(new Penerbangan("QZ202", "SUB, Surabaya", "KNO, Medan", "09:00", "11:45", 1350000));

        while (true) {
            System.out.println("======= EAD Ticket Booking System =======");
            System.out.println("1. Tampilkan Daftar Penerbangan");
            System.out.println("2. Beli Tiket");
            System.out.println("3. Tampilkan Pesanan Tiket");
            System.out.println("4. Exit");
            System.out.print("Silahkan pilih menu: ");
            int menu = scanner.nextInt();

            switch (menu) {
                case 1 -> {
                    System.out.println("Daftar Penerbangan:");
                    for (int i = 0; i < daftarPenerbangan.size(); i++) {
                        daftarPenerbangan.get(i).tampilDaftarPenerbangan();
                    }
                }
                case 2 -> {
                    scanner.nextLine();  
                    System.out.println("Silakan isi data diri anda terlebih dahulu!");
                    System.out.print("Masukan NIK: ");
                    String NIK = scanner.nextLine();
                    System.out.print("Masukan Nama Depan: ");
                    String namaDepan = scanner.nextLine();
                    System.out.print("Masukan Nama Belakang: ");
                    String namaBelakang = scanner.nextLine();

                    penumpang = new Penumpang(NIK, namaDepan, namaBelakang);

                    System.out.println("Terima Kasih telah mengisi data pelanggan.");
                    System.out.println("Silakan Pilih Tiket Penerbangan yang Tersedia");
                    for (int i = 0; i < daftarPenerbangan.size(); i++) {
                        daftarPenerbangan.get(i).tampilDaftarPenerbangan();
                    }

                    System.out.print("Pilih nomor penerbangan (ex: 1): ");
                    int pilihanPenerbangan = scanner.nextInt();
                    if (pilihanPenerbangan > 0 && pilihanPenerbangan <= daftarPenerbangan.size()) {
                        pesananPenerbangan.add(daftarPenerbangan.get(pilihanPenerbangan - 1));
                        System.out.println("Pemesanan Tiket Berhasil Dilakukan, Cek Pesanan Tiket pada Menu (3)");
                    } else {
                        System.out.println("Penerbangan yang dipilih tidak tersedia.");
                    }
                }
                case 3 -> {
                    if (pesananPenerbangan.isEmpty()) {
                        System.out.println("Pembelian Tiket Tidak Ada");
                    } else {
                        System.out.println("======= Detail Tiket Penerbangan =======");
                        if (penumpang != null) {
                            penumpang.tampilDaftarPenumpang();
                        } else {
                            System.out.println("Data penumpang belum diisi.");
                        }
                        for (int i = 0; i < pesananPenerbangan.size(); i++) {
                            pesananPenerbangan.get(i).tampilDaftarPenerbangan();
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Terima kasih!");
                    scanner.close();  
                    return;
                }
                default -> System.out.println("Menu tidak valid!");
            }
        }
    }
}