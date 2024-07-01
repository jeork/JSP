package com.oj.jun283.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/BoardController")
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BoardController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateManager.getCurYear(request);
		if (MemberDAO.loginCheck(request)) {
			request.setAttribute("contentPage", "Board.jsp");
			request.setAttribute("dataPage", "user.jsp");
		} else {
			request.setAttribute("contentPage", "Board.jsp");
			request.setAttribute("dataPage", "login.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateManager.getCurYear(request);
		if (MemberDAO.loginCheck(request)) {
			MemberDAO.write(request);
			request.setAttribute("contentPage", "Board.jsp");
			request.setAttribute("dataPage", "user.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
