package com.cos.blog.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.domain.user.User;
import com.cos.blog.domain.user.UserDAO;
import com.cos.blog.service.Action;
import com.cos.blog.util.Script;
// User!!!
public class UpdateFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 검증 후 글쓰기 또는 로그인 페이지로 가게하기
		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute("principal");

		if (principal == null) {
			Script.href("로그인을 해주세요", response);
			return;
		}
		// dto가 상세보기로 데이터를 들고가서 화면에 뿌렸으니까
		// updateForm 도 그렇게 돼야하지 않을까?

		int id = Integer.parseInt(request.getParameter("id"));

		UserDAO userDAO = UserDAO.getInstance(); // 싱글톤패턴
		User userUpEntity = userDAO.findById(id);
		
		

		if (userUpEntity != null) {
			// 얘는 무조건 가야하니까 이프 필요업
			//System.out.println("userUpEntity : "+userUpEntity.getId());
			
			request.setAttribute("userUpEntity", userUpEntity);
			RequestDispatcher dis = request.getRequestDispatcher("views/user/updateForm.jsp");
			dis.forward(request, response);
			
			
		} else {
			Script.back("잘못된 접근입니다", response);
		}
	}

}
