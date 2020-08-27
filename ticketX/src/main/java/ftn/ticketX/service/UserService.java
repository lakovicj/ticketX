package ftn.ticketX.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ftn.ticketX.model.User;
import ftn.ticketX.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	
	public User findByUsername(String username) {
		Optional<User> user = userRepository.findByUsername(username);
		user.orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
		
		return user.get();
	}
	
	
	public void saveNewUser(User user) {
		userRepository.save(user);
	}
}
