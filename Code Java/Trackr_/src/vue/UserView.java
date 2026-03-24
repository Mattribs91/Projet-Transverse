package vue;

import controller.UserController;
import main.FactoryMedia;
import models.media.Media;
import models.user.Avis;
import models.user.Playlist;
import models.user.User;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserView extends JPanel {

    // Couleurs du thème
    private static final Color COLOR_BACKGROUND_DARK = new Color(18, 22, 28);
    private static final Color COLOR_CARD_BACKGROUND = new Color(30, 35, 43);
    private static final Color COLOR_TEXT_LIGHT = new Color(230, 230, 230);
    private static final Color COLOR_TEXT_DIM = new Color(150, 150, 150);
    private static final Color COLOR_ACCENT_GREEN = new Color(50, 205, 50);

    User user;

    public UserView(User user) {
        this.user = user;

        // On utilise un BorderLayout pour le panel principal afin d'y mettre le ScrollPane
        this.setLayout(new BorderLayout());
        this.setBackground(COLOR_BACKGROUND_DARK);

        // --- PANEL CONTENU (Celui qui va défiler) ---
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setBackground(COLOR_BACKGROUND_DARK);
        contentPanel.setBorder(new EmptyBorder(30, 40, 40, 40));

        // 1. En-tête
        contentPanel.add(createHeaderSection(user));
        contentPanel.add(Box.createVerticalStrut(40));

        // 2. Abonnements
        contentPanel.add(createSectionTitle("Mes Abonnements"));
        contentPanel.add(createAbonnementsSection());
        contentPanel.add(Box.createVerticalStrut(40));

        contentPanel.add(createDernierAvis());

        contentPanel.add(createSectionTitle("Mes Playlists"));
        contentPanel.add(createPlaylistPerso());
        contentPanel.add(Box.createVerticalStrut(40));


        JScrollPane scrollPane = new JScrollPane(contentPanel);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.getViewport().setBackground(COLOR_BACKGROUND_DARK);

        this.add(scrollPane, BorderLayout.CENTER);
    }

    private JPanel createHeaderSection(User user) {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COLOR_BACKGROUND_DARK);
        headerPanel.setMaximumSize(new Dimension(1200, 120));
        headerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        infoPanel.setBackground(COLOR_BACKGROUND_DARK);

        JLabel avatar = new JLabel(user.getPseudo().substring(0, 2).toUpperCase(), SwingConstants.CENTER);
        avatar.setFont(new Font("Arial", Font.BOLD, 30));
        avatar.setForeground(COLOR_ACCENT_GREEN);
        avatar.setOpaque(true);
        avatar.setBackground(COLOR_CARD_BACKGROUND);
        avatar.setPreferredSize(new Dimension(100, 100));

        JPanel textInfoPanel = new JPanel();
        textInfoPanel.setLayout(new BoxLayout(textInfoPanel, BoxLayout.Y_AXIS));
        textInfoPanel.setBackground(COLOR_BACKGROUND_DARK);

        JLabel nameLabel = new JLabel(user.getPseudo());
        nameLabel.setFont(new Font("Arial", Font.BOLD, 32));
        nameLabel.setForeground(COLOR_TEXT_LIGHT);

        JLabel memberSince = new JLabel("Membre depuis 2025");
        memberSince.setFont(new Font("Arial", Font.PLAIN, 14));
        memberSince.setForeground(COLOR_TEXT_DIM);

        textInfoPanel.add(Box.createVerticalStrut(20));
        textInfoPanel.add(nameLabel);
        textInfoPanel.add(Box.createVerticalStrut(5));
        textInfoPanel.add(memberSince);

        infoPanel.add(avatar);
        infoPanel.add(textInfoPanel);

        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        statsPanel.setBackground(COLOR_BACKGROUND_DARK);

        statsPanel.add(createStatItem(user.getVu().getLesMedias().size() + "", "VUS"));
        statsPanel.add(createStatItem(user.getFollower().size() + "", "FOLLOWERS"));
        statsPanel.add(createStatItem(user.getSuivi().size() + "", "SUIVIS"));

        headerPanel.add(infoPanel, BorderLayout.WEST);
        headerPanel.add(statsPanel, BorderLayout.EAST);

        return headerPanel;
    }

    private JPanel createAbonnementsSection() {
        // Changement : FlowLayout.LEFT pour aligner les badges à gauche
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        panel.setBackground(COLOR_BACKGROUND_DARK);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.user.getSuivi().forEach(user1 -> {
            panel.add(createBadge(user1.getPseudo()));
        });
        return panel;
    }

    private JPanel createPlaylistPerso() {
        // Changement : FlowLayout.LEFT pour aligner les playlists proprement
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        panel.setBackground(COLOR_BACKGROUND_DARK);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        var playlists = this.user.getMesPlaylists();

        playlists.stream()
                .limit(4)
                .forEach(playlist -> {
                    panel.add(createPlaylistItem(playlist));
                });

        if (playlists.size() > 4) {
            JButton btnVoirPlus = new JButton("Voir plus");
            btnVoirPlus.setFont(new Font("Arial", Font.BOLD, 14));
            btnVoirPlus.setForeground(COLOR_ACCENT_GREEN);
            btnVoirPlus.setBackground(COLOR_CARD_BACKGROUND);
            btnVoirPlus.setFocusPainted(false);
            btnVoirPlus.setCursor(new Cursor(Cursor.HAND_CURSOR));
            btnVoirPlus.setPreferredSize(new Dimension(150, 50)); // Taille fixe pour le bouton

            btnVoirPlus.setBorder(BorderFactory.createCompoundBorder(
                    BorderFactory.createLineBorder(new Color(60, 60, 60), 1),
                    new EmptyBorder(10, 20, 10, 20)
            ));

            // Le panel contenant le bouton est un peu descendu pour s'aligner avec le texte des playlists
            JPanel btnWrapper = new JPanel();
            btnWrapper.setBackground(COLOR_BACKGROUND_DARK);
            btnWrapper.setBorder(new EmptyBorder(80, 20, 0, 0));
            btnWrapper.add(btnVoirPlus);

            UserController.openViewPlaylist(btnVoirPlus, this);

            panel.add(btnWrapper);
        }

        return panel;
    }

    private JPanel createDernierAvis() {
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBackground(COLOR_BACKGROUND_DARK);
        container.setAlignmentX(Component.LEFT_ALIGNMENT);

        long countAvis = FactoryMedia.getFactoryMedia()
                .getLesAvisDeToutLeMonde()
                .stream()
                .filter(avis -> avis.getCreateur().equals(user))
                .count();

        container.add(createSectionTitle("Mes Derniers avis (" + countAvis + ")"));
        container.add(Box.createRigidArea(new Dimension(0, 15)));

        FactoryMedia.getFactoryMedia().getLesAvisDeToutLeMonde().stream()
                .filter(avis -> avis != null && avis.getCreateur() != null)
                .filter(avis -> avis.getCreateur().equals(user))
                .forEach(avis -> {
                    container.add(createCarteCritique(avis));
                    container.add(Box.createRigidArea(new Dimension(0, 15))); // Espace entre chaque avis
                });

        return container;
    }

    private JPanel createPlaylistItem(Playlist playlist) {
        JPanel card = new JPanel();
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBackground(COLOR_BACKGROUND_DARK);
        card.setPreferredSize(new Dimension(200, 260));

        JLabel imagePlaceholder = new JLabel("\uD83D\uDCFD\uFE0F", SwingConstants.CENTER); // Une note de musique au lieu d'un clin d'oeil
        imagePlaceholder.setFont(new Font("Arial", Font.PLAIN, 50));
        imagePlaceholder.setOpaque(true);
        imagePlaceholder.setBackground(COLOR_CARD_BACKGROUND);
        imagePlaceholder.setForeground(COLOR_TEXT_DIM);

        Dimension imageSize = new Dimension(200, 200);
        imagePlaceholder.setPreferredSize(imageSize);
        imagePlaceholder.setMaximumSize(imageSize);
        imagePlaceholder.setMinimumSize(imageSize);

        JLabel titleLabel = new JLabel(playlist.getNom());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(COLOR_TEXT_LIGHT);
        titleLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        int mediaCount = (playlist.getLesMedias() != null) ? playlist.getLesMedias().size() : 0;
        String texteElement = (mediaCount <= 1) ? " élément" : " éléments";
        JLabel countLabel = new JLabel(mediaCount + texteElement);
        countLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        countLabel.setForeground(COLOR_TEXT_DIM);
        countLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        card.add(imagePlaceholder);
        card.add(Box.createRigidArea(new Dimension(0, 12)));
        card.add(titleLabel);
        card.add(Box.createRigidArea(new Dimension(0, 5)));
        card.add(countLabel);

        return card;
    }

    private JPanel createCarteCritique(Avis avis) {
        Media media = avis.getMediaAssocie();

        JPanel card = new JPanel(new BorderLayout(20, 0));
        card.setBackground(COLOR_CARD_BACKGROUND);
        card.setBorder(new EmptyBorder(15, 15, 15, 15));
        card.setMaximumSize(new Dimension(1200, 200));
        card.setAlignmentX(Component.LEFT_ALIGNMENT); // Important pour l'alignement dans le BoxLayout

        JPanel filmPanel = new JPanel();
        filmPanel.setLayout(new BoxLayout(filmPanel, BoxLayout.Y_AXIS));
        filmPanel.setBackground(COLOR_CARD_BACKGROUND);
        filmPanel.setPreferredSize(new Dimension(250, 150));

        JLabel titleLabel = new JLabel(media.getTitre().toUpperCase());
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        titleLabel.setForeground(COLOR_ACCENT_GREEN);

        JLabel directorLabel = new JLabel("De " + media.getRealisateur());
        directorLabel.setFont(new Font("Arial", Font.ITALIC, 13));
        directorLabel.setForeground(COLOR_TEXT_DIM);

        JLabel catLabel = new JLabel(media.getLaCategorie().toString());
        catLabel.setFont(new Font("Arial", Font.PLAIN, 11));
        catLabel.setForeground(COLOR_TEXT_LIGHT);
        catLabel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(COLOR_TEXT_DIM),
                new EmptyBorder(2, 5, 2, 5)
        ));

        filmPanel.add(titleLabel);
        filmPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        filmPanel.add(directorLabel);
        filmPanel.add(Box.createRigidArea(new Dimension(0, 15)));
        filmPanel.add(catLabel);

        JPanel avisPanel = new JPanel(new BorderLayout(0, 10));
        avisPanel.setBackground(COLOR_CARD_BACKGROUND);

        String etoiles = "★".repeat(avis.getNombreEtoiles()) + "☆".repeat(5 - avis.getNombreEtoiles());
        JLabel starsLabel = new JLabel(etoiles + "  •  " + avis.getDateDeCreation().toLocaleString().split(",")[0]);
        starsLabel.setFont(new Font("Arial", Font.BOLD, 14));
        starsLabel.setForeground(new Color(255, 215, 0));

        JTextArea commentArea = new JTextArea(avis.getCommentaire());
        commentArea.setLineWrap(true);
        commentArea.setWrapStyleWord(true);
        commentArea.setEditable(false);
        commentArea.setBackground(COLOR_CARD_BACKGROUND);
        commentArea.setForeground(COLOR_TEXT_LIGHT);
        commentArea.setFont(new Font("Arial", Font.PLAIN, 14));

        avisPanel.add(starsLabel, BorderLayout.NORTH);
        avisPanel.add(commentArea, BorderLayout.CENTER);

        card.add(filmPanel, BorderLayout.WEST);
        card.add(avisPanel, BorderLayout.CENTER);

        return card;
    }

    private JLabel createSectionTitle(String title) {
        JLabel label = new JLabel(title);
        label.setFont(new Font("Arial", Font.BOLD, 22));
        label.setForeground(COLOR_TEXT_LIGHT);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        // Une bordure vide en bas sert de marge avec le contenu en dessous
        label.setBorder(new EmptyBorder(0, 0, 10, 0));
        return label;
    }

    private JPanel createStatItem(String number, String text) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(COLOR_BACKGROUND_DARK);

        JLabel numLabel = new JLabel(number, SwingConstants.CENTER);
        numLabel.setFont(new Font("Arial", Font.BOLD, 24));
        numLabel.setForeground(COLOR_TEXT_LIGHT);
        numLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel txtLabel = new JLabel(text, SwingConstants.CENTER);
        txtLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        txtLabel.setForeground(COLOR_TEXT_DIM);
        txtLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(numLabel);
        panel.add(txtLabel);
        return panel;
    }

    private JLabel createBadge(String text) {
        JLabel badge = new JLabel(" @" + text + "  ");
        badge.setFont(new Font("Arial", Font.PLAIN, 14));
        badge.setForeground(COLOR_TEXT_LIGHT);
        badge.setOpaque(true);
        badge.setBackground(COLOR_CARD_BACKGROUND);
        badge.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 60, 60), 1),
                new EmptyBorder(5, 5, 5, 5)
        ));
        return badge;
    }
}