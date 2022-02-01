package fr.diginamic.webmvc01.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.validation.BindingResult;

import fr.diginamic.webmvc01.entities.Client;
import fr.diginamic.webmvc01.entities.Emprunt;

public interface CrudClientRepo extends CrudRepository<Client, Integer>
{
	@Query("SELECT emp from Emprunt emp WHERE emp.clientE.id = :id")
	public Iterable<Emprunt> getEmpruntByClient(Integer id);

	public void save(BindingResult result);
}
