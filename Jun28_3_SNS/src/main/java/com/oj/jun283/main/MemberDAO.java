package com.oj.jun283.main;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oj.db.manager.OjDBManager;
import com.oj.jun283.main.Member;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {
		
	
	public static boolean loginCheck(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("m");
		return (m!= null);
	}

	public static void login(HttpServletRequest request, HttpServletResponse response) {
		Connection con = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		try {
			con =OjDBManager.connect("ojPool");
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			String sql = "select m_id,m_pw from jun28_member where m_id=?";
			
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			String m_id = rs.getString("m_id");
			String m_pw = rs.getString("m_pw");
			
			
			if (id.equals("1") && pw.equals("1")) {
				Member m = new Member(id,pw);
				request.getSession().setAttribute("m", m);
				request.getSession().setMaxInactiveInterval(10);
			}
			Cookie c = new Cookie("lastLoginId", id);
			c.setMaxAge(600);
			response.addCookie(c);

		} catch (Exception e) {
		}
	}
	
	public static void setMembers(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt=null;
		try {
			con =OjDBManager.connect("ojPool");
			request.setCharacterEncoding("UTF-8");
			
			String path = request.getServletContext().getRealPath("img");
			System.out.println(path);
			
			MultipartRequest mr = new MultipartRequest(request, path,10*1024*1024,"UTF-8", new DefaultFileRenamePolicy());
			
			
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String phone = mr.getParameter("phone");
			String birth = mr.getParameter("birth");
			String img = mr.getFilesystemName("img");
			
			img = URLEncoder.encode(img,"UTF-8");
			img = img.replace("+", " ");
			
			String sql = "insert into jun28_member values(?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, birth);
			pstmt.setString(6, img);
			
			if (pstmt.executeUpdate()==1) {
				request.setAttribute("r", "[가입 성공]");
			}
			
		} catch (Exception e) {
			request.setAttribute("r", "[가입 실패]");
		}
		OjDBManager.close(con, pstmt, null);
	}

}
