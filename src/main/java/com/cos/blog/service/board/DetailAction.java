package com.cos.blog.service.board;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.domain.board.Board;
import com.cos.blog.domain.board.BoardDAO;
import com.cos.blog.service.Action;
import com.cos.blog.util.Script;
import com.cos.blog.web.dto.BoardDetailDTO;

public class DetailAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 필요없음

		// 주소로 들어오는 건 전부 문자열이니까 숫자로 바꿔줘
		int id = Integer.parseInt(request.getParameter("id"));

		BoardDAO boardDAO = BoardDAO.getInstance(); // 싱글톤패턴
		BoardDetailDTO boardDetailDTO = boardDAO.mDetail(id);
		
		if (boardDetailDTO != null) {
			// 얘는 무조건 가야하니까 이프 필요업
			request.setAttribute("dto", boardDetailDTO);
			RequestDispatcher dis = request.getRequestDispatcher("views/board/detail.jsp");
			dis.forward(request, response);
		} else {
			Script.back("잘못된 접근입니다", response);
		}

		
		// 공통로직 끝

	}

}
