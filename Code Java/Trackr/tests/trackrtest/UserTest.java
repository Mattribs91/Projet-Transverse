package trackrtest;

import java.util.*;

public class UserTest {

	List<AvisTest> sesAvis;
	List<PlaylistTest> mesPlaylists;
	private String pseudo;
	private String mail;
	List<UserTest> follower;
	List<UserTest> suivi;


	public UserTest(List<AvisTest> sesAvis, List<PlaylistTest> mesPlaylists, String pseudo, String mail, List<UserTest> follower, List<UserTest> suivi) {
		this.sesAvis = sesAvis;
		this.mesPlaylists = mesPlaylists;
		this.pseudo = pseudo;
		this.mail = mail;
		this.follower = follower;
		this.suivi = suivi;
	}

	public List<AvisTest> getSesAvis() {
		return this.sesAvis;
	}

	public void setSesAvis(List<AvisTest> sesAvis) {
		this.sesAvis = sesAvis;
	}

	public List<PlaylistTest> getMesPlaylists() {
		return this.mesPlaylists;
	}

	public void setMesPlaylists(List<PlaylistTest> mesPlaylists) {
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

	public List<UserTest> getFollower() {
		return this.follower;
	}

	public void setFollower(List<UserTest> follower) {
		this.follower = follower;
	}

	public List<UserTest> getSuivi() {
		return this.suivi;
	}

	public void setSuivi(List<UserTest> suivi) {
		this.suivi = suivi;
	}

}