package edu.mum.cs.projects.attendance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.mum.cs.projects.attendance.domain.entity.security.User;
import edu.mum.cs.projects.attendance.service.UserService;

@Controller
public class AdminController {
	
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value="/createUser", method=RequestMethod.POST)
	public String createUser(@ModelAttribute ("user") User user){
		
		if(userService.createUser(user)!=null){
			return "redirect:/userInfo";	
		} else {
			return "error";
		}
			
	}
	
	@GetMapping("/userInfo")
	public String userInfo(Model model){
		List<User> userList = userService.findAllUser();
		model.addAttribute("userList", userList);
		return "userInfo";
	}
	
	
	
	
	@GetMapping("/userInfo/edit/{id}")
	public String getUserInfoEdit(Model model, @PathVariable("id") String userId){
		User user = userService.getUserById(Integer.parseInt(userId));
		
		System.out.println(user.getUserName());
		
		model.addAttribute("user", user);
		return "updateUser";	
	
	}
	
	@PostMapping("/updateUser")
	public String updateUser(@ModelAttribute("user")User user){
		System.out.println("user is going to be updated.");
		System.out.println("user name is: " + user.getUserName());
		userService.updateUser(user);
		System.out.println("user is updated");
		return "redirect:/userInfo";
	}

}
