package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Profile;


public interface ProfileDAO
{
	public List<Profile> showAll();
	public Profile showById(int id);
	public void delete(Profile profile);
	public void update(Profile profile);
}
