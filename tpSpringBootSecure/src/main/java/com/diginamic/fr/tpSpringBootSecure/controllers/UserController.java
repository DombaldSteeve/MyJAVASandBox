package com.diginamic.fr.tpSpringBootSecure.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diginamic.fr.tpSpringBootSecure.entities.User;
import com.diginamic.fr.tpSpringBootSecure.repo.UserJpaRepo;

@RestController
@RequestMapping("user")
public class UserController
{
	@Autowired
	private UserJpaRepo ur;

	@GetMapping
	public Iterable<User> getAllUsers()
	{
		return ur.findAll();
	}
}
