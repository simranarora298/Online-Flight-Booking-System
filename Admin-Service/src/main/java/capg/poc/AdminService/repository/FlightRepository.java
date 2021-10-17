package capg.poc.AdminService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import capg.poc.AdminService.models.Flight;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {

	@Query ("{flightId : ?0}")
	Flight findByFlightId(String flightId);

}
