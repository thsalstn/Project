<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="932339617596-7nffgo9n806mr2icsvnr41jc3n0p73l5.apps.googleusercontent.com">
<script src="<%=request.getContextPath()%>/js/login.js"></script>
<title>MBID 심리 검사 상담~~</title>
</head>
<style>
#social_b{
  width:50px;
  height:50px;  
}
#auto-login{
color: #fff;
}
</style>
<body>


	<section class="login-form">
		<h1>MBIT 심리</h1>
		<form action="login.do" method="post" class="form-horizontal"
			id="member">
			<div class="int-area">
				<input type="text" name="id" id="id" autocomplete="off" required>
				<label for="id">ID</label>
			</div>

			<div class="form-group">
				<div class="from-control" id="l_id_message"></div>
			</div>

			<div class="int-area">
				<input type="password" name="pw" id="pw" autocomplete="off" required>
				<label for="pw">PASSWORD</label>
			</div>
			<div class="form-group">
				<div class="from-control" id="l_pw_message"></div>
			</div>
			<c:if test="${result=='-1'}">
				<div class="form-group">
					<div class="from-control">가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.</div>
				</div>
			</c:if>
			<div id="auto-login">
				<input type="checkbox" id="login-cookie" name="login-cookie" value="true">자동로그인
			</div>
			
			<div class="btn-area">
				<button type="submit" class=login>LOGIN</button>
				<button onClick="location.href ='./memberform_join.do'" class=join>JOIN</button>
			</div>

			<div class="social" align="center">소셜로그인</div>

			<div class="form-group" align="center">
				
					<a href="${apiURL}"><img height="50" src="<%=request.getContextPath()%>/image/naver.PNG" id="social_b" name="social_b"/></a>													
					<a href="https://kauth.kakao.com/oauth/authorize?client_id=6c5e0f5424602dd8ffaff610fa2940f7&redirect_uri=http://15.164.165.19:8080/Project01/kakaologin.do&response_type=code">
				    <img src="<%=request.getContextPath()%>/image/kakaolink_btn_medium.png" id="social_b">
					</a>
					<img src="<%=request.getContextPath()%>/image/google_logo_icon_134448.png" id="social_b" class="g-signin2" data-onsuccess="onSignIn">
	 				
<!-- 				    <div class="g-signin2" data-onsuccess="onSignIn"></div> -->
				
			</div>
		</form>
		<div class="caption">
			<a href="id_find_form.do">아아디 찾기</a>
			<a href="pw_find_form.do">비밀번호 찾기</a>
		</div>
		<div class="caption">
			<a href="cloginform.do">상담사 로그인</a>
		</div>
	</section>
</body>

</html>