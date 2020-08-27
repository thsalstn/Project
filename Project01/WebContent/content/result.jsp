<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel = "stylesheet" href="<%=request.getContextPath()%>/css/css.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src = "http://code.jquery.com/jquery-Latest.js"></script>
<script src="<%=request.getContextPath()%>/js/js.js"></script>
</head>
<body>
	<!-- header -->
	<div>
		<%@ include file = "../header/header.jsp" %>
	</div>
	<!-- header -->
	
	<!-- content -->
	<div id = "r_main" class = "r_main">
		<c:set target = "${resultlist}" property = "PSYC_NO" value = "${resultlist.PSYC_NO}"/>
		<c:set target = "${resultlist}" property = "PSYC_GRADE" value = "${resultlist.PSYC_GRADE}"/>
		<c:set target = "${resultlist}" property = "DETI_CONT" value = "${resultlist.DETI_CONT}"/>
		<c:set target = "${resultlist}" property = "DETI_GRADE" value = "${resultlist.DETI_GRADE}"/>
		
		<div id = "re_detail_image">
			<img src = "<%=request.getContextPath()%>/image/${resultlist.PSYC_NO}${resultlist.DETI_GRADE}.png"/>
			<c:if test = "${resultlist.PSYC_NO == 1}">
				<center>
					<a href = "./resultsee.do?check=${resultlist.PSYC_NO}&point=${resultlist.DETI_GRADE}">자세히 보기</a>
				</center>
			</c:if>
		</div>
		
		<c:if test = "${resultlist.PSYC_NO != 3}">
			<div id = "re_detail_letter">
				<center>
					<c:out value = "${resultlist.DETI_GRADE}"/><br>
					<c:out value = "${resultlist.PSYC_GRADE}"/><br>
				</center>
				<c:out value = "${resultlist.DETI_CONT}"/><br>
			</div>
		</c:if>
	</div>
	<!-- content -->
	
	<!-- footer -->
	<div>
		<%@include file = "../footer/footer.jsp" %>
	</div>
	<!-- footer -->
</body>
</html>