package com.oj.jun251.main;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

public class JSTLCDataMaker {
	public static void make(HttpServletRequest request) {
		int[] ar = { 123, 456, 78, 91, 234 };
		request.setAttribute("ar", ar);

		ArrayList<Oj> al = new ArrayList<Oj>();
		al.add(new Oj("비버", 3, 50.5, 10.1));
		al.add(new Oj("빕어", 2, 40.4, 9.9));
		al.add(new Oj("비붜", 5, 30.3, 6.6));
		al.add(new Oj("빕워", 1, 10.1, 3.3));

		request.setAttribute("al", al);
	}
}
