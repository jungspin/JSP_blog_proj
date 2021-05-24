package com.cos.blog.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Don't repeat Yourself -> 두번 일 하지마라 => DRY 하게 코드를 짜세요
public class ModValid {

	public String mVaild(List<String> keys, HttpServletRequest request, HttpServletResponse response, int keyCount)
			throws ServletException, IOException {
	
		Enumeration<String> key = request.getParameterNames();
		
		
		// 키 값의 개수

		while (key.hasMoreElements()) {
			String param = key.nextElement();

			if (request.getParameter(param) == null || request.getParameter(param).equals("")) {
				return "실패";
			}
		}
		return "성공";
	}

}
