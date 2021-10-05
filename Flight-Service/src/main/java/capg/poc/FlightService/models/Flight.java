package capg.poc.FlightService.models;

import java.time.LocalDateTime;

public class Flight {

	private String id;
	private String flightName;
	private Airport airport;
	private String departureLocation;
	private String arrivalLocation;
	private LocalDateTime departureDateTime;
	private LocalDateTime arrivalDateTime;
	private int fare;
	
	public Flight() {
	}

	public Flight(String id, String flightName, Airport airport, String departureLocation, String arrivalLocation,
			LocalDateTime departureDateTime, LocalDateTime arrivalDateTime, int fare) {
		super();
		this.id = id;
		this.flightName = flightName;
		this.airport = airport;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.departureDateTime = departureDateTime;
		this.arrivalDateTime = arrivalDateTime;
		this.fare = fare;
	}

	public String getId() {
		return id;
	}	
	public String getFlightName() {
		return flightName;
	}
	public Airport getAirport() {
		return airport;
	}
	public String getDepartureLocation() {
		return departureLocation;
	}
	public String getArrivalLocation() {
		return arrivalLocation;
	}
	public LocalDateTime getDepartureDateTime() {
		return departureDateTime;
	}
	public LocalDateTime getArrivalDateTime() {
		return arrivalDateTime;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public void setAirport(Airport airport) {
		this.airport = airport;
	}
	public void setDepartureLocation(String departureLocation) {
		this.departureLocation = departureLocation;
	}
	public void setArrivalLocation(String arrivalLocation) {
		this.arrivalLocation = arrivalLocation;
	}
	public void setDepartureDateTime(LocalDateTime departureDateTime) {
		this.departureDateTime = departureDateTime;
	}
	public void setArrivalDateTime(LocalDateTime arrivalDateTime) {
		this.arrivalDateTime = arrivalDateTime;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Flight [id=" + id + ", flightName=" + flightName + ", airport=" + airport + ", departureLocation="
				+ departureLocation + ", arrivalLocation=" + arrivalLocation + ", departureDateTime="
				+ departureDateTime + ", arrivalDateTime=" + arrivalDateTime + ", fare=" + fare + "]";
	}

	


	 
	
}
