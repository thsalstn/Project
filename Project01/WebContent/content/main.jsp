<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="<%=request.getContextPath()%>/js/js.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
 


</head>
<body>
	<!-- header -->
	<div>
		<%@ include file="/header/header.jsp"%>
	</div>
	<!-- header -->

	<!-- content -->


	  <div>
		<!-- 이미지 변경 -->
		<div id="cen">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->

			<div class="carousel-inner">
				<div class="item active">
					<img src="<%=request.getContextPath()%>/image/couple.jpg" id="pic">
					<div class="carousel-caption">
						<h3>커플 심리</h3>
						<p>서로를 더욱 더 알아가는 심리 테스트</p>
					</div>
				</div>
				<div class="item">
					<img src="<%=request.getContextPath()%>/image/color.jpg" id="pic">
				</div>
				<div class="item">
					<img src="<%=request.getContextPath()%>/image/4you.jpg" id="pic">
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>

		</div>
		</div>
		<div id="login_window">
			<c:if test="${!empty sessionScope.id}">
				<div>
					<div>${sessionScope.name}님</div>
					<c:if test="${sessionScope.num != 1 }">
						<div>
							<a href="./Record.do">내 검사 항목 :${sessionScope.record}개</a>
						</div>
						<div align=center>
							<c:if test="${sessionScope.id == 'guest'}">
								<input type="button" class="btn btn-info h_cjoin"
									value="상담사 입력">
							</c:if>
							<input type="button" class="btn btn-info"
								OnClick="location.href='./mypage.do'" value="마이페이지"> <input
								type="button" id="h_logout" class="h_logout btn btn-info"
								value="로그아웃">
						</div>
						<textarea id="messageWindow" rows="10" cols="32" readonly></textarea>
					<br/> <input id="inputMessage" type="text" onkeyup="enterkey()">		
		
					</c:if>
					<c:if test="${sessionScope.num == 1 }">
						<input type="button" id="h_logout" class="h_logout btn btn-danger"
							value="로그아웃">
						<input type="button" id="h_amend" class="h_camend btn btn-info"
							value="정보 수정">
					</c:if>
				</div>
				</c:if>			
		</div>
	</div>


	
	



	<!-- content -->

	<!-- footer -->
<div  id="foot">
		<%@include file="/footer/footer.jsp"%>
	</div>
	<!-- footer -->
</body>
<script type="text/javascript">
	var textarea = document.getElementById("messageWindow");
	var webSocket = new WebSocket("ws://15.164.165.19:8080/Project01/broadcasting");
	var inputMessage = document.getElementById('inputMessage');
    var name= "<%=session.getAttribute("name")%>";
    var list = "<%=session.getAttribute("list")%>";	
    webSocket.onerror = function(event) {
		onError(event)
	};
	webSocket.onopen = function(event) {
		onOpen(event);
	};
	webSocket.onmessage = function(event) {
		onMessage(event)
	};
	function onMessage(event) {
		var str = event.data;
		var msg = str.split("/");
 		var sw = msg[0];		
 		var sender = msg[1];
 		var content = msg[2];
 		
		if(sw =="404") {		
			str= sender+content;
			$('#id_list').text("");
			textarea.value += str + "\n";
		}else if(sw =="405") {		
			$('#id_list').append(sender);
		}else if(sw == "500") {
			str= sender+":"+content;
			textarea.value += str + "\n";
		}else if(sw == "400") {
			str= sender+":"+content;
			textarea.value += str + "\n";
		}	
// 		$('#id_list').append(event.data);
	}    
	function onOpen(event) {
 		$("#messageWindow").html("채팅방에 입장하셨습니다.\n");
		webSocket.send("404/"+name + "/" + "님이 입장하셨습니다");
	}
	function onError(event) {
		alert(event.data);
	}
	function send() {
		textarea.value += name + ":" + inputMessage.value + "\n";
		webSocket.send("500/"+ name + "/" + inputMessage.value);
		inputMessage.value = "";
		inputMessage.focus();
	}
	function enterkey() {
		if (window.event.keyCode == 13) {
			send();			
		}
	}

	window.setInterval(function() {

		var scroll = document.getElementById('messageWindow');
		scroll.scrollTop = scroll.scrollHeight;
	}, 0);
</script>
</html>