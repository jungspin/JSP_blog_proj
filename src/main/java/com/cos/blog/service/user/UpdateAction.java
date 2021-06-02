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
// User!!!!
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

		// 유효성 검사 -> 로직이 좀 달라서(썸머노트) 얘는 일단 빼
		// key 값에 files가 있네....
//		ModValid modValid = new ModValid();
//		List<String> keys = Arrays.asList("title", "content");
//
//		if (modValid.mVaild(keys, request, response) != 1) {
//			System.out.println("실패");
//			return;
//		}
		// 공통로직 끝

		// 핵심 로직
		int id = Integer.parseInt(request.getParameter("id"));
		//System.out.println("id : " + id);
		
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
		
		//System.out.println(user);


		UserDAO userDAO = UserDAO.getInstance(); // 싱글톤패턴
		int result = userDAO.update(user);

		System.out.println(result);
		// 수정하면 세션 다시
		if (result == 1) {
			session = request.getSession();
			session.setAttribute("principal", user);
			response.sendRedirect("/blog");
		} else {
			Script.back("정보수정실패", response);
		}
		// 공통로직 끝
	}

}
