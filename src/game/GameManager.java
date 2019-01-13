package game;

import java.awt.*;
import java.util.*;

import static game.Joueur.getScore;

public class GameManager {


    // Fonction principale
    public static void main(String[] args) throws InterruptedException {

        // Création des ArrayLists
        // ArrayList des Rois
        ArrayList<Roi> listeRois = new ArrayList<Roi>();
        listeRois.add(new Roi(Color.GREEN));
        listeRois.add(new Roi(Color.BLUE));
        listeRois.add(new Roi(Color.PINK));
        listeRois.add(new Roi(Color.YELLOW));

        // On crée l'interface graphique
        InterfaceGraphique InterfaceGraphique = new InterfaceGraphique();
        // On affiche le menu principal
        int nombreJoueurs = InterfaceGraphique.Menu();

        // On crée le nombre de joueurs
        System.out.println("nombre de joueurs = " + nombreJoueurs);
        ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
        for (int i = 0; i < nombreJoueurs; i++) {
            listeJoueurs.add(new Joueur("Joueur " + (i + 1), listeRois, new Chateau(Color.WHITE), new ArrayList<>()));
        }

        // On choisit le roi pour chaque joueur
        Roi.choixRoi(listeJoueurs, listeRois, nombreJoueurs);

        // On récupère les tuiles en fonction du nombre de joueurs
        ArrayList<Tuile> tuilesFromFile = TuilesFileReader.getTuilesFromFile();
        ArrayList<Tuile> listeTuiles = TuilesFileReader.shuffleTuiles(tuilesFromFile, nombreJoueurs);

        // Savoir quel joueur commence
        Joueur joueurQuiCommence = listeJoueurs.get((int) (Math.random() * listeJoueurs.size()));


        // On crée les plateaux

        ArrayList<PlateauJoueur> listePlateaux = new ArrayList<PlateauJoueur>();
        for (Joueur j : listeJoueurs) {
            listePlateaux.add(new PlateauJoueur(new int[9][9], j));
        }


        while (listeTuiles.size() != 0) {
            ArrayList<Tuile> listeDes4PremiersDominos = Tuile.selectionnerDominos(listeTuiles, nombreJoueurs);

            // On trie les dominos
            TuilesManager.sortTuilesByNumber(listeDes4PremiersDominos);

            // On mélange les joueurs
            ArrayList<Joueur> joueurTour = new ArrayList<Joueur>();
            for (int i = 0; i < nombreJoueurs; i++) {
                joueurTour.add(new Joueur("Joueur " + (i + 1), listeRois, new Chateau(Color.WHITE), new ArrayList<>()));
            }
            int i = 1;
            Collections.shuffle(joueurTour);

            ArrayList<Joueur> listTemp = new ArrayList<Joueur>();

            Iterator<Joueur> it = joueurTour.iterator();
            while (it.hasNext()) {
                Joueur j = it.next();

                // On affiche les 4 premiers dominos
                Tuile tuileSelectionnee = InterfaceGraphique.afficherDominosPioche(listeDes4PremiersDominos, j);
                j.setTampon(tuileSelectionnee);
                listTemp.add(j);
                listeDes4PremiersDominos.remove(tuileSelectionnee);
                it.remove();
            }

            InterfaceGraphique.clear();


            //Tour de jeu
            for (int k = 0; k < listTemp.size(); k++) {
                Joueur joueur = Joueur.findJoueur(listeJoueurs, listTemp.get(k).getName());
                InterfaceGraphique.afficherJoueur(listTemp.get(k));
                Tuile addedTuile = InterfaceGraphique.Plateau(joueur, listTemp.get(k).getTampon());
                if (addedTuile != null) {
                    joueur.addTuile(addedTuile);
                }
            }
        }

        // Fin du jeu
        for (int i = 0; i < listeJoueurs.size(); i++) {
            Joueur joueur = listeJoueurs.get(i);
            joueur.setScore(getScore(joueur.getPaquet()));
            System.out.println(joueur.getName() + " score is " + joueur.getScore());
        }
        InterfaceGraphique.afficherScore(listeJoueurs);
    }
}

