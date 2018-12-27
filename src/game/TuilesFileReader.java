package game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import static java.lang.Integer.parseInt;


public class TuilesFileReader {

    public static void main(String[] args) {

        // Récupérer les tuiles
        ArrayList<Tuile> tuilesFromFile = getTuilesFromFile();
        System.out.println(tuilesFromFile);
    }


    public static ArrayList<Tuile> getTuilesFromFile() {
        ArrayList<Tuile> tuiles = new ArrayList<>();
        String dominoFile =  "resources/dominos.csv";
        //lire le document csv
        BufferedReader document = null;
        String ligne = "";
        String separation = ",";
        try {

            document = new BufferedReader(new FileReader(dominoFile));
            while ((ligne = document.readLine()) != null) {
                // Utiliser une virgule pour séparer
                String[] line = ligne.split(separation);
                Tuile domino = new Tuile(parseInt(line[0]),
                        line[1],
                        parseInt(line[2]),
                        line[3],
                        parseInt(line[4]));
                tuiles.add(domino);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (document != null) {
                try {
                    document.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return tuiles;
    }

    // Mélange les tuiles en fonction du nombre de joueurs
    public static ArrayList<Tuile> shuffleTuiles(ArrayList<Tuile> listeTuiles, int nombreJoueurs) {
        Random rand = new Random();

        ArrayList<Tuile> finalArray = new ArrayList<>();

        int tuilesASupprimer = 0;
        if(nombreJoueurs == 2) {
            tuilesASupprimer = 24;
        } else if(nombreJoueurs == 3) {
            tuilesASupprimer = 12;
        }

        for(int i = 0; i < 48 - tuilesASupprimer; i++) {
            int randomIndex = rand.nextInt(listeTuiles.size());
            Tuile tuile = listeTuiles.get(randomIndex);
            finalArray.add(tuile);
            listeTuiles.remove(tuile);
        }
        return finalArray;
    }

}
