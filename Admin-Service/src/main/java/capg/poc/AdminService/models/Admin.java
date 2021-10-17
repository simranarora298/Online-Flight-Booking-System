package capg.poc.AdminService.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "admin")
public class Admin {
	
	@Id
	private String adminId;
	private String firstName;
	private String lastName;
	private String email;
	private long mobNo;
	private Address address;
	
	public Admin() {
	}
	
	public Admin(String adminId, String firstName, String lastName, String email, long mobNo, Address address) {
		this.adminId=adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobNo = mobNo;
		this.address = address;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
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
}
