<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/cstyle.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://apis.google.com/js/platform.js" async defer></script>
<meta name="google-signin-client_id" content="932339617596-7nffgo9n806mr2icsvnr41jc3n0p73l5.apps.googleusercontent.com">
<script src="<%=request.getContextPath()%>/js/login.js"></script>
</head>

<body>


	<section class="clogin-form">
		<h1>상담사 페이지</h1>
		<form action="clogin.do" method="post" class="form-horizontal"
			id="counselor">
			<div class="int-area">
				<input type="text" name="cid" id="cid" autocomplete="off" required>
				<label for="cid">ID</label>
			</div>

			<div class="form-group">
				<div class="from-control" id="l_id_message"></div>
			</div>

			<div class="int-area">
				<input type="password" name="cpw" id="cpw" autocomplete="off" required>
				<label for="cpw">PASSWORD</label>
			</div>
			<div class="form-group">
				<div class="from-control" id="l_pw_message"></div>
			</div>
			<c:if test="${result=='-1'}">
				<div class="form-group">
					<div class="from-control">가입하지 않은 아이디이거나, 잘못된 비밀번호입니다.</div>
				</div>
			</c:if>
			<div>
				<input type="checkbox" id="clogin-cookie" name="clogin-cookie"
					value="true">자동로그인
			</div>
			<div class="btn-area">
				<button type="submit" class=clogin>LOGIN</button>
				<button onClick="location.href ='./counselorform_join.do'" class=cjoin>JOIN</button>
			</div>

			
		</form>
		<div class="caption">
			<a href="cid_pw_find_form.do">아아디/비밀번호 찾기</a>
		</div>
	</section>
</body>

</html>