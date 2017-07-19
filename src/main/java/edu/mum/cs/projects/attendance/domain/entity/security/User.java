package edu.mum.cs.projects.attendance.domain.entity.security;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Immutable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import edu.mum.cs.projects.attendance.domain.Identifiable;
import edu.mum.cs.projects.attendance.domain.entity.Role;

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

	@JoinColumn(name="studentId", columnDefinition = "nvarchar(50)")
	private int studentId;
	
	@JoinColumn(name="facultyId", columnDefinition = "int")
	private int facultyId;
	
	@JoinColumn(name="roleId", columnDefinition = "int")
	private int roleId;
	
	@OneToOne
	@Transient
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
	
	

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getFacultyId() {
		return facultyId;
	}

	public void setFacultyId(int facultyId) {
		this.facultyId = facultyId;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
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
