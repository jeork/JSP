package com.oj.jun281.main;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Controller
//		JSP 환경에서 상황판단을 
//			(GET or POST) 하기에는 Servlet이 적합
//			계산을 해야하면 M(Model)으로
//			보여줘야하면 V(View)로
//	흐름제어 + 실행

@WebServlet("/FirstC") // <-FisrstC를 톰캣에 등록
public class FirstC extends HttpServlet {
	
	// 이 프로젝트에는 main 메소드가 없음
	// 톰캣이 실행(main은 톰캣에) => 알아서 FirstC객체를 만듦
	
	// 이 프로젝트를 처음 시작할 때
    public FirstC() {
        super();
        // 생성자
        // 처음 실행했을 때 사과 데이터 총 갯수를 받아오기 위해서 사용했음
    }

    // 웹사이트의 페이지 전환 : Controller 로 요청 => M에 가서 작업 => View로 포워딩
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사이트에 처음 들어오면 or
		// FirstC로 요청 파라미터 하나도 없이 GET방식으로 요청을 하면,
		if (!request.getParameterNames().hasMoreElements()) {
			
			// firstV.jsp로 지금일어난 요청을 제보해주는 객체
			RequestDispatcher rd = request.getRequestDispatcher("firstV.jsp");
			rd.forward(request, response); // fisrtV.jsp를 포워딩
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
