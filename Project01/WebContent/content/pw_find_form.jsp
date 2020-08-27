<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style2.css">
<script src="http://code.jquery.com/jquery-latest.js"></script>

<script>
	
</script>
</head>
<body>

	<section class="container">
		<h1>비밀번호 찾기</h1>
		
		<form action="pw_find.do" method="post">
			<div class="int-area">
				<input type="text" name="pw_find_auth_id" id="pw_find_auth_id" autocomplete="off" required>
				<label for="id"> ID </label>
			</div>

			<div class="form-group">
				<div class="from-control" id="l_id_message"></div>
			</div>
	         <div class="int-area">
				<input type="text" name="pw_find_auth_name" id="pw_find_auth_name" autocomplete="off" required>
				<label for="name"> NAME </label>
			</div>
			<div class="int-area">
				<input type="text" name="pw_find_auth_email" id="pw_find_auth_email" autocomplete="off" required>
				<label for="email"> E-MAIL </label>
			</div>
			<div class="btn-area">
				<button type="submit" id="id_find_auth">FIND</button>
			</div>
	</form>
	</section>
</body>
</html>