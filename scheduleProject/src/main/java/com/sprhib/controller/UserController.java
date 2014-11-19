package com.sprhib.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.sprhib.Init.Init;
import com.sprhib.Init.InitImpl;
import com.sprhib.model.DayPlan;
import com.sprhib.model.LecturePlan;
import com.sprhib.model.Schedule;
import com.sprhib.model.User;
import com.sprhib.service.LoginService;
import com.sprhib.service.PlanService;
import com.sprhib.service.UserService;
import com.sprhib.servicefacebook.FacebookService;
import com.sprhib.servicefacebook.FacebookServiceImpl;

@Controller
public class UserController {

	@Autowired
	Init init ; 
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private PlanService planService;
	
	private long tempId;
	
	public long getTempId() {
		return tempId;
	}





	public void setTempId(long tempId) {
		this.tempId = tempId;
	}
	@Autowired
	private FacebookServiceImpl facebookService;

	
	
	@RequestMapping(value = "/deletePlan.mju", method= RequestMethod.GET )
	public @ResponseBody
	String deletePlan(@RequestParam(value="title")String title,
					  @RequestParam(value="start")String start,
					  @RequestParam(value="end")String end ){
		
		System.out.println("title="+title+"start="+start.toString()+"end="+end.toString());
		
		Date DStart = planService.changeStringIntoDate(start);
		Date DEnd = planService.changeStringIntoDate(end);
		
		
		
		planService.deletePlan(new DayPlan(title,DStart,DEnd,null,null));
		
	
		
		return "good";
		
		
	}
	
	

	
	
	
	
	
	
	
	
	@RequestMapping(value = "/getPlan/{id}.mju", method = RequestMethod.GET)
    @ResponseBody
    public String getPlan(HttpServletResponse response, @PathVariable long id) {
	
		
		System.out.println("���̵�"+id);
	    
		        
	   String json = loginService.getLoginUserPlansJsonType(id);
	
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
       
      
        return json;
      
       
    }
	
	@RequestMapping(value = "/insertUsersEvents.mju", method = RequestMethod.POST )
    public @ResponseBody String insertEvents( @RequestBody List<User> users, ModelMap map) {    
	    
	   for( User user : users){
	     System.out.println(user.getId());
	   }
	      
	  List<DayPlan> plans = userService.getUsersPlans(users);
	      
			String json = new Gson().toJson(plans);
			System.out.println(json);
			
	      return json;
	  }
	

	

	
	
	//this method response to POST request http://localhost/spring-mvc-json/rest/cont/person
	  // receives json data sent by client --> map it to Person object
	  // return Person object as json
	@RequestMapping(value = "/addPlan.mju", method = RequestMethod.POST )
      public @ResponseBody boolean post( @RequestBody DayPlan dayPlan, ModelMap map) {    
	    
	
	       
	                                     
	      return userService.addPlanIntoDB(this.getTempId(), dayPlan );
	  }
	
	
	
	@RequestMapping(value = "/addPlan/{id}.mju", method = RequestMethod.GET )
	@ResponseBody
    public void addPlan(@PathVariable long id) {    
	    
	     this.setTempId(id);
	     
	     
	     
	     
	  }
	
	
	
	
	
	@RequestMapping(value="/start.mju")
	public String start() {
		
		return "start";
	}
	
	

	@RequestMapping(value="/test.mju")
	public String test() {

		return "home2";
	}
	
	@RequestMapping(value="/getTest.mju")
	public void getTest() {
		System.out.println("ddd");
		
	}
	
	
	
		
	@RequestMapping(value = "/callback.mju", method = RequestMethod.GET)
	public String handleRequestInternal(
			@RequestParam(value = "code", required = false) String code,
			ModelMap model) throws Exception {
	     System.out.println("dd");
	    //  init.enterInitDBUser();   // ���� ���̵�, �̸� , schedule db�ֱ� 
		 facebookService.initFacebookInfo(code);  
		 //facebookinit���� loginuser�� �������µ�
		 // com.restfb.types.User ����  ==> User�� friend�� com.spr.hib.model.User�� �ٲ㼭 �����´�.
		 
		 //�׸��� ������ User�� UserFriends�� 
		 User loginUser = loginService.getFacebookDBUser(facebookService.getLoginUser()); //DB���� �����´�. ������ �ְ� ��������
		
		 List friendsList = loginService.getFacebookWithDBFriendUserList(facebookService.getFriendList());
		//DB�� �ִ� ģ���� ��Ͽ� index�� �Ǿ�����, �ƴ� �ֵ��� �ڷ� �ؼ� �����´�. 
         		 
		 
		 
		 
		 
		 
		 
		 
	model.put("dayPlan", new DayPlan());	 
	 model.put("user", loginUser);
	 model.put("friendsList",friendsList );
         
		
		 
	
		return "home";
	}
	
	
	
	
	
	
	@RequestMapping(value = "/home.mju", method = RequestMethod.POST)
	public String addingUser(@ModelAttribute User user, ModelMap model) throws Exception {
				
		
		
		    
		return "home";
	}

	
	
	
	





}