package com.cap.dao;

import java.util.List;

import com.cap.entity.Profile;

public interface ProfileDao 
{
  public void createProfile(Profile profile);
  public List<Profile> showAll();
  public Profile showProfile(int userId);
	  
  
}
