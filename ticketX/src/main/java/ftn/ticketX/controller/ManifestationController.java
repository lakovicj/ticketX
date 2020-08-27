package ftn.ticketX.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import ftn.ticketX.model.Manifestation;
import ftn.ticketX.service.ManifestationService;

@RestController
public class ManifestationController {

	@Autowired
	private ManifestationService manifestationService;
	
	@GetMapping("/manifestations")
	public ResponseEntity<?> getAllManifestations() {
		List<Manifestation> manifestations = manifestationService.getAllManifestations();
		
		return null;
	}
	
	@GetMapping("/hello")
	public void helloworld() {
		System.out.println("Hello world!");
	}
	

	
}
