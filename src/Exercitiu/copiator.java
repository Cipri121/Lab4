package Exercitiu;
enum Format {
    A3,
    A4
}
public class copiator extends Electronice{
    private   int p_ton;
    private Format format;

    public copiator(String denumire, int nr_inv, int pret, String zona_mag, Stare stare, int p_ton, Format format) {
        super(denumire, nr_inv, pret, zona_mag, stare);
        this.p_ton = p_ton;
        this.format = format;
    }

    public void setFormat(Format format) {
        this.format = format;
    }

    @Override
    public String toString() {
        return super.toString() + "copiator{" +
                "p_ton=" + p_ton +
                ", format=" + format +
                "} ";
    }
}