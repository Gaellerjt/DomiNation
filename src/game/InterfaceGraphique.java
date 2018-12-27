package game;

import edu.princeton.cs.introcs.StdDraw;
import edu.princeton.cs.introcs.StdOut;
import java.awt.*;
import java.util.ArrayList;


public class InterfaceGraphique {

    // Fonction du menu principal, retourne le nombre de joueurs de la partie
    int Menu() {

        Font font1 = new Font("Comic Sans MS",1,45);
        Font font2 = new Font("Arial",1,20);

        // Image de fond menu
        StdDraw.picture(0.6, 0.5, "out/img/menu.png");

        // Titre
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.setFont(font1);
        StdDraw.text(0.5,0.8,"DomiNation");

        // Boutons
        StdDraw.setFont(font2);
        StdDraw.setPenRadius(0.01);
        // 2 joueurs
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(0.2,0.5,0.1,0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.text(0.2,0.5,"2 joueurs");
        // 3 joueurs
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(0.5,0.5,0.1,0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.text(0.5,0.5,"3 joueurs");
        // 4 joueurs
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.filledRectangle(0.8,0.5,0.1,0.05);
        StdDraw.setPenColor(StdDraw.ORANGE);
        StdDraw.text(0.8,0.5,"4 joueurs");

        while(true) {

            if (StdDraw.mouseX() >= 0.1 && StdDraw.mouseX() <= 0.3 && StdDraw.mouseY() >= 0.45 && StdDraw.mouseY() <= 0.55) {
                if (StdDraw.isMousePressed()) {
                    return 2;
                }
            }
            else if (StdDraw.mouseX() >= 0.4 && StdDraw.mouseX() <= 0.6 && StdDraw.mouseY() >= 0.45 && StdDraw.mouseY() <= 0.55) {
                if (StdDraw.isMousePressed()) {
                    return 3;
                }
            }
            else if (StdDraw.mouseX() >= 0.7 && StdDraw.mouseX() <= 0.9 && StdDraw.mouseY() >= 0.45 && StdDraw.mouseY() <= 0.55) {
                if (StdDraw.isMousePressed()) {
                    return 4;
                }
            }

        }

    }

    // Fonction de sélection de la couleur du Roi

    Roi selectionRoi(ArrayList<Roi> rois, Joueur joueur) throws InterruptedException {
        Thread.sleep(500);
        StdDraw.clear();

        // Affichage du texte
        Font font1 = new Font("Comic Sans MS", 1, 40);
        StdDraw.setFont(font1);
        StdDraw.text(0.5, 0.9, joueur.getName());
        StdDraw.text(0.5, 0.8, "Choisissez un roi");

        System.out.println(rois.size());

        // Affichage des rois
        for (Roi r:rois) {
            if(r.getCouleurRoi() == Color.GREEN ) {
                StdDraw.picture(0.2, 0.5, "out/img/pion-vert.png", 0.2, 0.2, 0);
            }
            if(r.getCouleurRoi() == Color.BLUE) {
                StdDraw.picture(0.4, 0.5, "out/img/pion-bleu.png", 0.2, 0.2, 0);

            }
            if(r.getCouleurRoi() == Color.PINK) {
                StdDraw.picture(0.6, 0.5, "out/img/pion-rose.png", 0.2, 0.2, 0);
            }
            if(r.getCouleurRoi() == Color.YELLOW) {
                StdDraw.picture(0.8, 0.5, "out/img/pion-jaune.png", 0.2, 0.2, 0);
            }
        }

        // Détection du choix
        while (true) {
            if (StdDraw.mouseX() >= 0.15 && StdDraw.mouseX() <= 0.25 && StdDraw.mouseY() >= 0.40 && StdDraw.mouseY() <= 0.60 && StdDraw.isMousePressed()) {
                System.out.println("pion vert");
                Roi roiVert = new Roi(Color.GREEN);
                return roiVert;
            } else if (StdDraw.mouseX() >= 0.35 && StdDraw.mouseX() <= 0.45 && StdDraw.mouseY() >= 0.40 && StdDraw.mouseY() <= 0.60 && StdDraw.isMousePressed()) {
                System.out.println("pion bleu");
                Roi roiBleu = new Roi(Color.BLUE);
                return roiBleu;
            } else if (StdDraw.mouseX() >= 0.55 && StdDraw.mouseX() <= 0.65 && StdDraw.mouseY() >= 0.40 && StdDraw.mouseY() <= 0.60 && StdDraw.isMousePressed()) {
                System.out.println("pion rose");
                Roi roiRose = new Roi(Color.PINK);
                return roiRose;
            } else if (StdDraw.mouseX() >= 0.75 && StdDraw.mouseX() <= 0.85 && StdDraw.mouseY() >= 0.40 && StdDraw.mouseY() <= 0.60 && StdDraw.isMousePressed()) {
                System.out.println("pion jaune");
                Roi roiJaune = new Roi(Color.YELLOW);
                return roiJaune;
            }
        }
    }

    public static void main(String[] args) {
    }
}
