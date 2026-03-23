package vue;

import main.FactoryMedia;
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

    public UserView(User user) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(COLOR_BACKGROUND_DARK);
        this.setBorder(new EmptyBorder(20, 20, 20, 20));

        this.user = user;

        this.add(createHeaderSection(user));
        this.add(Box.createRigidArea(new Dimension(0, 40)));

    }


    private JPanel createHeaderSection(User user) {
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(COLOR_BACKGROUND_DARK);
        headerPanel.setMaximumSize(new Dimension(1000, 120));

        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 20, 0));
        infoPanel.setBackground(COLOR_BACKGROUND_DARK);

        JLabel avatar = new JLabel("SS", SwingConstants.CENTER);
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

        textInfoPanel.add(Box.createVerticalStrut(20)); // Centrer un peu le texte
        textInfoPanel.add(nameLabel);
        textInfoPanel.add(Box.createVerticalStrut(5));
        textInfoPanel.add(memberSince);

        infoPanel.add(avatar);
        infoPanel.add(textInfoPanel);

        JPanel statsPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 30, 20));
        statsPanel.setBackground(COLOR_BACKGROUND_DARK);

        statsPanel.add(createStatItem("0", "VUS"));
        statsPanel.add(createStatItem(user.getFollower().size() +" ", "FOLLOWER"));
        statsPanel.add(createStatItem(user.getSuivi().size() + "", "SUIVIS"));

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

}