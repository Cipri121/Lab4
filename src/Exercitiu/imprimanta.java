package Exercitiu;

enum ModTiparire{
    COLOR,
    ALBNEGRU
}

public class imprimanta extends Electronice{
    private int ppm;
    private String rezolutie;
    private int p_car;
    private static ModTiparire mod;

    public imprimanta(String denumire, int nr_inv, int pret, String zona_mag, Stare stare, int ppm, String rezolutie, int p_car, ModTiparire mod) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.ppm = ppm;
        this.rezolutie = rezolutie;
        this.p_car = p_car;
        this.mod = mod;
    }

    @Override
    public String toString() {
        return super.toString() + "imprimanta{" +
                "ppm=" + ppm +
                ", rezolutie='" + rezolutie + '\'' +
                ", p_car=" + p_car +
                ", mod=" + mod +
                "} ";
    }
}