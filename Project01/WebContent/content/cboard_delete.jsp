<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<script src="http://code.jquery.com/jquery-Latest.js"></script>
	<script src="<%=request.getContextPath()%>/js/js.js"></script>
	<title>게시판 삭제</title>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<!-- header -->
	<div>
		<%@include file="../header/header.jsp"%>
	</div>
	<!-- header -->
	
	<%-- board_num :<%=request.getParameter("BOAR_NO")%> <br>
	nowpage : <%=request.getParameter("page")%> <br>
	
	board_num2 : ${param.BOAR_NO } <br>
	nowpage2 : ${param.page } <br> --%>

<form action="./CBoardDelete.do" method="post">
<input type="hidden" name="board_num" value="${param.CBOAR_NO}">
<input type="hidden" name="page" value="${param.page}">

<table cellpadding="0" cellspacing="0" align=center border=1 width=300>
	<tr align="center" valign="middle">
		<td colspan="5">게시판 삭제</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input name="COUN_ID" id="COUN_ID" type="password" size="10" maxlength="10" value="${empty sessionScope.id }">
		</td>
	</tr>
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr align="center" valign="middle">
		<td colspan="5">			
			<input type=submit value="삭제">
			<input type=button onclick="history.go(-1)" value="취소">
		</td>
	</tr>
</table>
</form>

<!-- footer -->
	<div>
		<%@include file="../footer/footer.jsp"%>
	</div>
	<!-- footer -->
</body>
</html>