package trackr;

import java.util.List;
import java.util.Date;

public class Film extends Media {

	Film filmPrecedent;
	Film filmSuivant;
	private String duree;


	public Film(List<Avis> lesAvis, Categorie laCategorie, String titre, Date date, String realisateur) {
		super(lesAvis, laCategorie, titre, date, realisateur);
	}
	
	
	public Film getFilmPrecedent() {
		return this.filmPrecedent;
	}

	public void setFilmPrecedent(Film filmPrecedent) {
		this.filmPrecedent = filmPrecedent;
	}

	public Film getFilmSuivant() {
		return this.filmSuivant;
	}

	public void setFilmSuivant(Film filmSuivant) {
		this.filmSuivant = filmSuivant;
	}

	public String getDuree() {
		return this.duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

}