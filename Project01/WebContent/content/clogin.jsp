<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js">
	
</script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="<%=request.getContextPath()%>/js/login.js"></script>

</head>
<body>

	<%
		Cookie[] cookie = request.getCookies();
		if (cookie != null) {

			for (Cookie c : cookie) {
				if (c.getName().equals("cid")) {
					session.setAttribute("cid", c.getValue());
				}
			}
		}
	%>
	<div class="container" id="hed">
		<div class="content">
			<div id="login_id">
				<c:if test="${sessionScope.cid != null}">
					<div id="l_id">${sessionScope.cid}</div>
				</c:if>
			</div>
			
			<input type="button" class="btn btn-info" value="마이 페이지 "
				onClick="location.href='counpage.do'"> <input type="button"
				class="btn btn-info" value="로그아웃"
				onClick="location.href='clogOut.do'">
			<div id=>
				<fieldset>
					<textarea id="messageWindow" rows="10" cols="23" readonly></textarea>
					<br /> <input id="inputMessage" type="text" onkeyup="enterkey()">
					<input type="submit" value="send" onClick="send()">
				</fieldset>
			</div>
		</div>c
	</div>
</body>
</html>