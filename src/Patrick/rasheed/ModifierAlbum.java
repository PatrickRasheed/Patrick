package Patrick.rasheed;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class ModifierAlbum {
    private JFrame frame;

    public ModifierAlbum() {
        frame = new JFrame("Modifier un Album");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(3, 2));

        JTextField titreField = new JTextField();
        JTextField auteurField = new JTextField();
        JButton modifierButton = new JButton("Modifier");
        JButton retourButton = new JButton("Retour");

        frame.add(new JLabel("Titre:"));
        frame.add(titreField);
        frame.add(new JLabel("Auteur:"));
        frame.add(auteurField);
        frame.add(modifierButton);
        frame.add(retourButton);

        modifierButton.addActionListener(e -> {
            String titre = titreField.getText();
            String auteur = auteurField.getText();
            if (!titre.isEmpty() && !auteur.isEmpty()) {
                try {
                  
                    GestionFichierAlbums.supprimerAlbum(titre);
                   
                    Album album = new Album(titre, auteur);
                    GestionFichierAlbums.ajouterAlbum(album);
                    JOptionPane.showMessageDialog(frame, "Album modifié avec succès!");
                    titreField.setText("");
                    auteurField.setText("");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Erreur lors de la modification de l'album.", "Erreur", JOptionPane.ERROR_MESSAGE);
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
