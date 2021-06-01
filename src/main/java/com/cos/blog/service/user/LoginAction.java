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

public class LoginAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { 
																															
		// 1. 유효성 검사
//		ModValid vh = new ModValid();
//		List<String> keys = Arrays.asList("username", "password", "rememberMe");
//
//		if (vh.mVaild(keys, request, response) != 1) {
//			System.out.println("유효성 검사 실패");
//			return;
//		}

		// 2. http body 데이터 변수로 받아야 됨
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String cookie = request.getParameter("rememberMe");

//		if (cookie == null) {
//			System.out.println("cookie is " + cookie );
//			return;
//		}

		UserDAO userDAO = UserDAO.getInstance();
		// Entity 데이터베이스랑 동기화 된 User 오브젝트
		User userEntity = userDAO.findByUsernameAndPassword(username, password);

		if (userEntity != null && cookie == null) { // 체크 하지 않고, 로그인이 완료되었고
			//response.setHeader("Set-Cookie", "");

			HttpSession session = request.getSession();
			session.setAttribute("principal", userEntity);
			response.sendRedirect("/blog");
			
		} else if (userEntity != null && cookie.equals("on")) {
			// 체크가 되었고, 로그인이 완료되었고 => response 의 header 에 Cookie를 저장해서 날리세요
			// key 값은 똑같이 rememberMe를 들고 있는게 낫겠지
			// 브라우저는 rememberMe == ssar 을 가지고 있으면 된다
			response.setHeader("Set-Cookie", "rememberMe=" + username);

//			Cookie cook = new Cookie("rememberMe", username);
//			response.addCookie(cook);

			// 리퀘스트에 세션이 있는게 아니고 리퀘스트를 통해서 세션 공간에 접근!!
			HttpSession session = request.getSession();
			// ${principal} != null
			session.setAttribute("principal", userEntity);
			// principal 접근주체, 인증주체
			// session.invalidate(); -> 세션무효화 코드
		
			
			response.sendRedirect("/blog");
		} else { // 로그인 실패
			Script.back("로그인실패", response);
		}

	}

}
