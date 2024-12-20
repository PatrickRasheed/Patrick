package Patrick.rasheed;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class AjouterAlbum {
    private JFrame frame;

    public AjouterAlbum() {
        frame = new JFrame("Ajouter un Album");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new GridLayout(3, 2));

        JTextField titreField = new JTextField();
        JTextField auteurField = new JTextField();
        JButton ajouterButton = new JButton("Ajouter");
        JButton retourButton = new JButton("Retour");

        frame.add(new JLabel("Titre:"));
        frame.add(titreField);
        frame.add(new JLabel("Auteur:"));
        frame.add(auteurField);
        frame.add(ajouterButton);
        frame.add(retourButton);

        ajouterButton.addActionListener(e -> {
            String titre = titreField.getText();
            String auteur = auteurField.getText();
            if (!titre.isEmpty() && !auteur.isEmpty()) {
                Album album = new Album(titre, auteur);
                try {
                    GestionFichierAlbums.ajouterAlbum(album);
                    JOptionPane.showMessageDialog(frame, "Album ajouté avec succès!");
                    titreField.setText("");
                    auteurField.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur lors de l'ajout de l'album.", "Erreur", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Veuillez remplir tous les champs.", "Erreur", JOptionPane.WARNING_MESSAGE);
            }
        });

        retourButton.addActionListener(e -> {
            frame.dispose();
            new Menu();
        });

        frame.setVisible(true);
    }
}
