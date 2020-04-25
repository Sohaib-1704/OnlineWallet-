package com.cap.service;

import java.util.List;

import com.cap.entity.Profile;

public interface ProfileService {
	 public void createProfile(Profile profile);
	  public List<Profile> showAll();
	  public Profile showProfile(int userId);
		  
}
