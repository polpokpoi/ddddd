package com.sprhib.service;


import java.util.List;

import com.sprhib.model.DayPlan;
import com.sprhib.model.User;

public interface LoginService {
	
    
	public User getFacebookDBUser(User user); //dbcheck�ϰ� , db���� user��������
	public List<User> getFacebookWithDBFriendUserList(List<com.sprhib.model.User> facebookFriendList);//db���� friend�������
    public String getLoginUserPlansJsonType(long id);  //home�� LoginUser�� ID�� �޾Ƽ�  user�� Plan�� ����.
   
}
