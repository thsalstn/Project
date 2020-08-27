<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<!DOCTYPE html>
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
	<table border=1 width=auto height="auto" align="center">
		<h4>게시판목록</h4>
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성자</td>
			<td>작성일</td>
			<td>조회</td>
		</tr>
		<c:if test="${empty cboardlist}">
			<tr>
				<td colspan = "5">작성된 게시글이 없습니다.</td>
			</tr>			
		</c:if>		
		<c:set var="no" value="${ clistcount - (page - 1) * 10}"/>
		<c:forEach var="cboard" items="${cboardlist}">
			<tr>
				<td>${no}
					<c:set var="no" value="${no-1}"/>
				</td>
				<td>
					<a href="./CBoardDetail.do?CBOAR_NO=${cboard.CBOAR_NO}&page=${page}">${cboard.CBOAR_TITLE}</a>
					<%-- <a href="javascript:detail(${cboard.CBOAR_NO}, ${page} )">${cboard.CBOAR_TITLE }</a>  --%>
				</td>
				<td>${cboard.COUN_ID}</td>
				<td>${cboard.CBOAR_TIME}</td>
				<td>${cboard.CBOAR_COUN}</td>
			</tr>
		</c:forEach>
	</table>
	
	<!-- 페이징 처리 -->
	<div align="center">
		<c:if test="${empty condition }">
			<c:if test="${clistcount > 0}">		
				<!-- 첫페이지 이동-->
				<a href="./CBoardList.do?page=1" style="text-decoration: none; border: 0px; text-decoration: none;">
					&lt;&lt; </a>
	
				<!-- 이전 페이지 -->
				<c:if test="${clistcount > 10 }">
					<a href="./CBoardList.do?page=${startPage-10}" style="border: 0px; text-decoration: none;"> [이전] </a>
				</c:if>
	
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i == page}">
						<!-- 현재 페이지 -->
						[${i}]	
					</c:if>
					<c:if test="${i != page}">
						<a href="./CBoardList.do?page=${i}" style="border: 0px; text-decoration: none;"> [${i}] </a>
					</c:if>
				</c:forEach>
	
				<!-- 다음 블럭 이동 -->
				<c:if test="${endPage < pageCount}"><!-- 페이지의 마지막 숫자 < 한 화면에 출력할 갯수 -->
					<a href="./CBoardList.do?page=${startPage+10}" style="border: 0px; text-decoration: none;"> [다음] </a>	
					<c:if test="${page gt pageCount }">
										
					</c:if>			
				</c:if>
	
				<!-- 마지막 페이지 이동-->
				<a href="./CBoardList.do?page=${pageCount}" style="text-decoration: none; border: 0px">
					&gt;&gt; </a>
			</c:if>
		</c:if>
		<c:if test="${not empty condition }">
			<c:if test="${clistcount > 0}">		
				<!-- 첫페이지 이동-->
				<a href="./CBoardList.do?page=1&opt=${opt}&condition=${condition}" style="text-decoration: none; border: 0px; text-decoration: none;">
					&lt;&lt; </a>
	
				<!-- 이전 페이지 -->
				<c:if test="${clistcount > 10 }">
					<a href="./CBoardList.do?page=${startPage-10}&opt=${opt}&condition=${condition}" style="border: 0px; text-decoration: none;"> [이전] </a>
				</c:if>
	
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<c:if test="${i == page}">[${i}]</c:if> <!-- 현재 페이지 -->
					<c:if test="${i != page}">
						<a href="./CBoardList.do?page=${i}&opt=${opt}&condition=${condition}" style="border: 0px; text-decoration: none;"> [${i}] </a>
					</c:if>
				</c:forEach>
	
				<!-- 다음 블럭 이동 -->
				<c:if test="${endPage < pageCount}"><!-- 페이지의 마지막 숫자 < 한 화면에 출력할 갯수 -->
					<a href="./CBoardList.do?page=${startPage+10}&opt=${opt}&condition=${condition}" style="border: 0px; text-decoration: none;"> [다음] </a>	
					<c:if test="${page gt pageCount }">
										
					</c:if>			
				</c:if>
	
				<!-- 마지막 페이지 이동-->
				<a href="./CBoardList.do?page=${pageCount}&opt=${opt}&condition=${condition}" style="text-decoration: none; border: 0px">
					&gt;&gt; </a>
			</c:if>
		</c:if>
		
		<div id="searchForm" style="border: 0px;">
        <form action="./CBoardList.do" method="post">
            <select name="opt">
                <option value="0">제목</option>
                <option value="1">내용</option>
                <option value="2">제목+내용</option>
                <option value="3">글쓴이</option>
            </select>
            <input type="text" size="20" name="condition"/>&nbsp;
            <input type="submit" value="검색"/>&nbsp;
            <%-- <c:if test="${sessionScope.id}"> --%>
            <input type="button" value=글쓰기 onClick="location.href='./CBoardForm.do'">
            <%-- </c:if> --%>            
        </form>    
    	</div>		
	</div>
	
	<script type="text/javascript">
		var id = '${sessionScope.id}';
		
		function detail(cboard_no, page){
			if(id == ""){
				alert('회원만 사용 가능한 게시판입니다. 로그인 해주세요.');
				location.href="loginForm.do";
				return false;
			}else{
				location.href="./CBoardDetail.do?CBOAR_NO="+cboard_no+"&page="+page;
			}
		}	
	</script>
		
	
	<!-- footer -->
	<div>
		<%@include file="../footer/footer.jsp"%>
	</div>
	<!-- footer -->
</body>
</html>