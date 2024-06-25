package com.oj.jun251.main;

import javax.servlet.http.HttpServletRequest;

public class Calculator {

	public static void calculator(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		
		int add = x+y;
		int sub = x-y;
		int mul = x*y;
		double div = x/ (double)y;
		String div2 = String.format("%.2f", div);
		
		request.setAttribute("a", add);
		request.setAttribute("s", sub);
		request.setAttribute("m", mul);
		request.setAttribute("d", div2);
	}
}
