<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#cv {
		background-color: #298463;
	}
</style>
<script type="text/javascript">
	function init() {
		var canvas = document.getElementById("cv");
		var context = canvas.getContext("2d");
		//canvas에 mousedown 이벤트 추가 : 이벤트 발생시 mDown 호출
		canvas.addEventListener("mousedown", function(me) {
			mDown(me)
		}, false);
		//canvas에 mousemove 이벤트 추가 : 이벤트 발생시 mMove 호출
		canvas.addEventListener("mousemove", function(me) {
			mMove(me)
		}, false);
		//canvas에 mouseup 이벤트 추가 : 이벤트 발생시 : mUp 호출
		canvas.addEventListener("mouseup", function(me) {
			mUp(me)
		}, false);
		//canvas에 mouseout 이벤트 추가 : 이벤트 발생시 mOut 호출
		canvas.addEventListener("mouseout", function(me) {
			mOut(me)
		}, false);
		
		//처음 마우스 X좌표
		var stX = 0;
		//처음 마우스 Y좌표
		var stY = 0;
		//마우스를 캔버스에서 움직였을 때 그림 그리기 여부
		var drag = false;
		
		//기본 strokeStyle 색상 설정
		var strokeStyle = "skyblue";
			function mDown(me) {
			stX = me.offsetX; //눌렀을 때 현재 마우스 X좌표를 stX에 담음
			stY = me.offsetY; //눌렀을 때 현재 마우스 Y좌표를 stY에 담음
			drag = true; //그림 그리기는 그리는 상태로 변경
		}
		function mMove(me) {
			//drag가 false 일때는 return(return 아래는 실행 안함)
			if (!drag) {
				return;
			}
			//마우스를 움직일 때마다 X좌표를 nowX에 담음
			var nowX = me.offsetX;
			//마우스를 움직일 때마다 Y좌표를 nowY에 담음
			var nowY = me.offsetY;
			//실질적으로 캔버스에 그림을 그리는 부분
			canvasDraw(nowX, nowY);
			//마우스가 움직일때마다 X좌표를 stX에 담음
			stX = nowX;
			//마우스가 움직일때마다 Y좌표를 stY에 담음
			stY = nowY;
		}
		function canvasDraw(currentX, currentY) {
			context.beginPath();
			context.lineWidth = 10;
			context.strokeStyle = strokeStyle; 
			//마우스를 누르고 움직일 때마다 시작점을 재지정
			context.moveTo(stX, stY);
			//마우스 시작점부터 현재 점까지 라인 그리기
			context.lineTo(currentX, currentY);
			context.stroke();
		}
		function mUp(me) {
			drag = false; //마우스를 떼었을 때 그리기 중지
		}
		function mOut(me) {
			drag = false; //마우스가 캔버스 밖으로 벗어났을 때 그리기 중지
		}
		
		// 캔버스를 초기화하는 함수
		// window 객체는 브라우저 창을 나타냄
		window.clearCanvas = function() {
			context.clearRect(0, 0, canvas.width, canvas.height);
		}
		
		// 색상 변경 함수
		window.chanceColor = function() {
			var input = document.getElementById("colorInput");
			strokeStyle = input.value; // input 값으로 strokeStyle 변경
		}
		
		// 파일 저장
		window.saveCanvas = function() {
			var fileName = document.getElementById("fileNameInput").value;
			if (!fileName) {
				alert("파일명을 입력하세요.");
				return;
			}
			var link = document.createElement('a');
			link.download = fileName + '.png'; // 사용자 입력 파일명을 사용하여 저장
			link.href = canvas.toDataURL(); // 캔버스 이미지를 데이터 URL로 변환
			link.click();
		}
	}
</script>
</head>
<body onload="init();">
	<c:if test="${sessionScope.loginMember == null  }">
		<h1>그림판 기능은 로그인 후 이용해주세요.</h1>
	</c:if>
	<c:if test="${sessionScope.loginMember != null  }">
		<canvas id="cv" width="1000px" height="600px"
			style='border: 3px solid #000;'></canvas>
		<br>
		<button onclick="clearCanvas();" class="printBtn">초기화</button>
		<hr>
		<input id="colorInput" placeholder="색상 값을 입력하세요" class="printInput"> 
		<button onclick="chanceColor();" class="printBtn">색상바꾸기</button>
		<hr>
		<input type="text" id="fileNameInput" placeholder="저장할 파일명 입력" class="printInput">
		<button onclick="saveCanvas();" class="printBtn">이미지 저장</button>
	</c:if>

</body>
</html>













