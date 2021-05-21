package com.cos.blog.domain.board;

import java.util.List;

import com.cos.blog.web.dto.BoardDetailDTO;

public class BoardDAO {

	// 상세보기시 Board 정보와 User 정보를 조인해서 가져올 함수
	// id만 알면 조인해서 가져오면 됨
	public BoardDetailDTO mDetail(int id) { // 내 필요에 의해 만든건 앞에 m을 붙여쥬자
		return null;
	}
	
	// get
	public Board findById(int id) { // id로 셀렉트
		return null;
	}
	
	// get
	public List<Board> findAll(){
		return null;
	}
	
	// post
	public int save(Board board) {
		return -1;
	}
	
	// post
	public int update(Board board) {
		return -1;
	}
	
	// post
	public int deleteById() {
		return -1;
	}
}
