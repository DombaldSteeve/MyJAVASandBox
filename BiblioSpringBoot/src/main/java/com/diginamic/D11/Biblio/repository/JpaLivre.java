package com.diginamic.D11.Biblio.repository;

import org.springframework.data.repository.CrudRepository;

import com.diginamic.D11.Biblio.model.Livre;

public interface JpaLivre extends CrudRepository<Livre, Integer>
{
}
