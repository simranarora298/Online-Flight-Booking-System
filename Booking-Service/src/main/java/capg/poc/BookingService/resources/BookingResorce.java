package capg.poc.BookingService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capg.poc.BookingService.models.Booking;
import capg.poc.BookingService.service.BookingService;

@RestController
@RequestMapping("/booking")
public class BookingResorce {
	
	@Autowired
	private BookingService bookingService;
	
	@RequestMapping("/{bookingId}")
	public Booking getBookingById(@PathVariable("bookingId") String bookingId)
	{
		return  bookingService.getBookingById(bookingId);
	}
	
	@RequestMapping("/{passengerId}")
	public List<Booking> getAllBookingByPassenger(@PathVariable("passengerId") String passengerId)
	{
		return bookingService.getAllBookingByPassenger(passengerId);
	}
	
	@RequestMapping
	public List<Booking> getAllFlightBooking()
	{
		return bookingService.getAllFlightBooking();
	}
	
}
