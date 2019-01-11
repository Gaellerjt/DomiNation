package game;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;


public class InterfaceGraphique {

    // Fonction du menu principal, retourne le nombre de joueurs de la partie
    int Menu() {

        Font font1 = new Font("Comic Sans MS", 1, 45);
        Font font2 = new Font("Arial", 1, 20);

        // Image de fond menu
        StdDraw.picture(0.6, 0.5, "out/img/menu.png");

        // Titre
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.setFont(font1);
        StdDraw.text(0.5, 0.8, "DomiNation");

        // Boutons
        StdDraw.setFont(font2);
        StdDraw.setPenRadius(0.01);
        // 2 joueurs
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(0.2, 0.5, 0.1, 0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.text(0.2, 0.5, "2 joueurs");
        // 3 joueurs
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(0.5, 0.5, 0.1, 0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.text(0.5, 0.5, "3 joueurs");
        // 4 joueurs
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(0.8, 0.5, 0.1, 0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.text(0.8, 0.5, "4 joueurs");

        while (true) {

            if (StdDraw.mouseX() >= 0.1 && StdDraw.mouseX() <= 0.3 && StdDraw.mouseY() >= 0.45 && StdDraw.mouseY() <= 0.55) {
                if (StdDraw.isMousePressed()) {
                    return 2;
                }
            } else if (StdDraw.mouseX() >= 0.4 && StdDraw.mouseX() <= 0.6 && StdDraw.mouseY() >= 0.45 && StdDraw.mouseY() <= 0.55) {
                if (StdDraw.isMousePressed()) {
                    return 3;
                }
            } else if (StdDraw.mouseX() >= 0.7 && StdDraw.mouseX() <= 0.9 && StdDraw.mouseY() >= 0.45 && StdDraw.mouseY() <= 0.55) {
                if (StdDraw.isMousePressed()) {
                    return 4;
                }
            }

        }

    }

    // Fonction de sélection de la couleur du Roi
    static Roi selectionRoi(ArrayList<Roi> rois, Joueur joueur) throws InterruptedException {
        Thread.sleep(500);
        StdDraw.clear();

        // Affichage du texte
        Font font1 = new Font("Comic Sans MS", 1, 40);
        StdDraw.setFont(font1);
        StdDraw.text(0.5, 0.9, joueur.getName());
        StdDraw.text(0.5, 0.8, "Choisissez un roi");

        // Affichage des rois
        // On met chaque roi dans un array temporaire
        int[] tempRois = new int[]{0, 0, 0, 0};

        for (Roi r : rois) {
            if (r.getCouleurRoi() == Color.GREEN) {
                StdDraw.picture(0.2, 0.5, "out/img/pion-vert.png", 0.2, 0.2, 0);
                tempRois[0] = 1;
            }
            if (r.getCouleurRoi() == Color.BLUE) {
                StdDraw.picture(0.4, 0.5, "out/img/pion-bleu.png", 0.2, 0.2, 0);
                tempRois[1] = 1;
            }
            if (r.getCouleurRoi() == Color.PINK) {
                StdDraw.picture(0.6, 0.5, "out/img/pion-rose.png", 0.2, 0.2, 0);
                tempRois[2] = 1;
            }
            if (r.getCouleurRoi() == Color.YELLOW) {
                StdDraw.picture(0.8, 0.5, "out/img/pion-jaune.png", 0.2, 0.2, 0);
                tempRois[3] = 1;
            }
        }

        // Détection du choix
        while (true) {
            if (StdDraw.mouseX() >= 0.15 && StdDraw.mouseX() <= 0.25 && StdDraw.mouseY() >= 0.40 && StdDraw.mouseY() <= 0.60 && StdDraw.isMousePressed() && tempRois[0] == 1) {
                System.out.println("pion vert");
                return new Roi(Color.GREEN);
            } else if (StdDraw.mouseX() >= 0.35 && StdDraw.mouseX() <= 0.45 && StdDraw.mouseY() >= 0.40 && StdDraw.mouseY() <= 0.60 && StdDraw.isMousePressed() && tempRois[1] == 1) {
                System.out.println("pion bleu");
                return new Roi(Color.BLUE);
            } else if (StdDraw.mouseX() >= 0.55 && StdDraw.mouseX() <= 0.65 && StdDraw.mouseY() >= 0.40 && StdDraw.mouseY() <= 0.60 && StdDraw.isMousePressed() && tempRois[2] == 1) {
                System.out.println("pion rose");
                return new Roi(Color.PINK);
            } else if (StdDraw.mouseX() >= 0.75 && StdDraw.mouseX() <= 0.85 && StdDraw.mouseY() >= 0.40 && StdDraw.mouseY() <= 0.60 && StdDraw.isMousePressed() && tempRois[3] == 1) {
                System.out.println("pion jaune");
                return new Roi(Color.YELLOW);
            }
        }
    }

    public static void Plateau() {

        StdDraw.clear();
        StdDraw.setPenColor(Color.ORANGE);

        // Lignes horizontales
        StdDraw.line(0.2, 0, 0.2, 1);
        StdDraw.line(0.4, 0, 0.4, 1);
        StdDraw.line(0.6, 0, 0.6, 1);
        StdDraw.line(0.8, 0, 0.8, 1);

        // Lignes verticales
        StdDraw.line(0, 0.2, 1, 0.2);
        StdDraw.line(0, 0.4, 1, 0.4);
        StdDraw.line(0, 0.6, 1, 0.6);
        StdDraw.line(0, 0.8, 1, 0.8);

        // On affiche le chateau au centre

        StdDraw.picture(0.5, 0.5, "out/img/chateau.jpg", 0.2, 0.2);
    }

    public static ArrayList<Tuile> selectionnerDominos(ArrayList<Tuile> listeTuiles) {
        ArrayList<Tuile> dominosChoisis = new ArrayList<>();

        Random rand = new Random();

        // Récupère une tuile au hasard
        for (int i = 0; i < 4; i++) {
            Tuile randomElement = listeTuiles.get(rand.nextInt(listeTuiles.size()));
            dominosChoisis.add(randomElement);
            System.out.println(randomElement.getType1() + " " + randomElement.getType2()+" "+randomElement.getNumeroDomino());
        }

        return dominosChoisis;
    }

    public static ArrayList<Tuile> supprimerDominos(ArrayList<Tuile> listePrincipale, ArrayList<Tuile> elementsASupprimer) {

        listePrincipale.removeAll(elementsASupprimer);
        return listePrincipale;
    }


    public static void main(String[] args) {

    }
}
