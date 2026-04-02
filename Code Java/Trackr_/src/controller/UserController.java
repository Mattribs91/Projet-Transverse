package controller;

import main.FactoryMedia;
import vue.PlaylistsView;

import javax.swing.*;
import java.awt.*;

public class UserController {

    public static void openViewPlaylist(JButton button, JPanel jPanel){
        button.addActionListener(e -> {
            JPanel center = jPanel;
            center.removeAll();

            PlaylistsView playlistPage = new PlaylistsView(FactoryMedia.getFactoryMedia().getSelma());

            center.add(playlistPage, BorderLayout.CENTER);

            center.revalidate();
            center.repaint();
        });
    }
}
