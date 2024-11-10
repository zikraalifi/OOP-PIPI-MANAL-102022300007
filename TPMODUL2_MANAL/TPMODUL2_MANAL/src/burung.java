public class burung extends hewan {
    public String warnaBulu;

    public burung(String nama, int umur, String warnaBulu) {
        super(nama, umur);
        this.warnaBulu = warnaBulu;
    }

    @Override
    public void suara() {
        System.out.println(nama + " berkicau.");
    }

    @Override
    public void infoHewan() {
        super.infoHewan();
        System.out.println("Warna bulu: " + warnaBulu);
    }
}
