package capg.poc.PassengerService.VO;

import capg.poc.PassengerService.models.Passenger;

public class ResponseTemplateVO {
	
	private Passenger passenger;
	private Booking booking;
	private Flight flight;
	
	public ResponseTemplateVO() {
	}
	public ResponseTemplateVO(Passenger passenger, Booking booking , Flight flight) {
		this.passenger = passenger;
		this.booking = booking;
		this.flight = flight;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public Booking getBooking() {
		return booking;
	}
	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	public Flight getFlight() {
		return flight;
	}
	public void setFlight(Flight flight) {
		this.flight = flight;
	}
	
	
}
