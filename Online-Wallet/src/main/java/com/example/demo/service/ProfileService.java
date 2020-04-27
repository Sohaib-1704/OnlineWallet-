package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Profile;

public interface ProfileService 
{
	public ResponseEntity<List<Profile>> showAllProfiles();
	public ResponseEntity<Profile> showById(int id);
	public void updateProfie(Profile profile);
	public void deleteProfile(int id);
}
