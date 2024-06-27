<%@page import="com.oj.jun261.apple.AppleDAO"%>
<%@page import="com.oj.jun261.apple.Apple"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/apple.css">
<script type="text/javascript" src="js/detail.js"></script>
<title>Insert title here</title>
</head>
<body>
	<%
	Connection con = null;
	ResultSet rs = null;
	try {
		String arr = "jdbc:oracle:thin:@localhost:1521:xe";
		con = DriverManager.getConnection(arr, "oj2", "1");
		String sql = "select a_location,a_price from jun26_apple";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();

		pstmt.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
	try {
		con.close();

	} catch (Exception e) {
		e.printStackTrace();
	}
	%>
	<table>
		<tr>
			<td><img src="img/apple.jpg"></td>
			<td>
				<table class="dataTbl">
					<tr class="regTr">
						<td>${r }</td>
						<td align="right"><a href="AppleRegController">등록</a></td>
					</tr>
					<tr>
						<th>지역</th>
						<th>가격</th>
					</tr>
					<c:forEach var="apple" items="${apples}">
						<tr class="dataTr" onclick="goAppleDetail('${apple.a_location}');">
							<td class="dataTd">${apple.a_location}</td>
							
							<td><fmt:formatNumber value="${apple.a_price}"
									type="number">
								</fmt:formatNumber></td>
						</tr>
					</c:forEach>
				</table>
			</td>
			<td><img src="img/apple2.jpg"></td>
		</tr>
		<tr align="center">
			<td class="pageNumTd" colspan="2">
				<c:forEach var ="p" begin="1" end="${pageCount }">
					<a href="ApplePageController?p=${p }">${p }</a>
				</c:forEach>
			</td>
		</tr>
	</table>



</body>
</html>