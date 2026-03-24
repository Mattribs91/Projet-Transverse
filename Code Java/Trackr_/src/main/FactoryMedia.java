package main;

import models.media.Categorie;
import models.media.Film;
import models.media.Media;
import models.user.Avis;
import models.user.Playlist;
import models.user.User;
import vue.FactoryView;
import javax.swing.*;
import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactoryMedia {


    User antoine;
    User selma;

    User alana;
    User jordan;

    List<Media> mediaEnVrac;

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

        Playlist playlist_1 = new Playlist(new ArrayList<>(), "Mes Films trop trop <3", new Date(), false, selma);
        Playlist playlist_2 = new Playlist(new ArrayList<>(), "Playlist n2", new Date(), false, selma);
        Playlist playlist_3 = new Playlist(new ArrayList<>(), "Playlist n3", new Date(), false, antoine);
        Playlist playlist_4 = new Playlist(new ArrayList<>(), "Playlist n4", new Date(), false, antoine);
        Playlist playlist_5 = new Playlist(new ArrayList<>(), "Playlist n5", new Date(), false, alana);
        Playlist playlist_6 = new Playlist(new ArrayList<>(), "Playlist n6", new Date(), false, alana);
        Playlist playlist_7 = new Playlist(new ArrayList<>(), "Playlist n7", new Date(), false, jordan);
        Playlist playlist_8 = new Playlist(new ArrayList<>(), "Playlist n8", new Date(), false, jordan);


        //ajout de films de romance -> dans le but de creer une playlist de romance pour selma + ajout davis sur ceux ci
        Film filmcute1 = new Film(new ArrayList<>(), Categorie.ROMANCE, "About Time", new Date(113, 8, 4), "Richard Curtis");
        Film filmcute2 = new Film(new ArrayList<>(), Categorie.ROMANCE, "Past Lives", new Date(123, 5, 2), "Celine Song");
        Film filmcute3 = new Film(new ArrayList<>(), Categorie.ROMANCE, "Pride & Prejudice", new Date(105, 8, 16), "Joe Wright");
        Film filmcute4 = new Film(new ArrayList<>(), Categorie.ROMANCE, "La La Land", new Date(116, 11, 9), "Damien Chazelle");
        Film filmcute5 = new Film(new ArrayList<>(), Categorie.ROMANCE, "Before Sunrise", new Date(95, 0, 27), "Richard Linklater");



        mediaEnVrac = new ArrayList<>();
        mediaEnVrac.add(filmcute1);
        mediaEnVrac.add(filmcute2);
        mediaEnVrac.add(filmcute3);
        mediaEnVrac.add(filmcute4);
        mediaEnVrac.add(filmcute5);

        List mesPlaylist = new ArrayList<Playlist>();
        mesPlaylist.add(playlist_1);
        mesPlaylist.add(playlist_2);
        mesPlaylist.add(playlist_3);
        mesPlaylist.add(playlist_4);
        mesPlaylist.add(playlist_5);
        mesPlaylist.add(playlist_6);
        mesPlaylist.add(playlist_7);
        mesPlaylist.add(playlist_8);

        selma = new User(null, mesPlaylist, "Selma Syone", "Selma.Syone@gmail.com", new ArrayList<>(), new ArrayList<>());
        antoine = new User(null, null, "Antoine Stadler", "AntoineStadler@gmail.com", new ArrayList<>(), new ArrayList<>());

        alana = new User(null, null, "Alana Babibel", "alanabibeldu92@gmail.com", new ArrayList<>(), new ArrayList<>());
        jordan = new User(null, null, "Jordan Bartoila", "jordinooooooo@yahou.com", new ArrayList<>(), new ArrayList<>());

        selma.getSuivi().add(antoine);
        selma.getSuivi().add(jordan);
        selma.getSuivi().add(alana);

        selma.getFollower().add(antoine);
        selma.getFollower().add(jordan);
        selma.getFollower().add(alana);

        antoine.getFollower().add(selma);

        Avis avisSelma1 = new Avis(getSelma(),
                filmcute2,
                new Date(126, 7, 4),
                "Ce film m'a trop fait pleurer... Mon chien et moi avons passé des soirees memorable... ",
                5);

        Avis avisSelma2 = new Avis(getSelma(),
                filmcute4,
                new Date(126, 8, 1),
                "Ils sont trop trop mignonnnnn !!!! <3 <3 <3 ",
                4);

        Avis avisSelma3 = new Avis(getSelma(),
                filmcute1,
                new Date(126, 6, 9),
                "Pas mes gouts pour le coup... ",
                2);

        selma.getSesAvis().add(avisSelma1);
        selma.getSesAvis().add(avisSelma2);
        selma.getSesAvis().add(avisSelma3);
    }


    public List<Media> getMediaEnVrac() {
        return mediaEnVrac;
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