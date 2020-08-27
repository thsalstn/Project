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
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/form.css">
<script src="<%=request.getContextPath()%>/js/updateMember2.js?var=1"></script>
</head>
<body>

	<form action="./member_Nupdate.do" method="post" class="form-horizontal"id="member">
		<input type="hidden" name="mem_id" id ="mem_id" value="${member.mem_id}">
		<input type="hidden" name="mem_social" id ="mem_social" value="${member.mem_social}">
		<div class="container" id="hed">
			<div class="content">
				<!--아이디 입력  -->
				
				<!--비밀번호 입력 및 다시 확인  -->
                 
					
				<div class="form-group">
					<div class="from-control" id="mypw2"></div>
				</div>
					<div class="form-group ">
					<label for="i_id">이름</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" id="mem_name" name="mem_name" value="${member.mem_name}" class="form-control" disabled >
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="myname"></div>
				</div>


			
				<!--이메일 -->			
				<label for="mem_email1">이메일</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class=" glyphicon glyphicon-envelope"></i>
							</span> <input type="text" class="form-control" id="mem_email1" name="mem_email1" value="${email[0]}" >
						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_email2" value="${email[1]}" name="mem_email2">
					</div>
					<div class="col-xs-4">
						<select id="mem_domain" class="form-control" name="mem_domain">
							<option value="">직접입력</option>
							<option value="naver.com">네이버</option>
							<option value="daum.net">다음</option>
							<option value="nate.com">네이트</option>
							<option value="gmail.com">gmail</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="myemail"></div>
				</div>
 	<!--이메일 인증  -->           	
          	
				<div class="form-group">
					<button type="button" class="btn btn-info" id="email_auth">이메일 인증</button>
					<div class="from-control" id="auth_message"></div>
				</div>
				<!--가입  -->
				<div class="form-group " align="center">

					<input type="submit" id="sub" class="btn btn-info" value="수정" >

					<button type="button" class="btn btn-info" onclick="location.href='./mypage.do'">취소</button>

				</div>
			</div>
		</div>
	</form>


</body>