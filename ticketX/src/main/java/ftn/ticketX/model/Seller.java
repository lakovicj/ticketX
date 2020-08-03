package ftn.ticketX.model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import ftn.ticketX.enums.Gender;
import ftn.ticketX.enums.UserRole;

@Entity
@DiscriminatorValue("user_seller")
public class Seller extends User {
	
	private static final long serialVersionUID = 1272192053727743047L;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "manifestation_id")
	private List<Manifestation> manifestations;

	
	public Seller() {
		
	}
	
	
	public Seller(String username, String password, String firstName, String lastName, Gender gender,
			LocalDate birthdate, UserRole userRole) {
		super(username, password, firstName, lastName, gender, birthdate, userRole);
	}

	public List<Manifestation> getManifestations() {
		return manifestations;
	}

	public void setManifestations(List<Manifestation> manifestations) {
		this.manifestations = manifestations;
	}
	
	

	
}
