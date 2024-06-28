<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function gogogo(){
		location.href="SecondC?a=20&b=200";
	}
</script>
</head>
<body>
	<%
	// 사용자가 어떠한 액션을 했을 때 이동 : 요청
	//	- <a> 태그를 써서 : 클릭하면 GET 방식
	//	- JS를 써서 : 이벤트를 추가했을 때
	//		(JS로 HTML만드는게 가능 => JS로 <form>을 만들면 POST방식도 가능)
	//	- <form> + <button> : 버튼을 클릭했을 때 GET/POST 방식
	%>
	<h1>First</h1>
	d : ${sessionScope.d }<br>
	e : ${cookie.e.value }<br>
	<a href="SecondC?a=10&b=200">SecondC로</a>
	<hr>
	<div onclick="gogogo();"> SecondC로</div>
	<hr>
	<form action="SecondC">
		<input name="a">
		<input name="b">
		<button>SecondC로</button>
	</form>

</body>
</html>