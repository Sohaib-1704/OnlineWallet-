package com.cap.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;

import com.cap.entity.Profile;

public class ProfileDaoImplementation implements ProfileDao
{
	@Autowired
    private EntityManager entityManager;
	@Override
	public void createProfile(Profile profile) {
		Session session=entityManager.unwrap(Session.class);
		session.save(profile);
		
	}

	@Override
	public List<Profile> showAll() {
		Session session =entityManager.unwrap(Session.class);
		List <Profile> profile=new ArrayList<>();
		TypedQuery<Profile> profilequery=session.createQuery("from profile",Profile.class);
		profile=profilequery.getResultList();
		return profile;
	}

	@Override
	public Profile showProfile(int userId) {
		Session session =entityManager.unwrap(Session.class);
		Profile profile=session.get(Profile.class, userId);
		return profile; 
		
	}

	
}