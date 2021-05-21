package com.cos.blog.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cos.blog.service.Action;

public class UpdateAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. updateForm 에서 받아온 데이터 유효성 검사
		// 2. 값 받아오기
		// 3. db에 update 하기 -> update()
		// 4. 리턴값 확인
		// 5. -1이냐 1이냐
		
	}

}
