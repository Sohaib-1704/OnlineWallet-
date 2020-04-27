package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.example.demo.dao.ProfileDAO;
import com.example.demo.entity.Profile;

@Service(value = "profileService")
@EnableTransactionManagement
public class ProfileServiceImpl implements ProfileService
{
	private ProfileDAO profileDAO;
	@Autowired
	public ProfileServiceImpl(ProfileDAO profileDAO)
	{
		this.profileDAO = profileDAO;
	}
	
	@Override
	@Transactional
	public ResponseEntity<List<Profile>> showAllProfiles() 
	{
		return ResponseEntity.ok().body(profileDAO.showAll());
	}

	@Override
	@Transactional
	public ResponseEntity<Profile> showById(int id) 
	{
		return ResponseEntity.ok().body(profileDAO.showById(id));
	}

	@Override
	@Transactional
	public void deleteProfile(int id) 
	{
		profileDAO.delete(profileDAO.showById(id));
	}

	@Override
	public void updateProfie(Profile profile) 
	{
		profileDAO.update(profile);
	}

}
