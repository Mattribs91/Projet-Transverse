package models.utils;

import models.media.*;
import models.user.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DataStore {

    public static List<User> utilisateurs = new ArrayList<>();
    public static List<Media> medias = new ArrayList<>();

    public static void initData() {

        String[][] usersData = {
                {"CineFan", "cine@fan.fr"}, {"SerieAddict", "serie@addict.fr"},
                {"NolanFanboy", "nolan@fan.fr"}, {"HorrorQueen", "horror@queen.fr"},
                {"RomComLover", "romcom@lover.fr"}, {"KinoCritic", "kino@critic.fr"},
                {"SciFiGeek", "scifi@geek.fr"}, {"PopcornEater", "popcorn@eater.fr"},
                {"BingeWatcher", "binge@watcher.fr"}, {"IndieSnob", "indie@snob.fr"}
        };

        for (String[] data : usersData) {
            User u = new User(new ArrayList<>(), new ArrayList<>(), data[0], data[1], new ArrayList<>(), new ArrayList<>(), null, null);
            u.setVu(new Playlist(new ArrayList<>(), "Vus", new Date(), true, u));
            u.setLike(new Playlist(new ArrayList<>(), "Favoris", new Date(), true, u));
            utilisateurs.add(u);
        }

        utilisateurs.get(0).follow(utilisateurs.get(1));
        utilisateurs.get(0).follow(utilisateurs.get(2));
        utilisateurs.get(3).follow(utilisateurs.get(0));
        utilisateurs.get(8).follow(utilisateurs.get(1));
        utilisateurs.get(1).follow(utilisateurs.get(8));

        Film f1 = new Film(new ArrayList<>(), Categorie.SF, "Interstellar", new Date(), "Christopher Nolan"); f1.setDuree("2h49");
        Film f2 = new Film(new ArrayList<>(), Categorie.HORREUR, "Alien", new Date(), "Ridley Scott"); f2.setDuree("1h57");
        Film f3 = new Film(new ArrayList<>(), Categorie.ROMANCE, "La La Land", new Date(), "Damien Chazelle"); f3.setDuree("2h08");
        Film f4 = new Film(new ArrayList<>(), Categorie.AUTEUR, "Parasite", new Date(), "Bong Joon Ho"); f4.setDuree("2h12");
        Film f5 = new Film(new ArrayList<>(), Categorie.SF, "Matrix", new Date(), "Les Wachowski"); f5.setDuree("2h16");
        Film f6 = new Film(new ArrayList<>(), Categorie.HORREUR, "The Shining", new Date(), "Stanley Kubrick"); f6.setDuree("2h26");
        Film f7 = new Film(new ArrayList<>(), Categorie.ROMANCE, "Titanic", new Date(), "James Cameron"); f7.setDuree("3h14");
        Film f8 = new Film(new ArrayList<>(), Categorie.AUTEUR, "Le Fabuleux Destin d'Amélie Poulain", new Date(), "Jean-Pierre Jeunet"); f8.setDuree("2h02");
        Film f9 = new Film(new ArrayList<>(), Categorie.SF, "Dune", new Date(), "Denis Villeneuve"); f9.setDuree("2h35");
        Film f10 = new Film(new ArrayList<>(), Categorie.HORREUR, "Get Out", new Date(), "Jordan Peele"); f10.setDuree("1h44");

        medias.addAll(List.of(f1, f2, f3, f4, f5, f6, f7, f8, f9, f10));

        Serie s1 = new Serie(new ArrayList<>(), Categorie.SF, "Stranger Things", new Date(), "Les frères Duffer", new ArrayList<>(), 34);
        Episode ep1 = new Episode(new ArrayList<>(), Categorie.SF, "La disparition de Will Byers", new Date(), "Les frères Duffer", s1, null, null, 1, "47m");
        Episode ep2 = new Episode(new ArrayList<>(), Categorie.SF, "La Fille de la forêt", new Date(), "Les frères Duffer", s1, null, ep1, 1, "50m");
        ep1.setEpisodeSuivant(ep2);
        s1.getLesEpisodes().addAll(List.of(ep1, ep2));

        medias.addAll(List.of(s1, ep1, ep2));

        User u1 = utilisateurs.get(0); // CineFan
        User u2 = utilisateurs.get(2); // NolanFanboy
        User u3 = utilisateurs.get(5); // KinoCritic
        User u4 = utilisateurs.get(3); // HorrorQueen

        new Avis(u1, f1, new Date(), "Un chef d'oeuvre absolu, la musique est incroyable.", 5).publier();
        new Avis(u2, f1, new Date(), "Nolan est un génie. Rien à redire.", 5).publier();
        new Avis(u3, f1, new Date(), "Visuellement beau, mais le scénario est un peu lourd.", 3).publier();

        new Avis(u4, f2, new Date(), "Un classique du genre, terrifiant !", 5).publier();
        new Avis(u1, f2, new Date(), "La tension est palpable de bout en bout.", 4).publier();

        new Avis(u3, f4, new Date(), "Une Palme d'or totalement méritée, écriture brillante.", 5).publier();
        new Avis(u1, f4, new Date(), "Très bon, la fin m'a laissé sans voix.", 4).publier();

        new Avis(u3, f5, new Date(), "A révolutionné le cinéma d'action.", 5).publier();
        new Avis(u1, f7, new Date(), "Trop long à mon goût...", 2).publier();
        new Avis(utilisateurs.get(4), f7, new Date(), "Je pleure à chaque fois !", 5).publier();

        new Avis(u4, f10, new Date(), "Très original, ça change des slashers classiques.", 4).publier();

        new Avis(utilisateurs.get(8), s1, new Date(), "La meilleure série pour binge-watcher le week-end !", 5).publier();

        u1.marquerCommeVu(f1);
        u1.marquerCommeVu(f2);
        u1.marquerCommeVu(f4);
        u1.ajouterAuxFavoris(f1);

        u4.marquerCommeVu(f2);
        u4.marquerCommeVu(f6);
        u4.marquerCommeVu(f10);
        u4.ajouterAuxFavoris(f2);
        u4.ajouterAuxFavoris(f6);
    }
}