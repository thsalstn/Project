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
<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="<%=request.getContextPath()%>/js/email.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/form.css">
</head>
<body>
	<form action="./counselor_delete.do" method="post" class="form-horizontal"
		id="counselor">
		<input type="hidden" name="coun_id" id ="coun_id" value="${sessionScope.id}">
		<input type="hidden" name="coun_social" id ="coun_social" value="${sessionScope.social}">
		<div class="container" id="hed">
			<div class="content">									
				<!--이메일 -->
				<label for="coun_email1">이메일</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class=" glyphicon glyphicon-envelope"></i>
							</span> <input type="text" class="form-control" id="coun_email1"
								name="coun_email1" value="${email[0]}" readonly>
						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_email2"
							name="coun_email2" value="${email[1]}" readonly>
					</div>
				
				</div>								
				<div class="form-group">
					<div class="from-control" id="counemail"></div>
				</div>
           
           	<!--이메일 인증  -->           	
          	
				<div class="form-group">
					<button type="button" class="btn btn-info" id="email_auth">이메일
						인증</button>
					<div class="from-control" id="auth_message"></div>
				</div>
				
				<!--가입  -->
				<div class="form-group " align="center">

					<input type="submit" id="sub" class="btn btn-info" value="가입" >

					<button type="button" class="btn btn-info" onclick="ti()">취소</button>

				</div>
			</div>
		</div>
	</form>


</body>