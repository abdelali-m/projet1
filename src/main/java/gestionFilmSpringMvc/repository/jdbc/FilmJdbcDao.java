package gestionFilmSpringMvc.repository.jdbc;

import java.sql.DriverManager;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import gestionFilmSpringMvc.entity.Film;
import gestionFilmSpringMvc.repository.IFilmDao;
 @Repository
public class FilmJdbcDao implements IFilmDao{
	
	private String classedriver;  // "com.mysql.jdbc.Driver"

	public void setClassedriver(String classedriver) {
		this.classedriver = classedriver;
	}
	public FilmJdbcDao(){
		System.out.println("dao appeler");
	}

	public void save(Film film) {
		Connection conn=null;
		String url = "jdbc:mysql://localhost:3306/filmemanager";
		 String user ="root";
		 String password="";
		
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		//	conn =  DriverManager.getConnection("jdbc:mysql://localhost:3306/filmemanager","root","")
			conn =  (Connection) DriverManager.getConnection(url, user, password);
			PreparedStatement psmt = (PreparedStatement) conn.prepareStatement("INSERT INTO filme (TITRE,GENRE,NBEXEMPLAIRE) values (?,?,?)");
			psmt.setString(1, film.getTitre());
			psmt.setString(2, film.getGenre());
			psmt.setInt(3, film.getNbeExemplaire());
			
			psmt.executeUpdate();
			System.out.println("insertion passer");
			
		}catch(Throwable t){
			System.out.println("connection n est pas etablit");
		}
		
	}

	public List<Film> getAllFillm() {
		// TODO Auto-generated method stub
		return null;
	}

}
