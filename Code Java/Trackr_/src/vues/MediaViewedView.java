package vues;

import modeles.user.Playlist;
import modeles.user.User;
import utils.WrapLayout;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static utils.Utils.*;
import static utils.Utils.COLOR_ACCENT_GREEN;
import static utils.Utils.COLOR_BACKGROUND_DARK;
import static utils.Utils.COLOR_CARD_BACKGROUND;
import static utils.Utils.COLOR_TEXT_DIM;
import static utils.Utils.COLOR_TEXT_LIGHT;

public class MediaViewedView extends JPanel {


    User user;

    public MediaViewedView(User user) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(COLOR_BACKGROUND_DARK);
        this.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.user = user;

        //ajout du header
        this.add(createHeaderSection());
        this.add(Box.createRigidArea(new Dimension(0, 40)));

        //ajout de la grille de playlist
        JScrollPane scrollPane = new JScrollPane(createPlaylistsGrid());
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setBackground(COLOR_BACKGROUND_DARK);
        scrollPane.getViewport().setBackground(COLOR_BACKGROUND_DARK);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        this.add(scrollPane);
    }

    //creation du header
    private JPanel createHeaderSection() {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COLOR_BACKGROUND_DARK);
        // On fixe une hauteur max pour éviter que le header ne s'étire verticalement
        headerPanel.setMaximumSize(new Dimension(2000, 60));

        // Titre et Compteur
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBackground(COLOR_BACKGROUND_DARK);

        JLabel titleLabel = new JLabel("Mes Medias vu");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 28));
        titleLabel.setForeground(COLOR_TEXT_LIGHT);

        int nbPlaylists = (user.getMesPlaylists() != null) ? user.getMesPlaylists().size() : 0;
        JLabel countLabel = new JLabel(nbPlaylists + " Media");
        countLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        countLabel.setForeground(COLOR_ACCENT_GREEN);

        leftPanel.add(titleLabel);
        leftPanel.add(countLabel);

        //allignement et assemblage
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(COLOR_BACKGROUND_DARK);
        headerPanel.add(leftPanel, BorderLayout.WEST);
        headerPanel.add(rightPanel, BorderLayout.EAST);

        return headerPanel;
    }

    //creation du conteneur principal en temps que grille
    private JPanel createPlaylistsGrid() {
        // FlowLayout permet aux éléments de se placer les uns après les autres
        // et de passer à la ligne suivante si la fenêtre est trop petite.
        JPanel gridPanel = new JPanel(new WrapLayout(FlowLayout.LEFT, 25, 25));
        gridPanel.setBackground(COLOR_BACKGROUND_DARK);

        return gridPanel;
    }

}
