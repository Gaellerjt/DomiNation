package game;

import java.util.ArrayList;

public class Joueur {

    private String name;
    private ArrayList<Roi> roi;
    private Chateau chateaux;
    private ArrayList<Tuile> paquet;


    public Joueur(String name, ArrayList<Roi> roi, Chateau chateaux, ArrayList<Tuile> paquet){
        this.name = name;
        this.roi = roi;
        this.chateaux = chateaux;
        this.paquet = paquet;
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
}
