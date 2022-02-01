package fr.diginamic.webmvc01.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import fr.diginamic.webmvc01.entities.Livre;

public interface CrudLivreRepo extends CrudRepository<Livre, Integer>
{
	@Query("select l from Livre l ")
	public Iterable<Livre> findByLivre(Livre livre);
}