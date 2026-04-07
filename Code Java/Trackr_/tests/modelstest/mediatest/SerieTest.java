package modelstest.mediatest;

import modeles.media.Serie;
import modeles.media.Episode;
import modeles.media.Categorie;

import java.util.ArrayList;
import java.util.Date;

public class SerieTest {
    private Serie maSerie;

    public static void main(String[] args) {
        SerieTest test = new SerieTest();
        test.getNombreEpisodes_NormalInput_ExpectedReturnValue();
        System.out.println("All tests passed for Serie.");
    }

    private void setup() {
        maSerie = new Serie(new ArrayList<>(), Categorie.HORREUR, "Stranger Things", new Date(), "Duffer", new ArrayList<>(), 34);
    }

    private void getNombreEpisodes_NormalInput_ExpectedReturnValue() {
        setup();
        assert(maSerie.getNombreEpisodes() == 34);
        System.out.println("getNombreEpisodes_NormalInput_ExpectedReturnValue passed.");
    }
}