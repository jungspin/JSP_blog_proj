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

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute("principal");

		if (principal == null) {
			Script.href("로그인을 해주세요", response);
			return;
		}

		int id = Integer.parseInt(request.getParameter("id"));

		UserDAO userDAO = UserDAO.getInstance();
		int result = userDAO.deleteById(id);

		if (result == 1) {
			session = request.getSession();
			session.invalidate();
			Script.href("탈퇴성공", response);
		} else {
			Script.back("다시 시도해주세요", response);
		}

	}

}
