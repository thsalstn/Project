<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="<%=request.getContextPath()%>/js/pw.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/form.css">

</head>
<body>

	<form action="./counselor_pw_ck.do" method="post" class="form-horizontal"
		id="counselor">
		<input type="hidden" name="coun_id" id ="coun_id" value="${sessionScope.id}">
		<input type="hidden" name="num" id ="num" value="<%=request.getParameter("num")%>">
		<div class="container" id="hed">
			<div class="content">			              				
				<div class="form-group">
					<label for="coun_pw">비밀번호</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-lock"></i>
						</span> <input type="password" class="form-control" id="coun_pw"
							name="coun_pw" placeholder="Enter password">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="counpw"></div>
				</div>  
				    	
				<!--가입  -->
				<div class="form-group " align="center">

					<input type="submit"  class="btn btn-info" value="가입" >

					<button type="button" class="btn btn-info" onclick="ti()">취소</button>

				</div>
			</div>
		</div>
	</form>


</body>