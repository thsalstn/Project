<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style2.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>
</head>
<body>
	<section class="container">
		<h1>아이디 찾기</h1>
		
		<form action="id_find.do" method="post">
			<div class="int-area">
				<input type="text" name="id_find_auth_name" id="id_find_auth_name" autocomplete="off" required>
				<label for="name"> NAME </label>
			</div>

			<div class="form-group">
				<div class="from-control" id="l_id_message"></div>
			</div>

			<div class="int-area">
				<input type="text" name="id_find_auth_email" id="id_find_auth_email" autocomplete="off" required>
				<label for="email"> E-MAIL </label>
			</div>
			<div class="btn-area">
				<button type="submit" id="id_pw_find_auth">FIND</button>
			</div>
	</form>
	</section>
</body>
</html>