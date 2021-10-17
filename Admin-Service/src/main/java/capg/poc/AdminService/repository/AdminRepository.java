package capg.poc.AdminService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import capg.poc.AdminService.models.Admin;

@Repository
public interface AdminRepository extends MongoRepository<Admin, String> {

	@Query("{adminId : ?0}")
	Admin findByAdminId(String adminId);

}
