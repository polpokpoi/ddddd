package com.sprhib.service;

import java.util.List;

import com.sprhib.model.DayPlan;
import com.sprhib.model.User;

public interface UserService {
	
	public void addUser(User user);
	public void updateUser(User user);
	public User getUser(long id);
	public void deleteUser(int id);
	public List<User> getUsers();
	 public boolean addPlanIntoDB(long id, DayPlan dayPlan); // dayplan 저장하기 
	 public List<DayPlan> getUsersPlans(List<User> selectedUsers );
	
}
