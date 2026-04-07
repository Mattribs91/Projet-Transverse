package modelstest.mediatest;

import modeles.media.Episode;
import modeles.media.Serie;
import modeles.media.Categorie;

import java.util.ArrayList;
import java.util.Date;

public class EpisodeTest {
    private Episode monEpisode;
    private Serie serieMere;

    public static void main(String[] args) {
        EpisodeTest test = new EpisodeTest();
        test.getSerieMere_NormalInput_ExpectedReturnValue();
        System.out.println("All tests passed for Episode.");
    }

    private void setup() {
        serieMere = new Serie(new ArrayList<>(), Categorie.SF, "Dark", new Date(), "Odar", new ArrayList<>(), 26);
        monEpisode = new Episode(new ArrayList<>(), Categorie.SF, "Secret", new Date(), "Odar", serieMere, null, null, 1, "50m");
    }

    private void getSerieMere_NormalInput_ExpectedReturnValue() {
        setup();
        assert(monEpisode.getSerieMere() == serieMere);
        System.out.println("getSerieMere_NormalInput_ExpectedReturnValue passed.");
    }
}