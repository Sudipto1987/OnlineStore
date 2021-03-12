package com.project.springboot.onlinestore.Entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="user_credentials")
public class UserCredentials {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="user_internal_id")
	private int userInternalId;
	
	@Column(name="login_name")
	private String loginName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="last_successful_login")
	private Date lastSuccessfulLogin;
	
	@Column(name="last_failed_login")
	private Date lastFailedLogin;
	
	@Column(name="failed_attempts")
	private int failedAttempts;
	
	@Column(name="blocked")
	private String blocked;
	
	@Column(name="blocked_until")
	private Date blockedUntil;

	@JsonIgnore
	@OneToOne(mappedBy="userCredentials", 
			cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH}) //To setup bidirectional mapping 
	private Users user;
	
	
	
	

	public UserCredentials(String loginName, String password, Date lastSuccessfulLogin, Date lastFailedLogin,
			int failedAttempts, String blocked, Date blockedUntil, Users user) {
		super();
		this.loginName = loginName;
		this.password = password;
		this.lastSuccessfulLogin = lastSuccessfulLogin;
		this.lastFailedLogin = lastFailedLogin;
		this.failedAttempts = failedAttempts;
		this.blocked = blocked;
		this.blockedUntil = blockedUntil;
		this.user = user;
	}
	
	public UserCredentials() {}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getLastSuccessfulLogin() {
		return lastSuccessfulLogin;
	}

	public void setLastSuccessfulLogin(Date lastSuccessfulLogin) {
		this.lastSuccessfulLogin = lastSuccessfulLogin;
	}

	public Date getLastFailedLogin() {
		return lastFailedLogin;
	}

	public void setLastFailedLogin(Date lastFailedLogin) {
		this.lastFailedLogin = lastFailedLogin;
	}

	public int getFailedAttempts() {
		return failedAttempts;
	}

	public void setFailedAttempts(int failedAttempts) {
		this.failedAttempts = failedAttempts;
	}

	public String getBlocked() {
		return blocked;
	}

	public void setBlocked(String blocked) {
		this.blocked = blocked;
	}

	public Date getBlockedUntil() {
		return blockedUntil;
	}

	public void setBlockedUntil(Date blockedUntil) {
		this.blockedUntil = blockedUntil;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
	
	
	
	

}
