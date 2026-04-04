package modelstest.usertest;

import models.user.User;
import models.user.Playlist;
import models.media.Film;
import models.media.Categorie;

import java.util.ArrayList;
import java.util.Date;

public class UserTest {
    private User monUser;
    private User cibleUser;
    private Film monFilm;

    public static void main(String[] args) {
        UserTest test = new UserTest();
        test.follow_ValidUser_AddsToSuivi();
        test.unfollow_FollowedUser_RemovesFromSuivi();
        test.creerNouvellePlaylist_ValidInput_AddsPlaylist();
        test.marquerCommeVu_ValidMedia_AddsToVu();
        System.out.println("All tests passed for User.");
    }

    private void setup() {
        monUser = new User(new ArrayList<>(), new ArrayList<>(), "CineFan", "test@test.fr", new ArrayList<>(), new ArrayList<>(), null, null);
        monUser.setVu(new Playlist(new ArrayList<>(), "Vus", new Date(), true, monUser));
        monUser.setLike(new Playlist(new ArrayList<>(), "Favoris", new Date(), true, monUser));

        cibleUser = new User(new ArrayList<>(), new ArrayList<>(), "Cible", "cible@test.fr", new ArrayList<>(), new ArrayList<>(), null, null);

        monFilm = new Film(new ArrayList<>(), Categorie.SF, "Interstellar", new Date(), "Nolan");
    }

    private void follow_ValidUser_AddsToSuivi() {
        setup();
        monUser.follow(cibleUser);
        assert(monUser.getSuivi().contains(cibleUser));
        assert(cibleUser.getFollower().contains(monUser));
        System.out.println("follow_ValidUser_AddsToSuivi passed.");
    }

    private void unfollow_FollowedUser_RemovesFromSuivi() {
        setup();
        monUser.follow(cibleUser); // On le suit d'abord
        monUser.unfollow(cibleUser); // Puis on se désabonne
        assert(!monUser.getSuivi().contains(cibleUser));
        assert(!cibleUser.getFollower().contains(monUser));
        System.out.println("unfollow_FollowedUser_RemovesFromSuivi passed.");
    }

    private void creerNouvellePlaylist_ValidInput_AddsPlaylist() {
        setup();
        int initialSize = monUser.getMesPlaylists().size();
        monUser.creerNouvellePlaylist("Ma Super Liste", false);
        assert(monUser.getMesPlaylists().size() == initialSize + 1);
        assert(monUser.getMesPlaylists().get(0).getNom().equals("Ma Super Liste"));
        System.out.println("creerNouvellePlaylist_ValidInput_AddsPlaylist passed.");
    }

    private void marquerCommeVu_ValidMedia_AddsToVu() {
        setup();
        monUser.marquerCommeVu(monFilm);
        assert(monUser.getVu().getLesMedias().contains(monFilm));
        System.out.println("marquerCommeVu_ValidMedia_AddsToVu passed.");
    }
}