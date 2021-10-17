package capg.poc.BookingService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking")
public class Booking {
	
	@Id
	private String pnr;
	private String status;
	private String flightId;
	private String passengerId;
	
	public Booking() {
	}
	
	public Booking(String pnr, String status, String flightId, String passengerId) {
		this.pnr = pnr;
		this.status = status;
		this.flightId = flightId;
		this.passengerId = passengerId;
	}
	
	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}
	
	
	
	
}
