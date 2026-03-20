package main;

import models.user.User;
import vue.FactoryView;
import javax.swing.*;
import java.util.ArrayList;

public class FactoryMedia {


    User antoine;
    User selma;

    User alana;
    User jordan;

    public static FactoryMedia factoryMedia;

    public FactoryMedia() {
        factoryMedia = this;

        JFrame frame = new JFrame("Trackr");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        FactoryView accueilView = new FactoryView(this);
        frame.setContentPane(accueilView);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        // Bonne pratique en Swing : Toujours lancer l'interfa
        // ce graphique sur le "Event Dispatch Thread"
        selma = new User(null, null, "Selma Syone", "Selma.Syone@gmail.com", new ArrayList<>(), new ArrayList<>());
        antoine = new User(null, null, "Antoine Stadler", "AntoineStadler@gmail.com", new ArrayList<>(), new ArrayList<>());

        selma.getSuivi().add(antoine);
        selma.getFollower().add(antoine);
        antoine.getFollower().add(selma);


    }

    public static void main(String[] args) {
        new FactoryMedia();
    }


    public User getAntoine() {
        return antoine;
    }

    public void setAntoine(User antoine) {
        this.antoine = antoine;
    }

    public User getSelma() {
        return selma;
    }

    public void setSelma(User selma) {
        this.selma = selma;
    }

    public User getAlana() {
        return alana;
    }

    public void setAlana(User alana) {
        this.alana = alana;
    }

    public User getJordan() {
        return jordan;
    }

    public void setJordan(User jordan) {
        this.jordan = jordan;
    }

    public static FactoryMedia getFactoryMedia() {
        return factoryMedia;
    }
}