package trackrtest;

import java.util.*;

public class PlaylistTest {

	List<MediaTest> lesMedias;
	private String nom;
	private Date dateCreation;
	private boolean estPrive;
	UserTest createur;

	public PlaylistTest(List<MediaTest> lesMedias, String nom, Date dateCreation, boolean estPrive, UserTest createur) {
		this.lesMedias = lesMedias;
		this.nom = nom;
		this.dateCreation = dateCreation;
		this.estPrive = estPrive;
		this.createur = createur;
	}

	public List<MediaTest> getLesMedias() {
		return this.lesMedias;
	}

	public void setLesMedias(List<MediaTest> lesMedias) {
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

	public UserTest getCreateur() {
		return this.createur;
	}

	public void setCreateur(UserTest createur) {
		this.createur = createur;
	}

}