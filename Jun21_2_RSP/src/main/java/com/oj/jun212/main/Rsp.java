package com.oj.jun212.main;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

public class Rsp {
	public static void Result(HttpServletRequest request) {
		Random r = new Random();
		int com = r.nextInt(3)+1;
		int user;
		if (!request.getParameterNames().hasMoreElements()) {
			user=0;
		}else {
			user = Integer.parseInt(request.getParameter("rsp"));
		}
		
		String result=null;
		int winCnt=0;
		int loseCnt=0;
		int drawCnt=0;
		int cnt=0;

			if(user-com==-1){
				result = "패배";
				loseCnt++;
				cnt++;
			}else if (user==com){
				result = "무승부";
				drawCnt++;
				cnt++;
			}else{
				result = "승리";
				winCnt++;
				cnt++;
			}
			
		request.setAttribute("user", user);	
		request.setAttribute("com", com);	
		request.setAttribute("result", result);
//		request.setAttribute("winCnt", winCnt);
//		request.setAttribute("drawCnt", drawCnt);
//		request.setAttribute("loseCnt", loseCnt);
	}
}
