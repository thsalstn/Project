<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<style>

.navbar{
  margin :0px;
width: 1165px
}
#jumbo{
  height: 250px;
	width: 1165px;
}
</style>
<body>
	<div class="container">
		
				<img src="<%=request.getContextPath()%>/image/jumbo.jpg"  id="jumbo">
		
		<nav class="navbar navbar-inverse">
			<div class="container">
				<div class="navbar-header">
					<a class="navbar-brand" href="./Main.do">Team5</a>
				</div>
				<ul class="nav navbar-nav">
				     <li><a href="./inproduce.do">소개</a>					
					<li><a href="./CheckList.do">심리 검사 </a></li>
					<li><a href="./CBoardList.do">상담사 </a></li>
				    <li><a href="./BoardList.do">게시판</a></li>			
				</ul>
				<form class="navbar-form navbar-right" action="/action_page.php">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</nav>
		<!-- 로그인버튼 -->
	</div>
	<!-- 헤드 정보 -->
	
	
</body>
</html>