<%@page import="java.util.Random"%>
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
	// Parameter 읽기
	String aaa = request.getParameter("a");
	Integer aa = Integer.parseInt(aaa);
	int a = aa.intValue();
	
	String bbb = request.getParameter("b");
	Integer bb = Integer.parseInt(bbb);
	int b = bb.intValue();

	//Attribute 읽기
	Object ccc = request.getAttribute("c");
	Integer cc = (Integer) ccc;
	int c = cc.intValue();

	String d = (String) request.getAttribute("d");
	Random e = (Random) request.getAttribute("e");
	%>
	<h1>Third</h1>
	<hr>
	
	a:<%= a%><br>
	b:<%= b%><br>
	c:<%= c%><br>
	d:<%= d%><br>
	e:<%= e%><br>
</body>
</html>