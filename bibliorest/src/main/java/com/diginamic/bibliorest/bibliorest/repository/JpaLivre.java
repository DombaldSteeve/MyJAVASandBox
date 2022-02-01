package com.diginamic.bibliorest.bibliorest.repository;

import org.springframework.data.repository.CrudRepository;

import com.diginamic.bibliorest.bibliorest.model.Livre;

public interface JpaLivre extends CrudRepository<Livre, Integer>
{
}