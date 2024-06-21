package com.oj.jun212.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Java + JSP + CSS + Sevlet
// 가위바위보 게임 페이지
// 가위바위보 누를때마다 게임 한판 진행됨
// WAS 종료할 때 까지 전적은 쌓이게 => 매판 진행할 때 마다 전적이 보이도록 (바뀌도록)
// 문제: GET방식 요청을 할때마다 전적이 안쌓임
// 해결책:  엔진 하나 => singleton pattern


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("uh", "no.png");
			request.setAttribute("ch", "no.png");
		}else {
			RSPGameEngine rge = RSPGameEngine.getRge();
			rge.doRSP(request);
		}
		request.getRequestDispatcher("V2.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RSPGameEngine rge = RSPGameEngine.getRge();
		rge.reset(request);
		request.setAttribute("uh", "no.png");
		request.setAttribute("ch", "no.png");
		request.getRequestDispatcher("V2.jsp").forward(request, response);
		
	}

}
