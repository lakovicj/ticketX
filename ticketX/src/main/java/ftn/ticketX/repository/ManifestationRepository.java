package ftn.ticketX.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ftn.ticketX.model.Manifestation;

@Repository
public interface ManifestationRepository extends CrudRepository<Manifestation, Long> {

	public List<Manifestation> findByActive(boolean active);
	
}
