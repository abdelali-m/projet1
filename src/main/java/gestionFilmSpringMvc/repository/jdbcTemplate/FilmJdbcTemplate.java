package gestionFilmSpringMvc.repository.jdbcTemplate;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.hibernate.sql.InsertSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import gestionFilmSpringMvc.entity.Film;
import gestionFilmSpringMvc.repository.IFilmDao;
@Component
@Repository
	public class FilmJdbcTemplate implements IFilmDao {
 
	    //private JdbcTemplate jdbcTemplate;
	   // private SimpleJdbcInsert insertFilm;
	    @Autowired
	    private  DataSource datasource;
      
	   /* @Autowired
	    public void setDataSource(DataSource dataSource) {
	        this.jdbcTemplate = new JdbcTemplate(dataSource);
	    }*/
	  
		public void setDatasource(DataSource datasource) {
			this.datasource = datasource;
		}

		public void save(Film film) {
		//	jdbcTemplate.execute("INSERT INTO filme (TITRE,GENRE,NBEXEMPLAIRE) values (?,?,?)",film.getTitre(),film.getGenre(),film.getNbeExemplaire());
	//	jdbcTemplate.update(update mytable set name = ? where id = ?", args, argTypes)
			//jdbcTemplate.execute(("INSERT INTO filme (TITRE,GENRE,NBEXEMPLAIRE) values (?,?,?)"));
			//PreparedStatement psmt =  jdbcTemplate.execute(("INSERT INTO filme (TITRE,GENRE,NBEXEMPLAIRE) values (?,?,?)"));
			/*Map<String, Object> parameters = new HashMap<String, Object>(3);
			parameters.put("id", film.getTitre());
	        parameters.put("first_name", film.getGenre());
	        parameters.put("last_name", film.getNbeExemplaire());
	        insertFilm.execute(parameters);*/
			
		//++++++++++++++	this.jdbcTemplate.update("INSERT INTO filme (TITRE,GENRE,NBEXEMPLAIRE) values (?,?,?)",film.getTitre(),film.getGenre(),film.getNbeExemplaire());
			/*this.jdbcTemplate.update(
			        "insert into t_actor (first_name, last_name) values (?, ?)",
			        "Leonor", "Watling");
			this.jdbcTemplate.update(
			        "update t_actor set last_name = ? where id = ?",
			        "Banjo", 5276L);
			this.jdbcTemplate.update(
			        "delete from actor where id = ?",
			        Long.valueOf(actorId));
			        spring Jdbc Template
			        *
			        */
			Connection conn=null;
			try{
			 conn= (Connection) datasource.getConnection();
			PreparedStatement pstm= (PreparedStatement) conn.prepareStatement("INSERT INTO filme (TITRE,GENRE,NBEXEMPLAIRE) values (?,?,?)");
			pstm.setString(1, film.getTitre());
			pstm.setString(2, film.getGenre());
			
			pstm.setInt(3, film.getNbeExemplaire());
			pstm.executeUpdate();
			}
			
			catch(Throwable th){
				th.printStackTrace();
				
			}finally {
				try {
					conn.close();
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
			
		
		}

		public List<Film> getAllFillm() {
		
		//	return jdbcTemplate.queryForList("SELECT * FROM filme ");
		return null;}

	    // JDBC-backed implementations of the methods on the CorporateEventDao follow...
	}

