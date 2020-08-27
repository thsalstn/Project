<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<script src="<%=request.getContextPath()%>/js/naverMember.js?var=1"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/form.css">

</head>
<body>
   
	<form action="./member.do" method="post" class="form-horizontal"
		id="member">
		<input type ="hidden" id ="mem_social" name = "mem_social" value="2">
		<div class="container" id="hed">
			<div class="content">
				
			<div class="form-group ">
					<label for="mem_id">아이디</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" id="mem_id" name="mem_id" class="form-control" value="${id}"  readonly >	
						<div class="input-group-btn">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="myid"></div>
				</div>
				<!--비밀번호 입력 및 다시 확인  -->

					<div class="form-group ">
					<label for="i_id">이름</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" id="mem_name" name="mem_name" value="${name}" class="form-control">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="myname"></div>
				</div>


				<!--생년월일  -->
				<label for="mem_birth">생년월일</label>
				<div class="form-group row">
					<div class="col-xs-4 ">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="text" class="form-control" id="mem_birth"
								name="mem_birth" placeholder="년 4자리" maxlength="4" >
						</div>
					</div>
					<div class="col-xs-4">
						<select class="form-control" id="mem_month" name="mem_month" disabled>
							<option value="" >월</option>
							<option value="01" <c:if test="${birth[0] ==  01}">${'selected'}</c:if>>01</option>
							<option value="02" <c:if test="${birth[0] == '02'}">${'selected'}</c:if>>02</option>
							<option value="03" <c:if test="${birth[0] == '03'}">${'selected'}</c:if>>03</option>
							<option value="04" <c:if test="${birth[0] == '04'}">${'selected'}</c:if>>04</option>
							<option value="05" <c:if test="${birth[0] == '05'}">${'selected'}</c:if>>05</option>
							<option value="06" <c:if test="${birth[0] == '06'}">${'selected'}</c:if>>06</option>
							<option value="07" <c:if test="${birth[0] == '07'}">${'selected'}</c:if>>07</option>
							<option value="08" <c:if test="${birth[0] == '08'}">${'selected'}</c:if>>08</option>
							<option value="09" <c:if test="${birth[0] == '09'}">${'selected'}</c:if>>09</option>
							<option value="10" <c:if test="${birth[0] =='10'}">${'selected'}</c:if>>10</option>
							<option value="11" <c:if test="${birth[0] =='11'}">${'selected'}</c:if>>11</option>
							<option value="12" <c:if test="${birth[0] == '12'}">${'selected'}</c:if>>12</option>
						</select>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_day"
							name="mem_day" placeholder="일"  maxlength="2" value="${birth[1]}" readonly>
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="mybirth"></div>
				</div>
				<!--집 전화 번호  -->
				<label for="mem_tel1">집 전화번호</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon "> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <select class="form-control" id="mem_tel1" name="mem_tel1">
								<option value="02">02</option>
								<option value="031">031</option>
								<option value="080">080</option>
							</select>

						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_tel2"
							name="mem_tel2" maxlength="3">
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_tel3"
							name="mem_tel3" maxlength="4">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="mytel"></div>
				</div>

				<!--핸드폰 번호  -->
				<label for="mem_phone1">핸드폰 번호</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon "> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <select class="form-control" id="mem_phone1" name="mem_phone1">
								<option value="010">010</option>
								<option value="016">016</option>
								<option value="011">011</option>
							</select>

						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_phone2"
							name="mem_phone2" maxlength="4">
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_phone3"
							name="mem_phone3" maxlength="4">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="myphone"></div>
				</div>

				<!--주소 검색  -->
				<label for="mem_address">주소</label>
				<div class="form-group row">
					<div class="input-group col-xs-7">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-home"></i>
						</span> <input type="text" id="mem_post" name="mem_post"
							class="form-control">
						<div class="input-group-btn">
							<button class="btn btn-info" type="button" id="addressbutton"
								onClick="openDaumPostcode()">우편번호 검색</button>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-xs-7">
						<input type="text" id="mem_addr1" name="mem_addr1"
							class="form-control" />
					</div>
					<div class="col-xs-4">
						<input type="text" id="mem_addr2" name="mem_addr2"
							class="form-control" />

					</div>
				</div>

				<div class="form-group">
					<div class="from-control" id="myaddr"></div>
				</div>



				<!--이메일 -->
				<label for="mem_email1">이메일</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class=" glyphicon glyphicon-envelope"></i>
							</span> <input type="text" class="form-control" id="mem_email1"
								name="mem_email1" value="${email[0]}" readonly>
						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="mem_email2"
							name="mem_email2" value="${email[1]}" readonly>
					</div>
				
				</div>
				<div class="form-group">
					<div class="from-control" id="myemail"></div>
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