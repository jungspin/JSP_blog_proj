package com.cos.blog.service.board;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cos.blog.domain.board.Board;
import com.cos.blog.domain.board.BoardDAO;
import com.cos.blog.domain.user.User;
import com.cos.blog.service.Action;
import com.cos.blog.util.ModValid;
import com.cos.blog.util.Script;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통로직시작 -> 세션검증과 유효성 검사 (인증이 필요한 부분)
		// 여기도 세션 검증해야겠지? -> DRY 하게 만들어
		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute("principal");

		if (principal == null) {
			response.sendRedirect("views/board/saveForm.jsp");
		} else {
			Script.href("로그인을 해주세요", response);
		}

		// 유효성 검사 -> 필요없음 들어올 값 없음. get 요청
		// 공통로직 끝

		// 핵심 로직
		int id = Integer.parseInt(request.getParameter("id"));

		BoardDAO boardDAO = BoardDAO.getInstance(); // 싱글톤패턴
		int result = boardDAO.deleteById(id);

		// 공통로직 (아직 신경쓰지마)
		// 끝나면 로그 남기고, 특정 페이지로 이동
		if (result == 1) {
			response.sendRedirect("/blog");
		} else {
			Script.back("삭제실패", response);
		}
		// 공통로직 끝
	}

}
