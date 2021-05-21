package com.cos.blog.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.service.Action;

public class LogoutAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 얘는 값 받아올게 없지? get 요청아닌가..?
		// 세션을 날려야하는거 아니야..? 디비까지 갈 일 있나
		
	}

}
