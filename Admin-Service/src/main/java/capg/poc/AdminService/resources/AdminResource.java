package capg.poc.AdminService.resources;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capg.poc.AdminService.models.Admin;
import capg.poc.AdminService.models.Flight;
import capg.poc.AdminService.models.Passenger;
import capg.poc.AdminService.services.AdminService;

@RestController
@RequestMapping("/admins")
public class AdminResource {
	
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/all")
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}
	
	@GetMapping("/{adminId}")
	public Admin findByAdminId(@PathVariable("adminId") String adminId){
		return adminService.findByAdminId(adminId);
	}
	
	@PostMapping("/register")
	public void addAdmin(@RequestBody Admin admin) {
		adminService.addAdmin(admin);	
	}
	
	@PutMapping("/{adminId}")
	public void updateAdmin(@RequestBody Admin admin , @PathVariable String adminId ) {
		adminService.updateAdmin(adminId, admin);	
	}
	
	@DeleteMapping("/{adminId}")
	public void deleteAdmin(@PathVariable String adminId) {
		adminService.deleteAdmin(adminId);	
	}
	
	@GetMapping("/passengers")
	public List<Passenger> getAllPassengers(){
		return adminService.getAllPassengers();
	}
	
	@DeleteMapping("passengers/{passengerId}")
	public void deletePassenger(@PathVariable String passengerId) {
		adminService.deletePassenger(passengerId);
	}
	
	@PostMapping("/flights")
	public void addFlights(@RequestBody Flight flight) {
		adminService.addFlights(flight);
	}
	
	@DeleteMapping("/flights/{flightId}")
	public void deleteFlight(@PathVariable String flightId) {
		adminService.deleteFlight(flightId);
	}
}

