package capg.poc.PassengerService.VO;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "flight")
public class Flight {
	
	@Id
	private String flightId;
	private String flightName;
	private Airport airport;
	private String departureLocation;
	private String arrivalLocation;
	private String date;
	private int fare;
	
	public Flight() {
	}

	public Flight(String flightId, String flightName, Airport airport, String departureLocation, String arrivalLocation,
			String date, int fare) {
		
		this.flightId = flightId;
		this.flightName = flightName;
		this.airport = airport;
		this.departureLocation = departureLocation;
		this.arrivalLocation = arrivalLocation;
		this.date=date;
		this.fare = fare;
	}

	public String getFlightId() {
		return flightId;
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
	public String getDate() {
		return date;
	}
	public int getFare() {
		return fare;
	}
	public void setFlightId(String flightId) {
		this.flightId = flightId;
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
	public void setDate(String date) {
		this.date = date;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}

	


}
