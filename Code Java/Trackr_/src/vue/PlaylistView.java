package vue;

import models.user.User;

import main.FactoryMedia;
import models.user.User;
import models.user.Playlist;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class PlaylistView extends JPanel{

    // couleurs principales
    private static final Color COLOR_BACKGROUND_DARK = new Color(18, 22, 28);
    private static final Color COLOR_CARD_BACKGROUND = new Color(30, 35, 43);
    private static final Color COLOR_TEXT_LIGHT = new Color(230, 230, 230);
    private static final Color COLOR_TEXT_DIM = new Color(150, 150, 150);
    private static final Color COLOR_ACCENT_GREEN = new Color(50, 205, 50);

    User user;

    public PlaylistView(User user) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(COLOR_BACKGROUND_DARK);
        this.setBorder(new EmptyBorder(20, 20, 20, 20));

        this.user = user;

        //ajout du header
        //this.add(createHeaderSection());

        //ajout d'un espace sous le header
        this.add(Box.createRigidArea(new Dimension(0, 40)));
    }



}
