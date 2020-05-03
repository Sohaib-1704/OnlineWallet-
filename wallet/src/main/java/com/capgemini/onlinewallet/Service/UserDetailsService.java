package com.capgemini.onlinewallet.Service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.capgemini.onlinewallet.dto.UserDetails;
/**********************Service Interface******************************/
public interface UserDetailsService 
{
	public ResponseEntity<List<UserDetails>> showAllUsers();
	public ResponseEntity<UserDetails> findById(int id);
	public ResponseEntity<String> updateUserDetails(UserDetails userDetails,int id);
	public ResponseEntity<String> delete(int id);
}
