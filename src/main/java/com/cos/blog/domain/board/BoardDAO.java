package com.cos.blog.domain.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.domain.CrudDAO;
import com.cos.blog.web.dto.BoardDetailDTO;

public class BoardDAO implements CrudDAO<Board> { // T는 변수

	private static BoardDAO instance = new BoardDAO();

	private BoardDAO() {
	} // 외부에서 new 하는걸 막음

	public static BoardDAO getInstance() {
		return instance;
	}

	// 상세보기시 Board 정보와 User 정보를 조인해서 가져올 함수
	// id만 알면 조인해서 가져오면 됨
	public BoardDetailDTO mDetail(int id) {
		// 상세보기시 필요한 것들
		// Board : id, (title, content, created), userId
		// User : username
		BoardDetailDTO boardDetailDTO = new BoardDetailDTO();
		String sql = "SELECT b.id, b.title, b.content, u.id, u.username, b.created FROM boards b INNER JOIN users u ON b.userId=u.id WHERE b.id = ?";

		try {
			Connection conn = DBConn.디비연결(); // 얘는 무조건 필요!

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(); // 결과(row)를 리턴

			while (rs.next()) {
				boardDetailDTO.setId(rs.getInt(1)); // 충돌나니까 어느 테이블의 뭔지 적어줘야됨
				boardDetailDTO.setTitle(rs.getString(2)); // 컬럼의 순서로도 가능
				boardDetailDTO.setContent(rs.getString(3));
				boardDetailDTO.setUserId(rs.getInt(4));
				boardDetailDTO.setUsername(rs.getString(5));
				boardDetailDTO.setCreated(rs.getTimestamp(6));

			}

//			System.out.println("=======================");
//			System.out.println(boardDetailDTO);
//			System.out.println("=======================");

			return boardDetailDTO;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Board findById(int id) {
		return null;
	}

	// findAll 오버로딩 -> 이름으로 검색하는거 할건데 잠만
//	public List<Board> findAll(String username) {
//		List<Board> boards = new ArrayList<>();
//		// 전체보기 할때는 보통 ORDEY BY 써주고 최신데이터가 앞에 나오게 해줌
//		String sql = "SELECT * FROM boards ORDER BY user DESC";
//
//		try {
//			Connection conn = DBConn.디비연결(); // 얘는 무조건 필요!
//
//			PreparedStatement pstmt = conn.prepareStatement(sql);
//			ResultSet rs = pstmt.executeQuery(); // 결과(row)를 리턴
//
//			while (rs.next()) {
//				Board board = new Board();
//				board.setId(rs.getInt("id"));
//				board.setTitle(rs.getString("title"));
//				board.setContent(rs.getString("content"));
//				board.setUserId(rs.getInt("userId"));
//				board.setCreated(rs.getTimestamp("created"));
//
//				boards.add(board);
//			}
//			return boards;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}

	// findAll 오버로딩
	public List<Board> findAll(int page) {
		List<Board> boards = new ArrayList<>();
		// StringBuffer -> 동시접근 불가능
		// StringBulider -> 동시접근 가능
		StringBuffer sb = new StringBuffer();
		sb.append("select * from");
		sb.append("(");
		sb.append("select id, title, content, userId, created, rownum as num from boards order by id DESC");
		sb.append(")");
		sb.append("where num > ? and num <= ?");
		// page 쿼리에 바로 넣는거 아니라고 했지 기억나지

		try {
			Connection conn = DBConn.디비연결(); // 얘는 무조건 필요!

			PreparedStatement pstmt = conn.prepareStatement(sb.toString());
			pstmt.setInt(1, page * 3);
			pstmt.setInt(2, (page + 1) * 3);
			ResultSet rs = pstmt.executeQuery(); // 결과(row)를 리턴

			while (rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt("id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setUserId(rs.getInt("userId"));
				board.setCreated(rs.getTimestamp("created"));

				boards.add(board);
			}
			return boards;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Board> findAll() {
		List<Board> boards = new ArrayList<>();
		// 전체보기 할때는 보통 ORDEY BY 써주고 최신데이터가 앞에 나오게 해줌
		String sql = "SELECT * FROM boards ORDER BY id DESC";

		try {
			Connection conn = DBConn.디비연결(); // 얘는 무조건 필요!

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // 결과(row)를 리턴

			while (rs.next()) {
				Board board = new Board();
				board.setId(rs.getInt("id"));
				board.setTitle(rs.getString("title"));
				board.setContent(rs.getString("content"));
				board.setUserId(rs.getInt("userId"));
				board.setCreated(rs.getTimestamp("created"));

				boards.add(board);
			}
			return boards;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int save(Board data) {
		String sql = "INSERT INTO boards(id, title, content, userId, created) "
				+ "VALUES(boards_seq.nextval,?,?,?,SYSDATE)";

		try {
			Connection conn = DBConn.디비연결();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			Board board = (Board) data;
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());
			pstmt.setInt(3, board.getUserId());

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
<<<<<<< HEAD
			
=======

>>>>>>> 471ce3a (board CRUD COMPLETE)
		}
		return -1;
	}

	@Override
	public int update(Board data) {
		// % 사용하려면 !! (쿼리문에 그냥 넣으면 안됨)
		// pstmt.setString(1, "%"+name+"%");
		String sql = "UPDATE boards SET title = ?, content = ? WHERE id = ? ";

		try {
			Connection conn = DBConn.디비연결(); // 얘는 무조건 필요!

			PreparedStatement pstmt = conn.prepareStatement(sql);
			Board board = (Board) data;
			pstmt.setString(1, board.getTitle());
			pstmt.setString(2, board.getContent());

			pstmt.setInt(3, board.getId());

			// System.out.println(board);
			int result = pstmt.executeUpdate(); // 변경된 행의 개수를 리턴

			return result;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	@Override
	public int deleteById(int id) {
		String sql = "DELETE FROM item WHERE id = ?";

		try {
			Connection conn = DBConn.디비연결(); // 얘는 무조건 필요!

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;   
	}

}
