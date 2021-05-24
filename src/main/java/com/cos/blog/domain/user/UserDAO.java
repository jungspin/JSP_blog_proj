package com.cos.blog.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.domain.board.Board;


public class UserDAO {

	// 중복검사는 담에 혼자 해바

	public User findByUsernameAndPassword(String username, String password) {
		String sql = "SELECT username, password FROM users;";

		try {
			Connection conn = DBConn.디비연결();

			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(); // 결과(row)를 리턴

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// default
	// get
	public User findById(int id) { // id로 셀렉트
		User user = new User();
		// 기본키이기 때문에 중복될 리 없음 그래서 무조건 한건만 나옴
		String sql = "SELECT * FROM product WHERE id = ?";

		try {
			Connection conn = DBConn.디비연결(); // 얘는 무조건 필요!

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery(); // 결과(row)를 리턴

			while (rs.next()) {
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));

			}
			return user;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// get
	public List<User> findAll() {
		List<User> users = new ArrayList<>();
		// 전체보기 할때는 보통 ORDEY BY 써주고 최신데이터가 앞에 나오게 해줌
		String sql = "SELECT * FROM product ORDER BY id DESC"; 
		
		try {
			Connection conn = DBConn.디비연결(); // 얘는 무조건 필요!
			
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			ResultSet rs = pstmt.executeQuery(); // 결과(row)를 리턴
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
				users.add(user);
			}
			return users;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	// post
	public int save(User user) {

		String sql = "INSERT INTO users(id, username, password, email, address, created) "
				+ "VALUES(users_seq.nextval,?,?,?,?,SYSDATE)";

		try {
			Connection conn = DBConn.디비연결();

			PreparedStatement pstmt = conn.prepareStatement(sql); // 프로토콜이 적용된 버퍼

			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getAddress());

			return pstmt.executeUpdate(); // 변경된 행의 갯수 리턴

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;

	}

	// post
	public int update(User user) {
		return -1;
	}

	// post
	public int deleteById() {
		return -1;
	}
}
