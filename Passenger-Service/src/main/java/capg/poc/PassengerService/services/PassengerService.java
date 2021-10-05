package capg.poc.PassengerService.services;

import java.util.List;
import capg.poc.PassengerService.models.Passenger;

public interface PassengerService {
	
	Passenger getPassengerId(String passengerId);
	
	List<Passenger> getAllPassengers();

}
