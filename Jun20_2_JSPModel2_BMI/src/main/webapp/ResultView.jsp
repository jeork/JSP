<%@page import="com.oj.jun202.main.Guest"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	request.setCharacterEncoding("UTF-8");
	String path = request.getServletContext().getRealPath("img");
	MultipartRequest mr = new MultipartRequest(request, path, 30*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
	
	Guest g = (Guest)request.getAttribute("g");
	String name= mr.getParameter("name");
	int weight=Integer.parseInt(mr.getParameter("weight"));
	double height = Double.parseDouble(mr.getParameter("height"));
 	double bmi = (Double) request.getAttribute("bmi");
	String result = (String) request.getAttribute("result");
	
	String image = mr.getFilesystemName("img");
	image = URLEncoder.encode(image,"UTF-8");
	image = image.replace("+", " ");
	%>

	<h1>BMI 계산 결과</h1>
	<img src="img/<%=image%>" style="max-width : 50%";>
	키 :	<%=height%>cm 
	몸무게 :<%=weight%>kg	<br> 
	BMI = <%=bmi%><br> 
	결과 = <%=result%>

</body>
</html>