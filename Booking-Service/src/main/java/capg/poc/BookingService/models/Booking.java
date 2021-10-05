package capg.poc.BookingService.models;

import java.util.List;

public class Booking {
	
	private String id;
	private Passenger passenger;
	private List<Flight> flights;
	
	public Booking() {
	}
	
	public Booking(String id, Passenger passenger, List<Flight> flights) {
		super();
		this.id = id;
		this.passenger = passenger;
		this.flights = flights;
	}
	public String getId() {
		return id;
	}
	public Passenger getPassenger() {
		return passenger;
	}
	public List<Flight> getFlights() {
		return flights;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}
	public void setFlights(List<Flight> flights) {
		this.flights = flights;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", passenger=" + passenger + ", flights=" + flights + "]";
	}
	
	
}
