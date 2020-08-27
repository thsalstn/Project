<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<link rel = "stylesheet" href="<%=request.getContextPath()%>/css/css.css">
<script src="<%=request.getContextPath()%>/js/js.js"></script>
</head>
<body>
	<!-- header -->
	<div>
		<%@ include file = "../header/header.jsp" %>
	</div>
	<!-- header -->
	
	<div class="container">

		<table class="table table-bordered">
			<thead>
				<tr>
										
					<th>이름</th>
					<th>제목</th>
					<th>내용</th>
					<th>시간</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty list}">
					<tr>
						<td colspan = "5">작성된 게시글이 없습니다.</td>
					</tr>
		        </c:if>
		      
				<c:forEach var="boarDTO" items="${list}">
					<tr>
					  
					 	<td>${sessionScope.name}</td>
						<td><a href="./BoardDetail.do?BOAR_NO=${boarDTO.BOAR_NO}&page=${page}" >${boarDTO.BOAR_TITLE }</a></td>
						<td>${boarDTO.BOAR_CONT }</td>
						<td>${boarDTO.BOAR_TIME }</td>
						<td>${boarDTO.BOAR_COUN}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<!--페이지 처리  -->

<c:if test="${listCount > 0}">



<!--1페이지로 이동  -->
<a href="./my_write.do?page=1" style="text-decoration: none"> << </a>

<c:if test="${startPage > 10 }">
<a href="./my_write.do?page=${startPage-10}" style="text-decoration: none"> [이전] </a>
</c:if>
<!--각 블럭의 페이지 10개 출력  -->
<c:forEach var="i" begin="${startPage}" end="${endPage}">
   <c:if test="${i == page }"> <!--현재 페이지  -->
     [${i}]
   </c:if>
   <c:if test="${ i != page }">
     <a href = "./my_write.do?page=${i}">[${i}]</a>
   </c:if>
</c:forEach>
<c:if test="${endPage < pageCount}">
<a href="./my_write.do?page=${startPage+10}" style="text-decoration: none"> [다음] </a>
</c:if>

<a href="./my_write.do?page=${pageCount}" style="text-decoration: none"> >> </a>


</c:if>






		
	</div>
	
	<!-- footer -->
	<div>
		<%@include file = "../footer/footer.jsp" %>
	</div>
	<!-- footer -->
</body>
</html>