package com.oj.jun202.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

// BMI를 JSPModel2 방식으로 만들기
// 의사와 환자가 데이터를 주고받는 형태로 만들기(OOP)
// 환자가 정보를 주면 의사가 그 정보를 가지고 계산을 하는 형태
// 계산을 마친 정보를 출력
// (이름, 키, 몸무게, 사진)

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("InputView.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BMICalcM.calc(request);
		request.getRequestDispatcher("ResultView.jsp").forward(request, response);
	}
}
