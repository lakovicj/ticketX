package ftn.ticketX.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ftn.ticketX.model.Manifestation;
import ftn.ticketX.repository.ManifestationRepository;

@Service
public class ManifestationService {

	@Autowired
	private ManifestationRepository manifestationRepo;
	
	
	public List<Manifestation> getAllManifestations() {
		return manifestationRepo.findByActive(true);
	}
	
	public Manifestation getManifestationById(Long id) {
		return manifestationRepo.findById(id).orElse(null);
	}
	
	public void search() {
		
	}
	
	public void filter() {
		
	}
	
	public void sort() {
		
	}
	
	public void makeManifestation() {
		
	}
	
	public void editManifestation(Long id) {
		
	}
	
}
