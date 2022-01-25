package com.diginamic.D11.Biblio.repository;

import org.springframework.data.repository.CrudRepository;

import com.diginamic.D11.Biblio.model.Emprunt;

public interface JpaEmprunt extends CrudRepository<Emprunt, Integer>
{
}
