package com.diginamic.fr.tpSpringBootSecure.dao;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.diginamic.fr.tpSpringBootSecure.entities.User;
import com.diginamic.fr.tpSpringBootSecure.repo.UserJpaRepo;

@Service
public class UserService implements UserDetailsService
{
	private final UserJpaRepo userRepository;

	@Autowired
	public UserService(UserJpaRepo userRepository)
	{
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		Objects.requireNonNull(username);
		User user = userRepository.findUserWithName(username)
				.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		return user;
	}
}
