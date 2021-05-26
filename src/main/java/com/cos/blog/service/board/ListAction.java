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

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션, 유효성 다 필요없음

		// 핵심 로직

		BoardDAO boardDAO = BoardDAO.getInstance(); // 싱글톤패턴
		List<Board> boardsEntity = boardDAO.findAll();
		
//		System.out.println("======================"); // 오류나서 테스트 해봤음. 습관화해라
//		System.out.println(boardsEntity.size());

		// 얘는 무조건 가야하니까 이프 필요업
		request.setAttribute("boards", boardsEntity);
		RequestDispatcher dis = request.getRequestDispatcher("views/board/list.jsp");
		dis.forward(request, response);
		// 공통로직 끝

	}

}
