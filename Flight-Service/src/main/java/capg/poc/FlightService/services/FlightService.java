package capg.poc.FlightService.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capg.poc.FlightService.models.Flight;
import capg.poc.FlightService.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	private FlightRepository flightRepository;
	
	public List<Flight> getAllFlights() { 
		List<Flight> flights = new ArrayList<>(); 
		flightRepository.findAll() 
		.forEach(flights::add);
		
		return flights; 
	}
	 
		public void addFlight(Flight flight) { 
		flightRepository.save(flight); 
	}
	 
	
	public void updateFlight(String flightId , Flight flight) {
		flightRepository.save(flight);	
	}
	
	public void deleteFlight(String flightId) {
		flightRepository.deleteById(flightId);	
	}

	public List<Flight> flightByDepartureArrivalLocation(String departureLocation , String arrivalLocation ) {
		List<Flight> flights = new ArrayList<>(); 
		flightRepository.findByDepartureLocation(departureLocation, arrivalLocation)
		.forEach(flights::add);
		
		return flights;
	}

	public List<Flight> flightByDate(String date) {
		List<Flight> flights = new ArrayList<>(); 
		flightRepository.findByDate(date)
		.forEach(flights::add);
		
		return flights;
	}

	public Flight findByFlightId(String flightId) {
		Flight flight = flightRepository.findByFlightId(flightId);
		if (flight!=null) {
			return flightRepository.findByFlightId(flightId);
		}else {
			System.out.println("No such flight exist");
			return null;
			
			
		}
	}

}