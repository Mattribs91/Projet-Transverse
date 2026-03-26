package trackrtest;

import java.util.*;

public class SerieTest extends MediaTest {

	List<EpisodeTest> lesEpisodes;
	private int nombreEpisodes;

	public SerieTest(List<AvisTest> lesAvis, CategorieTest laCategorie, String titre, Date date, String realisateur, List<EpisodeTest> lesEpisodes, int nombreEpisodes) {
		super(lesAvis, laCategorie, titre, date, realisateur);
		this.lesEpisodes = lesEpisodes;
		this.nombreEpisodes = nombreEpisodes;
	}

	public List<EpisodeTest> getLesEpisodes() {
		return this.lesEpisodes;
	}

	public void setLesEpisodes(List<EpisodeTest> lesEpisodes) {
		this.lesEpisodes = lesEpisodes;
	}

	public int getNombreEpisodes() {
		return this.nombreEpisodes;
	}

	public void setNombreEpisodes(int nombreEpisodes) {
		this.nombreEpisodes = nombreEpisodes;
	}

}