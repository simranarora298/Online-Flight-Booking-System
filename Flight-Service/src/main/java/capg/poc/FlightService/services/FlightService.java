package capg.poc.FlightService.services;

import java.util.List;

import capg.poc.FlightService.models.Flight;

public interface FlightService {

	Flight getFlightId(String flightId);
	
	List<Flight> getAllFlights();
	
}
