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

</head>
<body>

	<form action="./counselor_update.do" method="post" class="form-horizontal"
		id="counselor">
		<input type="hidden" name="coun_id" id ="coun_id" value="${counselor.coun_id}">
		<input type="hidden" name="coun_dept" id ="coun_dept" value="${counselor.coun_dept}">
		<div class="container" id="hed">
			<div class="content">
				<!--아이디 입력  -->
				
				<!--비밀번호 입력 및 다시 확인  -->
                 
					
				<div class="form-group">
					<div class="from-control" id="counpw2"></div>
				</div>
					<div class="form-group ">
					<label for="i_id">이름</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" id="coun_name" name="coun_name" value="${counselor.coun_name}" class="form-control" >
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="counname"></div>
				</div>


				<!--생년월일  -->
				<label for="coun_birth">생년월일</label>
				<div class="form-group row">
					<div class="col-xs-4 ">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class="glyphicon glyphicon-calendar"></i>
							</span> <input type="text" class="form-control" id="coun_birth"
								name="coun_birth" placeholder="년 4자리" maxlength="4" value="${birth[0]}">
						</div>
					</div>
					<div class="col-xs-4">
						<select class="form-control" id="coun_month" name="coun_month"
							disabled>
							<option value="">월</option>
							<option value="01"
								<c:if test="${birth[1] ==  '01'}">${"selected"}</c:if>>01</option>
							<option value="02"
								<c:if test="${birth[1] == '02'}">${"selected"}</c:if>>02</option>
							<option value="03"
								<c:if test="${birth[1] == '03'}">${"selected"}</c:if>>03</option>
							<option value="04"
								<c:if test="${birth[1] == '04'}">${"selected"}</c:if>>04</option>
							<option value="05"
								<c:if test="${birth[1] == '05'}">${"selected"}</c:if>>05</option>
							<option value="06"
								<c:if test="${birth[1] == '06'}">${"selected"}</c:if>>06</option>
							<option value="07"
								<c:if test="${birth[1] == '07'}">${"selected"}</c:if>>07</option>
							<option value="08"
								<c:if test="${birth[1] == '08'}">${"selected"}</c:if>>08</option>
							<option value="09"
								<c:if test="${birth[1] == '09'}">${"selected"}</c:if>>09</option>
							<option value="10"
								<c:if test="${birth[1] =='10'}">${"selected"}</c:if>>10</option>
							<option value="11"
								<c:if test="${birth[1] =='11'}">${"selected"}</c:if>>11</option>
							<option value="12"
								<c:if test="${birth[1] == '12'}">${"selected"}</c:if>>12</option>
						</select>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_day"
							name="coun_day" placeholder="일"  maxlength="2" value="${birth[2]}" readonly>
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="counbirth"></div>
				</div>
				<!--집 전화 번호  -->
				<label for="coun_tel1">집 전화번호</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon "> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <select class="form-control" id="coun_tel1" name="coun_tel1">
								<option value="02" <c:if test="${tel[0] == '02'}">${'selected'}</c:if>>02</option>
								<option value="031" <c:if test="${tel[0] == '031'}">${'selected'}</c:if>>031</option>
								<option value="080"<c:if test="${tel[0] == '080'}">${'selected'}</c:if>>080</option>
							</select>

						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_tel2"
							name="coun_tel2" maxlength="3" value="${tel[1]}">
					</div> 
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_tel3"
							name="coun_tel3" maxlength="4" value="${tel[2] }">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="countel"></div>
				</div>

				<!--핸드폰 번호  -->
				<label for="coun_phone1">핸드폰 번호</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon "> <i
								class="glyphicon glyphicon-phone"></i>
							</span> <select class="form-control" id="coun_phone1" name="coun_phone1">
								<option value="010" <c:if test="${phone[0] == '010'}">${'selected'} </c:if>>010</option>
								<option value="016" <c:if test="${phone[0] == '016'}">${'selected'} </c:if>>016</option>
								<option value="011" <c:if test="${phone[0] == '011'}">${'selected'} </c:if>>011</option>
							</select>

						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_phone2"
							name="coun_phone2" maxlength="4" value="${phone[1]}">
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_phone3"
							name="coun_phone3" maxlength="4" value="${phone[2]}">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="counphone"></div>
				</div>

				<!--주소 검색  -->
				<label for="coun_address">주소</label>
				<div class="form-group row">
					<div class="input-group col-xs-7">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-home"></i>
						</span> <input type="text" id="coun_post" name="coun_post" value="${counselor.coun_post}"
							class="form-control">
						<div class="input-group-btn">
							<button class="btn btn-info" type="button" id="addressbutton"
								onClick="openDaumPostcode()">우편번호 검색</button>
						</div>
					</div>
				</div>
				<div class="form-group row">
					<div class="col-xs-7">
						<input type="text" id="coun_addr1" name="coun_addr1"
							class="form-control" value="${counselor.coun_addr}" />
					</div>
					<div class="col-xs-4">
						<input type="text" id="coun_addr2" name="coun_addr2"
							class="form-control" value="${counselor.coun_addr2 }"/>

					</div>
				</div>

				<div class="form-group">
					<div class="from-control" id="counaddr"></div>
				</div>

				<!--이메일 -->
			
			
				<label for="coun_email1">이메일</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class=" glyphicon glyphicon-envelope"></i>
							</span> <input type="text" class="form-control" id="coun_email1"
								name="coun_email1" value="${email[0]}"  >
						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_email2" value="${email[1]}"
							name="coun_email2">
					</div>
					<div class="col-xs-4">
						<select id="coun_domain" class="form-control" name="coun_domain">
							<option value="">직접입력</option>
							<option value="naver.com">네이버</option>
							<option value="daum.net">다음</option>
							<option value="nate.com">네이트</option>
							<option value="gmail.com">gmail</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="counemail"></div>
				</div>

				<!--가입  -->
				<div class="form-group " align="center">

					<input type="submit" id="sub" class="btn btn-info" value="수정" >

					<button type="button" class="btn btn-info" onclick="ti()">취소</button>

				</div>
			</div>
		</div>
	</form>


</body>