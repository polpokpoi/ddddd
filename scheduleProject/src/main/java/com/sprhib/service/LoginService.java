package com.sprhib.service;


import java.util.List;

import com.sprhib.model.DayPlan;
import com.sprhib.model.User;

public interface LoginService {
	
    
	public User getFacebookDBUser(User user); //dbcheck하고 , db에서 user가저오기
	public List<User> getFacebookWithDBFriendUserList(List<com.sprhib.model.User> facebookFriendList);//db에서 friend갖고오기
    public String getLoginUserPlansJsonType(long id);  //home에 LoginUser의 ID를 받아서  user의 Plan을 쏴줌.
   
}
