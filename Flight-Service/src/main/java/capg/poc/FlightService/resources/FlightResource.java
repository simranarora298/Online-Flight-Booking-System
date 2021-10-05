package capg.poc.FlightService.resources;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capg.poc.FlightService.models.Flight;
import capg.poc.FlightService.services.FlightService;

@RestController
@RequestMapping("/flight")
public class FlightResource {
	
	private FlightService flightService;
	
	@RequestMapping
	List<Flight> getAllFlights()
	{
		return flightService.getAllFlights();
	}
	
	@RequestMapping("/flightId")
	public Flight getFlightId(@PathVariable("flightId") String flightId)
	{
		return flightService.getFlightId(flightId);
		
	}

}
