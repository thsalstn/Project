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
	<div id = "re_main">
		<h1>검사 이력</h1>
		<table id = "re_list">
			<tr>
				<th colspan = "4"><h2>테스트 총 갯수 : ${sum} 개 MBTI : ${MBTI} 개 스트레스 : ${stress} 개 우울증 : ${depression} 개 알코올 중독 : ${alcohol} 개 게임 중독 : ${game} 개</h2></th>
			</tr>
			
			<tr>
				<th id = "re_num"><h2>번호</h2></th>
				<th id = "re_type"><h2>검사</h2></th>
				<th id = "re_grade"><h2>등급</h2></th>
				<th id = "re_time"><h2>날짜</h2></th>
			</tr>
			<c:choose>
				<c:when test = "${empty recordlist}">
						<tr>
							<td colspan = "4"><h2>테스트 이력이 없습니다.</h2></td>
						</tr>
				</c:when>
				
				<c:when test = "${!empty recordlist}">
					<c:forEach var = "record" items = "${recordlist}">
						<tr>
							<td id = "re_num"><h4>${record.NUM}</h4></td>
							<td id = "re_type"><h4><a href = "./Recorddetail.do?no=${record.PSYC_NO}&grade=${record.DETI_GRADE}">${record.PSYC_TYPE}</a></h4></td>
							<td id = "re_grade"><h4>${record.DETI_GRADE}</h4></td>
							<td id = "re_time"><h4>${record.RECO_TIME}</h4></td>
						</tr>
					</c:forEach>
				</c:when>
			</c:choose>
		</table>
	</div>
	
	<center>
	<div id = "re_paging">
		<c:if test="${listcount > 0}">
		<!-- 1페이지로 이동 -->
			<a href="./Record.do?page=1" 
			   style="text-decoration:none"> << </a>
			   
		<!-- 이전 블럭으로 이동 -->
			<c:if test="${startPage > 10 }">
				<a href="./Record.do?page=${startPage-10}"> [이전] </a>
			</c:if>	   
		
		<!-- 각 블럭의 페이지 10개 출력 -->
		<c:forEach var="i" begin="${startPage}" end="${endPage}">
			<c:if test="${i == page }">   <!-- 현재 페이지 -->
				[${i}]	
			</c:if>
			<c:if test="${i != page }">   
				<a href="./Record.do?page=${i}"> [${i}] </a>	
			</c:if>
		</c:forEach>
		
		<!-- 다음 블럭으로 이동 -->
		<c:if test="${endPage < pageCount}">
			<a href="./Record.do?page=${startPage+10}"> [다음] </a>
		</c:if>
		
		<!-- 마지막 페이지로 이동 -->
		<a href="./Record.do?page=${pageCount}"
		   style="text-decoration:none"> >> </a>
		
		</c:if>
	</div>
	</center>
	<!-- content -->
	
	<!-- footer -->
	<div>
		<%@include file = "../footer/footer.jsp" %>
	</div>
	<!-- footer -->
</body>
</html>