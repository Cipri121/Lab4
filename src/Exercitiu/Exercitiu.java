package Exercitiu;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Exercitiu {
    public static void main(String[] args) throws FileNotFoundException {

        List<Electronice> electronice = new ArrayList<>();
        Scanner scanner = new Scanner(new File("src/Exercitiu/electronice.txt"));
        Scanner reader = new Scanner(System.in);
        Scanner reader1 = new Scanner(System.in);
        int opt;
        String denumire;
        int nr_inv;
        int pret;
        String zona_mag;
        Stare stare;
        int ppm;
        String rezolutie;
        int p_car;
        ModTiparire mod;
        int p_ton;
        Format format;
        String tip_mon;
        float vit_proc;
        int c_hdd;
        SistemeOperare sistem;
        String nume;

        while(scanner.hasNext()){
            String linie = scanner.nextLine();
            String[] cuv = linie.split(";");
            denumire = cuv[0];
            nr_inv = Integer.parseInt(cuv[1]);
            pret = Integer.parseInt(cuv[2]);
            zona_mag = cuv[3];
            stare = Stare.valueOf(cuv[4].toUpperCase());

            switch (cuv[5]) {
                case "imprimanta" -> {
                    ppm = Integer.parseInt(cuv[6]);
                    rezolutie = cuv[7];
                    p_car = Integer.parseInt(cuv[8]);
                    mod = ModTiparire.valueOf(cuv[9].toUpperCase());
                    electronice.add(new imprimanta(denumire, nr_inv, pret, zona_mag, stare, ppm, rezolutie, p_car, mod));
                }
                case "copiator" -> {
                    p_ton = Integer.parseInt(cuv[6]);
                    format = Format.valueOf(cuv[7]);
                    electronice.add(new copiator(denumire, nr_inv, pret, zona_mag, stare, p_ton, format));
                }
                case "sistem de calcul" -> {
                    tip_mon = cuv[6];
                    vit_proc = Float.parseFloat(cuv[7]);
                    c_hdd = Integer.parseInt(cuv[8]);
                    sistem = SistemeOperare.valueOf(cuv[9].toUpperCase());
                    electronice.add(new sistemDeCalcul(denumire, nr_inv, pret, zona_mag, stare, tip_mon, vit_proc, c_hdd, sistem));
                }
            }

        }

        do{
            System.out.println("Meniu\n0 - Iesire");
            System.out.println("""
                    1 - Afişarea tuturor echipamentelor
                    2 - Afişarea imprimantelor
                    3 - Afişarea copiatoarelor
                    4 - Afişarea sistemelor de calcul
                    5 - Modificarea stării în care se află un echipament
                    6 - Setarea unui anumit mod de scriere pentru o imprimantă
                    7 - Setarea unui format de copiere pentru copiatoare
                    8 - Instalarea unui anumit sistem de operare pe un sistem de calcul
                    9 - Afişarea echipamentelor vândute
                    10 - Să se realizeze două metode statice pentru serializarea / deserializarea colecției de
                    obiecte în fișierul echip.bin""");
            System.out.print("Da-ti optiunea: ");
            opt = reader.nextInt();

            if(opt == 0)
                break;

            switch (opt){
                case 1:
                    for (Electronice e:electronice) {
                        System.out.println(e);
                    }
                    break;
                case 2:
                    for (Electronice e: electronice) {
                        if(e instanceof imprimanta)
                            System.out.println(e);
                    }
                    break;
                case 3:for (Electronice e: electronice) {
                    if(e instanceof copiator)
                        System.out.println(e);
                }
                    break;
                case 4:for (Electronice e: electronice) {
                    if(e instanceof sistemDeCalcul)
                        System.out.println(e);
                }
                    break;
                case 5:
                    Stare stare1;
                    System.out.print("Alegeti un echipament pentru care vreti sa schimbati starea: ");
                    nume = reader1.nextLine();
                    for (Electronice e: electronice) {
                        if(e.getDenumire().equals(nume)) {
                            System.out.print("Alegeti noua stare: ");
                            stare1 = Stare.valueOf(reader1.next().toUpperCase());
                            e.setStare(stare1);
                        }

                        }
                    System.out.println("Stare actualizata!");
                    for (Electronice e: electronice) {
                        System.out.println(e);
                    }
                    break;
                case 6:
                    System.out.print("Alegeti o imprimanta pentru care dorirti sa schimbati modul de tiparire: ");
                    nume = reader1.nextLine();
                    for (Electronice e: electronice) {
                        if(e.getDenumire().equals(nume)) {
                            System.out.print("Alegeti noul mod de tiparire: ");
                            mod = ModTiparire.valueOf(reader1.next().toUpperCase());
                            ((imprimanta) e).setMod(mod);
                        }
                    }
                    System.out.println("Mod tiparire actualizat!");
                    for (Electronice e: electronice) {
                        System.out.println(e);
                    }
                    break;
                case 7:
                    System.out.print("Alegeti un copiator pentru care doriti sa schimbati formatul de copiere: ");
                    nume = reader1.nextLine();
                    for (Electronice e: electronice) {
                        if(e.getDenumire().equals(nume)) {
                            System.out.print("Alegeti noul format: ");
                            format = Format.valueOf(reader1.next().toUpperCase());
                            ((copiator) e).setFormat(format);
                        }
                    }
                    System.out.println("Format actualizat!");
                    for (Electronice e: electronice) {
                        System.out.println(e);
                    }
                    break;
                case 8:
                    System.out.print("Alegeti sistemul de calcul pentru care vreti sa instalati un sistem de operare: ");
                    nume = reader1.nextLine();
                    for (Electronice e: electronice) {
                        if(e.getDenumire().equals(nume)) {
                            System.out.print("Alegeti sistemul de operare: ");
                            sistem = SistemeOperare.valueOf(reader1.next().toUpperCase());
                            ((sistemDeCalcul) e).setSistem(sistem);
                        }
                    }
                    System.out.println("Sistem instalat!");
                    for (Electronice e: electronice) {
                        System.out.println(e);
                    }
                    break;
                case 9:
                    System.out.println("Electronicele vandute sunt: ");
                     for(Electronice e: electronice) {
                     if(e.getStare() == Stare.VANDUT) {
                        System.out.println(e);
                    }
                }
                    break;
                case 10:
                    System.out.println("1 - Serializare\n2 - Deserializare");
                    System.out.print("Alegeti optiunea: ");
                    int o = reader.nextInt();
                    if(o == 1) {
                        for (Electronice e:electronice) {
                            Electronice.scrie(e);
                        }
                    }
                    if(o == 2)
                        System.out.println(Electronice.citeste());
                    break;
                default:
                    System.out.println("Optiune gresita!");
                    break;

            }
        }while(true);

    }
}
