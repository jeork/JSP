<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js\OjValidChecker.js"></script>
<script type="text/javascript" src="js\calcCheck.js"></script>
</head>
<body>
	<form action="CalcController" name = "calcForm" onsubmit="return calcCheck();">
		<table id ="calcTbl">
			<tr>
				<td align="center">
					x : <input placeholder="x" autofocus="autofocus"
					autocomplete="off" name ="x">
				</td>
			</tr>
			<tr>
				<td align="center">
					y : <input placeholder="y" autofocus="autofocus"
					autocomplete="off" name ="y">
				</td>
			</tr>
			<tr>
				<td align="center">
					<button>계산</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>