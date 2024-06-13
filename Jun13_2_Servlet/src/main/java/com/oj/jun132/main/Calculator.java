package com.oj.jun132.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculator")
public class Calculator extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int sum = x+y;
		int sub = x-y;
		int mul = x*y;
		int div = x/y;
//		out.print("html");
//		out.print("<head><title>사칙연산</title><meta charset ="UTF-8"></head>");
//		out.print("<body>");
		
		
		out.print("<table>");
		out.print("<tr>");
		out.print("<td>10</td>");
		out.print("<td>+</td>");
		out.print("<td>5</td>");
		out.print("<td>=</td>");
		out.printf("<td>%d</td>",sum);
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>10</td>");
		out.print("<td>-</td>");
		out.print("<td>5</td>");
		out.print("<td>=</td>");
		out.printf("<td>%d</td>",sub);
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>10</td>");
		out.print("<td>*</td>");
		out.print("<td>5</td>");
		out.print("<td>=</td>");
		out.printf("<td>%d</td>",mul);
		out.print("</tr>");
		out.print("<tr>");
		out.print("<td>10</td>");
		out.print("<td>/</td>");
		out.print("<td>5</td>");
		out.print("<td>=</td>");
		out.printf("<td>%d</td>",div);
		out.print("</tr>");
		
//		out.print("/body");
//		out.print("/html");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
