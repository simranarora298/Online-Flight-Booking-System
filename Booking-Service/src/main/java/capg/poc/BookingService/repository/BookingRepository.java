package capg.poc.BookingService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import capg.poc.BookingService.models.Booking;

@Repository
public interface BookingRepository extends MongoRepository<Booking, String> {
	
	@Query("{passengerId :?0}")
	Booking findByPassengerId(String passengerId);
	
	@Query("{pnr :?0}")
	Booking findByPNR(String pnr);

}
