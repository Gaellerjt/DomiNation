package old;


import static java.lang.Integer.parseInt;

public class DomiNations {
    /*
    public static void regleDuJeu() {
        Color rouge = new Color(255 - 0 - 0);
        Color Foret = new Color(255 - 0 - 0);
        Color jaune = new Color(255 - 255 - 0);
        Color Champs = new Color(255 - 255 - 0);
        Color vert = new Color(34 - 139 - 34);
        Color Prairie = new Color(34 - 139 - 34);
        Color bleu = new Color(0 - 191 - 255);
        Color Mer = new Color(0 - 191 - 255);
        Color marron = new Color(139 - 69 - 19);
        Color Montagne = new Color(139 - 69 - 19);
        Color gris = new Color(190 - 190 - 190);
        Color Mine = new Color(190 - 190 - 190);
        Color rose = new Color(255 - 105 - 180);
        ArrayList<Tuile> tuiles = new ArrayList<>();
        String dominoFile =  "/Utilisateurs/Gaelle/IdeaProjects/dominos.csv";

        //lire le document csv
        BufferedReader document = null;
        String ligne = "";
        String separation = ",";
        try {

            document = new BufferedReader(new FileReader(dominoFile));
            while ((ligne = document.readLine()) != null) {
                // Utiliser une virgule pour séparer
                String[] line = ligne.split(separation);
                Tuile domino = new Tuile(Integer.parseInt(line[0]), Color.getColor(line[1]), parseInt(line[2]), Color.getColor(line[3]), parseInt(line[4]));
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



        Color[] color = {jaune,vert,bleu,rose};

        ArrayList<Roi> rois = new ArrayList<>();
        int nmbRois = 4;
        int nmbChateau = 4;
        for (int i = 0; i < nmbRois ; i++){
            int a = (int)(Math.random() * (color.length - 1));
            Roi roi = new Roi(color[a]);
            rois.add(roi);
            color[a] = null;
        }

        ArrayList<Chateau> chateaux = new ArrayList<>();
        for (int i = 0; i <nmbChateau ; i ++){
            int a = (int)(Math.random() * (color.length - 1));
            Chateau chateau = new Chateau(color[a]);
            chateaux.add(chateau);
            color[a] = null;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Saisissez le nombre de joueurs");
        int nmbJoueurs = scanner.nextInt();
        scanner.nextLine();

        while (nmbJoueurs < 2 || nmbJoueurs > 4) {
            System.out.println("Vous n'êtes pas le bon nombre de joueurs, veuillez ressaisir");
            nmbJoueurs = scanner.nextInt();

        }
        System.out.println("Veuillez commencer à jouer");


        ArrayList<Roi> newRois = new ArrayList<>();
        ArrayList<Tuile> paquet1 = new ArrayList<>();
        ArrayList<Tuile> paquet2 = new ArrayList<>();
        ArrayList<Tuile> paquet3 = new ArrayList<>();
        ArrayList<Tuile> paquet4 = new ArrayList<>();
        ArrayList<Chateau> newChateau = new ArrayList<>();

        if (nmbJoueurs == 2) {
            while(tuiles.size()>25){
                tuiles.remove(Math.random() * 2);
            }
            for (int i = 0; i < 2; i++) {
                int c = (int)Math.random()*2;
                newChateau.add(chateaux.get(c));
                chateaux.remove(c);
                int a = (int) Math.random() * 2;
                Roi r = rois.get(a);
                int b = (int)Math.random()*2;
                Roi s = rois.get(b);
                while (s != r) {
                    a = (int) Math.random() * 2;
                    rois.remove(a);
                    r = rois.get(a);
                }
                newRois.add(r);
                newRois.add(s);
            }
            while (tuiles.size() != 0) {
                int tuilePaquet1 = (int) Math.random() * tuiles.size();
                Tuile gettuile1 = tuiles.get(tuilePaquet1);
                paquet1.add(gettuile1);
                tuiles.remove(gettuile1);
                int tuilePaquet2 = (int) Math.random() * tuiles.size();
                Tuile gettuile2 = tuiles.get(tuilePaquet2);
                paquet2.add(gettuile2);
                tuiles.remove(gettuile2);
            }

        }

        if (nmbJoueurs == 3) {
            while (tuiles.size() > 37){
                tuiles.remove((int) (Math.random() * tuiles.size()) );
            }
            for (int i = 0; i < 3 ; i++) {
                int c = (int) Math.random() * 2;
                newChateau.add(chateaux.get(c));
                chateaux.remove(c);
                int a = (int) Math.random() * 4;
                newRois.add(rois.get(a));
                rois.remove(a);
            }
            while (tuiles.size() != 0) {
                int tuilePaquet1 = (int) Math.random() * tuiles.size();
                Tuile gettuile1 = tuiles.get(tuilePaquet1);
                paquet1.add(gettuile1);
                tuiles.remove(gettuile1);
                int tuilePaquet2 = (int) Math.random() * tuiles.size();
                Tuile gettuile2 = tuiles.get(tuilePaquet2);
                paquet2.add(gettuile2);
                tuiles.remove(gettuile2);
                int tuilePaquet3 = (int) Math.random() * tuiles.size();
                Tuile gettuile3 = tuiles.get(tuilePaquet3);
                paquet3.add(gettuile3);
                tuiles.remove(gettuile3);
            }
        }

        if (nmbJoueurs == 4){
             for (int i = 0; i < 4 ; i++) {
                 int c = (int) Math.random() * 2;
                 newChateau.add(chateaux.get(c));
                 chateaux.remove(c);
                 int a = (int) Math.random() * 4;
                 newRois.add(rois.get(a));
                 rois.remove(a);
             }
             while (tuiles.size() != 0) {
                 int tuilePaquet1 = (int) Math.random() * tuiles.size();
                 Tuile gettuile1 = tuiles.get(tuilePaquet1);
                 paquet1.add(gettuile1);
                 tuiles.remove(gettuile1);
                 int tuilePaquet2 = (int) Math.random() * tuiles.size();
                 Tuile gettuile2 = tuiles.get(tuilePaquet2);
                 paquet2.add(gettuile2);
                 tuiles.remove(gettuile2);
                 int tuilePaquet3 = (int) Math.random() * tuiles.size();
                 Tuile gettuile3 = tuiles.get(tuilePaquet3);
                 paquet3.add(gettuile3);
                 tuiles.remove(gettuile3);
                 int tuilePaquet4 = (int) Math.random() * tuiles.size();
                 Tuile gettuile4 = tuiles.get(tuilePaquet4);
                 paquet4.add(gettuile4);
                 tuiles.remove(gettuile4);
             }
        }

        for (int i = 0; i < paquet1.size(); i++){
             System.out.println(paquet1);
        }

    }

    public static void main (String[] args) {

        regleDuJeu();
    }
    */
}




