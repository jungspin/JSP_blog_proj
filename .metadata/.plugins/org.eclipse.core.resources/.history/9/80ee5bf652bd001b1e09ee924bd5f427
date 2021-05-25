package com.cos.blog.util;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class Script {
	
	public static void back(String msg, HttpServletResponse response) throws IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter(); // 버퍼를 만들어줌
		out.println("<script>");
		out.println("alert('"+msg+"');");
		out.println("history.back();"); // 전의 페이지로 데이터 남기고 돌아감
		out.println("</script>");
	}
}
