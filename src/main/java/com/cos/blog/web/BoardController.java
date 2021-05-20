package com.cos.blog.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// http://localhost:8000/blog/board
@WebServlet("/board")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	public void doProcess(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 1. null과 공백 접근 금지 (유효성 검사)
		if(request.getParameter("cmd")==null || request.getParameter("cmd").equals("") ) {
			return;
		}
		
		// 하나의 컨트롤러에서 다양한 요청을 받아 분기해주기
		String cmd = request.getParameter("cmd"); 
		
		
	}

	private void router(String cmd) { // process 가 얘를 때릴거얌, 역할 : 분기
		
		if (cmd.equals("joinForm")) { // form 적혀있으면 전부 sendRedirect
			
		} else if (cmd.equals("join")) { // joinProc
			
		} else if (cmd.equals("loginForm")) { 
			
		} else if (cmd.equals("login")) {
			
		} else if (cmd.equals("updateForm")) {
			
		} else if (cmd.equals("update")) {
			
		} else if (cmd.equals("logout")) {
			
		}
	}
}
