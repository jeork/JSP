package com.oj.jun132.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Output")

// 사용자가 입력한 데이터가 주소에
// 인터넷 주소에 한글 -X
// 사용자가 입력한 ㅋ(UTF-8) -URLEncoding => @WA
// 사용자가 받아온 %2A - URLDecoding -> ㅋ

//Get방식 요청 파라미터 한글처리
// UTF-8로 맞추자
// Tomcat-server.xml 63번째 줄

public class Output extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String a = request.getParameter("a");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head><title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.printf("<h2>Output-POST</h2>", a);

		out.print("</body>");
		out.print("<html>");
	}
	
	// GET vs POST
	// GET : 요청파라미터가 주소에 있음
	//		대부분 GET 방식을 사용함
	// POST : 요청파라미터가 주소에 없음, 내부적으로 전달
	//		보안성 높음 - 로그인, 회원가입
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String a = request.getParameter("a");
		PrintWriter out = response.getWriter();

		out.print("<html>");
		out.print("<head><title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.printf("<h2>Output-POST</h2>", a);
		out.printf("<h2>%s</h2>",a);
		out.print("</body>");
		out.print("<html>");
	}

}
