package ftn.ticketX.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.ticketX.enums.Gender;
import ftn.ticketX.enums.UserRole;
import ftn.ticketX.model.Administrator;
import ftn.ticketX.service.UserService;

@RestController
public class ProbaController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping("/init")
	public void initDB() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		//Administrator admin = new Administrator("user", "user", "Jovan", "Lakovic", Gender.MALE, LocalDate.parse("13/08/1996", formatter), UserRole.ADMINISTRATOR, true);
		//userService.saveNewUser(admin);
		Administrator admin2 = new Administrator("user2", passwordEncoder.encode("user2"), "Goran", "Lakovic", Gender.MALE, LocalDate.parse("14/08/1996", formatter), UserRole.ADMINISTRATOR, true);
		userService.saveNewUser(admin2);
	}

}
