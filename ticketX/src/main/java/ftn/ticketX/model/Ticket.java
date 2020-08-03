package ftn.ticketX.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Ticket implements Serializable {

	private static final long serialVersionUID = -7026640020818480603L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String uniqueId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Manifestation manifestation;
	
	@Column
	private LocalDateTime datetime;
	
	@Column
	private double price;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Customer user;
	
	@Column
	private boolean reservedStatus;
	
	
	public Ticket() {
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public Manifestation getManifestation() {
		return manifestation;
	}

	public void setManifestation(Manifestation manifestation) {
		this.manifestation = manifestation;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Customer getUser() {
		return user;
	}

	public void setUser(Customer user) {
		this.user = user;
	}

	public boolean isReserved() {
		return reservedStatus;
	}

	public void setReservedStatus(boolean reservedStatus) {
		this.reservedStatus = reservedStatus;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Customer)) {
			return false;
		}
		return id != null && id.equals(((Customer) obj).getId());
	}


	@Override
	public int hashCode() {
		return 31;
	}
		
	
	
	
	
}
