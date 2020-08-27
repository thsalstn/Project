<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="<%=request.getContextPath()%>/js/js.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<!-- header -->
	<div>
		<%@include file="../header/header.jsp"%>
	</div>
	<!-- header -->

<form action="/CBoardWrite.do" method="post">
<h4>글 양식</h4>
<table align="center" border=1>

<tr>
<td>아이디</td>
<td>${sessionScope.id}</td>
</tr> 

<tr>
	<td>제목</td>
	<td><input name="BOAR_TITLE" id="BOAR_TITLE" type="text" size="50" maxlength="100" ></td>
</tr>
<tr>
	<td>내용</td>
	<td><textarea name="BOAR_CONT" id="BOAR_CONT" clos="5" rows="40"></textarea></td>
</tr>
<br><br>
</table>
<input type="submit" value="등록">
<input type="reset" value="취소">
<input type="button" value="목록" onClick="./CBoardList.do">
</form>

	<!-- footer -->
	<div>
		<%@include file="../footer/footer.jsp"%>
	</div>
	<!-- footer -->
</body>
</html>