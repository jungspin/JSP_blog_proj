package com.cos.blog.service.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.domain.user.User;
import com.cos.blog.service.Action;
import com.cos.blog.util.Script;

public class SaveFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 검증 후 글쓰기 또는 로그인 페이지로 가게하기
		HttpSession session = request.getSession();
//		if (session.getAttribute("principal") != null) {
//			response.sendRedirect("views/board/saveForm.jsp");
//		} else {
//			Script.href("로그인을 해주세요", response);
//		}
		
		User principal = (User) session.getAttribute("principal");
		
		if (principal != null) {
			response.sendRedirect("views/board/saveForm.jsp");
		} else {
			Script.href("로그인을 해주세요", response);
		}
		
	}

}
