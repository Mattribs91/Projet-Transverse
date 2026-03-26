package trackrtest;

import java.util.List;
import java.util.Date;

public class EpisodeTest extends MediaTest {

	SerieTest serieMere;
	EpisodeTest episodeSuivant;
	EpisodeTest episodePrecedent;
	private int numeroDeSaison;
	private String duree;


	public EpisodeTest(List<AvisTest> lesAvis, CategorieTest laCategorie, String titre, Date date, String realisateur, SerieTest serieMere, EpisodeTest episodeSuivant, EpisodeTest episodePrecedent, int numeroDeSaison, String duree) {
		super(lesAvis, laCategorie, titre, date, realisateur);
		this.serieMere = serieMere;
		this.episodeSuivant = episodeSuivant;
		this.episodePrecedent = episodePrecedent;
		this.numeroDeSaison = numeroDeSaison;
		this.duree = duree;
	}

	public SerieTest getSerieMere() {
		return this.serieMere;
	}

	public void setSerieMere(SerieTest serieMere) {
		this.serieMere = serieMere;
	}

	public EpisodeTest getEpisodeSuivant() {
		return this.episodeSuivant;
	}

	public void setEpisodeSuivant(EpisodeTest episodeSuivant) {
		this.episodeSuivant = episodeSuivant;
	}

	public EpisodeTest getEpisodePrecedent() {
		return this.episodePrecedent;
	}

	public void setEpisodePrecedent(EpisodeTest episodePrecedent) {
		this.episodePrecedent = episodePrecedent;
	}

	public int getNumeroDeSaison() {
		return this.numeroDeSaison;
	}

	public void setNumeroDeSaison(int numeroDeSaison) {
		this.numeroDeSaison = numeroDeSaison;
	}

	public String getDuree() {
		return this.duree;
	}

	public void setDuree(String duree) {
		this.duree = duree;
	}

}