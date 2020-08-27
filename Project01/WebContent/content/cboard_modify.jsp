<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
<head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
	<title>게시판 수정</title>
	<script src="http://code.jquery.com/jquery-latest.js"></script>
	<script src="<%=request.getContextPath()%>/js/js.js"></script>
	<script src="resources/board/script.js"></script>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<!-- header -->
	<div>
		<%@include file="../header/header.jsp"%>
	</div>
	<!-- header -->
	
<form action="./CBoardModify.do" method="post">
<input type="hidden" name="CBOAR_NO" value="${cboard.CBOAR_NO}">
<input type="hidden" name="page" value="${page}">

<table cellpadding="0" cellspacing="0" align=center border=1>
	<tr align="center" valign="middle">
		<td colspan="5">게시판 수정</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">글쓴이</div>
		</td>
		<td>
			<input name="COUN_ID" id="COUN_ID" type="text" size="10" maxlength="10" 
				value="${cboard.COUN_ID }" disabled="disabled"/>
		</td>
	</tr>
	<!-- <tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">비밀번호</div>
		</td>
		<td>
			<input name="board_pass" id="board_pass" type="password" size="10" maxlength="10">
		</td>
	</tr> -->
	<tr>
		<td style="font-family:돋음; font-size:12" height="16">
			<div align="center">제 목</div>
		</td>
		<td>
			<input name="CBOAR_TITLE" id="CBOAR_TITLE" type="text" size="50" maxlength="100" 
				   value="${cboard.CBOAR_TITLE }"/>
		</td>
	</tr>
	<tr>
		<td style="font-family:돋음; font-size:12">
			<div align="center">내 용</div>
		</td>
		<td>
			<textarea name="CBOAR_CONT" id="CBOAR_CONT" cols="67" rows="15">${cboard.CBOAR_CONT}</textarea>
		</td>
	</tr>	
	<tr bgcolor="cccccc">
		<td colspan="2" style="height:1px;">
		</td>
	</tr>
	<tr><td colspan="2">&nbsp;</td></tr>
	<tr align="center" valign="middle">
		<td colspan="5">			
			<input type=submit value="수정">
			<input type=reset onclick="history.go(-1)" value="취소">
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