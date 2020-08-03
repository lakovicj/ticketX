package ftn.ticketX.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import ftn.ticketX.enums.Gender;
import ftn.ticketX.enums.UserRole;

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
	
	@OneToOne
	private UserType customerType;

	public Customer() {
		
	}
	
	public Customer(String username, String password, String firstName, String lastName, Gender gender,
			LocalDate birthdate, UserRole userRole) {
		super(username, password, firstName, lastName, gender, birthdate, userRole);
		// TODO Auto-generated constructor stub
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
