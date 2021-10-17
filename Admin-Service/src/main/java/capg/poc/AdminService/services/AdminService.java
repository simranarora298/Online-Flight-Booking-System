package capg.poc.AdminService.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import capg.poc.AdminService.models.Admin;
import capg.poc.AdminService.models.Flight;
import capg.poc.AdminService.models.Passenger;
import capg.poc.AdminService.repository.AdminRepository;
import capg.poc.AdminService.repository.FlightRepository;
import capg.poc.AdminService.repository.PassengerRepository;


@Service
public class AdminService {
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	

	public List<Admin> getAllAdmins() { 
		List<Admin> admins = new ArrayList<>(); 
		adminRepository.findAll() 
		.forEach(admins::add);
		
		return admins; 
	}
	
	public Admin findByAdminId(String adminId) {
		return adminRepository.findByAdminId(adminId);
	}

	public void addAdmin(Admin admin) {
		
		  Admin admin2 = adminRepository.findByAdminId(admin.getAdminId());
		  if(admin2==null) { adminRepository.save(admin); }else {
		  System.out.println("Admin already exists."); }
		 
			}
	
	public void updateAdmin(String adminId , Admin admin) {
		adminRepository.save(admin);	
	}
	
	public void deleteAdmin(String adminId) {
		adminRepository.deleteById(adminId);	
	}

	public List<Passenger> getAllPassengers() {
		return passengerRepository.findAll();
	}

	public void deletePassenger(String passengerId) {
		
		  Passenger pass = passengerRepository.findPassengerById(passengerId);
		  if(pass!=null) { passengerRepository.deleteById(passengerId); }else {
		  System.out.println("Can't delete it as  User doesn't exist."); }
		 
	}

	public void addFlights(Flight flight) {
		
		  Flight flight2 = flightRepository.findByFlightId(flight.getFlightId()); if
		  (flight2==null) { 
			  flightRepository.save(flight); 
			  }else {
		  System.out.println("Flight already exist."); 
		  }
	}

	public void deleteFlight(String flightId) {
		
		  Flight flight = flightRepository.findByFlightId(flightId); if(flight!=null) {
		  flightRepository.deleteById(flightId); }else {
		  System.out.println("Can't delete it as Flight doesn't exist."); }
		
	}
	
}
