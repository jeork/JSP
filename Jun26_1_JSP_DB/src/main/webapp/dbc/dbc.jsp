<%@page import="java.sql.Connection"%>
<%@page import="com.oj.db.manager.OjDBManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 톰캣이 튜브대여소 역할을 할 줄 앎
	// 튜브 = Connection 객체

	// 기존 : DriverManager.getConnection()을 실행하는 순간
	// 관련된 모든 작업을 해서 Connection 객체를 만들어줌 => 비교적 느림

	// Connection Pool : 미리 Connection 객체 x 100개를 만들어 놓고
	//	클라이언트가 요청을 하면 => 만들어진 객체 하나 주면 됨 => 비교적 빠름

	// 설정 - context.xml(설계도, 계획서 느낌)
	// Servers폴더 - context.xml
	//	저걸 건들면 워크스페이스 안에 있는 모든 프로젝트에 영향을 줌
	//	프로젝트가 다르다 => DB서버가 다르다

	// 우리가 만든 context.xml을 각 프로젝트의 META-INF폴더에 넣자!
	String result = "실패";

	Connection con = null;
	try {
		con = OjDBManager.connect("ojPool");
		result = "성공";
	} catch (Exception e) {
		e.printStackTrace();
	}
	OjDBManager.close(con, null, null);
	%>
	
	<h1>DB연결</h1>
	<h1><%=result %></h1>
</body>
</html>