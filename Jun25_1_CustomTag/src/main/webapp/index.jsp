<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/OjValidChecker.js"></script>
<script type="text/javascript" src="js/calcChecker.js"></script>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/calc.css">
</head>
<body>
<div>
	<table id="navTbl">
		<tr>
			<td><a href="HomeController">Home</a></td>
			<td><a href="CalcController">사칙연산</a></td>
			<td><a href="JSTLCController">JSTL-C</a></td>
			<td><a href="JSTLFController">JSTL-F</a></td>
		</tr>
		</table>
		
		<table>
		 <tr>
			<td><jsp:include page="${ contentPage}"></jsp:include>				
			</td>
		</tr> 
		<tr>
			<td>
				<img src="">
			</td> 
			<td>
				<img src="">
			</td> 
			<td></td> 
		</tr>
		
	</table>
</div>



</body>
</html>