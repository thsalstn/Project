<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="<%=request.getContextPath()%>/js/npw.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/form.css">
<script src="<%=request.getContextPath()%>/js/js.js"></script>

</head>
<body>
<!-- header -->
	<div>
		<%@ include file = "../header/header.jsp" %>
	</div>
	<!-- header -->
	<form action="./member_pw_update.do" method="post" class="form-horizontal"
		id="member">
		<input type="hidden" name="mem_id" id ="mem_id" value="${sessionScope.id}">
		<input type="hidden" name="str" id ="str" value="${str}">
		<div class="container" id="hed">
			<div class="content">
			
                 				
				<div class="form-group">
					<label for="mem_pw">비밀번호</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-lock"></i>
						</span> <input type="password" class="form-control" id="mem_pw"
							name="mem_pw" placeholder="Enter password">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="mypw"></div>
				</div>    
					<div class="form-group">
					<label for="mem_pw2">비밀번호 재 확인</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-bell"></i>
						</span> <input type="password" class="form-control" id="mem_pw2"
							placeholder="Enter password">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="mypw2"></div>
				</div>  	
				<!--가입  -->
				<div class="form-group " align="center">

					<input type="submit"  class="btn btn-info" value="확인" >

					<button type="button" class="btn btn-info" onclick="./loginForm.do">취소</button>

				</div>
			</div>
		</div>
	</form>
<div>
		<%@include file = "../footer/footer.jsp" %>
	</div>

</body>