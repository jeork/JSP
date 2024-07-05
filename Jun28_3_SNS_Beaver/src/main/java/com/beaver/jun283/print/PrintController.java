package com.beaver.jun283.print;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.jun283.home.TokenManager;
import com.beaver.jun283.member.MemberDAO;

@WebServlet("/PrintController")
public class PrintController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.loginCheck(request);
		TokenManager.make(request);
		request.setAttribute("cp", "print/print.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
