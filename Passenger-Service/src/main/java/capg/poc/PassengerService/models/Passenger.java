package capg.poc.PassengerService.models;

public class Passenger 
{
	private String firstName;
	private String lastName;
	private String email;
	private long mobNo;
	
	public Passenger() {
		
	}
	
	public Passenger(String firstName, String lastName, String email, long mobNo) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobNo = mobNo;
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

	public void setMobNo(long mobNo) {
		this.mobNo = mobNo;
	}
	
	
}
