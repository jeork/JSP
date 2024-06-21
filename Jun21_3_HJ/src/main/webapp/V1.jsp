<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"  href="style.css">
</head>
<body>
	<!-- 전적
승률
 -->
	<table>
		<tr>
			<td><a href="HomeController?userPick=1"> <img src="img/1.png">
			</a></td>
			<td><img src="img/3.png"></td>
			<td><a href="HomeController?userPick=2"> <img src="img/2.png">
			</a></td>
		</tr>
	</table>
	<table>
		<tr>
			<td>
			<img src="img/${up }">
			</td>
			<td>
			<img src="img/dog.jpg"></td>
			<td>
				 <img src="img/${c }">
			</td>
		</tr>

		<tr>
			<td>
			결과: ${r }
			</td>
		</tr>
		<tr>
			<td>${t } ${w } ${l }</td>
		</tr>
	</table>
</body>
</html>