package game;

import java.awt.*;
import java.util.*;

import edu.princeton.cs.introcs.StdDraw;

public class GameManager {

    public static void Teste() {

        ArrayList<Tuile> tuiles = TuilesFileReader.getTuilesFromFile();
        ColorManager colorManager = new ColorManager();

        Color[] kingColors = colorManager.getKingColors();

        //Création de la pioche de rois et de chateaux

        ArrayList<Roi> rois = new ArrayList<>();
        int nmbRois = 4;
        int nmbChateau = 4;
        for (int i = 0; i < nmbRois; i++) {
            int a = (int) (Math.random() * (kingColors.length - 1));
            Roi roi = new Roi(kingColors[a]);
            rois.add(roi);
            rois.add(roi);
            kingColors[a] = null;
        }

        ArrayList<Chateau> chateaux = new ArrayList<>();
        for (int i = 0; i < nmbChateau; i++) {
            int a = (int) (Math.random() * (kingColors.length - 1));
            Chateau chateau = new Chateau(kingColors[a]);
            chateaux.add(chateau);
            kingColors[a] = null;
        }

        ArrayList<Tuile> paquet = new ArrayList<>();
        ArrayList<Chateau> newChateau = new ArrayList<>();
        ArrayList<Roi> newRois = new ArrayList<>();
        ArrayList<Tuile> paquetJoueurs = new ArrayList<>();
        ArrayList<Tuile> paquetPlateforme = new ArrayList<>();
        ArrayList<Roi> countRois = new ArrayList<>();
        ArrayList<Joueur> joueurs = new ArrayList<>();
        ArrayList<Joueur> firstRoundPlayers = new ArrayList<>(joueurs);
        ArrayList<Integer> countPoints = new ArrayList<>();

        // Tester le nombre de joueurs
        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez le nombre de joueurs");
        int nmbJoueurs = scanner.nextInt();
        scanner.nextLine();
        while (nmbJoueurs < 2 || nmbJoueurs > 4) {
            System.out.println("Vous n'êtes pas le bon nombre de joueurs, veuillez ressaisir");
            nmbJoueurs = scanner.nextInt();

        }
        System.out.println("Veuillez commencer à jouer");


        // La pioche
        for (int j = 0; j < 48; j++) {
            paquet.add(tuiles.get((int) (Math.random() * 48)));
        }
        if (nmbJoueurs == 3) {
            for (int k = 0; k < 12; k++) {
                paquet.remove((int) (Math.random() * 48));
            }
        } else if (nmbJoueurs == 2) {
            for (int g = 0; g < 24; g++) {
                paquet.remove((int) (Math.random() * 48));
            }
        }

        // Init firstRoundPlayers
        Collections.shuffle(firstRoundPlayers);


        // Attribuer paquet, rois et chateau à chaque joueur

        for (int i = 0; i < nmbJoueurs; i++) {

            // game.Chateau
            Chateau essaiC = chateaux.get((int) Math.random() * 4);
            newChateau.add(essaiC);
            chateaux.remove(essaiC);
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            StdDraw.filledSquare(x, y, 5);

            //game.Roi
            Roi essaiR = rois.get((int) Math.random() * 8);
            newRois.add(essaiR);
            rois.remove(essaiR);
            countRois.add(essaiR);
            if (nmbJoueurs == 2) {
                Roi test = rois.get((int) Math.random() * 8);
                newRois.add(test);
                rois.remove(test);
                Roi test2 = rois.get((int) Math.random() * 7);
                while (test2 != test) {
                    test2 = rois.get((int) Math.random() * 7);
                }
                newRois.add(test2);
                rois.remove(test2);
                countRois.add(test);
                countRois.add(test2);
            }

            // La tuile de départ
            Tuile tuileDepart = paquet.get((int) Math.random() * paquet.size());
            paquetJoueurs.add(tuileDepart);
            paquet.remove(tuileDepart);
            StdDraw.filledSquare(x, y, 5);

/*
            //Création du joueur
            Joueur joueur = new Joueur("Joueur " + i, newRois,newChateau,paquetJoueurs);
            joueurs.add(joueur);
*/

            // Remettre à 0 les arguments du joueur pour le joueur d'après
            newRois.remove(newRois.size());
            newChateau.remove(newChateau.size());
            paquetJoueurs.remove(paquetJoueurs.size());

        }

        // Le jeu commence

        // Savoir qui commence
        Roi roiChoisi = countRois.get((int) (Math.random() * countRois.size()));

        //Jouer
        int turnNumber = 1;

        while (paquet.size() != 0) {

            for (int i = 0; i < countRois.size(); i++) {
                Tuile pioche = paquet.get(0);
                //Mettre les dominos au milieu du jeu
                paquetPlateforme.add(pioche);
                paquet.remove(pioche);
                TuilesManager.sortTuilesByNumber(paquetPlateforme);
            }


            for (int j = 0; j < nmbJoueurs; j++) {
                Joueur joueurPlaying = pickPlayer(firstRoundPlayers, turnNumber);
                // Le joueur choisi le domino qu'il veut
                int dominoChoisi = scanner.nextInt();
                paquetJoueurs.add(paquetPlateforme.get(dominoChoisi));


            }
            turnNumber++;
        }

        StdDraw.clear(StdDraw.BLACK);

    }

