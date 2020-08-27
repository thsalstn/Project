<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/board.css">
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css.css">
<script src="<%=request.getContextPath()%>/js/js.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>

<!-- header -->
	<div>
		<%@include file="../header/header.jsp"%>
	</div>
	<!-- header -->
	
<form action="./BoardWrite.do" method="post">
<input  type="hidden" name="MEM_ID" value="${sessionScope.id}">
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
<input class="btn btn-dark" type="submit" value="등록">
<input class="btn btn-dark" type="reset" value="취소">
<input class="btn btn-dark" type="button" value="목록" onClick="location.href='BoardList.do'">
</form>

</table>
	<!-- footer -->
	<div>
		<%@include file="../footer/footer.jsp"%>
	</div>
	<!-- footer -->
</body>
</html>