package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "profile")
public class Profile 
{
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	@Column(name = "user_name")
	private String name;
	@Column(name = "phone_number")
	private long phoneNumber;
	@Column(name = "email")
	private String email;
	@Column(name = "status")
	private boolean status;
	
	public Profile()
	{
		super();
	}

	public Profile(String name, long phoneNumber,
								String email, boolean status) 
	{
		super();
		this.name= name;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.status = status;
	}



	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public boolean isStatus() 
	{
		return status;
	}

	public void setStatus(boolean status) 
	{
		this.status = status;
	}
	
}
