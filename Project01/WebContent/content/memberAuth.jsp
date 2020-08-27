<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="<%=request.getContextPath()%>/js/member.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/form.css">
<body>

	<div class="container" id="hed">
		<div class="content">
			<div class="form-group" style="display: none" id="af">
				<div class="from-control" id="e_success" align="center">
				</div>
				<button type="button" class="btn btn-info" id="e_end">확인</button>
			</div>
			<div class="form-group row" align="right" id="be">
				<div class="col-xs-7">
					<input type="text" class="form-control" id="code">
				</div>
				<div class="col-xs-5">
					<button type="button" class="btn btn-info" id="code_check">확인</button>
					<button type="button" class="btn btn-info"
						value=<%=request.getAttribute("mail")%> id="email_code">이메일
						인증</button>
				</div>
			</div>
			<div class="form-group" id="e_time"></div>
		</div>
	</div>
</body>
</html>