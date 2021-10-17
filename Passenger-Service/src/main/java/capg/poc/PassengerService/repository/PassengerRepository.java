package capg.poc.PassengerService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import capg.poc.PassengerService.models.Passenger;

@Repository
public interface PassengerRepository extends MongoRepository<Passenger, String> {
	
	@Query("{passengerId : ?0}")
	public Passenger findByPassengerId(String passengerId);
	
	@Query("{email : ?0}")
	public String findByEmail(String email);

	@Query("{passengerId : ?0}")
	public Passenger updatePassenger(String passengerId);
	
}
