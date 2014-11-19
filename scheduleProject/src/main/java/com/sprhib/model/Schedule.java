package com.sprhib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;





import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.IndexColumn;



@Entity
@Table(name="Schedule")
public class Schedule implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -851141461045933127L;

	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Schedule_Id")
	private int id;
	
	
	private String title;

	@ManyToOne( fetch = FetchType.EAGER)
	//@JoinTable(name="Schedule_User", joinColumns=@JoinColumn(name="Schedule_Id"),inverseJoinColumns=@JoinColumn(name="User_Id"))
    private User user;	
	
	

	/**
	 * @return the user
	 */
	
	@Fetch( FetchMode.SELECT  )
	@OneToMany( fetch = FetchType.EAGER ,cascade=CascadeType.ALL)
	private List<DayPlan> dayPlans = new ArrayList<DayPlan>();
	
	@Fetch(FetchMode.SELECT)
	@OneToMany(fetch = FetchType.EAGER ,cascade=CascadeType.ALL)
	private List<LecturePlan> lecturePlans = new ArrayList<LecturePlan>();
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	
	public List<DayPlan> getDayPlans() {
		return dayPlans;
	}
	public void setDayPlans(List<DayPlan> dayPlans) {
		this.dayPlans = dayPlans;
	}
	
	public List<LecturePlan> getLecturePlans() {
		return lecturePlans;
	}
	public void setLecturePlans(List<LecturePlan> lecturePlans) {
		this.lecturePlans = lecturePlans;
	
	}
	

	
	
	
	
}
