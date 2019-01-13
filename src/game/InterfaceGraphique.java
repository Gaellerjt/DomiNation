package game;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;


public class InterfaceGraphique {

    // Fonction du menu principal, retourne le nombre de joueurs de la partie
    int Menu() {

        Font font1 = new Font("Arial", 1, 45);
        Font font2 = new Font("Arial", 1, 20);

        // Image de fond menu
        StdDraw.picture(0.6, 0.5, "out/img/menu.png");

        // Titre
        StdDraw.setPenColor(StdDraw.BOOK_RED);
        StdDraw.setFont(font1);
        StdDraw.text(0.5, 0.8, "Domi'Nations");

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
        Font font1 = new Font("Arial", 1, 40);
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

    public static Tuile Plateau(Joueur joueur, Tuile tuile) throws InterruptedException {

        StdDraw.clear();
        StdDraw.setPenColor(Color.BLACK);

        // Lignes horizontales
        for (double i = 0.2; i < 1; i += 0.2) {
            StdDraw.line(i, 0, i, 1);
            StdDraw.line(0, i, 1, i);
        }

        // On affiche le chateau au centre

        StdDraw.picture(0.49, 0.49, "out/img/chateau.jpg", 0.2, 0.2);

        ArrayList<Tuile> plateauJoueur = joueur.getPaquet();
        System.out.println("joueur: " + joueur.getName() + ", taille du paquet: "+joueur.getPaquet().size());

        System.out.println(plateauJoueur);


        // affichage des tuiles déja posées

        for(Tuile t:joueur.getPaquet()) {
            // On place la partie 1 du Domino
            if (t.getType1().equals("Prairie")) {
                StdDraw.picture(t.getX1(),t.getY1(),"out/img/domino/prairie.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX1()+k,t.getY1()+k, "out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
            if (t.getType1().equals("Foret")) {
                StdDraw.picture(t.getX1(),t.getY1(),"out/img/domino/foret.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX1()+k,t.getY1()+k,"out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
            if (t.getType1().equals("Champs")) {
                StdDraw.picture(t.getX1(),t.getY1(),"out/img/domino/champs.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX1()+k,t.getY1()+k, "out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
            if (t.getType1().equals("Mer")) {
                StdDraw.picture(t.getX1(),t.getY1(),"out/img/domino/mer.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX1()+k,t.getY1()+k,"out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
            if (t.getType1().equals("Montagne")) {
                StdDraw.picture(t.getX1(),t.getY1(),"out/img/domino/montagne.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX1()+k,t.getY1()+k, "out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
            if (t.getType1().equals("Mine")) {
                StdDraw.picture(t.getX1(),t.getY1(),"out/img/domino/mine.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX1()+k,t.getY1()+k,"out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
            // On place la partie 2 du Domino
            if (t.getType1().equals("Prairie")) {
                StdDraw.picture(t.getX2(),t.getY2(),"out/img/domino/prairie.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX2()+k,t.getY2()+k, "out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
            if (t.getType1().equals("Foret")) {
                StdDraw.picture(t.getX2(),t.getY2(),"out/img/domino/foret.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX2()+k,t.getY2()+k,"out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
            if (t.getType1().equals("Champs")) {
                StdDraw.picture(t.getX2(),t.getY2(),"out/img/domino/champs.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX2()+k,t.getY2()+k, "out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
            if (t.getType1().equals("Mer")) {
                StdDraw.picture(t.getX2(),t.getY2(),"out/img/domino/mer.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX2()+k,t.getY2()+k,"out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
            if (t.getType1().equals("Montagne")) {
                StdDraw.picture(t.getX2(),t.getY2(),"out/img/domino/montagne.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX2()+k,t.getY2()+k, "out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
            if (t.getType1().equals("Mine")) {
                StdDraw.picture(t.getX2(),t.getY2(),"out/img/domino/mine.png",0.2,0.2);
                double k = -0.05;

                for (int j = 1; j <= t.getNmbCouronne1(); j++) {
                    StdDraw.picture(t.getX2()+k,t.getY2()+k,"out/img/couronne.png", 0.05, 0.05);
                    k += 0.05;
                }
            }
        }


        // Création grille magnétique
        boolean isKing = false;

        while(true)
        {
            // On affiche les coordonnées et place le domino
            if (StdDraw.isMousePressed()) {

                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();

                // Si placement impossible => click sur le roi
                if(x>0.4 && x < 0.6 && y > 0.4 && y < 0.6) {
                    isKing = true;
                    break;
                }

                if(x > 0 && x < 0.2)  {
                    x = 0.1;
                }
                if(x > 0.2 && x < 0.4)  {
                    x = 0.3;
                }
                if(x > 0.4 && x < 0.6)  {
                    x = 0.5;
                }
                if(x > 0.6 && x < 0.8)  {
                    x = 0.7;
                }
                if(x > 0.8 && x < 1)  {
                    x = 0.9;
                }

                if(y > 0 && y < 0.2)  {
                    y = 0.1;
                }
                if(y > 0.2 && y < 0.4)  {
                    y = 0.3;
                }
                if(y > 0.4 && y < 0.6)  {
                    y= 0.5;
                }
                if(y > 0.6 && y < 0.8)  {
                    y = 0.7;
                }
                if(y > 0.8 && y < 1)  {
                    y  = 0.9;
                }

                // On place la partie 1 du Domino
                if (tuile.getType1().equals("Prairie")) {
                    tuile.setX1(x);
                    tuile.setY1(y);
                    StdDraw.picture(x,y,"out/img/domino/prairie.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }
                if (tuile.getType1().equals("Foret")) {
                    tuile.setX1(x);
                    tuile.setY1(y);
                    StdDraw.picture(x,y,"out/img/domino/foret.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }
                if (tuile.getType1().equals("Champs")) {
                    tuile.setX1(x);
                    tuile.setY1(y);
                    StdDraw.picture(x,y,"out/img/domino/champs.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }
                if (tuile.getType1().equals("Mer")) {
                    tuile.setX1(x);
                    tuile.setY1(y);
                    StdDraw.picture(x,y,"out/img/domino/mer.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }
                if (tuile.getType1().equals("Montagne")) {
                    tuile.setX1(x);
                    tuile.setY1(y);
                    StdDraw.picture(x,y,"out/img/domino/montagne.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }
                if (tuile.getType1().equals("Mine")) {
                    tuile.setX1(x);
                    tuile.setY1(y);
                    StdDraw.picture(x,y,"out/img/domino/mine.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }

            }
        }


        Thread.sleep(500);

        while(true && !isKing)
        {
            // On affiche les coordonnées
            if (StdDraw.isMousePressed()) {

                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();

                if((x>0.4 && x < 0.6 && y > 0.4 && y < 0.6)) {
                    isKing = true;
                    break;
                }

                if(x > 0 && x < 0.2)  {
                    x = 0.1;
                }
                if(x > 0.2 && x < 0.4)  {
                    x = 0.3;
                }
                if(x > 0.4 && x < 0.6)  {
                    x = 0.5;
                }
                if(x > 0.6 && x < 0.8)  {
                    x = 0.7;
                }
                if(x > 0.8 && x < 1)  {
                    x = 0.9;
                }

                if(y > 0 && y < 0.2)  {
                    y = 0.1;
                }
                if(y > 0.2 && y < 0.4)  {
                    y = 0.3;
                }
                if(y > 0.4 && y < 0.6)  {
                    y= 0.5;
                }
                if(y > 0.6 && y < 0.8)  {
                    y = 0.7;
                }
                if(y > 0.8 && y < 1)  {
                    y  = 0.9;
                }

                // On place la partie 2 du Domino
                if (tuile.getType2().equals("Prairie")) {
                    tuile.setX2(x);
                    tuile.setY2(y);
                    StdDraw.picture(x,y,"out/img/domino/prairie.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }
                if (tuile.getType2().equals("Foret")) {
                    tuile.setX2(x);
                    tuile.setY2(y);
                    StdDraw.picture(x,y,"out/img/domino/foret.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }
                if (tuile.getType2().equals("Champs")) {
                    tuile.setX2(x);
                    tuile.setY2(y);
                    StdDraw.picture(x,y,"out/img/domino/champs.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }
                if (tuile.getType2().equals("Mer")) {
                    tuile.setX2(x);
                    tuile.setY2(y);
                    StdDraw.picture(x,y,"out/img/domino/mer.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }
                if (tuile.getType2().equals("Montagne")) {
                    tuile.setX2(x);
                    tuile.setY2(y);
                    StdDraw.picture(x,y,"out/img/domino/montagne.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }
                if (tuile.getType2().equals("Mine")) {
                    tuile.setX2(x);
                    tuile.setY2(y);
                    StdDraw.picture(x,y,"out/img/domino/mine.png",0.2,0.2);
                    double k = -0.05;

                    for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                        StdDraw.picture(x + k, y, "out/img/couronne.png", 0.05, 0.05);
                        k += 0.05;
                    }
                    break;
                }
            }
        }
        Thread.sleep(1000);
        if (isKing) return null;
        return tuile;
    }


    /*public static ArrayList<Tuile> supprimerDominos(ArrayList<Tuile> listePrincipale, ArrayList<Tuile> elementsASupprimer) {

        listePrincipale.removeAll(elementsASupprimer);
        return listePrincipale;

    }*/

    public static Tuile afficherDominosPioche(ArrayList<Tuile> listeDominos, Joueur joueur) throws InterruptedException {
        StdDraw.clear();
        Thread.sleep(500);

        double i = 0.2;

        for (Tuile tuile : listeDominos) {
            Font noir = new Font("Arial", 1, 20);
            StdDraw.setPenColor(Color.BLACK);
            StdDraw.setFont(noir);
            StdDraw.text(i, 0.7, Integer.toString(tuile.getNumeroDomino()));


            // Affichage paysage domino
            if (tuile.getType1().equals("Prairie")) {
                StdDraw.picture(i, 0.55, "out/img/domino/prairie.png", 0.2, 0.2);
            }
            if (tuile.getType1().equals("Foret")) {
                StdDraw.picture(i, 0.55, "out/img/domino/foret.png", 0.2, 0.2);
            }
            if (tuile.getType1().equals("Champs")) {
                StdDraw.picture(i, 0.55, "out/img/domino/champs.png", 0.2, 0.2);
            }
            if (tuile.getType1().equals("Mer")) {
                StdDraw.picture(i, 0.55, "out/img/domino/mer.png", 0.2, 0.2);
            }
            if (tuile.getType1().equals("Montagne")) {
                StdDraw.picture(i, 0.55, "out/img/domino/montagne.png", 0.2, 0.2);
            }
            if (tuile.getType1().equals("Mine")) {
                StdDraw.picture(i, 0.55, "out/img/domino/mine.png", 0.2, 0.2);
            }

            // Affichage couronnes tuiles du haut
            double k = -0.05;

            for (int j = 1; j <= tuile.getNmbCouronne1(); j++) {
                StdDraw.picture(i + k, 0.55, "out/img/couronne.png", 0.05, 0.05);
                k += 0.05;
            }


            i += 0.2;
        }

        i = 0.2;
        for (Tuile tuile : listeDominos) {
            if (tuile.getType2().equals("Prairie")) {
                StdDraw.picture(i, 0.35, "out/img/domino/prairie.png", 0.2, 0.2);
            }
            if (tuile.getType2().equals("Foret")) {
                StdDraw.picture(i, 0.35, "out/img/domino/foret.png", 0.2, 0.2);
            }
            if (tuile.getType2().equals("Champs")) {
                StdDraw.picture(i, 0.35, "out/img/domino/champs.png", 0.2, 0.2);
            }
            if (tuile.getType2().equals("Mer")) {
                StdDraw.picture(i, 0.35, "out/img/domino/mer.png", 0.2, 0.2);
            }
            if (tuile.getType2().equals("Montagne")) {
                StdDraw.picture(i, 0.35, "out/img/domino/montagne.png", 0.2, 0.2);
            }
            if (tuile.getType2().equals("Mine")) {
                StdDraw.picture(i, 0.35, "out/img/domino/mine.png", 0.2, 0.2);
            }


            double k = -0.05;

            for (int j = 1; j <= tuile.getNmbCouronne2(); j++) {
                StdDraw.picture(i + k, 0.35, "out/img/couronne.png", 0.05, 0.05);
                k += 0.05;
            }

            i += 0.2;
        }
        // Boucle de test
        while (true) {

            Font font1 = new Font("Arial", 1, 40);
            StdDraw.setFont(font1);
            StdDraw.text(0.5, 0.9, joueur.getName());
            StdDraw.setPenColor(Color.BLUE);
            StdDraw.text(0.5, 0.8, "Choisissez un domino");

            double k = 0.1;
            for (Tuile t : listeDominos) {
                if (StdDraw.mouseX() > k && StdDraw.mouseX() < k + 0.2 && StdDraw.mouseY() > 0.25 && StdDraw.mouseY() < 0.65 && StdDraw.isMousePressed()) {
                    return t;
                }
                k += 0.2;
            }
        }
    }

    public static void clear() {
        StdDraw.clear();
    }

    public static int afficherJoueur(Joueur j) throws InterruptedException {
        StdDraw.clear();
        Thread.sleep(500);
        String nom = j.getName();
        Font font1 = new Font("Arial", 1, 45);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setFont(font1);

        StdDraw.text(0.5, 0.8, "Au " + nom + " de jouer ");

        Tuile tuile = j.getTampon();

        if (tuile.getType1().equals("Prairie")) {
            StdDraw.picture(0.5, 0.55, "out/img/domino/prairie.png", 0.2, 0.2);
        }
        if (tuile.getType1().equals("Foret")) {
            StdDraw.picture(0.5, 0.55, "out/img/domino/foret.png", 0.2, 0.2);
        }
        if (tuile.getType1().equals("Champs")) {
            StdDraw.picture(0.5, 0.55, "out/img/domino/champs.png", 0.2, 0.2);
        }
        if (tuile.getType1().equals("Mer")) {
            StdDraw.picture(0.5, 0.55, "out/img/domino/mer.png", 0.2, 0.2);
        }
        if (tuile.getType1().equals("Montagne")) {
            StdDraw.picture(0.5, 0.55, "out/img/domino/montagne.png", 0.2, 0.2);
        }
        if (tuile.getType1().equals("Mine")) {
            StdDraw.picture(0.5, 0.55, "out/img/domino/mine.png", 0.2, 0.2);
        }

        if (tuile.getType2().equals("Prairie")) {
            StdDraw.picture(0.5, 0.35, "out/img/domino/prairie.png", 0.2, 0.2);
        }
        if (tuile.getType2().equals("Foret")) {
            StdDraw.picture(0.5, 0.35, "out/img/domino/foret.png", 0.2, 0.2);
        }
        if (tuile.getType2().equals("Champs")) {
            StdDraw.picture(0.5, 0.35, "out/img/domino/champs.png", 0.2, 0.2);
        }
        if (tuile.getType2().equals("Mer")) {
            StdDraw.picture(0.5, 0.35, "out/img/domino/mer.png", 0.2, 0.2);
        }
        if (tuile.getType2().equals("Montagne")) {
            StdDraw.picture(0.5, 0.35, "out/img/domino/montagne.png", 0.2, 0.2);
        }
        if (tuile.getType2().equals("Mine")) {
            StdDraw.picture(0.5, 0.35, "out/img/domino/mine.png", 0.2, 0.2);
        }




        //Accéder à la grille
        while (true) {
            if (StdDraw.isKeyPressed(KeyEvent.VK_ENTER)) {
                return 1;
            }
        }
    }

    public static void main(String[] args) {

    }


    public void afficherScore(ArrayList<Joueur> listeJoueurs) throws InterruptedException {
        StdDraw.clear();
        Thread.sleep(500);
        StdDraw.picture(0.6, 0.5, "out/img/menu.png");
        Font font1 = new Font("Arial", 1, 25);
        StdDraw.setPenColor(Color.BLACK);
        StdDraw.setFont(font1);
        double hauteurTexte = 0.8;
        for (int i = 0; i < listeJoueurs.size(); i++) {
            String nom = listeJoueurs.get(i).getName();
            StdDraw.text(0.2, hauteurTexte, nom);
            int score = listeJoueurs.get(i).getScore();
            StdDraw.text(0.8, hauteurTexte, String.valueOf(score));
            hauteurTexte -= 0.2;
        }
    }
}
