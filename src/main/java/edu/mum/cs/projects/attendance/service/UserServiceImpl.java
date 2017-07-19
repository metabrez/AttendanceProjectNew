package edu.mum.cs.projects.attendance.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.projects.attendance.domain.entity.security.User;
import edu.mum.cs.projects.attendance.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(User user) {
		
		 return userRepository.save(user);
		
	}
	@Override
	public List<User> findAllUser() {
		return userRepository.findAll();
	}
	@Override
	public User getUserById(int id) {
		return userRepository.findByUserId(id);
	}
	@Override
	public int updateUser(User user) {
		
		return userRepository.userUpdate(user.getUserId(),user.getUserName(), user.getPassword(), user.getRoleId(), user.getStudentId(), user.getFacultyId());
	}

}
