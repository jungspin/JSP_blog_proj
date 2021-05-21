package com.cos.blog.service.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.service.Action;

public class DeleteAction implements Action{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// id 값 받기 (null이거나 공백일수도 있자나)
		// DAO deleteById()
		// -1 / n 리턴 -> 분기
		
	}

}
