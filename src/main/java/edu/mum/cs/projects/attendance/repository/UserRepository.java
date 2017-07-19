package edu.mum.cs.projects.attendance.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.attendance.domain.entity.security.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	@Modifying
	@Query("UPDATE User u SET u.userName = userName, u.password = password, u.studentId= studentId, u.facultyId= facultyId, u.roleId= roleId WHERE u.userId= userId")
	int userUpdate(int userId, String userName, String password, int roleId, int studentId, int facultyId);
	
	User findByUserName(String name);
	List<User> findAll();
	User findByUserId(int id);
	
}
