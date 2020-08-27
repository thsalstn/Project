<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
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
<script src="<%=request.getContextPath()%>/js/counselor.js?var=2"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/form.css">

</head>
<body>
	<form action="./counselor.do" method="post" class="form-horizontal"
		id="counselor">
	<input type ="hidden" id ="coun_social" name = "coun_social" value="1">
		<div class="container" id="hed">
			<div class="content">
				<!--아이디 입력  -->
				<div class="form-group">
					<label for="coun_id">아이디</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" id="coun_id" name="coun_id" class="form-control">	
						<div class="input-group-btn">
							<button class="btn btn-info" type="button" id="cidcheck">
								<i class="glyphicon glyphicon-search"></i>
							</button>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="counid"></div>
				</div>
				<!--비밀번호 입력 및 다시 확인  -->

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
				<div class="form-group">
					<label for="coun_pw2">비밀번호 재 확인</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-bell"></i>
						</span> <input type="password" class="form-control" id="coun_pw2"
							placeholder="Enter password">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="counpw2"></div>
				</div>
				<div class="form-group ">
					<label for="i_id">이름</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" id="coun_name" name="coun_name"
							class="form-control">
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
								name="coun_birth" placeholder="년 4자리" maxlength="4">
						</div>
					</div>
					<div class="col-xs-4">
						<select class="form-control" id="coun_month" name="coun_month">
							<option value="">월</option>
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
						</select>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_day"
							name="coun_day" placeholder="일"  maxlength="2">
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
								<option value="02">02</option>
								<option value="031">031</option>
								<option value="080">080</option>
							</select>

						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_tel2"
							name="coun_tel2" maxlength="3">
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_tel3"
							name="coun_tel3" maxlength="4">
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
								<option value="010">010</option>
								<option value="016">016</option>
								<option value="011">011</option>
							</select>

						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_phone2"
							name="coun_phone2" maxlength="4">
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_phone3"
							name="coun_phone3" maxlength="4">
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
						</span> <input type="text" id="coun_post" name="coun_post"
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
							class="form-control" />
					</div>
					<div class="col-xs-4">
						<input type="text" id="coun_addr2" name="coun_addr2"
							class="form-control" />

					</div>
				</div>

				<div class="form-group">
					<div class="from-control" id="counaddr"></div>
				</div>



				<!--이메일 
				<label for="coun_email1">이메일</label>
				<div class="form-group row">
					<div class="col-xs-4">
						<div class="input-group">
							<span class="input-group-addon"> <i
								class=" glyphicon glyphicon-envelope"></i>
							</span> <input type="text" class="form-control" id="coun_email1"
								name="coun_email1">
						</div>
					</div>
					<div class="col-xs-4">
						<input type="text" class="form-control" id="coun_email2"
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
				</div>	-->
				<!--DEPT 전공분야 작성  -->
				<div class="form-group ">
					<label for="dept">전공</label>
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" id="coun_dept" name="coun_dept"
							class="form-control">
					</div>
				</div>
				<div class="form-group">
					<div class="from-control" id="coundept"></div>
				</div>
				
				<!--가입  -->
				<div class="form-group " align="center">

					<input type="submit" class="btn btn-info" value="가입">

					<button type="button" class="btn btn-info" onclick="location.href='./Main.do'">취소</button>

				</div>
			</div>
		</div>
	</form>


</body>