package com.oj.jun133.registration;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Registration")
public class Registration extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String region = request.getParameter("region");
		String[] hobby = request.getParameterValues("hobby");
		String introduce = request.getParameter("introduce");
		
		introduce=introduce.replace("\r\n", "<br>");

		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><meta charset='UTF-8'><title>회원가입</title></head>");
		out.print("<body>");
		out.print("<div>");
		out.printf("<h3>ID: %s</h3><hr>", id);
		out.printf("<h3>PW: %s</h3><hr>", pw);
		out.printf("<h3>성별: %s</h3><hr>", gender);
		out.printf("<h3>지역: %s</h3><hr>", region);
		if(hobby!=null) {
		out.print("<h3>취미: ");
			for (String s : hobby) {
				out.print(s + " ");
			}
		out.print("</h3>");
		}
		out.print("<hr>");
		out.printf("<h3>자기소개</h3><br>%s<hr>", introduce);
		out.print("</div>");
		out.print("</body>");
		out.print("</html>");
	}
}
