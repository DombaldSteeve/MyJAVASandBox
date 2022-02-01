package com.diginamic.bibliorest.bibliorest.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.diginamic.bibliorest.bibliorest.model.Client;
import com.diginamic.bibliorest.bibliorest.model.Emprunt;

public interface JpaClient extends CrudRepository<Client, Integer>
{
	@Query("SELECT emp from Emprunt emp WHERE emp.clientE.id = :id")
	public Iterable<Emprunt> getEmpruntByClient(Integer id);
}
