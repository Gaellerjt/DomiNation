package game;

import java.awt.*;

public class Roi {
    public Color couleurRoi;

    public Roi(Color couleurRoi){ this.couleurRoi = couleurRoi; }

    public Color getCouleurRoi() {
        return couleurRoi;
    }

    public void setCouleurRoi(Color couleurRoi) {
        this.couleurRoi = couleurRoi;
    }
}
