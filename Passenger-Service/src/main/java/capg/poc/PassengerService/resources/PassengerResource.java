package capg.poc.PassengerService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capg.poc.PassengerService.models.Passenger;
import capg.poc.PassengerService.services.PassengerService;

@RestController
public class PassengerResource {
	
	@Autowired
	private PassengerService passengerService;
	
	@RequestMapping("/passenger")
	public List<Passenger> getAllPassengers()
	{
		return passengerService.getAllPassengers();
	}
	
	@RequestMapping("/{passengerId}")
	public Passenger getPassengerId(@PathVariable("passengerId") String passengerId)
	{
		return passengerService.getPassengerId(passengerId);
	}
}
