package com.cos.blog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.service.Action;
import com.cos.blog.service.board.DeleteAction;
import com.cos.blog.service.user.JoinAction;
import com.cos.blog.service.user.JoinFormAction;
import com.cos.blog.service.user.LoginFormAction;
import com.cos.blog.service.user.LogoutAction;
import com.cos.blog.service.user.UpdateAction;
import com.cos.blog.service.user.UpdateFormAction;
import com.cos.blog.service.user.LoginAction;

// http://localhost:8000/blog/user
// 경로는 모델이름으로 해주렴
@WebServlet("/user")
public class UserController extends HttpServlet {
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
		if (request.getParameter("cmd")==null || request.getParameter("cmd").equals("")) {
			return;
		}
		
		String cmd = request.getParameter("cmd");
		Action action = router(cmd); // 책임이 분리가 되었다
		
		if (action != null) {
			action.execute(request, response);
		}
	}
	// router 에게 객체 생성을 위임하고 결과를 응답받음
	private static Action router(String cmd) {
		
		if(cmd.equals("joinForm")) { 
			return new JoinFormAction();
		} else if(cmd.equals("join")) { 
			return new JoinAction();
		} else if(cmd.equals("loginForm")) {
			return new LoginFormAction();
		} else if(cmd.equals("login")) {
			return new LoginAction();
		} else if(cmd.equals("updateForm")) {
			return new UpdateFormAction();
		} else if(cmd.equals("update")) {
			return new UpdateAction();
		} else if(cmd.equals("logout")) {
			return new LogoutAction();
		} 
		return null;
	}
	
}

