package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Profile;
import com.example.demo.service.ProfileService;

@RestController
@RequestMapping("/api")
public class ProfileController 
{
	private ProfileService profileService;
	@Autowired
	public ProfileController(ProfileService profileService) 
	{
		super();
		this.profileService = profileService;
	}
	
	@GetMapping("/profiles")
	public ResponseEntity<List<Profile>> showAllProfiles()
	{
		return profileService.showAllProfiles();
	}
	
	@PutMapping("/profiles")
	public void updateProfile(@RequestBody Profile profile)
	{
		profileService.updateProfie(profile);
	}
	
	@DeleteMapping("/profiles/{id}")
	public void deleteProfile(@PathVariable int id)
	{
		profileService.deleteProfile(id);
	}
	
	@GetMapping("/profiles/{id}")
	public ResponseEntity<Profile> getById(@PathVariable int id)
	{
		return profileService.showById(id);	
	}
}
