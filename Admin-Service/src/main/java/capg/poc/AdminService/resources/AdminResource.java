package capg.poc.AdminService.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import capg.poc.AdminService.models.Admin;
import capg.poc.AdminService.services.AdminService;


@RestController
public class AdminResource {
	
	@Autowired
	private AdminService adminService;
	
	@RequestMapping("/admin")
	public List<Admin> getAllAdmins()
	{
		return adminService.getAllAdmins();
	}
	
	@RequestMapping("/{adminId}")
	public Admin getPassengerId(@PathVariable("adminId") String adminId)
	{
		return adminService.getAdminId(adminId);
	}

}
