package capg.poc.AdminService.models;

public class Admin {
	
	private String firstName;
	private String lastName;
	private String email;
	private long mobNo;
	private Address address;
	
	public Admin() {
	}
	
	public Admin(String firstName, String lastName, String email, long mobNo, Address address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobNo = mobNo;
		this.address = address;
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
	public Address getAddress() {
		return address;
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
	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Admin [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", mobNo=" + mobNo
				+ ", address=" + address + "]";
	}

}
