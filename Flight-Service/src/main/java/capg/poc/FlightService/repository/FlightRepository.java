package capg.poc.FlightService.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import capg.poc.FlightService.models.Flight;

@Repository
public interface FlightRepository extends MongoRepository<Flight, String> {
		
	@Query("{date : ?0}")
	public List<Flight> findByDate(String date);
	
	@Query("{flightId : ?0}")
	public Flight findByFlightId(String flightId);

	@Query("{departureLocation : ?0, arrivalLocation : ?0}")
	public List<Flight> findByDepartureLocation(String departureLocation, String arrivalLocation);
}
