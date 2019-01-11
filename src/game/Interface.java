package game;

import edu.princeton.cs.introcs.StdDraw;

import java.awt.*;

public class Interface {


    public static void MenuPrincipal() {

        // Afficher l'image
        StdDraw.picture(0.3, 0.45, "king.jpg", 2.1, 1.1);

        // Afficher le texte (Police + Couleur)
        Font policeTitre = new Font("Book Antiqua", 1, 45);
        StdDraw.setFont(policeTitre);
        StdDraw.setPenColor(new Color(200, 30, 50));
        StdDraw.text(0.5, 0.8, "KingDomino");

        // Création du bouton principal
        StdDraw.filledRectangle(0.5, 0.5, 0.15, 0.05);
        StdDraw.setPenColor(Color.WHITE);
        Font policeBouton = new Font("Book Antiqua", 1, 30);
        StdDraw.setFont(policeBouton);
        StdDraw.text(0.5, 0.5, "Start");

        // On regarde si on clique sur le bouton (ou pas)
        while (true) {

            if (StdDraw.mouseX() >= 0.35 && StdDraw.mouseX() <= 0.65 && StdDraw.mouseY() >= 0.45 && StdDraw.mouseY() <= 0.65 && StdDraw.isMousePressed()) {
                StdDraw.clear();
                break;
            }

        }

            /*
        // On regarde la position de la souris quand on clique
        while(true) {

            if(StdDraw.isMousePressed()) {
                System.out.println(StdDraw.mouseX());
                System.out.println(StdDraw.mouseY());
                System.out.println();
            }

        }
        */

    }

    public static int nombreJoueurs() {

        // Afficher l'image
        StdDraw.picture(0.3, 0.45, "king.jpg", 2.1, 1.1);

        // Afficher le texte (Police + Couleur)
        Font policeTitre = new Font("Book Antiqua", 1, 30);
        StdDraw.setFont(policeTitre);
        StdDraw.setPenColor(new Color(200, 30, 50));
        StdDraw.text(0.5, 0.8, "Nombre de joueurs");

        // Création des boutons
        Font policeBouton = new Font("Book Antiqua", 1, 25);
        StdDraw.setFont(policeBouton);
        // 2 joueurs
        StdDraw.filledRectangle(0.5, 0.6, 0.15, 0.05);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.text(0.5, 0.6, "2 joueurs");
        // 3 joueurs
        StdDraw.setPenColor(new Color(200, 30, 50));
        StdDraw.filledRectangle(0.5, 0.4, 0.15, 0.05);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.text(0.5, 0.4, "3 joueurs");
        // 4 joueurs
        StdDraw.setPenColor(new Color(200, 30, 50));
        StdDraw.filledRectangle(0.5, 0.2, 0.15, 0.05);
        StdDraw.setPenColor(Color.WHITE);
        StdDraw.text(0.5, 0.2, "4 joueurs");

        while (true) {

            // Bouton 2 joueurs
            if(StdDraw.mouseX() >= 0.35 && StdDraw.mouseX() <= 0.65 && StdDraw.mouseY() >= 0.55 && StdDraw.mouseY() <= 0.65 && StdDraw.isMousePressed()) {
                StdDraw.clear();
                return 2;
            }
            // Bouton 3 joueurs
            if(StdDraw.mouseX() >= 0.35 && StdDraw.mouseX() <= 0.65 && StdDraw.mouseY() >= 0.35 && StdDraw.mouseY() <= 0.45 && StdDraw.isMousePressed()) {
                StdDraw.clear();
                return 3;
            }
            // Bouton 4 joueurs
            if(StdDraw.mouseX() >= 0.35 && StdDraw.mouseX() <= 0.65 && StdDraw.mouseY() >= 0.15 && StdDraw.mouseY() <= 0.25 && StdDraw.isMousePressed()) {
                StdDraw.clear();
                return 4;
            }

        }

    }

    public static void sleep(int n) {
        try {
            Thread.sleep(n);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        MenuPrincipal();

        sleep(500);

        int nombreJoueurs = nombreJoueurs();

    }






}
