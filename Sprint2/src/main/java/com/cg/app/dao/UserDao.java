package com.cg.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.app.entity.User;

@Transactional
@Repository("userDao")
public class UserDao implements UserDaoInterface {
	
	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public User signUp(User user) {
		entityManager.persist(user);
		return user;
	}
	@Override
	public List<User> reterive() {
		String Qstr="SELECT user FROM User user";
		TypedQuery<User> query=entityManager.createQuery(Qstr,User.class);
		return query.getResultList();		
	}
	
	 @Override
	   	public boolean findUserByEmail(String email){
	   		String Qstr="SELECT user.email FROM User user WHERE user.email= :email";
	   		TypedQuery<String> query=entityManager.createQuery(Qstr,String.class).setParameter("email",email);
	   		try{
	   			query.getSingleResult();
	   		}
	   		catch(Exception ex){
	   			return false;
	   		}
	   		return true;
	   	}
		@Override 
		public User getUserByEmail(String email){
			String Qstr="SELECT user FROM User user WHERE user.email= :email";
	   		TypedQuery<User> query=entityManager.createQuery(Qstr,User.class).setParameter("email",email);
	   		return query.getSingleResult();
		}
		@Override
		public User getUser(Integer userId){   
			User user=entityManager.find(User.class, userId);
	        return user;
		}
		@Override
		public Boolean delete(int id) {
			User user = entityManager.find(User.class, id);
			if(user!=null){
				entityManager.remove(user);
				return true;
			}
		return false;
		}
		@Override
		public User findById(int id) {
			return entityManager.find(User.class, id);
		}
		@Override
		public boolean findId(int id){
			if(entityManager.contains(entityManager.find(User.class, id))){
				return true;
			}
			return false;
		}
		@Override
		public boolean update(User user,int id) {
			User userUpdate=  entityManager.find(User.class, id);
			userUpdate.setFirstname(user.getFirstname());
			userUpdate.setLastname(user.getLastname());
			userUpdate.setPassword(user.getPassword());
			userUpdate.setPhoneNumber(user.getPhoneNumber());
			entityManager.persist(userUpdate);
			return true;
		}
}