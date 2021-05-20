package com.cos.blog.domain.board;

import java.util.List;

import com.cos.blog.web.dto.BoardDetailDTO;

public class BoardDAO {
	
	// 상세보기시 Board 정보와 User 정보를 조인해서 가져올 함수
	public BoardDetailDTO mDetail(int id) { // 내가 만들었으니까 m 을 붙였엉
		return null;
	}
	
	// 공통적인 애들 먼저 만들기
	
	// get
	public Board findById(int id) { // 한건 찾기
		return null;
	}
	
	// get
	public List<Board> findAll() { // 모두 찾기
		return null;
	}
	
	// post
	public int save(Board board) {
		return -1;
	}
	
	// post
	public int update(Board board)	{
		return -1;
	}
	
	// post
	public int deleteById(int id) {
		return -1;
	}
}
