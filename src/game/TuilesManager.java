package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TuilesManager {

    public static void main(String[] args) {



    }

    public static void sortTuilesByNumber(List<Tuile> tuiles) {
        Collections.sort(tuiles,
                (o1, o2) -> o1.getNumeroDomino() > o2.getNumeroDomino() ? 1 : -1);
    }
}
