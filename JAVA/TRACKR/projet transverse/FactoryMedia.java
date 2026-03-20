import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FactoryMedia {

    public static void main(String[] args) {

        User alice = new User(new ArrayList<>(), new ArrayList<>(), "Alice", "alice@mail.com",
                new ArrayList<>(), new ArrayList<>());

        User bob = new User(new ArrayList<>(), new ArrayList<>(), "Bob", "bob@mail.com",
                new ArrayList<>(), new ArrayList<>());

        User claire = new User(new ArrayList<>(), new ArrayList<>(), "Claire", "claire@mail.com",
                new ArrayList<>(), new ArrayList<>());

        alice.getFollower().add(bob);
        bob.getSuivi().add(alice);

        Film snowpiercer = new Film(new ArrayList<>(), Categorie.SF, "Snowpiercer",
                new Date(1383127200L * 1000), "Bong Joon-ho");
        snowpiercer.setDuree("2h06");

        Film parasite = new Film(new ArrayList<>(), Categorie.Auteur, "Parasite",
                new Date(1559347200L * 1000), "Bong Joon-ho");
        parasite.setDuree("2h12");

        snowpiercer.setFilmSuivant(parasite);
        parasite.setFilmPrecedent(snowpiercer);

        Serie dark = new Serie(new ArrayList<>(), Categorie.SF, "Dark",
                new Date(1498867200L * 1000), "Baran bo Odar",
                new ArrayList<>(), 0);

        Episode ep1 = new Episode(new ArrayList<>(), Categorie.SF, "Secrets",
                new Date(), "Baran bo Odar", dark, null, null, 1, "52 min");

        Episode ep2 = new Episode(new ArrayList<>(), Categorie.SF, "Lies",
                new Date(), "Baran bo Odar", dark, null, ep1, 1, "50 min");

        ep1.setEpisodeSuivant(ep2);

        dark.getLesEpisodes().add(ep1);
        dark.getLesEpisodes().add(ep2);
        dark.setNombreEpisodes(2);

        Avis avis1 = new Avis(alice, snowpiercer, new Date(), "Excellent film, très original", 5);
        Avis avis2 = new Avis(bob, parasite, new Date(), "Un chef d'œuvre moderne", 5);
        Avis avis3 = new Avis(claire, ep1, new Date(), "Très mystérieux, j'adore", 4);

        snowpiercer.getLesAvis().add(avis1);
        parasite.getLesAvis().add(avis2);
        ep1.getLesAvis().add(avis3);

        alice.getSesAvis().add(avis1);
        bob.getSesAvis().add(avis2);
        claire.getSesAvis().add(avis3);

        Playlist playlistAlice = new Playlist(
                new ArrayList<>(List.of(snowpiercer, parasite)),
                "Films préférés",
                new Date(),
                false,
                alice
        );

        Playlist playlistBob = new Playlist(
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

    public static void afficherMedia(Media m) {
        System.out.println("\n=== MEDIA ===");
        System.out.println("Titre : " + m.getTitre());
        System.out.println("Catégorie : " + m.getLaCategorie());
        System.out.println("Réalisateur : " + m.getRealisateur());
        System.out.println("Date : " + m.getDate());

        if (m instanceof Film f) {
            System.out.println("Durée : " + f.getDuree());
            if (f.getFilmPrecedent() != null)
                System.out.println("Film précédent : " + f.getFilmPrecedent().getTitre());
            if (f.getFilmSuivant() != null)
                System.out.println("Film suivant : " + f.getFilmSuivant().getTitre());
        }

        if (m instanceof Episode e) {
            System.out.println("Épisode de la série : " + e.getSerieMere().getTitre());
            System.out.println("Saison : " + e.getNumeroDeSaison());
            System.out.println("Durée : " + e.getDuree());
        }

        afficherAvis(m.getLesAvis());
    }

    public static void afficherAvis(List<Avis> avis) {
        System.out.println("\n--- Avis ---");
        if (avis.isEmpty()) {
            System.out.println("Aucun avis.");
            return;
        }
        for (Avis a : avis) {
            System.out.println(a.getCreateur().getPseudo() + " (" + a.getNombreEtoiles() + "★) : " + a.getCommentaire());
        }
    }

    public static void afficherPlaylist(Playlist p) {
        System.out.println("\n=== PLAYLIST ===");
        System.out.println("Nom : " + p.getNom());
        System.out.println("Créateur : " + p.getCreateur().getPseudo());
        System.out.println("Privée : " + p.isEstPrive());
        System.out.println("Médias :");
        for (Media m : p.getLesMedias()) {
            System.out.println(" - " + m.getTitre());
        }
    }

    public static void afficherUtilisateur(User u) {
        System.out.println("\n=== UTILISATEUR ===");
        System.out.println("Pseudo : " + u.getPseudo());
        System.out.println("Mail : " + u.getMail());

        System.out.println("Followers : " + u.getFollower().size());
        System.out.println("Suit : " + u.getSuivi().size());

        System.out.println("\nPlaylists :");
        for (Playlist p : u.getMesPlaylists()) {
            System.out.println(" - " + p.getNom());
        }

        System.out.println("\nAvis laissés :");
        for (Avis a : u.getSesAvis()) {
            System.out.println(" - " + a.getMediaAssocie().getTitre() + " : " + a.getNombreEtoiles() + "★");
        }
    }

    public static void afficherSerie(Serie s) {
        System.out.println("\n=== SÉRIE ===");
        System.out.println("Titre : " + s.getTitre());
        System.out.println("Catégorie : " + s.getLaCategorie());
        System.out.println("Nombre d'épisodes : " + s.getNombreEpisodes());

        System.out.println("\nÉpisodes :");
        for (Episode e : s.getLesEpisodes()) {
            System.out.println(" - " + e.getTitre() + " (" + e.getDuree() + ")");
        }
    }
}
