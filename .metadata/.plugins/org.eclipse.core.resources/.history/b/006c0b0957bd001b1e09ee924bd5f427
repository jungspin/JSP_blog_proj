package com.cos.blog.util;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Don't repeat Yourself -> 두번 일 하지마라 => DRY 하게 코드를 짜세요
public class ModValid {

	public int mVaild(List<String> keys, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// key 값 추출
		Enumeration<String> key = request.getParameterNames();

		// username =
		// username = ssar&paswword = 1234
		// 뒤에 key 두개가 더 있는데 안들어온걸 알 수가 없음
		// -> null을 못 잡아 -> 받을 key 값이 몇개인지 알아야됨

		// 키 값이 null인지 검증
		// 검증

		// 키 공백인 것 검증
		while (key.hasMoreElements()) {
			String param = key.nextElement();

			if (request.getParameter(param) == null || request.getParameter(param).equals("")) {
				return -1;
			}
		}
		return 1;
	}

}
