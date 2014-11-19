package com.sprhib.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sprhib.model.Plan;



@Repository
public class DayPlanDAOImpl implements PlanDAO{

   @Autowired
	private SessionFactory sessionFactory;

 
   
    public Session getCurrentSession() {
	        return sessionFactory.getCurrentSession();
	    }

	public void addPlan(Plan plan) {
		Session session = getCurrentSession();
		   
			session.persist(plan);
			
	}
	
	public void updatePlan(Plan plan) {
		Plan planToUpdate = getPlan(plan.getId());
		planToUpdate.setTitle(plan.getTitle());
		planToUpdate.setStart(plan.getStart());
		planToUpdate.setEnd(plan.getStart());
        planToUpdate.setColor(plan.getColor());
        getCurrentSession().merge(planToUpdate);
	}
	
	
	
	
	

	public Plan getPlan(long id) {
		Plan plan = (Plan) getCurrentSession().get(Plan.class, id);
		return plan;
	}

	public void deletePlan(int id) {
		Plan plan = getPlan(id);
		if (plan != null)
			getCurrentSession().delete(plan);
	}

	
	@SuppressWarnings("unchecked")
	public List<Plan> getPlans() {
		return getCurrentSession().createQuery("from Plan").list();
	}

	
	public boolean checkIn(Plan plan) {
		
	
			
		if(	getPlan(plan.getId()) ==null){
			return false;
		}
			
		
		  return true;
		  
		  
	}
	
	public int deletePlan(Plan plan){
		
		//dayplan instance of ... 그리고 not lectureplan일떄 if()
		System.out.println(plan.getTitle()+plan.getStart()+plan.getEnd());
		//Query deleteQuery = getCurrentSession().createQuery("delete from DayPlan d where d.title = :title " + " and d.end = :end "
		//		 + "and start = :start ");
		
		Query getDayPlan = getCurrentSession().createQuery("from DayPlan d where "+
															 " d.title = :title and " +
															  "d.end = :end and "  + 
															  "d.start = :start");
		
		getDayPlan.setParameter("title", plan.getTitle());
		getDayPlan.setParameter("end",plan.getEnd());
		getDayPlan.setParameter("start", plan.getStart());
		System.out.println(getDayPlan.list());      
		return getDayPlan.executeUpdate();
	}
	
	
	
}
