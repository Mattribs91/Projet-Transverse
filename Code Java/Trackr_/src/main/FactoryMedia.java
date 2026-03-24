package main;

import models.media.Film;
import models.user.Playlist;
import models.user.User;
import vue.FactoryView;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;

public class FactoryMedia {


    User antoine;
    User selma;

    User alana;
    User jordan;

    Film inception;

    public static FactoryMedia factoryMedia;
    public static FactoryView factoryview;

    public FactoryMedia() {
        factoryMedia = this;

        JFrame frame = new JFrame("Trackr");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1280, 720);
        FactoryView accueilView = new FactoryView(this, true);
        frame.setContentPane(accueilView);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        factoryview = accueilView;

        Playlist playlist_1 = new Playlist(new ArrayList<>(), "Playlist n1", new Date(), false, selma);
        Playlist playlist_2 = new Playlist(new ArrayList<>(), "Playlist n2", new Date(), false, selma);
        Playlist playlist_3 = new Playlist(new ArrayList<>(), "Playlist n3", new Date(), false, antoine);
        Playlist playlist_4 = new Playlist(new ArrayList<>(), "Playlist n4", new Date(), false, antoine);
        Playlist playlist_5 = new Playlist(new ArrayList<>(), "Playlist n5", new Date(), false, alana);
        Playlist playlist_6 = new Playlist(new ArrayList<>(), "Playlist n6", new Date(), false, alana);
        Playlist playlist_7 = new Playlist(new ArrayList<>(), "Playlist n7", new Date(), false, jordan);
        Playlist playlist_8 = new Playlist(new ArrayList<>(), "Playlist n8", new Date(), false, jordan);

        selma = new User(null, null, "Selma Syone", "Selma.Syone@gmail.com", new ArrayList<>(), new ArrayList<>(), playlist_1, playlist_2);
        antoine = new User(null, null, "Antoine Stadler", "AntoineStadler@gmail.com", new ArrayList<>(), new ArrayList<>(), playlist_3, playlist_4);

        alana = new User(null, null, "Alana Babibel", "alanabibeldu92@gmail.com", new ArrayList<>(), new ArrayList<>(), playlist_5, playlist_6);
        jordan = new User(null, null, "Jordan Bartoila", "jordinooooooo@yahou.com", new ArrayList<>(), new ArrayList<>(), playlist_7, playlist_8);



        selma.getSuivi().add(antoine);
        selma.getSuivi().add(jordan);
        selma.getSuivi().add(alana);

        selma.getFollower().add(antoine);
        selma.getFollower().add(jordan);
        selma.getFollower().add(alana);

        antoine.getFollower().add(selma);

    }

    public static void main(String[] args) {
        new FactoryMedia();
    }


    public static FactoryView getFactoryview() {
        return factoryview;
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