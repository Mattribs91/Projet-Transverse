package trackrtest;

import java.util.List;
import java.util.Date;

public class FilmTest extends MediaTest {

	FilmTest filmPrecedent;
	FilmTest filmSuivant;
	private String duree;


	public FilmTest(List<AvisTest> lesAvis, CategorieTest laCategorie, String titre, Date date, String realisateur) {
		super(lesAvis, laCategorie, titre, date, realisateur);
	}
	
	
	public FilmTest getFilmPrecedent() {
		return this.filmPrecedent;
	}

	public void setFilmPrecedent(FilmTest filmPrecedent) {
		this.filmPrecedent = filmPrecedent;
	}

	public FilmTest getFilmSuivant() {
		return this.filmSuivant;
	}

	public void setFilmSuivant(FilmTest filmSuivant) {
		this.filmSuivant = filmSuivant;
	}

	public String getDuree() {
		return this.duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

}