package vue;


import main.FactoryMedia;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FactoryView extends JPanel {

    // --- ATTRIBUTS ET CONSTANTES DE STYLE ---

    // Couleurs du thème sombre (inspirées de la maquette)
    private static final Color COLOR_BACKGROUND_DARK = new Color(18, 22, 28);
    private static final Color COLOR_SIDEBAR_BACKGROUND = new Color(25, 30, 38);
    private static final Color COLOR_TEXT_LIGHT = new Color(230, 230, 230);
    private static final Color COLOR_TEXT_DIM = new Color(150, 150, 150);
    private static final Color COLOR_ACCENT_GREEN = new Color(50, 205, 50); // Vert vif
    private static final Color COLOR_CARD_BACKGROUND = new Color(30, 35, 43);

    // Nouveaux boutons de barre latérale (attributs pour le contrôleur)
    private JButton btnAccueil;
    private JButton btnProfil;
    private JButton btnCoupsDeCoeur;
    private JButton btnParametres;

    // Champ de recherche (accessible pour le contrôleur)
    private JTextField searchField;

    // Zone centrale pour le contenu (accessible pour le contrôleur)
    private JPanel centralContentPanel;
    private JScrollPane contentScrollPane;
    private JPanel contentContainer; // Panneau à l'intérieur du scrollpane


    FactoryMedia factoryMedia;


    public FactoryView(FactoryMedia factoryMedia) {
        this.setLayout(new BorderLayout());
        this.setBackground(COLOR_BACKGROUND_DARK);

        this.factoryMedia = factoryMedia;

        JPanel sidebarPanel = new JPanel();
        sidebarPanel.setLayout(new BoxLayout(sidebarPanel, BoxLayout.Y_AXIS));
        sidebarPanel.setBackground(COLOR_SIDEBAR_BACKGROUND);
        sidebarPanel.setPreferredSize(new Dimension(230, 0));
        sidebarPanel.setBorder(new EmptyBorder(25, 15, 25, 15));

        // Logo "TRACKR" (couleur verte)
        JLabel appNameLabel = new JLabel("TRACKR");
        appNameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        appNameLabel.setForeground(COLOR_ACCENT_GREEN);
        appNameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        sidebarPanel.add(appNameLabel);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 40)));


        sidebarPanel.add(createSectionHeader("MENU"));

        btnAccueil = createSidebarButton("Accueil");
        btnProfil = createSidebarButton("Mon Profil");
        btnCoupsDeCoeur = createSidebarButton("Coups de cœur");

        sidebarPanel.add(btnAccueil);
        sidebarPanel.add(btnProfil);
        sidebarPanel.add(btnCoupsDeCoeur);
        sidebarPanel.add(Box.createRigidArea(new Dimension(0, 25)));


        // Espace pour pousser le bas
        sidebarPanel.add(Box.createVerticalGlue());

        // Paramètres tout en bas
        btnParametres = createSidebarButton("⚙️ Paramètres");
        sidebarPanel.add(btnParametres);


        // --- 3. CRÉATION DE LA ZONE CENTRALE (CONTENU PAR DÉFAUT ET STRUCTURE) ---
        centralContentPanel = new JPanel(new BorderLayout());
        centralContentPanel.setBackground(COLOR_BACKGROUND_DARK);

        // Panneau de recherche (en haut)
        JPanel searchPanel = new JPanel(new BorderLayout());
        searchPanel.setBackground(COLOR_BACKGROUND_DARK);
        searchPanel.setBorder(new EmptyBorder(20, 30, 10, 30));

        searchField = new JTextField("Rechercher un film, une série, un réalisateur...");
        searchField.setFont(new Font("Arial", Font.PLAIN, 14));
        searchField.setForeground(new Color(150, 150, 150)); // Texte d'espace réservé (simulé)
        searchField.setBackground(COLOR_CARD_BACKGROUND);
        searchField.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(60, 60, 60), 1),
                new EmptyBorder(10, 15, 10, 15)
        ));
        // Effet de base pour le texte d'espace réservé
        searchField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (searchField.getText().equals("Rechercher un film, une série, un réalisateur...")) {
                    searchField.setText("");
                    searchField.setForeground(COLOR_TEXT_LIGHT);
                }
            }
        });

        searchPanel.add(searchField, BorderLayout.CENTER);
        centralContentPanel.add(searchPanel, BorderLayout.NORTH);


        // Zone centrale d'affichage avec JScrollPane pour le défilement
        contentContainer = new JPanel();
        contentContainer.setLayout(new BoxLayout(contentContainer, BoxLayout.Y_AXIS));
        contentContainer.setBackground(COLOR_BACKGROUND_DARK);
        contentContainer.setBorder(new EmptyBorder(20, 30, 30, 30));

        contentScrollPane = new JScrollPane(contentContainer);
        contentScrollPane.setBorder(null); // Enlever la bordure du scrollpane
        contentScrollPane.getVerticalScrollBar().setUnitIncrement(16); // Défiler plus vite
        contentScrollPane.setBackground(COLOR_BACKGROUND_DARK);
        contentScrollPane.getViewport().setBackground(COLOR_BACKGROUND_DARK);
        centralContentPanel.add(contentScrollPane, BorderLayout.CENTER);

        // Écoute du bouton Profil dans FactoryView
        this.getBtnProfil().addActionListener(e -> {
            JPanel center = this.getCentralContentPanel();
            center.removeAll();


            UserView profilPage = new UserView(factoryMedia.getSelma());

            center.add(profilPage, BorderLayout.CENTER);

            center.revalidate();
            center.repaint();
        });

        // --- 4. ASSEMBLAGE FINAL ---
        this.add(sidebarPanel, BorderLayout.WEST);
        this.add(centralContentPanel, BorderLayout.CENTER);
    }
    // --- MÉTHODES UTILITAIRES DE STYLISATION ---

    /**
     * Crée un en-tête de section dans la barre latérale.
     */
    private JLabel createSectionHeader(String text) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.BOLD, 12));
        label.setForeground(COLOR_TEXT_DIM);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        label.setBorder(new EmptyBorder(10, 0, 5, 0));
        return label;
    }


    /**
     * Stylise les boutons du sidebar de manière uniforme.
     */
    private JButton createSidebarButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Arial", Font.PLAIN, 15));
        button.setForeground(COLOR_TEXT_LIGHT);
        button.setBackground(COLOR_SIDEBAR_BACKGROUND); // Fond transparent par défaut
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setOpaque(false); // Rendre le fond transparent
        button.setMaximumSize(new Dimension(200, 40));
        button.setAlignmentX(Component.LEFT_ALIGNMENT); // Alignement à gauche
        button.setHorizontalAlignment(SwingConstants.LEFT); // Texte aligné à gauche
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(new EmptyBorder(5, 10, 5, 10)); // Rembourrage interne

        // Effet de survol (optionnel, mais sympa)
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(COLOR_ACCENT_GREEN); // Vert au survol
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(COLOR_TEXT_LIGHT); // Revenir au blanc
            }
        });

        return button;
    }



    public JButton getBtnAccueil() { return btnAccueil; }
    public JButton getBtnProfil() { return btnProfil; }
    public JButton getBtnCoupsDeCoeur() { return btnCoupsDeCoeur; }
    public JButton getBtnParametres() { return btnParametres; }

    public JTextField getSearchField() { return searchField; }

    public JPanel getCentralContentPanel() { return centralContentPanel; }
}