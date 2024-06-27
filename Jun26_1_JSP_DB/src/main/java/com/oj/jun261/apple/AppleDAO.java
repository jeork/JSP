package com.oj.jun261.apple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.oj.db.manager.OjDBManager;

public class AppleDAO {
	private int allAppleCount;
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

			pstmt.setString(1, location);
			pstmt.setString(2, color);
			pstmt.setString(3, flavor);
			pstmt.setInt(4, price);
			pstmt.setString(5, introduce);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[등록 성공]");
			}

		} catch (Exception e) {
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

	// 사과데이터가 몇개인지
	public void getApplesCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = OjDBManager.connect("ojPool");

			String sql = "select count(*) from jun26_apple";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allAppleCount = rs.getInt("count(*)");

		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			OjDBManager.close(con, pstmt, rs);
		} catch (Exception e) {
		}
	}

	// DB에 데이터가 100개 있다 ? => 해당 페이지 번호에 맞는 데이터만 가져오기
	public void getApples(int pageNo, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int applePerPage = 4;

		// Math.ceil : 숫자 올림처리

		try {
			con = OjDBManager.connect("ojPool");
			int pageCount = (int) Math.ceil(allAppleCount / (double) applePerPage);
			request.setAttribute("pageCount", pageCount);
			int start = (applePerPage * (pageNo - 1)) + 1;
			int end = (pageNo == pageCount) ? allAppleCount : (start + applePerPage - 1);
			String sql = "select * from (" + "select rownum as rn, a_location, a_color, a_flavor, a_price, a_introduce "
					+ "from( " + "select * " + "from jun26_apple " + "order by a_price " + ") " + ") "
					+ "where rn >= ? and rn <=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
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

	// 상세정보 가져오기 PK
	// 제대로 데이터를 가져왔으면 : true
	// 실패했으면 : false
	public boolean getAppleDetail(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = OjDBManager.connect("ojPool");

			String location = request.getParameter("a_location");
			String sql = "select * from jun26_apple where a_location =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				Apple apple = new Apple();
				apple.setA_location(rs.getString("a_location"));
				apple.setA_color(rs.getString("a_color"));
				apple.setA_flavor(rs.getString("a_flavor"));
				apple.setA_price(rs.getInt("a_price"));
				apple.setA_introduce(rs.getString("a_introduce"));
				request.setAttribute("apple", apple);

				return true;
			}
			return false; // ex) 다른 사람이 그 데이터를 지웠으면 : 데이터 없음
		} catch (Exception e) {
			return false; // DB서버 상태가 안좋음
		} finally {
			OjDBManager.close(con, pstmt, rs);
		}

	}

	// 수정
	public void editAppleDetail(HttpServletRequest request) {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = OjDBManager.connect("ojPool");

			request.setCharacterEncoding("UTF-8");
			String location = request.getParameter("a_location");
			String color = request.getParameter("a_color");
			String flavor = request.getParameter("a_flavor");
			int price = Integer.parseInt(request.getParameter("a_price"));
			String introduce = request.getParameter("a_introduce").replace("\r\n", "<br>");

			String sql = "update jun26_apple set a_color=?, a_flavor=?, a_price=?, a_introduce=? where a_location =? ";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, color);
			pstmt.setString(2, flavor);
			pstmt.setInt(3, price);
			pstmt.setString(4, introduce);
			pstmt.setString(5, location);
			pstmt.executeUpdate();
		} catch (Exception e) {
		}
		OjDBManager.close(con, pstmt, null);
	}

	public void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = OjDBManager.connect("ojPool");

			String location = request.getParameter("a_location");
			String sql = "delete from jun26_apple where a_location =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[삭제 성공]");
				allAppleCount--;
			} else {
				request.setAttribute("r", "[삭제 실패]");
			}

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[삭제 실패]");
		}
		OjDBManager.close(con, pstmt, null);
	}

//	public void getInfo(HttpServletRequest request) {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String a_location=request.getParameter();
//		try {
//			con = OjDBManager.connect("ojPool");
//			String sql = "select * from jun26_apple where a_location ='?'";
//			
//			pstmt.setString(1, a_location);
//			
//			pstmt = con.prepareStatement(sql);
//			rs = pstmt.executeQuery();
//			
//			ArrayList<Apple> apples = new ArrayList<Apple>();
//			Apple apple = null;
//
//			while (rs.next()) {
//				apple = new Apple();
//				apple.setA_location(rs.getString("a_location"));
//				apple.setA_color(rs.getString("a_color"));
//				apple.setA_flavor(rs.getString("a_flavor"));
//				apple.setA_price(rs.getInt("a_price"));
//				apple.setA_introduce(rs.getString("a_introduce"));
//				apples.add(apple);
//			}
//			request.setAttribute("apples", apples);
//
//		} catch (Exception e) {
//		}
//
//	}
}
