package com.oj.jun212.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class RSPGameEngine {
	private int t;
	private int win;
	private int draw;
	private int lose;
	
	//private : class 내부에서만 사용 가능 / 외부로는 사용이 불가능
	private static final RSPGameEngine RGE = new RSPGameEngine();
	
	private RSPGameEngine() {
	}
	// Controller에서 사용하기 위한 getter (public)
	public static RSPGameEngine getRge() {
		return RGE;
	}





	// 게임 한판에 대한 판정
	public void doRSP(HttpServletRequest request) {
		int userHand = Integer.parseInt(request.getParameter("userHand"));
		request.setAttribute("uh",userHand+".png");
		
		int comHand = new Random().nextInt(3)+1;
		request.setAttribute("ch",comHand+".png");
		
		//판정
		int result = userHand - comHand;
		if (result == 0) {
			request.setAttribute("r", "무");
			draw++;
			t++;
		}else if (result == -1 || result == 2) {
			request.setAttribute("r", "패");
			lose++;
			t++;
		}else {
			request.setAttribute("r", "승");
			win++;
			t++;
		}
		request.setAttribute("t",t+"전");
		request.setAttribute("w", win + "승");
		request.setAttribute("d", draw + "무");
		request.setAttribute("l", lose + "패");
	}
	
	//초기화
	public void reset(HttpServletRequest request) {
		t=0;
		win=0;
		draw=0;
		lose=0;
		request.setAttribute("r", "전적 초기화완료");
		
	}


}
