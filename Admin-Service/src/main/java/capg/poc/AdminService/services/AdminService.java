package capg.poc.AdminService.services;

import java.util.List;

import capg.poc.AdminService.models.Admin;

public interface AdminService {
	
	Admin getAdminId(String AdminId);
	List<Admin> getAllAdmins();

}
