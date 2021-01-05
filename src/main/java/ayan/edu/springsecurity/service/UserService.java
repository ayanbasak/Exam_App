package ayan.edu.springsecurity.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import ayan.edu.springsecurity.dto.UserRegistrationDto;
import ayan.edu.springsecurity.model.User;

public interface UserService extends UserDetailsService {

	User findByEmail(String email);

	User save(UserRegistrationDto registration);

	void savead(User theUser);

	public List<User> findAll();
}
