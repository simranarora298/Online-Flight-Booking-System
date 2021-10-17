package capg.poc.PassengerService.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

//import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import capg.poc.PassengerService.VO.Booking;
import capg.poc.PassengerService.VO.Flight;
import capg.poc.PassengerService.VO.ResponseTemplateVO;
import capg.poc.PassengerService.models.Passenger;
import capg.poc.PassengerService.repository.PassengerRepository;


@Service
public class PassengerService {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public List<Passenger> getAllPassengers() { 
		List<Passenger> passengers = new ArrayList<>(); 
		passengerRepository.findAll() 
		.forEach(passengers::add);
		
		return passengers; 
	}
	 
		public Passenger findByPassengerId(String passengerId) {
		return passengerRepository.findByPassengerId(passengerId);
	}

	public Passenger addPassenger(Passenger passenger) {

		
		  Passenger passenger2 =
		  passengerRepository.findByPassengerId(passenger.getPassengerId());
		  if(passenger2.getPassengerId()==null) { return
		  passengerRepository.save(passenger); } else {
		  System.out.println("Already exist"); 
		  return null;
		  }
		
		}
	
	public void updatePassenger(String passengerId , Passenger passenger) {
		passengerRepository.save(passenger);	
	}
	
	public void deletePassenger(String passengerId) {
		passengerRepository.deleteById(passengerId);	
	}
	
	//@HystrixCommand(fallbackMethod = "getPassengerWithBooking_Fallback")
	public ResponseTemplateVO getPassengerWithBooking(String passengerId) {
		ResponseTemplateVO vo = new ResponseTemplateVO();
		Passenger passenger = passengerRepository.findByPassengerId(passengerId);
		
		Booking booking = restTemplate.getForObject("http://booking-service/bookings/pnr1/" + passenger.getPnr(), Booking.class);
		Flight flight = restTemplate.getForObject("http://flight-service/flights/" + booking.getFlightId(), Flight.class);
		vo.setPassenger(passenger);
		vo.setBooking(booking);
		vo.setFlight(flight);
		
		return vo;
	}
	
	/*
	 * public ResponseTemplateVO getPassengerWithBooking_Fallback(String
	 * passengerId) { System.out.
	 * println("Booking/Flight Service is down!!! Fallback route enabled...\n Service will be back shortly"
	 * ); return null; }
	 */
}
