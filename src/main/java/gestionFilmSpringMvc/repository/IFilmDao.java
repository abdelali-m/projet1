package gestionFilmSpringMvc.repository;

import java.util.List;


import gestionFilmSpringMvc.entity.Film;

public interface IFilmDao {
	public void save(Film film);
	public List<Film> getAllFillm();
	/*public void deleteProduit(Long id);
	public Produit getProduitById(Long id);
	public List<Produit> getAllProduits();
	public void updateProduit(Produit p);*/
}
