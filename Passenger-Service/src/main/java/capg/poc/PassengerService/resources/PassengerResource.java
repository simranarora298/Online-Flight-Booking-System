package capg.poc.PassengerService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capg.poc.PassengerService.VO.ResponseTemplateVO;
import capg.poc.PassengerService.models.Passenger;
import capg.poc.PassengerService.services.PassengerService;


@RestController
@RequestMapping("/passengers")
public class PassengerResource {
	
	@Autowired
	private PassengerService passengerService;
	
	/*
	 * @RequestMapping("/passengers") public ResponseEntity<?> getAllPassengers(){
	 * return passengerService.getAllPassengers(); }
	 */
	
	@GetMapping("/all")
	public List<Passenger> getAllPassengers(){
		return passengerService.getAllPassengers();
	}
	
	@GetMapping("/{passengerId}")
	public Passenger findByPassengerId(@PathVariable("passengerId") String passengerId) {
		return passengerService.findByPassengerId(passengerId);
	}
	
	/*
	 * @PostMapping("/register") public String addPassenger(@RequestBody Passenger
	 * passenger) { return passengerService.addPassenger(passenger); }
	 */
	
	@PostMapping("/register")
	public Passenger addPassenger(@RequestBody Passenger passenger) {
		 return passengerService.addPassenger(passenger);	
	}
	
	@PutMapping("/{passengerId}")
	public void updatePassenger(@RequestBody Passenger passenger , @PathVariable String passengerId ) {
		passengerService.updatePassenger(passengerId, passenger);	
	}
	
	@DeleteMapping("/{passengerId}")
	public void deletePassenger(@PathVariable String passengerId) {
		passengerService.deletePassenger(passengerId);	
	}
	
	@GetMapping("/bookings/{passengerId}")
	public ResponseTemplateVO getPassengerWithBooking(@PathVariable("passengerId") String passengerId) {
		return passengerService.getPassengerWithBooking(passengerId);
	}
	
}
