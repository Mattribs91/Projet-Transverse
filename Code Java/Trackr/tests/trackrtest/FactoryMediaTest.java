package trackrtest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactoryMediaTest {

    public static void main(String[] args) {

        UserTest alice = new UserTest(new ArrayList<>(), new ArrayList<>(), "Alice", "alice@mail.com",
                new ArrayList<>(), new ArrayList<>());

        UserTest bob = new UserTest(new ArrayList<>(), new ArrayList<>(), "Bob", "bob@mail.com",
                new ArrayList<>(), new ArrayList<>());

        UserTest claire = new UserTest(new ArrayList<>(), new ArrayList<>(), "Claire", "claire@mail.com",
                new ArrayList<>(), new ArrayList<>());

        alice.getFollower().add(bob);
        bob.getSuivi().add(alice);

        FilmTest snowpiercer = new FilmTest(new ArrayList<>(), CategorieTest.SF, "Snowpiercer",
                new Date(1383127200L * 1000), "Bong Joon-ho");
        snowpiercer.setDuree("2h06");

        FilmTest parasite = new FilmTest(new ArrayList<>(), CategorieTest.Auteur, "Parasite",
                new Date(1559347200L * 1000), "Bong Joon-ho");
        parasite.setDuree("2h12");

        snowpiercer.setFilmSuivant(parasite);
        parasite.setFilmPrecedent(snowpiercer);

        SerieTest dark = new SerieTest(new ArrayList<>(), CategorieTest.SF, "Dark",
                new Date(1498867200L * 1000), "Baran bo Odar",
                new ArrayList<>(), 0);

        EpisodeTest ep1 = new EpisodeTest(new ArrayList<>(), CategorieTest.SF, "Secrets",
                new Date(), "Baran bo Odar", dark, null, null, 1, "52 min");

        EpisodeTest ep2 = new EpisodeTest(new ArrayList<>(), CategorieTest.SF, "Lies",
                new Date(), "Baran bo Odar", dark, null, ep1, 1, "50 min");

        ep1.setEpisodeSuivant(ep2);

        dark.getLesEpisodes().add(ep1);
        dark.getLesEpisodes().add(ep2);
        dark.setNombreEpisodes(2);

        AvisTest avis1 = new AvisTest(alice, snowpiercer, new Date(), "Excellent film, très original", 5);
        AvisTest avis2 = new AvisTest(bob, parasite, new Date(), "Un chef d'œuvre moderne", 5);
        AvisTest avis3 = new AvisTest(claire, ep1, new Date(), "Très mystérieux, j'adore", 4);

        snowpiercer.getLesAvis().add(avis1);
        parasite.getLesAvis().add(avis2);
        ep1.getLesAvis().add(avis3);

        alice.getSesAvis().add(avis1);
        bob.getSesAvis().add(avis2);
        claire.getSesAvis().add(avis3);

        PlaylistTest playlistAlice = new PlaylistTest(
                new ArrayList<>(List.of(snowpiercer, parasite)),
                "Films préférés",
                new Date(),
                false,
                alice
        );

        PlaylistTest playlistBob = new PlaylistTest(
                new ArrayList<>(List.of(dark)),
                "Séries SF",
                new Date(),
                true,
                bob
        );

        alice.getMesPlaylists().add(playlistAlice);
        bob.getMesPlaylists().add(playlistBob);

        afficherUtilisateur(alice);
        afficherPlaylist(playlistAlice);
        afficherMedia(snowpiercer);
        afficherSerie(dark);
    }

    public static void afficherMedia(MediaTest m) {
        System.out.println("\n=== MEDIA ===");
        System.out.println("Titre : " + m.getTitre());
        System.out.println("Catégorie : " + m.getLaCategorie());
        System.out.println("Réalisateur : " + m.getRealisateur());
        System.out.println("Date : " + m.getDate());

        if (m instanceof FilmTest f) {
            System.out.println("Durée : " + f.getDuree());
            if (f.getFilmPrecedent() != null)
                System.out.println("Film précédent : " + f.getFilmPrecedent().getTitre());
            if (f.getFilmSuivant() != null)
                System.out.println("Film suivant : " + f.getFilmSuivant().getTitre());
        }

        if (m instanceof EpisodeTest e) {
            System.out.println("Épisode de la série : " + e.getSerieMere().getTitre());
            System.out.println("Saison : " + e.getNumeroDeSaison());
            System.out.println("Durée : " + e.getDuree());
        }

        afficherAvis(m.getLesAvis());
    }

    public static void afficherAvis(List<AvisTest> avis) {
        System.out.println("\n--- Avis ---");
        if (avis.isEmpty()) {
            System.out.println("Aucun avis.");
            return;
        }
        for (AvisTest a : avis) {
            System.out.println(a.getCreateur().getPseudo() + " (" + a.getNombreEtoiles() + "★) : " + a.getCommentaire());
        }
    }

    public static void afficherPlaylist(PlaylistTest p) {
        System.out.println("\n=== PLAYLIST ===");
        System.out.println("Nom : " + p.getNom());
        System.out.println("Créateur : " + p.getCreateur().getPseudo());
        System.out.println("Privée : " + p.isEstPrive());
        System.out.println("Médias :");
        for (MediaTest m : p.getLesMedias()) {
            System.out.println(" - " + m.getTitre());
        }
    }

    public static void afficherUtilisateur(UserTest u) {
        System.out.println("\n=== UTILISATEUR ===");
        System.out.println("Pseudo : " + u.getPseudo());
        System.out.println("Mail : " + u.getMail());

        System.out.println("Followers : " + u.getFollower().size());
        System.out.println("Suit : " + u.getSuivi().size());

        System.out.println("\nPlaylists :");
        for (PlaylistTest p : u.getMesPlaylists()) {
            System.out.println(" - " + p.getNom());
        }

        System.out.println("\nAvis laissés :");
        for (AvisTest a : u.getSesAvis()) {
            System.out.println(" - " + a.getMediaAssocie().getTitre() + " : " + a.getNombreEtoiles() + "★");
        }
    }

    public static void afficherSerie(SerieTest s) {
        System.out.println("\n=== SÉRIE ===");
        System.out.println("Titre : " + s.getTitre());
        System.out.println("Catégorie : " + s.getLaCategorie());
        System.out.println("Nombre d'épisodes : " + s.getNombreEpisodes());

        System.out.println("\nÉpisodes :");
        for (EpisodeTest e : s.getLesEpisodes()) {
            System.out.println(" - " + e.getTitre() + " (" + e.getDuree() + ")");
        }
    }
}
