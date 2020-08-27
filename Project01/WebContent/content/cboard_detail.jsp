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
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<body>
	<!-- header -->
	<div>
		<%@include file="../header/header.jsp"%>
	</div>
	<!-- header -->


<table border=1 width=400 align=center>
	<caption>상세 페이지</caption>
	<tr><td>제목</td>
		<td>${cboard.CBOAR_TITLE }</td>
	</tr>
	<tr>
		<td>글쓴이</td>
		<td>${cboard.COUN_ID }</td>
	</tr>
	<tr><td>내용</td>
		<td>
		${CBOAR_CONT}
		<%-- <pre>${board.board_content}</pre> --%>
		</td>
	</tr>
	<%-- <tr><td>첨부파일</td>
		<td>
			<!-- 첨부파일이 있을때만 첨부파일 출력 -->
			<c:if test="${board.board_file != null }"> 
				<a href="<%=request.getContextPath() %>/board/file_down.jsp?file_name=${board.board_file }">
					${board.board_file}
				</a>
			</c:if>
		</td>
	</tr> --%>
	<tr>
		<td colspan=2 align=center>
			<%-- <input type="button" value="댓글" 
					onClick="location.href='./CBoardReplyAction.do?BOAR_NO=${board.BOAR_NO}&page=${page}'">	 --%>		
			<%-- <c:if test="${sessionScope.COUN_ID}"> --%>
				<input type="button" value="수정" 
					onClick="location.href='./CBoardModifyAction.do?CBOAR_NO=${cboard.CBOAR_NO}&page=${page}'">			
				<input type="button" value="삭제" 
					onClick="location.href='./CBoardDelete.do?CBOAR_NO=${cboard.CBOAR_NO}&page=${page}'">
			<%-- </c:if> --%>									
			<input type="button" value="목록" 
					onClick="location.href='./CBoardList.do?page=${page}' ">				
			<input type="button" value="뒤로" 
					onClick="history.go(-1)">				
		</td>
	</tr>	
</table>

<!-- footer -->
	<div>
		<%@include file="../footer/footer.jsp"%>
	</div>
	<!-- footer -->
</body>
</html>