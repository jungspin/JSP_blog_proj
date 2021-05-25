package com.cos.blog.service.user;

import java.io.IOException;
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
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException { // void
																															// 가능
		// 1. 유효성 검사
		ModValid vh = new ModValid();
		List<String> keys = Arrays.asList("username", "password");

		if (vh.mVaild(keys, request, response) != 1) {
			System.out.println("유효성 검사 실패");
			return;
		}

		// 2. http body 데이터 변수로 받아야 됨
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDAO userDAO = UserDAO.getInstance();
		// Entity 데이터베이스랑 동기화 된 User 오브젝트
		User userEntity = userDAO.findByUsernameAndPassword(username, password);

		if (userEntity != null) {
			// 체크가 되었고, 로그인이 완료되었고 => response 의 header 에 Cookie를 저장해서 날리세요
			// key 값은 똑같이 rememberMe를 들고 있는게 낫겠지
			// 브라우저는 rememberMe == ssar 을 가지고 있으면 된다
			// 브라우저는 요청시마다 쿠키값을 서버에게 자동전송한다.
			// 서버는 쿠키에 접근해서 rememberMe 값을 가져와서 변수에 저장한다.
			
			
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
