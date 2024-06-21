<%@page import="com.oj.jun211.main.Beaver"%>
<%@page import="java.util.ArrayList"%>
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
		// EL (Expression Language)
		//	값 받을 때 Java 대신 (<%) 가능
		// 	.jsp 에서만 사용 가능
		//		(.jsp를 톰캣이 Servlet으로 바꿀 때 EL을 Java 코드로 바꿔줌)
		// 	문법 : ${xxx}
		//		연산자 사용 가능
		//		형 변환 자동
		//		값이 없으면 그냥 넘어감
		//		import가 없어도 됨
		
		//	파라미터값 읽기 : ${param.파라미터명}
		//	어트리뷰트값 읽기(int,double, String,... 포함)
		//		: ${어트리뷰트명}
		//	어트리뷰트값 읽기 (객체)
		//		주소값 : ${어트리뷰트명}
		//		속성값 : ${어트리뷰트명.멤버변수명}
		
		//	어트리뷰트값 읽기 (List, [])
		//		AL, [] 자체 : ${어트리뷰트명}
		//		인덱스 위치의 객체 : ${어트리뷰트명[인덱스]} 
		//		인덱스 위치의 객체 속성 : ${어트리뷰트명[인덱스].멤버변수명}
		
		//	반복문, 조건문 - EL(X) / CustomTag(O)
	%>
	<%
	String x = request.getParameter("x");
	String y = request.getParameter("y");
	int z = (Integer) request.getAttribute("z");

	Beaver b = (Beaver) request.getAttribute("b");
	
	ArrayList<Beaver> bvs = (ArrayList<Beaver>) request.getAttribute("bvs");
	%>
	
	<h1>결과</h1>
	<%=x %> x <%=y %> = <%=z %><br>
	<%=b.getName() %> : <%=b.getAge() %> : <%=b.getHeight() %> : <%=b.getWeight() %><p>
	<%=b %><p>
	 
	<%=bvs %><p>
	<%=bvs.get(1) %><p>
	<%=bvs.get(2).getName() %>, <%=bvs.get(3).getAge() %><p><p>
	
	<%
		for (int i = 0; i< bvs.size(); i++){
			
	%>
		<%=bvs.get(i).getName() %> : <%=bvs.get(i).getAge() %>살<br>
	<% 
	}
	%>
	<hr>
	${param.x}<p>
	${param.y}<p>
	${param.x * param.y}<p>
	${z}<p>
	<hr>
	${b.name } ; ${b.age } : ${b.height } : ${b.weight }<p>
	<hr>
	${param.asd}
	<hr>
	${bvs }<p>
	${bvs[1] }<p>
	${bvs[2].name }, ${bvs[3].age }<p>
</body>
</html>