package game;


import java.util.Scanner;

public class Tuile {
    private int nmbCouronne1;
    private String type1;
    private int nmbCouronne2;
    private String type2;
    private int numeroDomino ;

    public Tuile(int numeroDomino) {
        this.numeroDomino = numeroDomino;
    }

    public Tuile(int nmbCouronne1, String type1, int nmbCouronne2, String type2, int numeroDomino) {
        this.nmbCouronne1 = nmbCouronne1;
        this.type1=type1;
        this.nmbCouronne2 = nmbCouronne2;
        this.type2 = type2;
        this.numeroDomino = numeroDomino;
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
}