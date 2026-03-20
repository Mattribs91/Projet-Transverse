package models.user;

import models.media.Media;

import java.util.Date;

public class Avis {

    User createur;
    Media mediaAssocie;
    private Date dateDeCreation;
    private String commentaire;
    private int nombreEtoiles;

    public Avis(User createur, Media mediaAssocie, Date dateDeCreation, String commentaire, int nombreEtoiles) {
        this.createur = createur;
        this.mediaAssocie = mediaAssocie;
        this.dateDeCreation = dateDeCreation;
        this.commentaire = commentaire;
        this.nombreEtoiles = nombreEtoiles;
    }

    public User getCreateur() { return this.createur; }

    public void setCreateur(User createur) { this.createur = createur; }

    public Media getMediaAssocie() {
        return this.mediaAssocie;
    }

    public void setMediaAssocie(Media mediaAssocie) {
        this.mediaAssocie = mediaAssocie;
    }

    public Date getDateDeCreation() {
        return this.dateDeCreation;
    }

    public void setDateDeCreation(Date dateDeCreation) {
        this.dateDeCreation = dateDeCreation;
    }

    public String getCommentaire() {
        return this.commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public int getNombreEtoiles() {
        return this.nombreEtoiles;
    }

    public void setNombreEtoiles(int nombreEtoiles) {
        this.nombreEtoiles = nombreEtoiles;
    }

}