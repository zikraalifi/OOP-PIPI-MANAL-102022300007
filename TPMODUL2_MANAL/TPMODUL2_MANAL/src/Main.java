public class Main {
    public static void main(String[] args) {
        System.out.println("Detail Hewan\n");

        
        kucing kucing = new kucing("Momo", 2, "Persia");
        System.out.println("ini adalah " + kucing.nama + " !");
        kucing.suara();
        kucing.makan();
        kucing.makan("ikan");
        kucing.infoHewan();

        System.out.println();

        
        burung burung = new burung("Rio", 1, "Hijau");
        System.out.println("ini adalah " + burung.nama + " !");
        burung.suara();
        burung.makan();
        burung.makan("biji-bijian");
        burung.infoHewan();
    }
}
