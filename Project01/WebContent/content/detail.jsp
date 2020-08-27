<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/css.css">
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="<%=request.getContextPath()%>/js/js.js"></script>
<script type="text/javascript">
$(function(){
	$('#slist').load('./CommList.do?BOAR_NO=${board.BOAR_NO}&page=${page}')
});

function Delete(BOAR_NO,page){
	var result = confirm("게시글을 삭제하시겠습니까?");
	if(result){
		location.href = "BoardDelete.do?BOAR_NO="+BOAR_NO+"&page="+page;
	}
}
</script>

</head>
<body>
	<!-- header -->
	<div>
		<%@include file="../header/header.jsp"%>
	</div>
	
	<div id = "board_main">
		<table id="detailboard">
			<tr>
				<th>글제목</th>
				<td>${board.BOAR_TITLE}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${board.MEM_ID}</td>
			</tr>
			<tr>
				<th>내  용</th>
				<td>${BOAR_CONT}</td>
			</tr>
		</table>
		<c:if test="${board.MEM_ID == sessionScope.id}">
		<input type="button" class="btn btn-dark" value="수정" onClick="location.href='BoardModifyForm.do?BOAR_NO=${board.BOAR_NO}&page=${page}'">
		<button class="btn btn-dark" onClick="javascript:Delete(${board.BOAR_NO}, ${page})">삭제</button>
		</c:if>
		<input type="button" class="btn btn-dark" value="목록" style="float:right;" onClick="location.href='BoardList.do?page=${page}'">
		<br>
		<br>
		
		<!-- 댓글 -->
		<%-- <div>
			<%@include file="./commentList.jsp" %>	
		</div> --%>
		<div id="slist"></div>
		<!-- 댓글 -->
	</div>
	
	<!-- footer -->
	<div>
		<%@include file="../footer/footer.jsp"%>
	</div>
	<!-- footer -->
</body>
</html>