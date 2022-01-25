package com.diginamic.D11.Biblio.repository;

import org.springframework.data.repository.CrudRepository;

import com.diginamic.D11.Biblio.model.Client;

public interface JpaClient extends CrudRepository<Client, Integer>
{
	// permet de supp un client
	/**
	 * @Query("SELECT emp FROM EMPRUNT EMP WHERE emp.clientE.id = :id") public
	 * Iterable<Emprunt> getListeEmpruntByClient(Integer id);
	 */
}
