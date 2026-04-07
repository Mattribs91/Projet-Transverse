package modelstest.mediatest;

import modeles.media.Film;
import modeles.media.Categorie;
import modeles.user.Avis;
import modeles.user.User;

import java.util.ArrayList;
import java.util.Date;

public class FilmTest {
    private Film monFilm;
    private User testUser;

    public static void main(String[] args) {
        FilmTest test = new FilmTest();
        test.getScoreMoyen_NoAvis_ReturnsZero();
        test.getScoreMoyen_WithAvis_ReturnsAverage();
        System.out.println("All tests passed for Film (and Media).");
    }

    private void setup() {
        monFilm = new Film(new ArrayList<>(), Categorie.SF, "Matrix", new Date(), "Wachowski");
        testUser = new User(new ArrayList<>(), new ArrayList<>(), "Neo", "neo@matrix.com", new ArrayList<>(), new ArrayList<>(), null, null);
    }

    private void getScoreMoyen_NoAvis_ReturnsZero() {
        setup();
        assert(monFilm.getScoreMoyen() == 0.0);
        System.out.println("getScoreMoyen_NoAvis_ReturnsZero passed.");
    }

    private void getScoreMoyen_WithAvis_ReturnsAverage() {
        setup();
        Avis avis1 = new Avis(testUser, monFilm, new Date(), "Super", 4);
        Avis avis2 = new Avis(testUser, monFilm, new Date(), "Génial", 5);
        monFilm.getLesAvis().add(avis1);
        monFilm.getLesAvis().add(avis2);

        assert(monFilm.getScoreMoyen() == 4.5);
        System.out.println("getScoreMoyen_WithAvis_ReturnsAverage passed.");
    }
}