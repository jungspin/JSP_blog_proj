package com.cos.blog.domain.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cos.blog.config.DBConn;
import com.cos.blog.domain.CrudDAO;

public class UserDAO implements CrudDAO<User> {

	// 중복검사는 담에 혼자 해바

	public User findByUsernameAndPassword(String username, String password) {
		User user = new User();
		String sql = "SELECT * FROM users WHERE id = ? AND password = ?";
		
		try {
			Connection conn = DBConn.디비연결();
			PreparedStatement pstmt = conn.prepareStatement(sql); 
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery(); // 결과(row)를 리턴
			
			while (rs.next()) {
				user.setUsername(rs.getString("id"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setAddress(rs.getString("address"));
			}
			
			return user;
		} catch (Exception e) {
			
		}
		return null;
	}

	@Override
	public User findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int save(User data) {
		// 쿼리 망가트려서 Script.back() 함수 테스트 해보기
		String sql = "INSERT INTO users(id, username, password, email, address, created) "
				+ "VALUES(users_seq.nextval,?,?,?,?,SYSDATE)";
		
		// 자바에서도 시간을 넣을 수 있대~!
		// LocalDateTime.now(); -> 서버의 시간 / db의 timestamp
		// Timestamp now =  Timestamp.valueOf(LocalDateTime.now());
		
		try {
			Connection conn = DBConn.디비연결();

			PreparedStatement pstmt = conn.prepareStatement(sql); // 프로토콜이 적용된 버퍼
			User user = (User)data;
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

	@Override
	public int update(User data) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteById() {
		// TODO Auto-generated method stub
		return 0;
	}

}
