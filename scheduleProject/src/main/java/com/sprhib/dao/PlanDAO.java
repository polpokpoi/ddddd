package com.sprhib.dao;

import java.util.List;

import com.sprhib.model.Plan;

public interface PlanDAO {

	

		public void addPlan(Plan dayPlan);
		public void updatePlan(Plan dayPlan);
		public Plan getPlan(long id);
		public void deletePlan(int id);
		public List<Plan> getPlans();
		public boolean checkIn(Plan dayPlan);
		
	

	
}
