<%@page import="java.util.ArrayList"%>
<%@page import="com.oj.jun212.main.RSPGameEngine"%>
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"href="RSP.css">
</head>
<body>

<table>
<tr class = "tr1">
<td>
	<a href="HomeController?userHand=1">
		<img src="img/1.png">
	</a>
</td>
<td>
	<a href="HomeController?userHand=2">
		<img src="img/2.png">
	</a>
</td>
<td>
	<a href="HomeController?userHand=3">
		<img src="img/3.png">
	</a>
</td>
</tr>
<tr class = "tr1">
<td>
		<img src="img/${uh}">
</td>
<td>
		<img src="img/no.png">
</td>
<td>
		<img src="img/${ch}">
</td>
</tr>
<tr>
	<td>
		판정:${r}
	</td>	
</tr>
<tr>
	<td>
		${t } ${w } ${d } ${l }
	</td>	
</tr>
<tr>
	<td>
		<form action="HomeController" method="post">
			<button>다시하기</button>
		</form>
	</td>	
</tr>
</table>
</body>
</html>