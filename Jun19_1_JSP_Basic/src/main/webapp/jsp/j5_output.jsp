<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getRandomColor() {
		
		// Math.random()	=> 0 ~ 0.99999
		// Math.random()*255	=> 0 ~ 254.999999
		// Math.round(Math.random()*255)	=> 0 ~ 255 (반올림)
		
		let r = Math.round(Math.random()*255);
		let g = Math.round(Math.random()*255);
		let b = Math.round(Math.random()*255);
		
		return "rgb(" + r + "," + g + "," + b + ")"";
	}
	function init(){
		let cv = document.getElementById("cv");
		let pen = cv.getContext("2d");
		let x = 0;
		let y = 0;
		
		setInterval(() => {
			pen.save();
			pen.fillStyle="rgba(0,0,0,0.2)";
			pen.fillRect(0,0,500,500);
			
			pen.shadowOffSetX=0;
			pen.shadowOffSetY=0;
			pen.shadowBlur=5;
			pen.shadowColor="white";
			
			x=Math.random()*500;
			y=Math.random()*500;
			pen.fillStyle=getRandomColor();
			pen.fillRect(x,y,20,20);
			
			pen.restore();
		}, 200);
	}
</script>
</head>
<body onload="init();">

	<canvas id ="cv" width="500px" height="500px"></canvas>
	<hr>

	<%!public int getNum(String s) {
		String[] num = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "0" };
		for (int i = 0; i < num.length; i++) {
			if (s.contains(num[i])) {
				return Integer.parseInt(s);
			}
		}
		return 0;
	}%>

	<%
	// response.sendRedirect("test.jsp");
	request.setCharacterEncoding("UTF-8");
	String text = request.getParameter("inputText");
	String[] textArr = text.split(",");
	int sum1 = 0;

	for (int i = 0; i < textArr.length; i++) {
		sum1 += getNum(textArr[i]);
	}
	%>

	<%
	StringTokenizer st = new StringTokenizer(text,",");
	int sum2 = 0;
	while(st.hasMoreTokens()){
		try{
			sum2+=Integer.parseInt(st.nextToken());
		}catch(Exception e){
		}
	}
	%>

	<div>
		합(Split) : <%=sum1%><br>
		합(StringTokenizer) : <%=sum2%><br>

	</div>

</body>
</html>