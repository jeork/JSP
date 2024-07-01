package com.oj.jun283.main;

import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oj.db.manager.OjDBManager;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class MemberDAO {

	public static boolean loginCheck(HttpServletRequest request) {
		Member m = (Member) request.getSession().getAttribute("loginMember");
		if (m!=null) {
			request.setAttribute("dataPage", "user.jsp");
			return true;
		}
		request.setAttribute("dataPage", "login.jsp");
		return false;
	}

	public static void login(HttpServletRequest request, HttpServletResponse response) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = OjDBManager.connect("ojPool");
			request.setCharacterEncoding("UTF-8");
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");

			String sql = "select * from jun28_member where m_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				String dbPw = rs.getString("m_pw");
				if (dbPw.equals(pw)) {
					Member m = new Member(rs.getString("m_id"), dbPw, rs.getString("m_name"), rs.getString("m_phone"),
							rs.getDate("m_birth"), URLDecoder.decode(rs.getString("m_img"), "UTF-9"));
					request.getSession().setAttribute("loginMember", m);
					request.getSession().setMaxInactiveInterval(600);

					Cookie c = new Cookie("lastLoginId", id);
					c.setMaxAge(60 * 60 * 24 * 5);
					response.addCookie(c);
					request.setAttribute("r", "로그인성공");
				} else {
					request.setAttribute("r", "로그인 실패(PW오류)");
				}
			} else {

				request.setAttribute("r", "로그인실패(미가입ID)");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r","로그인실패(DB서버)");
		} finally {
			OjDBManager.close(con, pstmt, rs);
		}
	}

	public static void logout(HttpServletRequest request) {
		request.getSession().setAttribute("loginMember", null);
		request.setAttribute("r","로그아웃 성공");
	}
	
	public static void setMembers(HttpServletRequest request) {

		String path = null;
		MultipartRequest mr = null;
		try {
			path = request.getServletContext().getRealPath("img");
			System.out.println(path);
			mr = new MultipartRequest(request, path, 30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "회원가입 실패(사진파일 용량)");
			return;
		}
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = OjDBManager.connect("ojPool");

			String id = mr.getParameter("m_id");
			String pw = mr.getParameter("m_pw");
			String name = mr.getParameter("m_name");
			String phone = mr.getParameter("m_phone");
			String y = mr.getParameter("m_y");
			int m = Integer.parseInt(mr.getParameter("m_m"));
			int d = Integer.parseInt(mr.getParameter("m_d"));
			String birth = String.format("%s%02d%02d", y, m, d);
			String img = mr.getFilesystemName("m_img");
			img = URLEncoder.encode(img, "UTF-8").replace("+", " ");

			String sql = "insert into jun28_member values(?,?,?,?,to_date(?, 'YYYYMMDD'),?)";
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, name);
			pstmt.setString(4, phone);
			pstmt.setString(5, birth);
			pstmt.setString(6, img);

			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "회원가입 성공!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			File f = new File(path + "/" + mr.getFilesystemName("m_img"));
			f.delete();
			request.setAttribute("r", "회원가입 실패(DB서버)");

		}
		OjDBManager.close(con, pstmt, null);
	}

	public static void getInfo(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = OjDBManager.connect("ojPool");
			request.setCharacterEncoding("UTF-8");

			String id = request.getParameter("m_id");
			String sql = "select m_id, m_name, m_phone, m_birth, m_img  from JUN28_MEMBER where m_id=?";
			String m_name = "test";
			String m_phone = null;
			String m_birth = null;
			String m_img = null;
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				id = rs.getString("m_id");
				m_name = rs.getString("m_name");
				m_phone = rs.getString("m_phone");
				m_birth = rs.getString("m_birth");
				m_img = rs.getString("m_img");
			}
			request.setAttribute("m_id", id);
			request.setAttribute("m_name", m_name);
			request.setAttribute("m_phone", m_phone);
			request.setAttribute("m_birth", m_birth);
			request.setAttribute("m_img", m_img);

		} catch (Exception e) {
		} finally {
			OjDBManager.close(con, pstmt, rs);
		}
	}

	public static void write(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		Date today = new Date();
		SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {

			Member m = (Member) request.getSession().getAttribute("m");
			con = OjDBManager.connect("ojPool");
			String sql = "insert into jun28_post values(jun28_post_seq.nextval,?,?,?)";
			String p_id = m.getM_id();
			String p_post = request.getParameter("textDetail");
			String p_date = date.format(today);
			System.out.println(p_date);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, p_id);
			pstmt.setString(2, p_post);
			pstmt.setString(3, p_date);

			if (pstmt.executeUpdate() == 1) {
				System.out.println("등록 성공");
			}

		} catch (Exception e) {
			System.out.println("등록 실패");
		} finally {
			OjDBManager.close(con, pstmt, null);
		}

	}

}
