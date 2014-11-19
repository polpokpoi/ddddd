package com.sprhib.Init;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;

import com.sprhib.model.DayPlan;
import com.sprhib.model.LecturePlan;
import com.sprhib.model.Schedule;
import com.sprhib.model.User;
import com.sprhib.service.UserService;

public class InitImpl implements Init{
   
	 @Autowired
	 UserService userService;

	
	public void enterInitDBUser() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		
		
		
		
		
		
		
		
		
		
		
	   User user1 = new User();
	   
	        user1.setId(100001699874421l);
	        user1.setName("Hyeong Cheol Kim");
	        user1.setType(true);
	        
	   
	   Schedule scheudle1 = new Schedule();
	      
		
	   
	   
	   DayPlan dayplan1= new DayPlan();
	                     String start1String ="2013-12-10";
	                     String end1String = "2013-12-11";
	                     Date end1  = dateFormat.parse(end1String);
		                 Date start1 =  dateFormat.parse(start1String);
	             dayplan1.setStart(start1);
	             dayplan1.setEnd(end1);
	             dayplan1.setTitle("dayplan1");
	             dayplan1.setColor("red");
	             
	           scheudle1.getDayPlans().add(dayplan1);
	        
	         user1.getSchedules().add(scheudle1) ;
	    
	         
	         System.out.println(user1.getId());
	         
	      userService.addUser(user1);
	   
	   
	      
	

		   User user2 = new User();
		   
		        user2.setId(100001883561096l);
		        user2.setName("Park Ja Seung");
		        user2.setType(true);
		        
		   
		   Schedule scheudle2 = new Schedule();
		    
		   
		   DayPlan dayplan2= new DayPlan();
		                     String start2String ="2013-12-11";
		                     String end2String = "2013-12-12";
		                     Date end2  = dateFormat.parse(end1String);
			                 Date start2 =  dateFormat.parse(start1String);
		             dayplan2.setStart(start2);
		             dayplan2.setEnd(end2);
		             dayplan2.setTitle("dayplan2");
		             dayplan2.setColor("red");
		          
		           scheudle2.getDayPlans().add(dayplan2);
		         
		         user2.getSchedules().add(scheudle2) ;
		         
		         
		         System.out.println(user2.getId());
		         
		      userService.addUser(user2);
		   
	    
	    
	    

			   User user3 = new User();
			   
			        user3.setId(100002574379154l);
			        user3.setName("Ji Hyeon  Shin");
			        user3.setType(true);
			        
			   
			   Schedule scheudle3 = new Schedule();
			    
			   
			   DayPlan dayplan3= new DayPlan();
			                     String start3String ="2013-12-11";
			                     String end3String = "2013-12-12";
			                     Date end3  = dateFormat.parse(end3String);
				                 Date start3 =  dateFormat.parse(start3String);
			             dayplan3.setStart(start3);
			             dayplan3.setEnd(end3);
			             dayplan3.setTitle("dayplan3");
			             dayplan3.setColor("red");
			          
			           scheudle3.getDayPlans().add(dayplan3);
			         
			         user3.getSchedules().add(scheudle3) ;
			         
			         
			         
			         
			      userService.addUser(user3);
			   
		      
		     
	    
	    
	    
	
		
		
	}
	 
	
}
