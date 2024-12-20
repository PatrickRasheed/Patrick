package Patrick.rasheed;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.io.IOException;

public class GestionLocationApp {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;

    public GestionLocationApp() {
        frame = new JFrame("Afficher les Albums");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        model = new DefaultTableModel(new Object[]{"Titre", "Auteur"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(scrollPane, BorderLayout.CENTER);

        JButton retourButton = new JButton("Retour");

        retourButton.addActionListener(e -> {
            frame.dispose();
            new Menu();
        });

        panel.add(retourButton, BorderLayout.SOUTH);

        frame.add(panel);

        
        chargerAlbums();

        frame.setVisible(true);
    }

    private void chargerAlbums() {
        try {
            for (Album album : GestionFichierAlbums.lireAlbums()) {
                model.addRow(new Object[]{album.getTitre(), album.getAuteur()});
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Erreur lors du chargement des albums.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }
}
