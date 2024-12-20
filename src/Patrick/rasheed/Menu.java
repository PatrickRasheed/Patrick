package Patrick.rasheed;

import javax.swing.*;
import java.awt.*;

public class Menu {
    private JFrame frame;

    public Menu() {
        frame = new JFrame("Gestion de Location d'Album - Menu Principal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(4, 1));

        JButton ajouterButton = new JButton("Ajouter un album");
        JButton modifierButton = new JButton("Modifier un album");
        JButton afficherButton = new JButton("Afficher les albums");
        JButton quitterButton = new JButton("Quitter");

        ajouterButton.addActionListener(e -> {
            frame.dispose();
            new AjouterAlbum();
        });

        modifierButton.addActionListener(e -> {
            frame.dispose();
            new ModifierAlbum();
        });

        afficherButton.addActionListener(e -> {
            frame.dispose();
            new GestionLocationApp();
        });

        quitterButton.addActionListener(e -> System.exit(0));

        frame.add(ajouterButton);
        frame.add(modifierButton);
        frame.add(afficherButton);
        frame.add(quitterButton);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Menu::new);
    }
}
