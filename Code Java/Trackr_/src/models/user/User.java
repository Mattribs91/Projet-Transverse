package models.user;

import java.util.List;

public class User {

    List<Avis> sesAvis;
    List<Playlist> mesPlaylists;
    private String pseudo;
    private String mail;
    List<User> follower;
    List<User> suivi;
    Playlist like;
    Playlist vu;


    public User(List<Avis> sesAvis, List<Playlist> mesPlaylists, String pseudo, String mail, List<User> follower, List<User> suivi, Playlist like, Playlist vu) {
        this.sesAvis = sesAvis;
        this.mesPlaylists = mesPlaylists;
        this.pseudo = pseudo;
        this.mail = mail;
        this.follower = follower;
        this.suivi = suivi;
        this.like = like;
        this.vu = vu;
    }

    public List<Avis> getSesAvis() {
        return this.sesAvis;
    }

    public void setSesAvis(List<Avis> sesAvis) {
        this.sesAvis = sesAvis;
    }

    public List<Playlist> getMesPlaylists() {
        return this.mesPlaylists;
    }

    public void setMesPlaylists(List<Playlist> mesPlaylists) {
        this.mesPlaylists = mesPlaylists;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<User> getFollower() {
        return this.follower;
    }

    public void setFollower(List<User> follower) {
        this.follower = follower;
    }

    public List<User> getSuivi() {
        return this.suivi;
    }

    public void setSuivi(List<User> suivi) {
        this.suivi = suivi;
    }

    public Playlist getLike() {return like;}

    public void setLike(Playlist like) {this.like = like;}

    public Playlist getVu() {return vu;}

    public void setVu(Playlist vu) {this.vu = vu;}
}