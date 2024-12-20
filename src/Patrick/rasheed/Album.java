package Patrick.rasheed;

public class Album {
    private String titre;
    private String auteur;

    public Album(String titre, String auteur) {
        this.titre = titre;
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public String getAuteur() {
        return auteur;
    }

    @Override
    public String toString() {
        return titre + "," + auteur;
    }

    public static Album fromString(String ligne) {
        String[] parties = ligne.split(",");
        return new Album(parties[0], parties[1]);
    }
}
