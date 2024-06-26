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
					<tr>
						<td align="right"><a href="AppleRegController">등록</a></td>
						<td>${r }</td>
					</tr>
					<tr>
						<th>지역</th>
						<th>가격</th>
					</tr>
					<c:forEach var="apple" items="${apples }">
						<tr>
							<td>${apple.a_location }</td>
							<td><fmt:formatNumber value="${apple.a_price }"
									type="number">
								</fmt:formatNumber></td>
						</tr>
					</c:forEach>

				</table>
			</td>
			<td><img src="img/apple2.jpg"></td>
		</tr>
	</table>

</body>
</html>