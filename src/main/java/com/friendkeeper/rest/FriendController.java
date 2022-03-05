package com.friendkeeper.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friendkeeper.entity.Friend;
import com.friendkeeper.service.FriendService;

@RestController
@RequestMapping("/api/friends")
public class FriendController {
	
	@Autowired FriendService service;
	
	@GetMapping("")
	public List<Friend> getFriends(){
		return service.getFriends();
	}
	
	@GetMapping("/{id}")
	public Friend getFriend(@PathVariable int id) {
		Friend friend = service.getFriend(id);
		if(friend == null) {
			throw new FriendNotFoundException("Friend not found.");
		}
		return friend;
	}
	
	@PostMapping("")
	public Friend addFriend(@RequestBody Friend friend) {
		friend.setId(0);
		service.saveFriend(friend);
		return friend;
	}
	
	@PutMapping("")
	public Friend updateFriend(@RequestBody Friend friend) {
		service.saveFriend(friend);
		return friend;
	}
	
	@DeleteMapping("/{id}")
	public String deleteFriend(@PathVariable int id) {
		Friend friend = service.getFriend(id);
		if(friend == null) {
			throw new FriendNotFoundException("Friend not found.");
		}
		service.deleteFriend(id);
		return "Deleted friend successfully.";
	}
}
