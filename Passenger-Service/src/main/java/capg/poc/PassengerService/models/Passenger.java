package capg.poc.PassengerService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passenger")
public class Passenger 
{
	@Id
	private String passengerId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private long mobNo;
	private String pnr;
	
	public Passenger() {
		
	}
	
	public Passenger(String passengerId,String firstName, String lastName, String email,String password, long mobNo , String pnr) {
		this.passengerId=passengerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password=password;
		this.mobNo = mobNo;
		this.pnr=pnr;;
	}



	public String getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(String passengerId) {
		this.passengerId = passengerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}
	
	public String getPassword() {
		return password;
	}
	
	public long getMobNo() {
		return mobNo;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}
	
	
}
