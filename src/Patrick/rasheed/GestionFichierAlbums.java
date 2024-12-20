package Patrick.rasheed;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionFichierAlbums {
    private static final String FICHIER = "albums.txt";

    public static void ajouterAlbum(Album album) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FICHIER, true))) {
            writer.write(album.toString());
            writer.newLine();
        }
    }

    public static List<Album> lireAlbums() throws IOException {
        List<Album> albums = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FICHIER))) {
            String ligne;
            while ((ligne = reader.readLine()) != null) {
                albums.add(Album.fromString(ligne));
            }
        }
        return albums;
    }

    public static void supprimerAlbum(String titre) throws IOException {
        List<Album> albums = lireAlbums();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FICHIER))) {
            for (Album album : albums) {
                if (!album.getTitre().equals(titre)) {
                    writer.write(album.toString());
                    writer.newLine();
                }
            }
        }
    }
}
