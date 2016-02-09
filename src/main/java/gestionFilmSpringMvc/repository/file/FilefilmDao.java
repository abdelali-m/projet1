package gestionFilmSpringMvc.repository.file;
import java.io.*;
import java.util.List;

import gestionFilmSpringMvc.entity.Film;
import gestionFilmSpringMvc.repository.IFilmDao;
public class FilefilmDao implements IFilmDao {
public void save(Film film){
FileWriter writer;
try{
	writer= new FileWriter("c:\\test\\filme.txt",true);
	writer.write(film.getTitre()+";"+film.getGenre()+";"+film.getNbeExemplaire());
	writer.close();
	
}catch(IOException e){
	e.printStackTrace();
}
}

public List<Film> getAllFillm() {
	// TODO Auto-generated method stub
	return null;
}}
