package com.cap.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cap.dao.ProfileDao;
import com.cap.entity.Profile;


public class ProfileServiceImplementation implements ProfileService {
	@Autowired
	private ProfileDao profiledao;
	@Override
	public void createProfile(Profile profile) {
		// TODO Auto-generated method stub
		return profiledao.createProfile(profile);
	}

	@Override
	public List<Profile> showAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Profile showProfile(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
