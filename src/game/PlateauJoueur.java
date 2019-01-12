package game;


public class PlateauJoueur {

    private int[][] plateau;
    private Joueur joueur;


    public PlateauJoueur(int[][] plateau, Joueur joueur) {
        this.plateau = plateau;
        this.joueur = joueur;
    }

    public int[][] getPlateau() {
        return plateau;
    }

    public void setPlateau(int[][] plateau) {
        this.plateau = plateau;
    }

    public Joueur getJoueur() {
        return joueur;
    }

    public void setJoueur(Joueur joueur) {
        this.joueur = joueur;
    }

}

