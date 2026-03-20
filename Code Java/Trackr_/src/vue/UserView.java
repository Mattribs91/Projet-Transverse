package vue;

import models.user.User;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UserView extends JPanel {

    // On reprend les couleurs de votre thème
    private static final Color COLOR_BACKGROUND_DARK = new Color(18, 22, 28);
    private static final Color COLOR_CARD_BACKGROUND = new Color(30, 35, 43);
    private static final Color COLOR_TEXT_LIGHT = new Color(230, 230, 230);
    private static final Color COLOR_TEXT_DIM = new Color(150, 150, 150);
    private static final Color COLOR_ACCENT_GREEN = new Color(50, 205, 50);

    User user;

    public UserView(User user) { // On passe l'utilisateur en paramètre (le Modèle)
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(COLOR_BACKGROUND_DARK);
        this.setBorder(new EmptyBorder(20, 20, 20, 20));

        this.user = user;

        // 1. EN-TÊTE DU PROFIL (Avatar, Nom, Stats)
        this.add(createHeaderSection(user));
        this.add(Box.createRigidArea(new Dimension(0, 40))); // Espacement

        // 2. SECTION : ABONNEMENTS
        this.add(createSectionTitle("Abonnements "));
        this.add(createAbonnementsSection());
        this.add(Box.createRigidArea(new Dimension(0, 40)));

        // 3. SECTION : DERNIERS AVIS
        this.add(createSectionTitle("Mes derniers avis"));
        this.add(createDernierAvisCard());
        this.add(Box.createRigidArea(new Dimension(0, 40)));

        // 4. SECTION : LISTES PERSONNALISÉES
        this.add(createSectionTitle("• Listes personnalisées"));
        this.add(createListesSection());
    }

    // --- MÉTHODES DE CRÉATION DES SECTIONS ---

    private JPanel createHeaderSection(User user) {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COLOR_BACKGROUND_DARK);
        headerPanel.setMaximumSize(new Dimension(1000, 120)); // Limiter la hauteur

        // --- GAUCHE : Avatar et Infos ---
        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        infoPanel.setBackground(COLOR_BACKGROUND_DARK);

        // Faux Avatar (cercle simulé par un JLabel carré aux coins arrondis, ou juste un carré ici pour simplifier)
        JLabel avatar = new JLabel("AS", SwingConstants.CENTER);
        avatar.setFont(new Font("Arial", Font.BOLD, 30));
        avatar.setForeground(COLOR_ACCENT_GREEN);
        avatar.setOpaque(true);
        avatar.setBackground(COLOR_CARD_BACKGROUND);
        avatar.setPreferredSize(new Dimension(100, 100));

        // Nom et date
        JPanel textInfoPanel = new JPanel();
        textInfoPanel.setLayout(new BoxLayout(textInfoPanel, BoxLayout.Y_AXIS));
        textInfoPanel.setBackground(COLOR_BACKGROUND_DARK);

        JLabel nameLabel = new JLabel(user.getPseudo() != null ? user.getPseudo() : "Antoine Stadler");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 32));
        nameLabel.setForeground(COLOR_TEXT_LIGHT);

        JLabel memberSince = new JLabel("Membre depuis 2025");
        memberSince.setFont(new Font("Arial", Font.PLAIN, 14));
        memberSince.setForeground(COLOR_TEXT_DIM);

        textInfoPanel.add(Box.createVerticalStrut(20)); // Centrer un peu le texte
        textInfoPanel.add(nameLabel);
        textInfoPanel.add(Box.createVerticalStrut(5));
        textInfoPanel.add(memberSince);

        infoPanel.add(avatar);
        infoPanel.add(textInfoPanel);

        // --- DROITE : Statistiques ---
        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        statsPanel.setBackground(COLOR_BACKGROUND_DARK);

        statsPanel.add(createStatItem("128", "VUS"));
        statsPanel.add(createStatItem("14", "LISTES"));
        statsPanel.add(createStatItem("2", "SUIVIS"));

        headerPanel.add(infoPanel, BorderLayout.WEST);
        headerPanel.add(statsPanel, BorderLayout.EAST);

        return headerPanel;
    }

    private JPanel createAbonnementsSection() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 0));
        panel.setBackground(COLOR_BACKGROUND_DARK);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        this.user.getSuivi().forEach(user1 -> {
            panel.add(createBadge(user1.getPseudo()));
        });

        return panel;
    }

    private JPanel createDernierAvisCard() {
        // Une carte grise contenant l'avis
        JPanel card = new JPanel(new BorderLayout(15, 15));
        card.setBackground(COLOR_CARD_BACKGROUND);
        card.setBorder(new EmptyBorder(15, 15, 15, 15));
        card.setMaximumSize(new Dimension(800, 150));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Faux poster
        JPanel poster = new JPanel();
        poster.setBackground(new Color(45, 50, 60));
        poster.setPreferredSize(new Dimension(70, 100));

        // Infos du film et de l'avis
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(COLOR_CARD_BACKGROUND);

        JLabel title = new JLabel("Inception");
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setForeground(COLOR_TEXT_LIGHT);

        JLabel stars = new JLabel("⭐⭐⭐⭐⭐"); // Simuler les étoiles
        stars.setForeground(Color.ORANGE);

        JLabel review = new JLabel("\"Un chef d'œuvre du design sonore et visuel...\"");
        review.setFont(new Font("Arial", Font.PLAIN, 14));
        review.setForeground(COLOR_TEXT_DIM);

        textPanel.add(title);
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(stars);
        textPanel.add(Box.createVerticalStrut(10));
        textPanel.add(review);

        card.add(poster, BorderLayout.WEST);
        card.add(textPanel, BorderLayout.CENTER);

        return card;
    }

    private JPanel createListesSection() {
        JPanel grid = new JPanel(new GridLayout(1, 4, 15, 0));
        grid.setBackground(COLOR_BACKGROUND_DARK);
        grid.setAlignmentX(Component.LEFT_ALIGNMENT);
        grid.setMaximumSize(new Dimension(1000, 150));

        grid.add(createListeCard("Top 2025", "5 médias • Privée"));
        grid.add(createListeCard("À voir en 2026", "12 médias • Publique"));
        grid.add(createListeCard("À voir en 2026", "12 médias • Publique"));
        grid.add(createListeCard("À voir en 2026", "12 médias • Publique"));

        return grid;
    }

    private JLabel createSectionTitle(String title) {
        JLabel label = new JLabel(title);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        label.setForeground(COLOR_TEXT_LIGHT);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(new EmptyBorder(0, 0, 15, 0));
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
        JLabel badge = new JLabel("  " + text + "  "); // Espaces pour simuler la marge interne
        badge.setFont(new Font("Arial", Font.PLAIN, 14));
        badge.setForeground(COLOR_TEXT_LIGHT);
        badge.setOpaque(true);
        badge.setBackground(COLOR_CARD_BACKGROUND);

        badge.setBorder(BorderFactory.createLineBorder(new Color(60, 60, 60), 1));
        return badge;
    }

    private JPanel createListeCard(String title, String subtitle) {
        JPanel card = new JPanel(new BorderLayout());
        card.setBackground(COLOR_CARD_BACKGROUND);
        card.setBorder(new EmptyBorder(10, 10, 10, 10));

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setBackground(COLOR_CARD_BACKGROUND);

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setForeground(COLOR_TEXT_LIGHT);

        JLabel subLabel = new JLabel(subtitle);
        subLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        subLabel.setForeground(COLOR_TEXT_DIM);

        // On pousse le texte vers le bas de la carte
        textPanel.add(Box.createVerticalGlue());
        textPanel.add(titleLabel);
        textPanel.add(Box.createVerticalStrut(5));
        textPanel.add(subLabel);

        card.add(textPanel, BorderLayout.CENTER);
        return card;
    }
}