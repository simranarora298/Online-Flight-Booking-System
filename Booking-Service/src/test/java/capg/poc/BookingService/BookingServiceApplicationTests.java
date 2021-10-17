package capg.poc.BookingService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import capg.poc.BookingService.models.Booking;
import capg.poc.BookingService.repository.BookingRepository;
import capg.poc.BookingService.service.BookingService;

@SpringBootTest
class BookingServiceApplicationTests {
	
	@InjectMocks
	private BookingService service;
	
	@Mock
	private BookingRepository bookingRepository;
	
	@Test
	public void getAllBookingByPassengerTest() {
		String passengerId ="PASS1";
		when(bookingRepository.findByPassengerId(passengerId))
		.thenReturn(new Booking("FL1PASS1","Success","FL1" ,"PASS1"));
		Booking booking = bookingRepository.findByPassengerId(passengerId);
	
		assertEquals("FL1PASS1",booking.getPnr());
		assertEquals("Success",booking.getStatus());
		assertEquals("FL1",booking.getFlightId());
		assertEquals("PASS1",booking.getPassengerId());	
	}
	@Test
	public void getAllFlightBookingTest() {
		Booking booking = new Booking("FL1PASS1","Success","FL1" ,"PASS1");
		Booking booking2 = new Booking("FL3PASS2","Success","FL3" ,"PASS2");
		
		List<Booking> listOfBooking = new ArrayList<Booking>();
		listOfBooking.add(booking);
		listOfBooking.add(booking2);
		
		bookingRepository.saveAll(listOfBooking);
		when(bookingRepository.findAll()).thenReturn(listOfBooking);
		assertEquals(booking.getPnr(),listOfBooking.get(0).getPnr());	
		assertEquals(booking2,listOfBooking.get(1));
		 
	}
	@Test
	public void bookFlightTest() {
		Booking booking = new Booking("FL1PASS1","Success","FL1" ,"PASS1");
		when(bookingRepository.save(booking))
		.thenReturn(new Booking("FL1PASS1","Success","FL1" ,"PASS1"));
		assertEquals("FL1PASS1",booking.getPnr());
		assertEquals("Success",booking.getStatus());
		assertEquals("FL1",booking.getFlightId());
		assertEquals("PASS1",booking.getPassengerId());	
	}	
	@Test
	public void findByPNRTest() {
		String pnr = "FL1PASS1";
		when(bookingRepository.findByPNR(pnr))
		.thenReturn(new Booking("FL1PASS1","Success","FL1" ,"PASS1"));
		Booking booking = bookingRepository.findByPNR(pnr);
		assertEquals("FL1PASS1",booking.getPnr());
		assertEquals("Success",booking.getStatus());
		assertEquals("FL1",booking.getFlightId());
		assertEquals("PASS1",booking.getPassengerId());		
	}
	
	
}
