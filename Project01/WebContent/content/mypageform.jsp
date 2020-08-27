<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="<%=request.getContextPath()%>/js/js.js"></script>
</head>
<body>
	<!-- header -->
	<div>
		<%@ include file = "../header/header.jsp" %>
	</div>
	<!-- header -->

	<c:if test="${sessionScope.social == 1}">

		<div id="my_local">
			<a href="./local.do">내가 주위 심리 상담소 </a>
		</div>
		<div id="my_pw_update">
			<a href="./member_pw_ck_form.do?num=1">비밀번호 수정 </a>
		</div>

	</c:if>
	<div id="my_info_update">
		<a href="./member_pw_ck_form.do?num=2">정보 수정 </a>
	</div>
	<div id="my_delete">
		<a href="./member_pw_ck_form.do?num=3">회원탈퇴 </a>
	</div>
	<div id="my_write">
		<a href="./my_write.do">내 게시판 글 </a>
	</div>
	<div id="my_record">
		<a href="./Record.do">내가 본심리 검사 항목 </a>
	</div>


	<!-- footer -->
	<div>
		<%@include file = "../footer/footer.jsp" %>
	</div>
	<!-- footer -->
</body>
</html>