<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<marquee><%=1230*877 %></marquee>
	
	<%--
		1. 스크립트릿 (Scriptlet)
		JSP에서 Java코드를 실행할 때 사용하는 블록
		<% Java코드가 여기에! %>
		2. 지시자
		특별한 지시를 내릴 수 있도록 하는 블록
		<%@ page/ include /taglib/ ... %>
		3.표현 식
		어떤 값을 (웹페이지에) 출력 결과로 포함시키고 싶을 때 사용하는 블록
		<%= 값/ 변수/ ...%>
		숫자, 문자열, 변수 등 값 사용 가능
		Servlet에서의 out.print() 와 같은 기능
		4. 선언문
		표현식에서 사용할 수 있는 Java의 method를 작성할 때 사용하는 블록
		<%! 멤버변수/ method %>
		Java의 method와 동일 (이름 규칙도 동일)
		5. 주석(이 설명들 감싼 블록이 주석)
		
	 --%>
	
</body>
</html>