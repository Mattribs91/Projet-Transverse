package controller;

import main.FactoryMedia;
import vue.UserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static vue.FactoryView.COLOR_ACCENT_GREEN;
import static vue.FactoryView.COLOR_TEXT_LIGHT;

public class FactoryController {

    public static void mouseDesigned(JButton button){
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setForeground(COLOR_ACCENT_GREEN);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setForeground(COLOR_TEXT_LIGHT);
            }
        });
    }


    public static void openViewUser(JButton button, JPanel jPanel){
        button.addActionListener(e -> {
            JPanel center = jPanel;
            center.removeAll();

            UserView profilPage = new UserView(FactoryMedia.getFactoryMedia().getSelma());

            center.add(profilPage, BorderLayout.CENTER);

            center.revalidate();
            center.repaint();
        });
    }
}
