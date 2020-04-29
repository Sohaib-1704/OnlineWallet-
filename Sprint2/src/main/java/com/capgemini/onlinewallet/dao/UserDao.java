package com.capgemini.onlinewallet.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinewallet.entity.User;
import com.capgemini.onlinewallet.entity.User.login;
import com.capgemini.onlinewallet.entity.User.type;

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
	public List<User> retrieveData() {
		String Qstr = "SELECT user FROM User user";
		TypedQuery<User> query = entityManager.createQuery(Qstr, User.class);
		return query.getResultList();
	}

	@Override
	public boolean findUserByEmail(String email) {
		String Qstr = "SELECT user.email FROM User user WHERE user.email= :email";
		TypedQuery<String> query = entityManager.createQuery(Qstr, String.class).setParameter("email", email);
		try {
			query.getSingleResult();
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	@Override
	public User getUserByEmail(String email) {
		String Qstr = "SELECT user FROM User user WHERE user.email= :email";
		TypedQuery<User> query = entityManager.createQuery(Qstr, User.class).setParameter("email", email);
		return query.getSingleResult();
	}

	@Override
	public Boolean delete(int id) {
		User user = entityManager.find(User.class, id);
		if (user != null) {
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
	public boolean findId(int id) {
		if (entityManager.contains(entityManager.find(User.class, id))) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateFullName(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		userUpdate.setFirstname(user.getFirstname());
		userUpdate.setLastname(user.getLastname());
		entityManager.persist(userUpdate);
		return true;
	}

	@Override
	public boolean updatePassword(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		userUpdate.setPassword(user.getPassword());
		entityManager.persist(userUpdate);
		return true;
	}

	@Override
	public boolean updatePhoneNumber(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		userUpdate.setPhoneNumber(user.getPhoneNumber());
		entityManager.persist(userUpdate);
		return true;
	}

	@Override
	public boolean updateUserToAdmin(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		userUpdate.setUserType(type.admin);
		;
		entityManager.persist(userUpdate);
		return true;
	}

	@Override
	public boolean updateToUser(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		userUpdate.setUserType(type.user);
		;
		entityManager.persist(userUpdate);
		return true;
	}

	@Override
	public boolean updateLogoutStatus(User user, String email) {
		User userUpdate = getUserByEmail(email);
		if (userUpdate.getLoginStatus() == login.LoggedIn)
			return false;
		userUpdate.setLoginStatus(login.LoggedIn);
		entityManager.persist(userUpdate);
		return true;
	}

	@Override
	public boolean updateLoginStatus(User user, int id) {
		User userUpdate = entityManager.find(User.class, id);
		if (userUpdate.getLoginStatus() == login.LoggedOut)
			return false;
		userUpdate.setLoginStatus(login.LoggedOut);
		entityManager.persist(userUpdate);
		return true;
	}
}