package com.cos.blog.domain.user;

import java.util.List;

public class UserDAO {

	public User findByUsernameAndPasswod(String username, String password) {
		return null;
	}
	
	// default
	// get
	public User findById(int id) { // 한건 찾기
		return null;
	}

	// get
	public List<User> findAll() { // 모두 찾기
		return null;
	}

	// post
	public int save(User board) {
		return -1;
	}

	// post
	public int update(User board) {
		return -1;
	}

	// post
	public int deleteById(int id) {
		return -1;
	}
}