    /**
     * @param firstRoundPlayers
     * @param turnNumber
     * @return
     */
    private static Joueur pickPlayer(ArrayList<Joueur> firstRoundPlayers, int turnNumber) {
        if (turnNumber == 1) {
            Joueur joueur = firstRoundPlayers.get(0);
            firstRoundPlayers.remove(joueur);
            return joueur;
        } else {
            // TODO : Implements
            return null;
        }
    }

    // Fonction principale
    public static void main(String[] args) throws InterruptedException {

        // Création des ArrayLists
        // ArrayList des Rois
        ArrayList<Roi> listeRois = new ArrayList<Roi>();
        listeRois.add(new Roi(Color.GREEN));
        listeRois.add(new Roi(Color.BLUE));
        listeRois.add(new Roi(Color.PINK));
        listeRois.add(new Roi(Color.YELLOW));

        ArrayList<Tuile> listePaquet = new ArrayList<Tuile>();

        // On crée l'interface graphique
        InterfaceGraphique InterfaceGraphique = new InterfaceGraphique();
        // On affiche le menu principal
        int nombreJoueurs = InterfaceGraphique.Menu();

        // On crée le nombre de joueurs
        System.out.println("nombre de joueurs = " + nombreJoueurs);
        ArrayList<Joueur> listeJoueurs = new ArrayList<Joueur>();
        for (int i = 0; i < nombreJoueurs; i++) {
            listeJoueurs.add(new Joueur("Joueur " + (i + 1), listeRois, new Chateau(Color.WHITE), listePaquet));
        }


        // On choisit le roi pour chaque joueur
        Roi.choixRoi(listeJoueurs, listeRois, nombreJoueurs);

        // On récupère les tuiles en fonction du nombre de joueurs
        ArrayList<Tuile> tuilesFromFile = TuilesFileReader.getTuilesFromFile();
        ArrayList<Tuile> listeTuiles = TuilesFileReader.shuffleTuiles(tuilesFromFile,nombreJoueurs);

        // Savoir quel joueur commence
        Joueur joueurQuiCommence = listeJoueurs.get((int) (Math.random() * listeJoueurs.size()));


        System.out.println(listeTuiles.size());
        ArrayList<Tuile> listeDes4PremiersDominos = InterfaceGraphique.selectionnerDominos(listeTuiles);
        System.out.println(InterfaceGraphique.supprimerDominos(listeTuiles,listeDes4PremiersDominos).size());


    }
}

