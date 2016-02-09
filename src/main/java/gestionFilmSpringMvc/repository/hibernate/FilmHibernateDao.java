package gestionFilmSpringMvc.repository.hibernate;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import gestionFilmSpringMvc.entity.Film;
import gestionFilmSpringMvc.repository.HibernateUtil;
import gestionFilmSpringMvc.repository.IFilmDao;

@Component
@Repository
public class FilmHibernateDao implements IFilmDao {
	
	@Autowired
		private SessionFactory sessionfactory;
	
	public void save(Film film) {
		//Session session =  HibernateUtil.getSessionFactory().openSession();
		Session session =  sessionfactory.openSession();
		try{
		
		session.beginTransaction();
		session.persist(film);
		session.getTransaction().commit();
	}catch(HibernateException he1){
		he1.printStackTrace();
		if(session.getTransaction() != null ){
			try{
			session.getTransaction().rollback();
		}catch(HibernateException he2){
			he2.printStackTrace();
			}
		}
		}
	}
	public List<Film> getAllFillm() {
		Session session =  sessionfactory.getCurrentSession();
		session.beginTransaction();
		return session.createQuery("from filme").list();
		
	}

}
