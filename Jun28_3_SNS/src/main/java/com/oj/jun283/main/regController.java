package com.oj.jun283.main;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/regController")
public class regController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public regController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request);
		DateManager.getCurYear(request);
		request.setAttribute("contentPage", "reg.jsp");
		request.setAttribute("dataPage", "login.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.setMembers(request);
		MemberDAO.loginCheck(request);
		DateManager.getCurYear(request);
		request.setAttribute("contentPage", "reg.jsp");
		request.setAttribute("dataPage", "login.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
