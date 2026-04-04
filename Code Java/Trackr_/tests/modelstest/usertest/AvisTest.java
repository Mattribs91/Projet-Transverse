package modelstest.usertest;

import models.user.Avis;
import models.user.User;
import models.media.Film;
import models.media.Categorie;

import java.util.ArrayList;
import java.util.Date;

public class AvisTest {
    private Avis monAvis;
    private User monUser;
    private Film monFilm;

    public static void main(String[] args) {
        AvisTest test = new AvisTest();
        test.publier_ValidAvis_BindsUserAndMedia();
        System.out.println("All tests passed for Avis.");
    }

    private void setup() {
        monUser = new User(new ArrayList<>(), new ArrayList<>(), "Critique", "mail", new ArrayList<>(), new ArrayList<>(), null, null);
        monFilm = new Film(new ArrayList<>(), Categorie.AUTEUR, "Parasite", new Date(), "Bong Joon Ho");
        monAvis = new Avis(monUser, monFilm, new Date(), "Incroyable", 5);
    }

    private void publier_ValidAvis_BindsUserAndMedia() {
        setup();
        monAvis.publier();
        // L'avis doit être dans la liste des avis de l'utilisateur ET du film
        assert(monUser.getSesAvis().contains(monAvis));
        assert(monFilm.getLesAvis().contains(monAvis));
        System.out.println("publier_ValidAvis_BindsUserAndMedia passed.");
    }
}