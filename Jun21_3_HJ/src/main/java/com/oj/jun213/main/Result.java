package com.oj.jun213.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Result {
	private int t;
	private int win;
	private int lose;
	private String pp;

	private static final Result r = new Result();
	
	public Result() {
		// TODO Auto-generated constructor stub
	}
	
	public static Result getR() {
		return r;
	}
	
	// 게임
	public void doCoin(HttpServletRequest request) {
		int userPick = Integer.parseInt(request.getParameter("userPick"));
		request.setAttribute("up", userPick + ".png");

		int coin = new Random().nextInt(10) + 1;
		request.setAttribute("c", coin%2+1 + ".png");

		// 결과
		if ((coin % 2 == 0 && userPick == 2) || (coin % 2 == 1 && userPick == 1)) {
			request.setAttribute("r", "정답");
			win++;
			t++;
		} else {
			request.setAttribute("r", "땡");
			lose++;
			t++;
		}
		request.setAttribute("t", t+"판");
		request.setAttribute("w", win+"승");
		request.setAttribute("l", lose+"패");
	
	}	
}
