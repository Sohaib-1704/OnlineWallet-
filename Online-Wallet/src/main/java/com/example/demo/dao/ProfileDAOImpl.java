package com.example.demo.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Profile;

@Repository(value = "profileDAO")
public class ProfileDAOImpl implements ProfileDAO
{
	private EntityManager entityManager;
	@Autowired
	public ProfileDAOImpl(EntityManager entityManager) 
	{
		super();
		this.entityManager = entityManager;
	}

	@Override
	public List<Profile> showAll() 
	{
		return entityManager.createQuery("from Profile",Profile.class).getResultList();
	}

	@Override
	public Profile showById(int id) 
	{
		return entityManager.find(Profile.class, id);
	}

	@Override
	public void delete(Profile profile) 
	{
		entityManager.remove(profile);
	}

	@Override
	public void update(Profile profile) 
	{
		TypedQuery<Profile> query = entityManager.createQuery("update PROFILE set user_name :=? WHERE id:=?",Profile.class);
		query.setParameter(1,profile.getName());
		query.setParameter(2, profile.getUserId());
		query.executeUpdate();
		
	}

}
