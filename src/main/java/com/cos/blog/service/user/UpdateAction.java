package com.cos.blog.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserDAO;
import com.cos.blog.service.Action;
import com.cos.blog.util.Script;

// User!!!!!!!!!
public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통로직시작 -> 세션검증과 유효성 검사 (인증이 필요한 부분)
		// 여기도 세션 검증해야겠지? -> DRY 하게 만들어
		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute("principal");

		if (principal == null) {
			Script.href("로그인을 해주세요", response);
			return;
		}

		// 핵심 로직
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String address = request.getParameter("address");

		User user = new User();
		user.setId(id);
		user.setUsername(username);
		user.setPassword(password);
		user.setEmail(email);
		user.setAddress(address);

		UserDAO userDAO = UserDAO.getInstance(); // 싱글톤패턴
		int result = userDAO.update(user);

		System.out.println(result);
		// 공통로직 (아직 신경쓰지마)
		// 끝나면 로그 남기고, 특정 페이지로 이동
		if (result == 1) {
			session = request.getSession();
			session.setAttribute("principal", user);
			response.sendRedirect("/blog");
		} else {
			Script.back("회원정보수정 실패", response);
		}
		// 공통로직 끝
	}

}
