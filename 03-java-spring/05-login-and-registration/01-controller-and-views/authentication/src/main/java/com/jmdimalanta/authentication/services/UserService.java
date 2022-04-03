package com.jmdimalanta.authentication.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jmdimalanta.authentication.models.User;
import com.jmdimalanta.authentication.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	//register a user and hash their password
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return userRepository.save(user);
	}
	
	//find user by email
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	//find by id
	public User findUserByID(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	//authenticate user
	public boolean authenticateUser(String email, String password) {
		//find user by email
		User user = userRepository.findByEmail(email);
		//if we can't find the user, return false
		if(user == null) {
			return false;
		} else {
			//if the passwords match, return true, else, return false.
			if(BCrypt.checkpw(password, user.getPassword())) {
				return true;
			} else {
				return false;
			}
		}
	}
}
