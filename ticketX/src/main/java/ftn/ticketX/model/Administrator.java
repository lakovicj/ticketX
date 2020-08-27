package ftn.ticketX.model;

import java.time.LocalDate;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import ftn.ticketX.enums.Gender;
import ftn.ticketX.enums.UserRole;

@Entity
@DiscriminatorValue("user_admin")
public class Administrator extends User {

	private static final long serialVersionUID = 7254223842953939983L;
	

	public Administrator() {
		
	}
	
	public Administrator(String username, String password, String firstName, String lastName, Gender gender,
			LocalDate birthdate, UserRole userRole, boolean active) {
		super(username, password, firstName, lastName, gender, birthdate, userRole, active);
		// TODO Auto-generated constructor stub
	}

}
