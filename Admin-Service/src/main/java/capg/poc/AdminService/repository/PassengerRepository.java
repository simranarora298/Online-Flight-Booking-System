package capg.poc.AdminService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import capg.poc.AdminService.models.Passenger;

@Repository
public interface PassengerRepository extends MongoRepository<Passenger, String> {
	
	@Query("{passengerId : ?0}")
	Passenger findPassengerById(String passengerId);

}
