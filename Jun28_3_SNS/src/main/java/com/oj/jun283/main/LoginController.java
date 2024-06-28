package com.oj.jun283.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
       
	public LoginController() {
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.login(request, response);
		
		if (MemberDAO.loginCheck(request)) {
			request.setAttribute("contentPage","info.jsp" );
			request.setAttribute("dataPage", "user.jsp");
			request.setAttribute("r", "로그인 성공");
		}else {
			request.setAttribute("contentPage","reg.jsp" );
			request.setAttribute("dataPage", "login.jsp");
			request.setAttribute("r", "로그인 실패");
		}
		
	request.getRequestDispatcher("index.jsp").forward(request, response);
	
	}
}
