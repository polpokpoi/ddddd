package com.sprhib.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sprhib.dao.UserDAO;
import com.sprhib.model.DayPlan;
import com.sprhib.model.User;
@Service
@Transactional
public class LoginServiceImpl implements LoginService {

	
	@Autowired
	UserDAO userDAO;
	
  

	ArrayList facebookWithDBFriendList = new ArrayList();
	
	
	
	  public ArrayList getFacebookWithDBFriendList() {
			return facebookWithDBFriendList;
		}

		public void setFacebookWithDBFriendList(ArrayList facebookWithDBFriendList) {
			this.facebookWithDBFriendList = facebookWithDBFriendList;
		}
	
	public User getFacebookDBUser(User user) {
		
		 
	    if(userDAO.checkIn(user)){
	    	 
	    	 user = userDAO.getUser(user.getId());
	    	 
	     }else{
		    userDAO.addUser(user);
		    
	    	 
	     }	
	    return user ;
	}

	
	
public List<com.sprhib.model.User> getFacebookWithDBFriendUserList(List<com.sprhib.model.User> facebookFriendList) {
		
	   
		for(com.sprhib.model.User friend : facebookFriendList){
			
			if(userDAO.getUser(Long.valueOf(friend.getId()).longValue())==null ){
				
				facebookWithDBFriendList.add(new User(Long.valueOf(friend.getId()).longValue(),friend.getName(),false ));
				
			}else{
				
				facebookWithDBFriendList.add(0,userDAO.getUser(Long.valueOf(friend.getId()).longValue()));
			}
			
		//System.out.println(friend.getName());
			
			
		}
		
		
		
		return facebookWithDBFriendList;
	}


   public String getLoginUserPlansJsonType(long id) {
	
	
	
	com.sprhib.model.User user = userDAO.getUser(id);
    user.getSchedules().get(0).getId();
     List<DayPlan> dayPlansList =  user.getSchedules().get(0).getDayPlans();

                       
      String json = new Gson().toJson(dayPlansList);
      
     
	return json;
}



}
