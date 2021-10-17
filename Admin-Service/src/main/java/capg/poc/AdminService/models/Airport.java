package capg.poc.AdminService.models;

public class Airport 
{
	private String id;
	private String name;
	private String city;
	private String country;
	
	public Airport() {
	}
	
	public Airport(String id, String name, String city, String country) {
		
		this.id = id;
		this.name = name;
		this.city = city;
		this.country = country;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getCity() {
		return city;
	}
	public String getCountry() {
		return country;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
