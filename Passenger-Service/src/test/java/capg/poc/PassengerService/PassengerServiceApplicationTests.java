package capg.poc.PassengerService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
//import static org.mockito.Mockito.times;
//import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import capg.poc.PassengerService.models.Passenger;
import capg.poc.PassengerService.repository.PassengerRepository;
import capg.poc.PassengerService.services.PassengerService;

@SpringBootTest
class PassengerServiceApplicationTests {
	
	@InjectMocks
	private PassengerService service;
	
	@Mock
	private PassengerRepository repository;

	@Test
	public void findByPassengerIdTest() {
		String passengerId ="PASS1";
		when(repository.findByPassengerId(passengerId))
		.thenReturn(new Passenger("PASS1","Sim","Arora","sim@gmail.com","password", 987654321, "FL1PASS1"));
		
		Passenger pass = service.findByPassengerId("PASS1");
		//Passenger pass2 = service.findByPassengerId("PASS1");
		
		assertEquals("PASS1", pass.getPassengerId());
		assertEquals("Sim", pass.getFirstName());
		assertEquals("Arora", pass.getLastName());
		assertEquals("sim@gmail.com", pass.getEmail());
		assertEquals("password", pass.getPassword());
		assertEquals(987654321, pass.getMobNo());
		assertEquals("FL1PASS1", pass.getPnr());
		
		//verify(repository,times(2)).findByPassengerId(passengerId);
	}
	
	@Test
	public void getAllPassengersTest() {
		Passenger pass = new Passenger("PASS1","Sim","Arora","sim@gmail.com","password", 987654321, "FL1PASS1");
		Passenger pass2 = new Passenger("PASS2","Susanto","Mandal","sushi@gmail.com","password1", 987632121, "FL3PASS2");
		List<Passenger> listOfPassenger = new ArrayList<Passenger>();
		listOfPassenger.add(pass);
		listOfPassenger.add(pass2);
		
		repository.saveAll(listOfPassenger);
		when(repository.findAll()).thenReturn(listOfPassenger);
		assertEquals(pass.getPassengerId(),listOfPassenger.get(0).getPassengerId());	
		assertEquals(pass2,listOfPassenger.get(1));
	}
	
	@Test
	public void addPassengerTest() {
		Passenger pass = new Passenger("PASS1","Sim","Arora","sim@gmail.com","password", 987654321, "FL1PASS1");
		when(repository.insert(pass)).thenReturn(pass);
		assertEquals("PASS1", pass.getPassengerId());
		assertEquals("Sim", pass.getFirstName());
		assertEquals("Arora", pass.getLastName());
		assertEquals("sim@gmail.com", pass.getEmail());
		assertEquals("password", pass.getPassword());
		assertEquals(987654321, pass.getMobNo());
		assertEquals("FL1PASS1", pass.getPnr());
	}
	
	@Test
	public void updatePassengerTest() {
		Passenger pass = new Passenger("PASS1","Sim","Arora","sim@gmail.com","password", 987654321, "FL1PASS1");
		when(repository.save(pass)).thenReturn(new Passenger("PASS1","Sim","Arora","sim@gmail.com","password", 987654321, "FL1PASS1"));
		assertEquals("PASS1", pass.getPassengerId());
		assertEquals("Sim", pass.getFirstName());
		assertEquals("Arora", pass.getLastName());
		assertEquals("sim@gmail.com", pass.getEmail());
		assertEquals("password", pass.getPassword());
		assertEquals(987654321, pass.getMobNo());
		assertEquals("FL1PASS1", pass.getPnr());		
	}
	
	
	  @Test 
	  public void deletePassengerTest() { 
		  repository.deleteById("PASS2");
		  verify(repository,times(1)).deleteById("PASS2");
	  }
	 
	
}
	
