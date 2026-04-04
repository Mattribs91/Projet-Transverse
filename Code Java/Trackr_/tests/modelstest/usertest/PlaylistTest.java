package modelstest.usertest;

import models.user.Playlist;
import models.user.User;
import models.media.Film;
import models.media.Categorie;

import java.util.ArrayList;
import java.util.Date;

public class PlaylistTest {
    private Playlist maPlaylist;
    private Film monFilm;

    public static void main(String[] args) {
        PlaylistTest test = new PlaylistTest();
        test.ajouterMedia_ValidMedia_AddsToList();
        test.retirerMedia_ExistingMedia_RemovesFromList();
        System.out.println("All tests passed for Playlist.");
    }

    private void setup() {
        User createur = new User(new ArrayList<>(), new ArrayList<>(), "Createur", "mail", new ArrayList<>(), new ArrayList<>(), null, null);
        maPlaylist = new Playlist(new ArrayList<>(), "Ma Liste", new Date(), false, createur);
        monFilm = new Film(new ArrayList<>(), Categorie.SF, "Alien", new Date(), "Scott");
    }

    private void ajouterMedia_ValidMedia_AddsToList() {
        setup();
        maPlaylist.ajouterMedia(monFilm);
        assert(maPlaylist.getLesMedias().contains(monFilm));
        System.out.println("ajouterMedia_ValidMedia_AddsToList passed.");
    }

    private void retirerMedia_ExistingMedia_RemovesFromList() {
        setup();
        maPlaylist.ajouterMedia(monFilm);
        maPlaylist.retirerMedia(monFilm);
        assert(!maPlaylist.getLesMedias().contains(monFilm));
        System.out.println("retirerMedia_ExistingMedia_RemovesFromList passed.");
    }
}