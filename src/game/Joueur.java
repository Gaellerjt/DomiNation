package game;

import java.util.ArrayList;

public class Joueur {
    private String name;
    private ArrayList<game.Roi> rois;
    private ArrayList<game.Chateau> chateaux;
    private ArrayList<Tuile> paquet;


    public Joueur(String name, ArrayList<Roi> rois, ArrayList<Chateau> chateaux, ArrayList<Tuile> paquet){
        this.name = name;
        this.rois = rois;
        this.chateaux = chateaux;
        this.paquet = paquet;
    }

}
