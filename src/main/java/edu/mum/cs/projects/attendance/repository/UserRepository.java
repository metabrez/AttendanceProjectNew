package edu.mum.cs.projects.attendance.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.mum.cs.projects.attendance.domain.entity.security.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	User findByUserName(String name);
}
