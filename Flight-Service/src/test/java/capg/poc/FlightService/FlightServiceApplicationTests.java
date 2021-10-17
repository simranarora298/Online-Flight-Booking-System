package capg.poc.FlightService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import capg.poc.FlightService.models.Airport;
import capg.poc.FlightService.models.Flight;
import capg.poc.FlightService.repository.FlightRepository;
import capg.poc.FlightService.services.FlightService;

@SpringBootTest
class FlightServiceApplicationTests {
	
	@InjectMocks
	private FlightService flightService;
	
	@Mock
	private FlightRepository flightRepository;
	
	@Test
	public void getAllFlightsTest() { 
		Flight flight = new Flight("FL1","express",new Airport("AIR1","International airport", "delhi","india"), 
				"delhi", "china", "13/09/21", 45000);
		Flight flight2 = new Flight("FL2","expressfast",new Airport("AIR2","Primary airport", "delhi","india"), 
				"delhi", "kerela", "15/10/21", 4000);
		List<Flight> listOfFlight = new ArrayList<Flight>();
		listOfFlight.add(flight);
		listOfFlight.add(flight2);
		
		flightRepository.saveAll(listOfFlight);
		when(flightRepository.findAll()).thenReturn(listOfFlight);
		assertEquals(flight.getFlightId(),listOfFlight.get(0).getFlightId());	
		assertEquals(flight2,listOfFlight.get(1));
	}
	 
	@Test
	public void addFlightTest() { 
			Flight flight = new Flight("FL1","express",new Airport("AIR1","International airport", "delhi","india"), 
					"delhi", "china", "13/09/21", 45000);
			when(flightRepository.insert(flight)).thenReturn(flight);
			assertEquals("FL1", flight.getFlightId());
			assertEquals("express", flight.getFlightName());
			assertEquals("AIR1", flight.getAirport().getId());
			assertEquals("International airport", flight.getAirport().getName());
			assertEquals("delhi", flight.getAirport().getCity());
			assertEquals("india", flight.getAirport().getCountry());
			assertEquals("delhi", flight.getDepartureLocation());
			assertEquals("china", flight.getArrivalLocation());
			assertEquals("13/09/21", flight.getDate());
			assertEquals(45000, flight.getFare());	
	}
	 
	@Test
	public void flightByDepartureArrivalLocation() {
		Flight flight = new Flight("FL1","express",new Airport("AIR1","International airport", "delhi","india"), 
				"delhi", "china", "13/09/21", 45000);
		Flight flight2 = new Flight("FL2","expressfast",new Airport("AIR2","Primary airport", "delhi","india"), 
				"delhi", "kerela", "15/10/21", 4000);
		List<Flight> listOfFlight = new ArrayList<Flight>();
		listOfFlight.add(flight);
		listOfFlight.add(flight2);
		
		flightRepository.saveAll(listOfFlight);
		when(flightRepository.findByDepartureLocation("delhi","kerela")).thenReturn(listOfFlight);
		assertEquals(flight.getFlightId(),listOfFlight.get(0).getFlightId());	
		assertEquals(flight2,listOfFlight.get(1));
	}
	
	@Test
	public void flightByDate() {
		Flight flight = new Flight("FL1","express",new Airport("AIR1","International airport", "delhi","india"), 
				"delhi", "china", "13/09/21", 45000);
		Flight flight2 = new Flight("FL2","expressfast",new Airport("AIR2","Primary airport", "delhi","india"), 
				"delhi", "kerela", "15/10/21", 4000);
		List<Flight> listOfFlight = new ArrayList<Flight>();
		listOfFlight.add(flight);
		listOfFlight.add(flight2);
		
		flightRepository.saveAll(listOfFlight);
		when(flightRepository.findByDate("13/09/21")).thenReturn(listOfFlight);
		assertEquals(flight.getFlightId(),listOfFlight.get(0).getFlightId());	
		assertEquals(flight2,listOfFlight.get(1));
	}
	
	@Test
	public void findByFlightId() {
		String flightId= "FL1";
		when(flightRepository.findByFlightId(flightId))
		.thenReturn(new Flight("FL1","express",new Airport("AIR1","International airport", "delhi","india"), 
				"delhi", "china", "13/09/21", 45000));
		
		Flight flight = flightService.findByFlightId(flightId);
		assertEquals("FL1", flight.getFlightId());
		assertEquals("express", flight.getFlightName());
		assertEquals("AIR1", flight.getAirport().getId());
		assertEquals("International airport", flight.getAirport().getName());
		assertEquals("delhi", flight.getAirport().getCity());
		assertEquals("india", flight.getAirport().getCountry());
		assertEquals("delhi", flight.getDepartureLocation());
		assertEquals("china", flight.getArrivalLocation());
		assertEquals("13/09/21", flight.getDate());
		assertEquals(45000, flight.getFare());
    }
	
	@Test
	public void updateFlightTest(){
		Flight flight = new Flight("FL1","express",new Airport("AIR1","International airport", "delhi","india"), 
				"delhi", "china", "13/09/21", 45000);
		when(flightRepository.save(flight)).thenReturn(new Flight("FL1","express",new Airport("AIR1","International airport", "delhi","india"), 
				"delhi", "china", "13/09/21", 45000));
		assertEquals("FL1", flight.getFlightId());
		assertEquals("express", flight.getFlightName());
		assertEquals("AIR1", flight.getAirport().getId());
		assertEquals("International airport", flight.getAirport().getName());
		assertEquals("delhi", flight.getAirport().getCity());
		assertEquals("india", flight.getAirport().getCountry());
		assertEquals("delhi", flight.getDepartureLocation());
		assertEquals("china", flight.getArrivalLocation());
		assertEquals("13/09/21", flight.getDate());
		assertEquals(45000, flight.getFare());
		}
		
	@Test
	public void deleteFlightTest(){	
		flightRepository.deleteById("FL1");
		verify(flightRepository,times(1)).deleteById("FL1");
		}
		
}

