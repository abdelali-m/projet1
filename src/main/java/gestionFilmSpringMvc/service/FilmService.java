package gestionFilmSpringMvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

import gestionFilmSpringMvc.entity.Film;
import gestionFilmSpringMvc.repository.IFilmDao;
import gestionFilmSpringMvc.repository.file.FilefilmDao;
import gestionFilmSpringMvc.repository.hibernate.FilmHibernateDao;
@Service
public class FilmService implements FilmServiceInterface {
	
	
@Autowired	
private IFilmDao dao;
public IFilmDao getDao() {
		return dao;
	}
	public void setDao(IFilmDao dao) {
		this.dao = dao;
	}
public void registerfilm(Film film){
	//FilefilmDao dao  = new FilefilmDao();
	
	//FilmHibernateDao dao = new FilmHibernateDao();
	dao.save(film);
}
}
