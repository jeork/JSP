package com.beaver.jun283.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.beaver.jun283.home.DateManager;

@WebServlet("/MemberInfoController")
public class MemberInfoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.loginCheck(request)) {
			DateManager.getCurYear(request);
			request.setAttribute("cp", "member/info.jsp");
		} else {
			request.setAttribute("cp", "home.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.loginCheck(request)) {
			MemberDAO.update(request);
			DateManager.getCurYear(request);
			request.setAttribute("cp", "member/info.jsp"); // �������� ������ �ٷ� Ȯ���غ��� �ִ� ����
			// MemberDAO.loginCheck(request);
		} else {
			request.setAttribute("cp", "home.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
