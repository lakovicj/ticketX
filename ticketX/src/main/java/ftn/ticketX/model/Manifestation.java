package ftn.ticketX.model;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import ftn.ticketX.enums.ManifestationType;

@Entity
public class Manifestation implements Serializable{
	
	private static final long serialVersionUID = -4594800950266416087L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column
	private String name;
	
	@Enumerated
	private ManifestationType type;
	
	@Column
	private int availableSeats;
	
	@Column
	private LocalDateTime datetime;
	
	@Column
	private double regularTicketPrice;
	
	@Column
	private boolean active;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Location location;
	
	@Column
	private String image;
	
	public Manifestation() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ManifestationType getType() {
		return type;
	}

	public void setType(ManifestationType type) {
		this.type = type;
	}

	public int getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}

	public LocalDateTime getDatetime() {
		return datetime;
	}

	public void setDatetime(LocalDateTime datetime) {
		this.datetime = datetime;
	}

	public double getRegularTicketPrice() {
		return regularTicketPrice;
	}

	public void setRegularTicketPrice(double regularTicketPrice) {
		this.regularTicketPrice = regularTicketPrice;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	

}
