package com.cos.blog.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.service.Action;

public class LoginAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// loginForm 에서 받은 데이터 유효성 검사
		// 아이디랑 비밀번호 null 아닌지, 일치하는지?
		// 같은 정보가 있는지 db에 select (findByUsernameAndPassword)
		// result 받기
		// 결과값 리턴되는거 확인, 세션에 저장해야하나? 로그아웃도 있던데..
		
	}

}
