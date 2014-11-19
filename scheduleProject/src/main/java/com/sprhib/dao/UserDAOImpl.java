package com.sprhib.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.User;



@Repository
public class UserDAOImpl implements UserDAO{

   @Autowired
	private SessionFactory sessionFactory;

  
   
    public Session getCurrentSession() {
	        return sessionFactory.getCurrentSession();
	    }

	public void addUser(User user) {
		Session session = getCurrentSession();
		    /* if(checkIn(user)){
		    	 
		     }else{*/
			session.persist(user);
			
			//  session.save(user);
			//session.flush();
		     //}
	}
	
	public void updateUser(User user) {
		User userToUpdate = getUser(user.getId());
		userToUpdate.setName(user.getName());
		userToUpdate.setSchedules(user.getSchedules());
		getCurrentSession().merge(userToUpdate);
	}
	
	
	
	
	

	public User getUser(long id) {
		User user = (User) getCurrentSession().get(User.class, id);
		return user;
	}

	public void deleteUser(int id) {
		User user = getUser(id);
		if (user != null)
			getCurrentSession().delete(user);
	}

	
	@SuppressWarnings("unchecked")
	public List<User> getUsers() {
		return getCurrentSession().createQuery("from User").list();
	}

	
	public boolean checkIn(User user) {
		
	
			
		if(	getUser(user.getId()) ==null){
			return false;
		}
			
		
		  return true;
		  
		  
	}
	
	
	
}
