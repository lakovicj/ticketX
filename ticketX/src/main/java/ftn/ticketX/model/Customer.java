package ftn.ticketX.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ftn.ticketX.dto.UserDTO;
import ftn.ticketX.enums.Gender;
import ftn.ticketX.enums.UserRole;
import ftn.ticketX.helper.Helper;

@Entity
@DiscriminatorValue("user_customer")
public class Customer extends User {
	
	private static final long serialVersionUID = 3533627474149375836L;
	
	@OneToMany(
			mappedBy = "user",
			cascade = CascadeType.ALL,
			orphanRemoval = true
			)
	private List<Ticket> tickets;
	
	
	@Column
	private int acquiredPoints;
	
	@OneToOne(cascade = CascadeType.DETACH)
	private UserType customerType;

	
	
	public Customer() {
		this.setUserRole(UserRole.CUSTOMER);
	}
	
	public Customer(String username, String password, String firstName, String lastName, Gender gender,
			LocalDate birthdate, boolean active) {
		super(username, password, firstName, lastName, gender, birthdate, UserRole.CUSTOMER, active);
		// TODO Auto-generated constructor stub
	}
	
	public Customer(UserDTO dto) {
		super(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(), Gender.values()[dto.getGender()],
				Helper.dateToLocalDate(dto.getBirthdate()), UserRole.CUSTOMER, true);
		
		this.tickets = new ArrayList<Ticket>();
		
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public int getAcquiredPoints() {
		return acquiredPoints;
	}

	public void setAcquiredPoints(int acquiredPoints) {
		this.acquiredPoints = acquiredPoints;
	}

	public UserType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(UserType customerType) {
		this.customerType = customerType;
	}
	
	public void addTicket(Ticket ticket) {
		tickets.add(ticket);
		ticket.setUser(this);
	}
	
	public void removeTicket(Ticket ticket) {
		tickets.remove(ticket);
		ticket.setUser(null);
	}
	

}
