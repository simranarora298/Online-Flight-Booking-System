package capg.poc.BookingService.service;

import java.util.List;

import capg.poc.BookingService.models.Booking;

public interface BookingService {

	Booking getBookingById( String bookingId);
	List<Booking> getAllBookingByPassenger(String passengerId);
	List<Booking> getAllFlightBooking();
	
}
