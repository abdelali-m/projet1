package gestionFilmSpringMvc.entity;

public class Film {
private String titre;
private String genre;
private int nbeExemplaire;

public int getNbeExemplaire() {
	return nbeExemplaire;
}
public void setNbeExemplaire(int nbeExemplaire) {
	this.nbeExemplaire = nbeExemplaire;
}
public String getGenre() {
	return genre;
}
public void setGenre(String genre) {
	this.genre = genre;
}
public String getTitre() {
	return titre;
}
public void setTitre(String titre) {
	this.titre = titre;
}


}
