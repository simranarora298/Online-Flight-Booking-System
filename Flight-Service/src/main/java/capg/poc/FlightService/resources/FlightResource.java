package capg.poc.FlightService.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capg.poc.FlightService.models.Flight;
import capg.poc.FlightService.services.FlightService;

@RestController
@RequestMapping("/flights")
public class FlightResource {
	
	@Autowired
	private FlightService flightService;
	
	@GetMapping("/all")
	public List<Flight> getAllFlights(){
		return flightService.getAllFlights();
	}
	
	@GetMapping("/{flightId}")
	public Flight findByFlightId(@PathVariable("flightId") String flightId){
		return flightService.findByFlightId(flightId);
	}
	
	@PostMapping("/add") 
	public void addFlight(@RequestBody Flight flight) {
		flightService.addFlight(flight); 
	}
	
	@PutMapping("/{flightId}")
	public void updateFlight(@RequestBody Flight flight , @PathVariable String flightId ) {
		flightService.updateFlight(flightId, flight);	
	}
	
	@DeleteMapping("/{flightId}")
	public void deleteFlight(@PathVariable String flightId) {
		flightService.deleteFlight(flightId);	
	}
	
	@GetMapping("/dep/{departureLocation}")
	public List<Flight> flightByDepartureArrivalLocation(String departureLocation , String arrivalLocation){
		return flightService.flightByDepartureArrivalLocation(departureLocation, arrivalLocation);
	}
	
	@GetMapping("/date/{date}")
	public List<Flight> flightByDate(String date){
		return flightService.flightByDate(date);
	}
}
