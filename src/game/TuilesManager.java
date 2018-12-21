package game;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TuilesManager {

    public static void main(String[] args) {
        ArrayList<Tuile> tuilesUnsorted = new ArrayList<>();
        tuilesUnsorted.add(new Tuile(3));
        tuilesUnsorted.add(new Tuile(6));
        tuilesUnsorted.add(new Tuile(2));
        tuilesUnsorted.add(new Tuile(4));
        tuilesUnsorted.add(new Tuile(1));
        tuilesUnsorted.add(new Tuile(9));
        tuilesUnsorted.add(new Tuile(7));
        System.out.println(tuilesUnsorted);
        sortTuilesByNumber(tuilesUnsorted);
        System.out.println("After Sort:");
        System.out.println(tuilesUnsorted);


    }

    public static void sortTuilesByNumber(List<Tuile> tuiles) {
        Collections.sort(tuiles,
                (o1, o2) -> o1.getNumeroDomino() > o2.getNumeroDomino() ? 1 : -1);
    }
}
