package com.oj.jun261.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleRegController")
public class AppleRegController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setAttribute("contentPage", "reg.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	// 등록하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AppleDAO.getAppledao().setApples(request);
		AppleDAO.getAppledao().getAllApples(request);
		request.setAttribute("contentPage", "apple.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
