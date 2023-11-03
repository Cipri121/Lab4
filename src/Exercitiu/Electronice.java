package Exercitiu;

import java.io.*;

enum Stare{
    ACHIZITIONAT,
    EXPUS,
    VANDUT
}
public class Electronice implements Serializable {
    private String denumire;
    private int nr_inv;
    private int pret;
    private String zona_mag;
    private Stare stare;

    public Electronice(String denumire, int nr_inv, int pret, String zona_mag, Stare stare) {
        this.denumire = denumire;
        this.nr_inv = nr_inv;
        this.pret = pret;
        this.zona_mag = zona_mag;
        this.stare = stare;
    }

    @Override
    public String toString() {
        return "Electronice{" +
                "denumire='" + denumire + '\'' +
                ", nr_inv=" + nr_inv +
                ", pret=" + pret +
                ", zona_mag='" + zona_mag + '\'' +
                ", stare=" + stare +
                '}';
    }

    public void setStare(Stare stare) {
        this.stare = stare;
    }

    public String getDenumire() {
        return denumire;
    }

    public int getNr_inv() {
        return nr_inv;
    }

    public int getPret() {
        return pret;
    }

    public Stare getStare() {
        return stare;
    }

    public String getZona_mag() {
        return zona_mag;
    }

    static void scrie(Object o) {
        try {
            FileOutputStream f = new FileOutputStream("echip.bin");
            ObjectOutputStream oos = new ObjectOutputStream(f);
            oos.writeObject(o);
            oos.close();
            f.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    static Object citeste() {
        try {
            FileInputStream f = new FileInputStream("echip.bin");
            ObjectInputStream ois = new ObjectInputStream(f);
            Object o=ois.readObject();
            ois.close();
            f.close();
            return o;
        }
        catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    }
