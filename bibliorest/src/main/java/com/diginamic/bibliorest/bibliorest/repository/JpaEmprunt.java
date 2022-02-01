package com.diginamic.bibliorest.bibliorest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.diginamic.bibliorest.bibliorest.model.Emprunt;
import com.diginamic.bibliorest.bibliorest.model.Livre;

public interface JpaEmprunt extends CrudRepository<Emprunt, Integer>
{
	/**
	 * Me retourne la liste des livres d'un emprunt.
	 * 
	 * @param emp
	 * @return
	 */
	@Query("select l from Livre l where :emp MEMBER OF l.empruntLivres")
	public Iterable<Livre> findByLivre(Emprunt emp);
}