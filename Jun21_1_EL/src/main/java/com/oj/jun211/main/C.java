package com.oj.jun211.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/C")
public class C extends HttpServlet {
	// 어떤 사이트에 첫 접속 : GET 방식
	// 만약 V1.html에서 버튼을 눌렀을 때 GET방식을 써야한다면 문제가 됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		// 요청파라미터명이 없으면 => 이 사이트 첫 접속 GET방식
		if (!request.getParameterNames().hasMoreElements()) {
			request.getRequestDispatcher("V1.html").forward(request, response);
		} else {
			// 요청 파라미터명이 있으면 => 이사이트의 기능활용을 GET방식
			M.multiply(request);
			request.getRequestDispatcher("V2.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {

	}
}
