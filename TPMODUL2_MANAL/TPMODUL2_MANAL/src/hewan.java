public class hewan {
    protected String nama;
    protected int umur;

    public hewan(String nama, int umur) {
        this.nama = nama;
        this.umur = umur;
    }

    public void suara() {
        System.out.println(nama + " membuat suara.");
    }

    public void makan() {
        System.out.println(nama + " sedang makan.");
    }

    public void makan(String makanan) {
        System.out.println(nama + " sedang makan " + makanan + ".");
    }

    public void infoHewan() {
        System.out.println("Nama: " + nama + ", Umur: " + umur + " tahun.");
    }
}
