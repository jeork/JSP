package com.oj.jun261.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oj.jun261.apple.AppleDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	// 톰캣이 이 프로젝트를 처음 실행시킬 때
	public HomeController() {
		AppleDAO.getAppledao().getApplesCount();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentPage", "home.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
		
	}

}
