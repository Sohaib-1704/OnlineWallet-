package com.cg.app.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
	public void update(User user) {
		  User userUpdate= entityManager.find(User.class, user.getId());
		  userUpdate.getEmail();
		  userUpdate.getFirstname();
		  userUpdate.getLastname();
		  userUpdate.getPassword();
		  userUpdate.getPhoneNumber();
		  entityManager.persist(userUpdate);
		
	}
	@Override
	public User findByEmail(String email) {
	    User user = null;
	    Query query = entityManager.createQuery("SELECT u FROM User u WHERE u.email=:email");
	    query.setParameter("email", email);
	    try {
	        user = (User) query.getSingleResult();
	    } catch (Exception e) {
	        // Handle exception
	    }
	    return user;
	}
	@Override
	public boolean findEmail(String email){
		if(entityManager.contains(entityManager.find(User.class, email))){
			return true;
		}
		return false;
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
}