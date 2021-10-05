package capg.poc.AdminService.models;

public class Address {
	
	private String houseNo;
	private String street;
	private String city;
	private String state;
	private long zip;
	private String country;
	
	public Address() {
	}
	
	public Address(String houseNo, String street, String city, String state, long zip, String country) {
		super();
		this.houseNo = houseNo;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.country = country;
	}

	public String getHouseNo() {
		return houseNo;
	}

	public String getStreet() {
		return street;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public long getZip() {
		return zip;
	}

	public String getCountry() {
		return country;
	}

	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setZip(long zip) {
		this.zip = zip;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [houseNo=" + houseNo + ", street=" + street + ", city=" + city + ", state=" + state + ", zip="
				+ zip + ", country=" + country + "]";
	}
	
}
