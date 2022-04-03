package com.jmdimalanta.authentication.validators;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.jmdimalanta.authentication.models.User;
import com.jmdimalanta.authentication.repositories.UserRepository;

@Component
public class UserValidator implements Validator{
	
	@Autowired
	private UserRepository userRepo;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}
	
	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		if (!user.getPasswordConfirmation().equals(user.getPassword())) {
			errors.rejectValue("password","Match","Password does not match");
		}
		
		if(this.userRepo.findByEmail(user.getEmail()) != null) {
			errors.rejectValue("email", "Unique", "Email address already exists");
		}
	}
	
}
