package edu.mum.cs.projects.attendance.service;

import java.util.List;

import edu.mum.cs.projects.attendance.domain.entity.security.User;

public interface UserService {
	
	public User createUser(User user);
	
	public List<User> findAllUser();

	public User getUserById(int id);
	
	public int updateUser(User user);

	public User findByUserName(String userName);
}
