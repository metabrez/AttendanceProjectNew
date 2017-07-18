package edu.mum.cs.projects.attendance.domain.entity.security;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.mum.cs.projects.attendance.domain.entity.Faculty;
import edu.mum.cs.projects.attendance.domain.entity.Role;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import org.hibernate.annotations.Immutable;

import edu.mum.cs.projects.attendance.domain.Identifiable;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Entity
@Immutable
@Table(name="user")
public class User implements Identifiable<String>, UserDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;

	@Column(name="username", columnDefinition = "nvarchar(25)")
    private String userName;

	@Column(name="password", columnDefinition = "nvarchar(25)")
    private String password;

	@OneToOne
	@JoinColumn(name="studentId", columnDefinition = "nvarchar(50)")
	private Student student;
	
	@OneToOne
	@JoinColumn(name="facultyId", columnDefinition = "int")
	private Faculty faculty;
	
	@OneToOne
	@JoinColumn(name="roleId", columnDefinition = "int")
	private Role role;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}

	public String getUsername(){
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Faculty getFaculty() {
		return faculty;
	}

	public void setFaculty(Faculty faculty) {
		this.faculty = faculty;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
//		role.forEach(ur -> authorities.add(new Authority(ur.getRole().getName())));
		authorities.add(new Authority(role.getName()));
		return authorities;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getId() {
		return getUserId()+"";
	}
}
