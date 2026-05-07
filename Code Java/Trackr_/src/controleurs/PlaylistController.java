package controleurs;

import main.ApplicationMedias;
import modeles.user.Playlist;
import vues.PlaylistView;
import vues.PlaylistsView;

import javax.swing.*;
import java.awt.*;

public class PlaylistController {

    public static void openPlaylistView(JButton button, JPanel jPanel, Playlist playlist){
        button.addActionListener(e -> {
            JPanel center = jPanel;
            center.removeAll();

            PlaylistView mediaViewedView = new PlaylistView(playlist);

            center.add(mediaViewedView, BorderLayout.CENTER);

            center.revalidate();
            center.repaint();
        });
    }

}
