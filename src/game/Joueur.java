package game;

import java.util.ArrayList;

public class Joueur {

    private String name;
    private ArrayList<Roi> roi;
    private Chateau chateaux;
    private ArrayList<Tuile> paquet;
    private Tuile tampon;
    private int score;

    public Joueur(String name, ArrayList<Roi> roi, Chateau chateaux, ArrayList<Tuile> paquet) {
        this.name = name;
        this.roi = roi;
        this.chateaux = chateaux;
        this.paquet = paquet;
    }

    public Tuile getTampon() {
        return tampon;
    }

    public void setTampon(Tuile tampon) {
        this.tampon = tampon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Roi> getRoi() {
        return roi;
    }

    public void setRoi(ArrayList<Roi> roi) {
        this.roi = roi;
    }

    public Chateau getChateaux() {
        return chateaux;
    }

    public void setChateaux(Chateau chateaux) {
        this.chateaux = chateaux;
    }

    public ArrayList<Tuile> getPaquet() {
        return paquet;
    }

    public void setPaquet(ArrayList<Tuile> paquet) {
        this.paquet = paquet;
    }

    public void addTuile(Tuile tuile) {
        this.paquet.add(tuile);
    }

    @Override
    public String toString() {
        return "Joueur{" +
                "pseudo = " + name;
    }

    public static Joueur findJoueur(ArrayList<Joueur> listJoueur, String name) {
        for (int i = 0; i < listJoueur.size(); i++) {
            if (listJoueur.get(i).getName().equals(name)) {
                return listJoueur.get(i);
            }
        }
        return null;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static int getScore(ArrayList<Tuile> paquet) {
        int scorePrairie = 0; int scoreMer = 0;int scoreMine = 0;int scoreMontagne = 0;int scoreForet = 0;int scoreChamps = 0;
        int crownPrairie = 0;int crownMer = 0;int crownMine = 0;int crownMontagne = 0;int crownForet = 0;int crownChamps = 0;
        for (int tuile = 0; tuile < paquet.size(); tuile++) {
            if (paquet.get(tuile).getType1().equals("Prairie")) {
                scorePrairie += 1;
                crownPrairie += paquet.get(tuile).getNmbCouronne1();
            }
            if (paquet.get(tuile).getType1().equals("Mer")) {
                scoreMer += 1;
                crownMer += paquet.get(tuile).getNmbCouronne1();
            }
            if (paquet.get(tuile).getType1().equals("Mine")) {
                scoreMine += 1;
                crownMine += paquet.get(tuile).getNmbCouronne1();
            }
            if (paquet.get(tuile).getType1().equals("Montagne")) {
                scoreMontagne += 1;
                crownMontagne += paquet.get(tuile).getNmbCouronne1();
            }
            if (paquet.get(tuile).getType1().equals("Foret")) {
                scoreForet += 1;
                crownForet += paquet.get(tuile).getNmbCouronne1();
            }
            if (paquet.get(tuile).getType1().equals("Champs")) {
                scoreChamps += 1;
                crownChamps += paquet.get(tuile).getNmbCouronne1();
            }
            if (paquet.get(tuile).getType2().equals("Prairie")) {
                scorePrairie += 1;
                crownPrairie += paquet.get(tuile).getNmbCouronne2();
            }
            if (paquet.get(tuile).getType2().equals("Mer")) {
                scoreMer += 1;
                crownMer += paquet.get(tuile).getNmbCouronne2();
            }
            if (paquet.get(tuile).getType2().equals("Mine")) {
                scoreMine += 1;
                crownMine += paquet.get(tuile).getNmbCouronne2();
            }
            if (paquet.get(tuile).getType2().equals("Montagne")) {
                scoreMontagne += 1;
                crownMontagne += paquet.get(tuile).getNmbCouronne2();
            }
            if (paquet.get(tuile).getType2().equals("Foret")) {
                scoreForet += 1;
                crownForet += paquet.get(tuile).getNmbCouronne2();
            }
            if (paquet.get(tuile).getType2().equals("Champs")) {
                scoreChamps += 1;
                crownChamps += paquet.get(tuile).getNmbCouronne2();
            }
        }
        return scorePrairie * crownPrairie + scoreMer + crownMer + scoreMine * crownMine + scoreMontagne * crownMontagne + scoreForet * crownForet + scoreChamps * crownChamps;
    }
}
