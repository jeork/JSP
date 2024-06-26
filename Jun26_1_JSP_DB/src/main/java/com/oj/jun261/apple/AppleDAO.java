package com.oj.jun261.apple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oj.db.manager.OjDBManager;

public class AppleDAO {
	private static final AppleDAO APPLEDAO = new AppleDAO();

	public AppleDAO() {
		// TODO Auto-generated constructor stub
	}

	public static AppleDAO getAppledao() {
		return APPLEDAO;
	}
	// 등록
	public static void setApples(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = OjDBManager.connect("ojPool");

			request.setCharacterEncoding("UTF-8");
			String location = request.getParameter("a_location");
			String color = request.getParameter("a_color");
			String flavor = request.getParameter("a_flavor");
			int price = Integer.parseInt(request.getParameter("a_price"));
			
			// <textArea> 에서 엔터친거 : \r\n
			// 웹페이지에서 줄바꾸기 : <br>
			String introduce = request.getParameter("a_introduce").replace("\r\n", "<br>");
			
			String sql = "insert into jun26_apple values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,location);
			pstmt.setString(2, color);
			pstmt.setString(3, flavor);
			pstmt.setInt(4, price);
			pstmt.setString(5, introduce);
			
			if (pstmt.executeUpdate()==1) {
				request.setAttribute("r", "[등록 성공]");				
			}
			
		}catch (Exception e) {
			request.setAttribute("r", "[등록 실패]");				
		}
		OjDBManager.close(con, pstmt, null);
		
	}
	
	// 모든 사과 데이터 다 가져오기
	public static void getAllApples(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = OjDBManager.connect("ojPool");

			String sql = "select * from jun26_apple order by a_price";
			pstmt = con.prepareStatement(sql);

			// C / U / D : pstmt.executeUpdate()로 실행
			// => 데이터 몇 개 영향을 받았는지
			// R : pstmt.excuteQuery()로 실행
			// => select 결과를 ResultSet으로 보냄
			rs = pstmt.executeQuery();
			ArrayList<Apple> apples = new ArrayList<Apple>();
			Apple apple = null;

			while (rs.next()) {
				apple = new Apple();
				apple.setA_location(rs.getString("a_location"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_introduce(rs.getString("a_introduce"));
				apples.add(apple);
			}
			request.setAttribute("apples", apples);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
