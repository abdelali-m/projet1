package gestionFilmSpringMvc.controller;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import gestionFilmSpringMvc.entity.Film;
import gestionFilmSpringMvc.service.FilmService;
import gestionFilmSpringMvc.service.FilmServiceInterface;

@Controller
public class FilmController  {
@Autowired
     private FilmServiceInterface service;
	
	
	public void setService(FilmServiceInterface service) {
		this.service = service;
	}

	public void registrefilmfromconsole(){
		Scanner sc = new Scanner(System.in);
		System.out.println("quel est le titre ?");
		String titre =sc.nextLine();
		System.out.println("quel est le genre??");
		String genre =sc.nextLine();
		System.out.println("quel est le nbr d exemplaire??");
		int nb = sc.nextInt();
		Film film = new Film();
		film.setTitre(titre);
		film.setGenre(genre);
		film.setNbeExemplaire(nb);
		//FilmService service = new FilmService();
		service.registerfilm(film);
	}
}
