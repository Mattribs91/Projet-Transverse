package trackrtest;

import java.util.*;

public class AvisTest {

	UserTest createur;
	MediaTest mediaAssocie;
	private Date dateDeCreation;
	private String commentaire;
	private int nombreEtoiles;

	public AvisTest(UserTest createur, MediaTest mediaAssocie, Date dateDeCreation, String commentaire, int nombreEtoiles) {
		this.createur = createur;
		this.mediaAssocie = mediaAssocie;
		this.dateDeCreation = dateDeCreation;
		this.commentaire = commentaire;
		this.nombreEtoiles = nombreEtoiles;
	}

	public UserTest getCreateur() { return this.createur; }

	public void setCreateur(UserTest createur) { this.createur = createur; }

	public MediaTest getMediaAssocie() {
		return this.mediaAssocie;
	}

	public void setMediaAssocie(MediaTest mediaAssocie) {
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