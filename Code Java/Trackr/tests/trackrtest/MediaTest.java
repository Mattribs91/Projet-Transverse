package trackrtest;

import java.util.*;

public abstract class MediaTest {

	List<AvisTest> lesAvis;
	CategorieTest laCategorie;
	private String titre;
	private Date date;
	private String realisateur;


	public MediaTest(List<AvisTest> lesAvis, CategorieTest laCategorie, String titre, Date date, String realisateur) {
		this.lesAvis = lesAvis;
		this.laCategorie = laCategorie;
		this.titre = titre;
		this.date = date;
		this.realisateur = realisateur;
	}
	
	
	public List<AvisTest> getLesAvis() {
		return this.lesAvis;
	}

	public void setLesAvis(List<AvisTest> lesAvis) {
		this.lesAvis = lesAvis;
	}

	public CategorieTest getLaCategorie() {
		return this.laCategorie;
	}

	public void setLaCategorie(CategorieTest laCategorie) {
		this.laCategorie = laCategorie;
	}

	public String getTitre() {
		return this.titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getRealisateur() {
		return this.realisateur;
	}

	public void setRealisateur(String realisateur) {
		this.realisateur = realisateur;
	}

}