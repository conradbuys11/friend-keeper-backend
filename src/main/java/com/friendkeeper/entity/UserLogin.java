package com.friendkeeper.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_login")
public class UserLogin {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id") private int id;
	@OneToOne(mappedBy="login", cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) private FKUser user;
	@Column(name="username") private String username;
	@Column(name="password") private long password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public long getPassword() {
		return password;
	}
	public void setPassword(long password) {
		this.password = password;
	}
	
	public FKUser getUser() {
		return user;
	}
	public void setUser(FKUser user) {
		this.user = user;
	}
	
	public UserLogin() {
		
	}
	
	public UserLogin(String username, long password) {
		this.username = username;
		this.password = password;
	}	
}
