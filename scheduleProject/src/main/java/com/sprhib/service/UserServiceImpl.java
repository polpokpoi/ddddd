package com.sprhib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.UserDAO;
import com.sprhib.dao.UserDAOImpl;
import com.sprhib.model.DayPlan;
import com.sprhib.model.User;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Autowired
	PlanService planService;
	
	
	public UserDAO getUserDAO() {
		return userDAO;
	}

	public void addUser(User user) {
		userDAO.addUser(user);		
	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public User getUser(long id) {
		return userDAO.getUser(id);
	}

	public void deleteUser(int id) {
		userDAO.deleteUser(id);
	}

	public List<User> getUsers() {
		return userDAO.getUsers();
	}
	
	
	
	@Override
	public boolean addPlanIntoDB(long id, DayPlan dayPlan) {
		 
		User user = userDAO.getUser(id);
		user.getSchedules().get(0).getDayPlans().add(new DayPlan(dayPlan.getTitle(),
				planService.changeDateFormat(dayPlan.getStart()), planService.changeDateFormat(dayPlan.getEnd()),
				  dayPlan.getColor(),null ));  
	    userDAO.updateUser(user);
		
	    return true;
	}


	@Override
	public List<DayPlan> getUsersPlans(List<User> selectedUsers) {
		     List<DayPlan> plans = new ArrayList<DayPlan>();  
		         
		for ( User user : selectedUsers){
		     if((user = userDAO.getUser(user.getId()))!=null){
			plans.addAll( user.getSchedules().get(0).getDayPlans());
		     }
		     }
		  
		   
		return plans;
	}



}
