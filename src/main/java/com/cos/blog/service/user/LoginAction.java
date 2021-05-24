package com.cos.blog.service.user;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserDAO;
import com.cos.blog.service.Action;
import com.cos.blog.util.ModValid;
import com.cos.blog.util.Script;


public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // void 여도 return 가능
		// 1. 유효성 검사 -> postman 으로 하면 리콰이어 안먹음
		// ?username=ssar, ?username=, ?
//		if (request.getParameter("username")==null || request.getParameter("username").equals("")) {
//			return;
//		}else if (request.getParameter("password")==null || request.getParameter("password").equals("")) {
//			return;
//		}else if (request.getParameter("email")==null || request.getParameter("email").equals("")) {
//			return;
//		}else if (request.getParameter("address")==null || request.getParameter("address").equals("")) {
//			return;
//		}
		
//		ModValid modValid = new ModValid();
//		List<String> keys = Arrays.asList("username","password");
//		if (modValid.mVaild(keys,request, response).equals("실패")) {
//			System.out.println("실패");
//			return;
//		}
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
	
		
		UserDAO userDAO = new UserDAO();
		// entity 는 데이터베이스와 동기화된 User 오브젝트
		User userEntity = userDAO.findByUsernameAndPassword(username, password);
		
		
		// 5. 1일때, 1아닐때를 분기해서  1-> 로그인페이지(sendR) / !1-> joinForm페이지로 보내기
		if (userEntity != null) {
			HttpSession session = request.getSession();
			// ${pricipal}
			session.setAttribute("pricipal", userEntity); // pricipal 인증주체
			// session.invalidate(); -> 로그아웃 코드
			response.sendRedirect("/blog");
		}else {
			//System.out.println("회원가입 실패, 콘솔에 오류를 확인하세요.");
			Script.back("로그인실패", response);
		}
		
	}
	
}
