package capg.poc.BookingService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import capg.poc.BookingService.models.Booking;
import capg.poc.BookingService.models.Passenger;
import capg.poc.BookingService.repository.PassengerRepository;
import capg.poc.BookingService.service.BookingService;

@RestController
@RequestMapping("/bookings")
public class BookingResource {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/passengers/{passengerId}")
	public Booking getBookingByPassenger(@PathVariable("passengerId") String passengerId){
		return bookingService.getBookingByPassenger(passengerId);
	}
	
	@GetMapping("/all")
	public List<Booking> getAllFlightBooking() {
	  return bookingService.getAllFlightBooking(); 
	}
	
	@PostMapping("/bookflight")
	@ResponseBody
	public String bookFlight(@RequestBody Booking bookingDetails) {
		
		Passenger pass = passengerRepository.findByPassengerId(bookingDetails.getPassengerId());
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(pass.getEmail());
			message.setSubject("Booking Confirmed");
			message.setText("Flight Booking Confirmed");
			mailSender.send(message);
			return bookingService.bookFlight(bookingDetails);
	}
	
	@GetMapping("/pnr1/{pnr}")
	public Booking findByPNR(@PathVariable("pnr") String pnr) {
		return bookingService.findByPNR(pnr);
	}
	
}
