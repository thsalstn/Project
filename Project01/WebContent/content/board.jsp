<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="<%=request.getContextPath()%>/js/js.js"></script>
<style>
ul {
  display: table;
  margin-left: auto;
  margin-right: auto;
}
</style>
<script>
	var sess = '${sessionScope.id}'
	//console.log(sess)

	function move(board_no, page) {
		if (sess == "") {
			alert("게시판을 이용하시려면 로그인하셔야 합니다.");
			location.href = "loginForm.do";
			return false;
		} else {
			location.href = "BoardDetail.do?BOAR_NO=" + board_no + "&page="
					+ page;
		}
	}
</script>
</head>
<body>
	<!-- header -->
	<div>
		<%@include file="/header/header.jsp"%>
	</div>
	<!-- header -->
	<div class="container">
		<h2 align="left">게시판목록</h2>
		<input type="button" class="btn btn-dark" value="글쓰기"
			style="float: right" onClick="location.href='BoardForm.do'">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>작성자</th>
					<th>작성일</th>
					<th>조회</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty boardlist}">
					<br>작성된 게시글이 없습니다.
		</c:if>
				<c:set var="BOAR_NO" value="${listcount - (page-1) * 10 }" />
				<c:forEach var="board" items="${boardlist}">
					<tr>
						<td>${BOAR_NO}<c:set var="BOAR_NO" value="${BOAR_NO -1 }" /></td>
						<td>
							<a href="javascript:move(${board.BOAR_NO},${page})">
								${board.BOAR_TITLE} </a>
						</td>
						<td>${board.MEM_ID}</td>
						<td>${board.BOAR_TIME}</td>
						<td>${board.BOAR_COUN}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<!-- 검색 -->
	<div align="center">
	<form action="./BoardList.do?page=1">
		<select name="op">
			<option value="0"
				<c:if test="${op == '0'}">selected="selected"</c:if>>제목</option>
			<option value="1"
				<c:if test="${op == '1'}">selected="selected"</c:if>>내용</option>
			<option value="2"
				<c:if test="${op == '2'}">selected="selected"</c:if>>제목+내용</option>
			<option value="3"
				<c:if test="${op == '3'}">selected="selected"</c:if>>아이디</option>
		</select> <input type="text" size="20" name="sc">&nbsp; 
				  <input type="submit" value="검색">
	</form>
	</div>
	
	<div id = "bo_paging">
	<!-- 페이지 처리 -->
		<ul class="pagination" id = "ul_paging">
			<c:if test="${not empty sc }">
				<c:if test="${startPage > 5}">
					<li><a href="./BoardList.do?page=${startPage -5}&op=${op}&sc=${sc}">이전</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<li ><c:if test="${i == page}">${i}</c:if></li>
					<li ><c:if test="${i != page}"><a href="./BoardList.do?page=${i}&op=${op}&sc=${sc}">${i}</a></c:if></li>
					
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<li><a href="./BoardList.do?page=${endPage + 5}&op=${op}&sc=${sc}">다음</a></li>
				</c:if>
			</c:if>
			<c:if test="${empty sc}">
				<c:if test="${startPage > 5}">
					<li><a href="./BoardList.do?page=${startPage-5}">이전</a></li>
				</c:if>
				<c:forEach var="i" begin="${startPage}" end="${endPage}">
					<li ><c:if test="${i == page}">${i}</c:if></li>
					<li ><c:if test="${i != page}"><a class="page-link" href="./BoardList.do?page=${i}">${i}</a></c:if></li>
					
				</c:forEach>
				<c:if test="${endPage < pageCount}">
					<li><a href="./BoardList.do?page=${startPage+5}">다음</a></li>
				</c:if>
			</c:if>
		</ul>
	</div>
	<!-- footer -->
	<div>
		<%@include file="../footer/footer.jsp"%>
	</div>
	<!-- footer -->
</body>
</html>