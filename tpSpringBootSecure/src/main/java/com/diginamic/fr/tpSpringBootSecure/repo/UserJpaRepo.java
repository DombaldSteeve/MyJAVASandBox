package com.diginamic.fr.tpSpringBootSecure.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.diginamic.fr.tpSpringBootSecure.entities.User;

public interface UserJpaRepo extends CrudRepository<User, Integer>
{
	@Query(" select u from User u " + " where u.username = ?1 ")
	Optional<User> findUserWithName(String username);
}
