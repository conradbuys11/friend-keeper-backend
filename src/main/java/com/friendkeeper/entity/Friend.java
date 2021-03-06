package com.friendkeeper.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="friend")
public class Friend {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name="id") private int id;
	@Column(name="first_name") private String firstName;
	@Column(name="last_name") private String lastName;
	
	@JsonBackReference @ManyToOne(cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}) 
	@JoinColumn(name="user_id") private FKUser user;
	
	public Friend() {
		
	}
	
	public Friend(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Friend(String firstName, String lastName, FKUser user) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.user = user;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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

	public FKUser getUser() {
		return user;
	}

	public void setUser(FKUser user) {
		this.user = user;
	}
}
