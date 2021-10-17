package capg.poc.BookingService.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import capg.poc.BookingService.models.Booking;
import capg.poc.BookingService.models.Passenger;
import capg.poc.BookingService.repository.BookingRepository;
import capg.poc.BookingService.repository.PassengerRepository;

@Service
public class BookingService {

	@Autowired
	private BookingRepository bookingRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	
	public Booking getBookingByPassenger(String passengerId) {
		Booking bookings = bookingRepository.findByPassengerId(passengerId);
		return bookings;
	}
	
	public List<Booking> getAllFlightBooking() {
		List<Booking> bookings = new ArrayList<>(); 
		bookingRepository.findAll() 
		.forEach(bookings ::add);
		
		return bookings; 
	}

	public String bookFlight(Booking bookingDetails) {
		
		  bookingDetails.setPnr(bookingDetails.getFlightId()+bookingDetails.getPassengerId());
		  bookingDetails.setStatus("Success");
		 
		bookingRepository.save(bookingDetails);
		Passenger pass = passengerRepository.findByPassengerId(bookingDetails.getPassengerId());
		pass.setPnr(bookingDetails.getPnr());
		passengerRepository.save(pass);
		return "Flight booked successfully. Your PNR number is " + bookingDetails.getPnr();
	}

	public Booking findByPNR(String pnr) {
		
		  Booking booking = bookingRepository.findByPNR(pnr); if (booking!=null) {
		  return bookingRepository.findByPNR(pnr); }else {
		  System.out.println("No such booking exist"); return null; }
	}
}
