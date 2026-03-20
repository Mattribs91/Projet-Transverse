package trackr;

import java.util.*;

public class Playlist {

	List<Media> lesMedias;
	private String nom;
	private Date dateCreation;
	private boolean estPrive;
	User createur;

	public Playlist(List<Media> lesMedias, String nom, Date dateCreation, boolean estPrive, User createur) {
		this.lesMedias = lesMedias;
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.estPrive = estPrive;
		this.createur = createur;
	}

	public List<Media> getLesMedias() {
		return this.lesMedias;
	}

	public void setLesMedias(List<Media> lesMedias) {
		this.lesMedias = lesMedias;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDateCreation() {
		return this.dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public boolean isEstPrive() {
		return this.estPrive;
	}

	public void setEstPrive(boolean estPrive) {
		this.estPrive = estPrive;
	}

	public User getCreateur() {
		return this.createur;
	}

	public void setCreateur(User createur) {
		this.createur = createur;
	}

}