<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="js\OjValidChecker.js"></script>
<script type="text/javascript" src="js\jun26_check.js"></script>
<title>Insert title here</title>
</head>
<body>
	<!-- 
		유효성 검사
		CSS
		input select textarea
	 -->
	 
	 <form action="AppleRegController" method="post" 
	 name="appleRegForm" onsubmit="return appleRegCheck();">
	 	지역 :<input type="text" name ="a_location"><br>
	 	색깔 :<input type="text" name ="a_color"><br>
	 	맛 :<input type="text" name ="a_flavor"><br>
	 	가격 :<input type="number" name ="a_price"><Br>
	 	설명 :<input type="text" name = "a_introduce"><br>
	 	<button>등록</button>
	 </form>
</body>
</html>