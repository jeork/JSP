<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function gogo() {
		location.href="Second.jsp?a=100&b=200";
	}
</script>
</head>
<body>
	<h1>First</h1>
	<hr>
	
	<!-- 
		First.jsp 에서 두 숫자를 입력했을 때
		Second.jsp 에서 각 숫자들 출력하기 
	 -->
	 <a href = "Second.jsp?a=10&b=20">&lt;a&gt;로 [GET방식]</a><hr>
	 <div onclick="gogo();">JavaScript [GET방식]</div><hr>
	 <form action="Second.jsp">
	 	첫번째 숫자 : <input name = "a"><br>
	 	두번째 숫자 : <input name = "b"><br>
	 	<button>입력</button>
	 </form>
</body>
</html>