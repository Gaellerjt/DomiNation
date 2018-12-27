package game;

import java.util.Collections;
import java.util.List;

public class CountPoints {
    public static void CountPoints(List<Tuile> tuiles) {
        Collections.sort(tuiles,
                (o1, o2) -> o1.getType1() == o2.getType1() ? 1 : -1);
        Collections.sort(tuiles,
                (o1, o2) -> o1.getType2() == o2.getType2() ? 1 : -1);
        Collections.sort(tuiles,
                (o1,o2) -> o1.getNmbCouronne1() > o2.getNmbCouronne1() ? 1 : -1);
        Collections.sort(tuiles,
                (o1,o2) -> o1.getNmbCouronne2() > o2.getNmbCouronne2() ? 1 : -1);

    }

}
