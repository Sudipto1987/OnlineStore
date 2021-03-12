package com.project.springboot.onlinestore.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;




@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mob_no")
	private String mobNo;
	
	@Column(name="house_no")
	private String houseNo;
	
	@Column(name="locality")
	private String locality;
	
	@Column(name="state")
	private String state;
	
	@Column(name="pin")
	private String pin;
	
	@Column(name="type")
	private String userType;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_internal_id")
	private UserCredentials userCredentials;	
	
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "user", cascade = {CascadeType.PERSIST,CascadeType.REFRESH,CascadeType.DETACH,CascadeType.MERGE })
	private List<Orders> orders;
	
	
		
	public void add(Orders tempOrder) {
		
		if (orders==null) {
			
			orders=new ArrayList<>();			
		}
		
		orders.add(tempOrder);
		tempOrder.setUser(this);		
		
	}



	public Users() {}
	
	public Users(String firstName, String lastName, String email, String mobNo, String houseNo, String locality,
			String state, String pin, String userType, UserCredentials userCredentials, List<Orders> orders) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobNo = mobNo;
		this.houseNo = houseNo;
		this.locality = locality;
		this.state = state;
		this.pin = pin;
		this.userType = userType;
		this.userCredentials = userCredentials;
		this.orders = orders;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobNo() {
		return mobNo;
	}



	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}



	public String getHouseNo() {
		return houseNo;
	}



	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}



	public String getLocality() {
		return locality;
	}



	public void setLocality(String locality) {
		this.locality = locality;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getPin() {
		return pin;
	}



	public void setPin(String pin) {
		this.pin = pin;
	}



	public String getUserType() {
		return userType;
	}



	public void setUserType(String userType) {
		this.userType = userType;
	}



	public UserCredentials getUserCredentials() {
		return userCredentials;
	}



	public void setUserCredentials(UserCredentials userCredentials) {
		this.userCredentials = userCredentials;
	}



	public List<Orders> getOrders() {
		return orders;
	}



	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}
	
	

	


}
