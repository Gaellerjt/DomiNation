package game;

import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class Roi {
    public Color couleurRoi;

    public Roi(Color couleurRoi){ this.couleurRoi = couleurRoi; }

    public Color getCouleurRoi() {
        return couleurRoi;
    }

    public void setCouleurRoi(Color couleurRoi) {
        this.couleurRoi = couleurRoi;
    }

    public static void choixRoi(ArrayList<Joueur> listeJoueurs, ArrayList<Roi> listeRois, int nombreJoueurs) throws InterruptedException {
        // On crée d'abord une variable roi temporaire
        Roi temp = new Roi(Color.WHITE);
        // On explore ensuite chaque joueur crée dans l'ArrayList
        for (Joueur j : listeJoueurs) {
            // On récupère le roi sélectionné dans le menu qui sera à supprimer
            Roi roiASupprimer = (Roi) InterfaceGraphique.selectionRoi(listeRois, j);
            // On crée une boucle for qui parcourt chaque roi dans la liste des rois qui existe
            for (Iterator<Roi> i = listeRois.iterator(); i.hasNext();) {
                Roi r = i.next();
                // Si le roi à supprimer est de la même couleur que le roi choisi par le joueur, on stocke ce roi dans la variable temporaire
                // créée plus haut et on casse la boucle
                if (r.getCouleurRoi().equals(roiASupprimer.getCouleurRoi())) {
                    temp = r;
                    break;
                }
            }
            /* On assigne le roi au joueur, 2 cas se présentent :
            - Il y a 2 joueurs: chaque joueur aura 2 rois de la même couleur
            - Il y a 3 ou 4 joueurs : chaque joueur aura un seul Roi
            */
            ArrayList<Roi> arrayRoi = new ArrayList<Roi>();
            arrayRoi.add(temp);
            // Si il y a 2 joueurs, on ajoute une deuxieme fois un Roi
            if(nombreJoueurs == 2)
                arrayRoi.add(temp);
            j.setRoi(arrayRoi);

            // Enfin, on supprime le roi de la liste temporaire
            listeRois.remove(temp);
        }
    }
}
