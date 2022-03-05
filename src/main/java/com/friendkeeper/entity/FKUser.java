package com.friendkeeper.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class FKUser {

	@Id @GeneratedValue @Column(name="id") private int id;
	@Column(name="first_name") private String firstName;
	@Column(name="last_name") private String lastName;
	@Column(name="email") private String email;
	@OneToOne(cascade=CascadeType.ALL) @JoinColumn(name="user_login_id") UserLogin login;
	@OneToMany(mappedBy="friend", cascade=CascadeType.ALL) List<Friend> friends;

	public FKUser() {
		
	}

	public FKUser(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public UserLogin getLogin() {
		return login;
	}

	public void setLogin(UserLogin login) {
		this.login = login;
	}

	public List<Friend> getFriends() {
		return friends;
	}

	public void setFriends(List<Friend> friends) {
		this.friends = friends;
	}
	
	public void addFriend(Friend friend) {
		if(friends == null) {
			friends = new ArrayList<>();
		}
		friends.add(friend);
	}
}
