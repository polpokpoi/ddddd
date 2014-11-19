package com.sprhib.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.sprhib.service.UserService;

@Entity
@Table(name = "User")
public class User implements Serializable {

	

	private static final long serialVersionUID = 5191154850678391084L;


	public  User(){}
	
	public  User(long id, String name,boolean type){
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	
	
	@Id
	@Column(name="User_Id")
	private long id;
	private String name;
	private boolean type;
/*  
	@ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy="user")
	private List<User> friends = new ArrayList<User>();
	*/
 
   

	//@OneToMany(mappedBy="user", fetch = FetchType.EAGER ,cascade = CascadeType.ALL )
	@OneToMany( fetch = FetchType.EAGER ,cascade = CascadeType.ALL )
     private List<Schedule> schedules = new ArrayList<Schedule>();

	
	/*
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="friends")
	private Set<User> User = new HashSet<User>();
	
	

	@ManyToMany(fetch = FetchType.EAGER ,cascade = {CascadeType.ALL})
	@JoinTable(name="USER_FRIEND", joinColumns={@JoinColumn(name="USER_ID")}, 
			inverseJoinColumns={@JoinColumn(name="FRIEND_ID")})
	private Set<User> friends = new HashSet<User>();
	
	public Set<User> getFriends() {
		return friends;
	}

	public void setFriends(Set<User> friends) {
		this.friends = friends;
	}


	*
	*
	*
	*/
	
	
	
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
	
	public boolean isType() {
		return type;
	}

	public void setType(boolean type) {
		this.type = type;
	}

	public List<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}

}
