package capg.poc.AdminService;

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

import capg.poc.AdminService.models.Address;
import capg.poc.AdminService.models.Admin;
import capg.poc.AdminService.models.Airport;
import capg.poc.AdminService.models.Flight;
import capg.poc.AdminService.models.Passenger;
import capg.poc.AdminService.repository.AdminRepository;
import capg.poc.AdminService.repository.FlightRepository;
import capg.poc.AdminService.repository.PassengerRepository;
import capg.poc.AdminService.services.AdminService;

@SpringBootTest
class AdminServiceApplicationTests {
	
	@InjectMocks
	private AdminService service;
	
	@Mock
	private AdminRepository adminRepository;
	
	@Mock
	private PassengerRepository passengerRepository;
	
	@Mock
	private FlightRepository flightRepository;
	
	
	@Test
	public void getAllAdminsTest() {
		Admin admin = new Admin("ADM1","Aryan","Tripathi","aryan@gmail", 987654321, 
				new Address("h98", "rajghar", "gwalior","gwalior", 110045, "india"));
		Admin admin2 = new Admin("ADM2","ryan","Tripathi","ryan@gmail", 987654321, 
				new Address("h8", "ghar", "walior","walior", 11045, "india"));
		List<Admin> listOfAdmin = new ArrayList<Admin>();
		listOfAdmin.add(admin);
		listOfAdmin.add(admin2);
		
		adminRepository.saveAll(listOfAdmin);
		when(adminRepository.findAll()).thenReturn(listOfAdmin);
		assertEquals(admin.getAdminId(),listOfAdmin.get(0).getAdminId());	
		assertEquals(admin2,listOfAdmin.get(1));
	}
	
	@Test
	public void getAdminId() {
		String adminId ="ADM1";
		when(adminRepository.findByAdminId(adminId))
		.thenReturn(new Admin("ADM1","Aryan","Tripathi","aryan@gmail", 987654321, 
				new Address("h98", "rajghar", "gwalior","gwalior", 110045, "india")));
		
		Admin admin = service.findByAdminId(adminId);
		assertEquals("ADM1",admin.getAdminId());
		assertEquals("Aryan",admin.getFirstName());
		assertEquals("Tripathi",admin.getLastName());
		assertEquals("aryan@gmail",admin.getEmail());
		assertEquals(987654321,admin.getMobNo());
		assertEquals("h98",admin.getAddress().getHouseNo());
		assertEquals("rajghar",admin.getAddress().getStreet());
		assertEquals("gwalior",admin.getAddress().getCity());
		assertEquals("gwalior",admin.getAddress().getState());
		assertEquals(110045,admin.getAddress().getZip());
		assertEquals("india",admin.getAddress().getCountry());
		
	}

	
	@Test
	public void addAdminTest() {
		
		Admin admin = new Admin("ADM1","Aryan","Tripathi","aryan@gmail", 987654321, 
				new Address("h98", "rajghar", "gwalior","gwalior", 110045, "india"));
		when(adminRepository.insert(admin)).thenReturn(admin);
		assertEquals("ADM1",admin.getAdminId());
		assertEquals("Aryan",admin.getFirstName());
		assertEquals("Tripathi",admin.getLastName());
		assertEquals("aryan@gmail",admin.getEmail());
		assertEquals(987654321,admin.getMobNo());
		assertEquals("h98",admin.getAddress().getHouseNo());
		assertEquals("rajghar",admin.getAddress().getStreet());
		assertEquals("gwalior",admin.getAddress().getCity());
		assertEquals("gwalior",admin.getAddress().getState());
		assertEquals(110045,admin.getAddress().getZip());
		assertEquals("india",admin.getAddress().getCountry());
		
	}
	
	@Test
	public void getAllPassengersTest() {
		Passenger pass = new Passenger("PASS1","Sim","Arora","sim@gmail.com","password", 987654321, "FL1PASS1");
		Passenger pass2 = new Passenger("PASS2","Susanto","Mandal","sushi@gmail.com","password1", 987632121, "FL3PASS2");
		List<Passenger> listOfPassenger = new ArrayList<Passenger>();
		listOfPassenger.add(pass);
		listOfPassenger.add(pass2);
		
		passengerRepository.saveAll(listOfPassenger);
		when(passengerRepository.findAll()).thenReturn(listOfPassenger);
		assertEquals(pass.getPassengerId(),listOfPassenger.get(0).getPassengerId());	
		assertEquals(pass2,listOfPassenger.get(1));
	}
	
	@Test
	public void addFlightsTest() {
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
	public void updateAdminTest() {
		Admin admin = new Admin("ADM1","Aryan","Tripathi","aryan@gmail", 987654321, 
				new Address("h98", "rajghar", "gwalior","gwalior", 110045, "india"));
		when(adminRepository.save(admin)).thenReturn(new Admin("ADM1","Aryan","Tripathi","aryan@gmail", 987654321, 
				new Address("h98", "rajghar", "gwalior","gwalior", 110045, "india")));
		assertEquals("ADM1",admin.getAdminId());
		assertEquals("Aryan",admin.getFirstName());
		assertEquals("Tripathi",admin.getLastName());
		assertEquals("aryan@gmail",admin.getEmail());
		assertEquals(987654321,admin.getMobNo());
		assertEquals("h98",admin.getAddress().getHouseNo());
		assertEquals("rajghar",admin.getAddress().getStreet());
		assertEquals("gwalior",admin.getAddress().getCity());
		assertEquals("gwalior",admin.getAddress().getState());
		assertEquals(110045,admin.getAddress().getZip());
		assertEquals("india",admin.getAddress().getCountry());
	}
	
	@Test
	public void deleteAdminTest() {
		adminRepository.deleteById("ADM1");	
		verify(adminRepository,times(1)).deleteById("ADM1");
	}
	
	@Test
	public void deletePassengerTest() {
		passengerRepository.deleteById("PASS1");
		verify(passengerRepository,times(1)).deleteById("PASS1");
	}
	
	@Test
	public void deleteFlightTest() {
		flightRepository.deleteById("FL1");
		verify(flightRepository,times(1)).deleteById("FL1");
	}

}
