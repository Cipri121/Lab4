package Exercitiu;

enum SistemeOperare{
    WINDOWS,
    LINUX
}

public class sistemDeCalcul extends Electronice{
   private String tip_mon;
   private float vit_proc;
   private int c_hdd;
   private SistemeOperare sistem;

    public sistemDeCalcul(String denumire, int nr_inv, int pret, String zona_mag, Stare stare, String tip_mon, float vit_proc, int c_hdd, SistemeOperare sistem) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.tip_mon = tip_mon;
        this.vit_proc = vit_proc;
        this.c_hdd = c_hdd;
        this.sistem = sistem;
    }

    @Override
    public String toString() {
        return super.toString() + "sistemDeCalcul{" +
                "tip_mon='" + tip_mon + '\'' +
                ", vit_proc=" + vit_proc +
                ", c_hdd=" + c_hdd +
                ", sistem=" + sistem +
                "} ";
    }
}