package com.oj.jun201.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller : Servlet
// 		상황판단해서 M/V 소환
//			=> 어떤 요청이 들어왔을 때, 판단해서 M/V를 소환
//		이 사이트의 진입점(실행은 여기서!)

// Back-end 웹개발자 A - PL급(Project Leader)

@WebServlet("/C")
public class C extends HttpServlet {
	// 어떤 사이트에 접속
	//	 1. 주소를 직접 입력
	//	 2. 검색 => <a> 눌러서
	//		둘다 GET방식 요청 (어떤 사이트에 POST로 첫 접속은 없음)
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
//		RequestDispatcher rd = request.getRequestDispatcher("V1.html");
//		rd.forward(request, response);
		request.getRequestDispatcher("V1.html").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		M.add(request);
		request.getRequestDispatcher("V2.jsp").forward(request, response);
	}
}
