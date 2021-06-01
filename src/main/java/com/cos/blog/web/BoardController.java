package com.cos.blog.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.service.Action;
import com.cos.blog.service.board.DeleteAction;
import com.cos.blog.service.board.DetailAction;
import com.cos.blog.service.board.ListAction;
import com.cos.blog.service.board.SaveAction;
import com.cos.blog.service.board.SaveFormAction;

// http://localhost:8000/blog/board
// 경로는 모델이름으로 해주렴
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
		
		if (request.getParameter("cmd")==null || request.getParameter("cmd").equals("")) {
			return;
		}
	
		String cmd = request.getParameter("cmd");
		Action action = router(cmd); // 책임이 분리가 되었다
		
		if (action != null) {
			action.execute(request, response);
		}
	}
	private static Action router(String cmd) {
		// http://localhost:8000/blog/board?cmd=list
		if(cmd.equals("list")) { // 게시물 전체보기
			return new ListAction();
		} else if(cmd.equals("detail")) { // 상세보기
			return new DetailAction();
		} else if(cmd.equals("delete")) {
			return new DeleteAction();
		} else if(cmd.equals("updateForm")) { // form 태그가 있는건 무조건 form 붙일래? 그래
			 // user 랑 헷갈리지마
		} else if(cmd.equals("update")) { // update 수행
			
		} else if(cmd.equals("saveForm")) {
			return new SaveFormAction(); // 글쓰기 화면 액션 가기 (세션 검증 후)
		} else if(cmd.equals("save")) {
			return new SaveAction();
		} else if(cmd.equals("search")) { // 검색
			
		} 
		return null;
	}
		
	
}
