package game;


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tuile {
    private int nmbCouronne1;
    private String type1;
    private int nmbCouronne2;
    private String type2;
    private int numeroDomino;
    private double x1;
    private double y1;
    private double x2;
    private double y2;


    public Tuile(int nmbCouronne1, String type1, int nmbCouronne2, String type2, int numeroDomino, double x1, double y1, double x2, double y2) {
        this.nmbCouronne1 = nmbCouronne1;
        this.type1=type1;
        this.nmbCouronne2 = nmbCouronne2;
        this.type2 = type2;
        this.numeroDomino = numeroDomino;
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public String toString() {
        return "Tuile{" +
                "nmbCouronne1=" + nmbCouronne1 +
                ", type1=" + type1 +
                ", nmbCouronne2=" + nmbCouronne2 +
                ", type2=" + type2 +
                ", numeroDomino=" + numeroDomino +
                '}';
    }

    public int getNmbCouronne1() {
        return nmbCouronne1;
    }

    public void setNmbCouronne1(int nmbCouronne1) {
        this.nmbCouronne1 = nmbCouronne1;
    }

    public String getType1() {
        return type1;
    }

    public void setType1(String type1) {
        this.type1 = type1;
    }

    public int getNmbCouronne2() {
        return nmbCouronne2;
    }

    public void setNmbCouronne2(int nmbCouronne2) {
        this.nmbCouronne2 = nmbCouronne2;
    }

    public String getType2() {
        return type2;
    }

    public void setType2(String type2) {
        this.type2 = type2;
    }

    public int getNumeroDomino() {
        return numeroDomino;
    }

    public void setNumeroDomino(int numeroDomino) {
        this.numeroDomino = numeroDomino;
    }

    public static ArrayList<Tuile> selectionnerDominos(ArrayList<Tuile> listeTuiles, int nombreDeJoueurs) {
        ArrayList<Tuile> dominosChoisis = new ArrayList<>();

        Random rand = new Random();
        int nombreDeDomino = 4;
        if(nombreDeJoueurs == 3) {
            nombreDeDomino = 3;
        }
        // Récupère une tuile au hasard
        for (int i = 0; i < nombreDeDomino; i++) {
            Tuile randomElement = listeTuiles.get(rand.nextInt(listeTuiles.size()));
            dominosChoisis.add(randomElement);
            System.out.println(randomElement.getType1() + " " + randomElement.getType2()+" "+randomElement.getNumeroDomino()+" "+randomElement.getNmbCouronne1()+" "+randomElement.getNmbCouronne2());
            listeTuiles.remove(randomElement);
        }

        return dominosChoisis;
    }

    public double getX1() {
        return x1;
    }

    public void setX1(double x1) {
        this.x1 = x1;
    }

    public double getY1() {
        return y1;
    }

    public void setY1(double y1) {
        this.y1 = y1;
    }

    public double getX2() {
        return x2;
    }

    public void setX2(double x2) {
        this.x2 = x2;
    }

    public double getY2() {
        return y2;
    }

    public void setY2(double y2) {
        this.y2 = y2;
    }
}