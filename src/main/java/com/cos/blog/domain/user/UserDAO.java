package com.cos.blog.domain.user;

import java.util.List;

import com.cos.blog.domain.board.Board;

public class UserDAO {

	
	// 중복검사는 담에 혼자 해바
	
	
	public User findByUsernameAndPassword(String username, String password) {
		return null;
	}
	
	
	// default
	// get
	public User findById(int id) { // id로 셀렉트
		return null;
	}

	// get
	public List<Board> findAll() {
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
	public int deleteById() {
		return -1;
	}
}
