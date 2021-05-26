package com.cos.blog.util;

import java.io.IOException;
import java.util.ArrayList;
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
		List<String> list = new ArrayList<>();

		while (key.hasMoreElements()) {
			String param = key.nextElement();

			// 근데 만약 키값을 다르게 설정하고 길이만 맞춰주면 뚫을 수 있지 않나?
			if (!keys.contains(param)) {
				continue;
			}
			System.out.println(param);
			list.add(param);

			if (request.getParameter(param).equals("")) {
				return -1;
			}

		}
		if (list.size() != keys.size()) {
			return -1;
		}

		return 1;
	}

}
