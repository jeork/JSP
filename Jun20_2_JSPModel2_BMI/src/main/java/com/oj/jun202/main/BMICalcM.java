package com.oj.jun202.main;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

//BMI 계산
public class BMICalcM {
	public static void calc(HttpServletRequest request) throws IOException {
		request.setCharacterEncoding("UTF-8");
		String path = request.getServletContext().getRealPath("img");
		
		MultipartRequest mr = new MultipartRequest(request, path, 30*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		String name = mr.getParameter("name");
		double height = Double.parseDouble(mr.getParameter("height"));
		int weight = Integer.parseInt(mr.getParameter("weight"));
		double bmi = weight / ((height / 100) * (height / 100));
		
		String result = "저체중";
		if (bmi >= 40) {
			result = "고도비만";
		} else if (bmi >= 35) {
			result = "중증도비만";
		} else if (bmi >= 30) {
			result = "경도비만";
		} else if (bmi >= 25) {
			result = "과체중";
		} else if (bmi >= 18.5) {
			result = "정상";
		}
		String bmi2 = String.format("%.f", bmi);
		double bmi3 = Double.parseDouble(bmi2);
		String image =mr.getFilesystemName("img");
		image = URLEncoder.encode(image,"UTF=8");
		image = image.replace("+", " ");
		

		//객체를 만들어서 한꺼번에 보내기
		Guest g = new Guest(name,weight,height,bmi3,image,result);
		request.setAttribute("g", g);
		//hyypserveletrequest클래스를 활용해서만 attribute
	}
}