package com.oj.jun211.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class M {
	public static void multiply(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		int z = x * y;
		request.setAttribute("z", z);
		
		Beaver b = new Beaver("비버", 3, 50.5, 10.1);
		request.setAttribute("b", b);

		ArrayList<Beaver> bvs = new ArrayList<Beaver>();
		bvs.add(b);
		bvs.add(new Beaver("빕어", 2, 40.4, 9.4));
		bvs.add(new Beaver("빕버", 2, 40.4, 9.4));
		bvs.add(new Beaver("빕워", 2, 40.4, 9.4));
		request.setAttribute("bvs", bvs);
	}
}
