package com.study.repository;

import java.util.ArrayList;
import java.util.List;

import com.study.domain.User;

public class UserRepository { // 싱글톤
	
	
	private static UserRepository instance = null; 
	private List<User> userList;
	
	private UserRepository() {
		userList = new ArrayList<>();
	}
	
	public static UserRepository getInstance() {
		if(instance == null) {
			instance = new UserRepository();
		}
		return instance;
	}
	
	public void saveUser(User user) {
		System.out.println("저장소에 사용자 등록");
		userList.add(user);
	}
	
	public User findUserbyUsername(String username) {
		User user = null;
		
		for(User u : userList) {
			if(u.getUsername().equals(username)) {
				user = u;
				break;
			}
		}
		return user;
	}
	
	public void ShowUserAll() {
		System.out.println("[등록된 사용자 조회]");
		userList.forEach(user -> {
			System.out.println(user);
		});
	}
}
