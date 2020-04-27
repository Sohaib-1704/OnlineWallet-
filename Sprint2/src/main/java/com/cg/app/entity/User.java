package com.cg.app.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "userlog")
public class User {
 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "email", unique=true,length=50)
    @NotBlank(message = "Email is mandatory")
	private String email;
	
	@Column(name = "firstname",length=25)
    @NotBlank(message = "Firstname is mandatory")
	private String firstname;
	
	@Column(name = "lastname",length=25)
    @NotBlank(message = "Lastname is mandatory")
	private String lastname;
	
	@Column(name = "password",length=50)
    @NotBlank(message = "Password is mandatory")
	private String password;
 
	@Column(name = "confimrPassword",length=50)
    @NotBlank(message = "ConfirmPassword is mandatory")
	private String confirmPassword;
	
	@Column(name = "phoneNumber",length=10)
    @NotBlank(message = "PhoneNumber is mandatory")
	private String phoneNumber;
	
	public enum type{admin,user};
	@Enumerated(EnumType.STRING)
	private type userType;
	
	public enum login{LoggedIn,LoggedOut};
	@Enumerated(EnumType.STRING)
	private login loginStatus;
	
	public User() {
		
	}
	public User(String email,String firstname,String lastname,String password,String confirmPassword,String phoneNumber) {
		this.email=email;
		this.firstname=firstname;
		this.lastname=lastname;
		this.password=password;
		this.confirmPassword=confirmPassword;
		this.phoneNumber=phoneNumber;
	}
	public User(String email,String password) {
		this.email=email;
		this.password=password;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public type getUserType() {
		return userType;
	}
	public void setUserType(type userType) {
		this.userType = userType;
	}
	public login getLoginStatus() {
		return loginStatus;
	}
	public void setLoginStatus(login loginStatus) {
		this.loginStatus = loginStatus;
	}
}