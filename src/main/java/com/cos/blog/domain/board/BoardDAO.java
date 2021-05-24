package com.cos.blog.domain.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import com.cos.blog.config.DBConn;
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
	public List<Board> findAll() {
		return null;
	}

	// post
	public int save(Board board) {
		String sql = "INSERT INTO boards (id, title, content, userId, created) "
									+ "VALUES(boards_seq.nextval,?,?,?,SYSDATE)";

		try {
			Connection conn = DBConn.디비연결();

			PreparedStatement pstmt = conn.prepareStatement(sql); // 프로토콜이 적용된 버퍼

			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			//pstmt.setString(3, board.getTitle()); // userId 어케 하냐
		

			return pstmt.executeUpdate(); // 변경된 행의 갯수 리턴

		} catch (Exception e) {
			e.printStackTrace();
		}
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
