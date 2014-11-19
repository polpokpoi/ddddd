package com.sprhib.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sprhib.dao.DayPlanDAOImpl;
import com.sprhib.dao.PlanDAO;
import com.sprhib.model.Plan;
import com.sprhib.service.*;

@Service
@Transactional
public class PlanServiceImpl implements PlanService{
    
	
	
	@Autowired
	public DayPlanDAOImpl DayPlanDAO;
	
	public Date changeDateFormat(Date date) {
		               
		  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		  
		  String Sdate = dateFormat.format(date);
		  
		   try {
			date = dateFormat.parse(Sdate);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return date;
	}

	
	public Date changeStringIntoDate(String date){
		        
		              
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		                
		   Date formatedDate = new Date();
		  try {
			formatedDate = dateFormat.parse(date);
		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return formatedDate ;
	
	}



	public int deletePlan(Plan plan) {
		 
		return  DayPlanDAO.deletePlan(plan);
	}
	
	

}
