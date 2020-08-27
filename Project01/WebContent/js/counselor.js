var x;
var time = 6000;
var cidcheck = false;
$(document)
		.ready(
				function() {
					// ID 중복검사
					$("#cidcheck").click(function() {
										if ($("#coun_id").val() == "") {
											$("#counid").text("아이디를 입력하세요");
											$("#coun_id").focus();
											return false;
										} else {
											var cid = $("#coun_id").val();
											var pattern = /[^0-9a-z_\-]/;
											if (pattern.test(cid)|| cid.length <= 5|| cid.length >= 20) {
												$("#counid").text("6~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
											} else {
												$.ajax({
															type : "post",
															url : "cidCheck.do",
															data : {
																"cid" : cid
															},
															datatype : "text",
															success : function(
																	data) {
																if (data == 1) { // 중복
																	$("#counid").text("중복ID입니다");
																	$("#coun_id").val("").focus();
																} else { // 사용
																			// 가능
																	$("#counid").text("사용 가능한 ID");
																	$("#coun_pw").focus();
																	cidcheck = true;
																}
															}
														});
											}
										}
									});
					// ------------------------------------------------------------------------------------------
					// --------------------------유효성
					// 검사--------------------------------------------------------

					// 비밀번호 유효성 체크
					$("#coun_id").change(function() {
						var cid = $("#coun_id").val();
						var pattern = /[^0-9a-z_\-]/;
						if (pattern.test(cid)|| cid.length <= 5|| cid.length >= 20) {
							$("#counid").text("6~20자의 영문 소문자, 숫자와 특수기호(_),(-)만 사용 가능합니다.");
							$("#coun_id").val("").focus();
							return false;
						}else{
							$("#counid").text("중복체크 해주세요");
							cidcheck = false;
						}
						});
					$("#coun_pw").change(function() {

						regExppw($("#coun_pw").val());
					});
					// 비밀번호 체크
					$("#coun_pw2").change(function() {

						if ($("#coun_pw").val() != $("#coun_pw2").val()) {
							$("#counpw2").text("비밀번호가 일치하지 않습니다.");
						} else {
							$("#counpw2").text("비밀번호가 일치 합니다");
						}

					});
					// 아이디 유효성

					$("#coun_day").change(
							function() {

								regExpbirth($("#coun_birth").val(),
										$("#coun_day").val());
							});
					$("#coun_phone3").change(
							function() {
								regExpphone($("#coun_phone3").val(), $(
										"#coun_phone2").val());
							});

					$("#coun_tel3").change(function() {

						regExptel($("#coun_tel2").val(), $("#coun_tel3").val());
					});

					$("#coun_name").change(function() {

						regExpname($("#coun_name").val());
					});
					// -------------------------------------------------------------------------------------
					// ------------------------이메일 부분
					// ----------------------------------------------------
					// 도메인 선택
					$("#coun_domain").change(
							function() {
								if ($("#coun_domain").val() == "") { // 직접 입력 선택
									// $("#domain").attr("readonly", false);
									$("#coun_email2").removeAttr("readonly");
									$("#coun_email2").val("").focus();
								} else { // 도메인명 선택
									$("#coun_email2").val(
											$("#coun_domain option:selected")
													.val());
									$("#coun_email2").attr("readonly",
											"readonly");
								}
							});

					// 이메일 인증
					$("#email_auth")
							.click(
									function() {
										var mail = $("#coun_email1").val() + "@"
												+ $("#coun_email2").val();
										if ($("#coun_email1").val() == "") {
											$("#counemail").text(
													"이메일을 입력하셔야 합니다 ");
											$("#coun_email1").focus();
										} else if ($("#coun_email2").val() == "") {
											$("#counemail")
													.text("도메인 입력하셔야 합니다 ");
											$("#coun_email2").focus();

										}
					});

					// --------------------------------------------------------------------------------------------
					// ------------------------form submit
					// 부분-----------------------------------------------------

					$("form").submit(function() {

								if ($("#coun_id").val() == "") {
									$("#counid").text("아이디를 입력하세요");
									$("#coun_id").focus();
									return false;
								} else if (!cidcheck) {
									$("#counid").text("ID중복 체크를 해주세요.");
									$("#coun_id").focus();
									return false;
								}

								if ($("#coun_pw").val() == "") {
									$("#counpw").text("비밀번호를 입력하세요");
									$("#coun_pw").focus();
									return false;
								} else if ($("#coun_pw2").val() == "") {
									$("#counpw2").text("비밀번호를 입력하세요");
									$("#coun_pw2").focus();
									return false;
								}
								if (($("#coun_pw").val() != "" && ($("#coun_pw2").val() != ""))) {
									
									if (!regExppw($("#coun_pw").val())) {
										alert("비밀번호 오류");
										return false;
									}
								}

								if ($("#coun_pw").val() != $("#coun_pw2").val()) {
									$("#counpw2").text("비밀번호가 일치하지 않습니다.");
									$("#coun_pw2").focus();
									return false;
								}

								if ($("#coun_name").val() == "") {
									$("#counname").text("이름을 입력하세요");
									$("#coun_name").focus();
									return false;
								}
								if ($("#coun_name").val() != "") {									
									if (!regExpname($("#coun_name").val())) {
										alert("이름 오류");
										return false;
									}
								}

								if ($("#coun_birth").val() == "") {
									$("#counbirth").text("생년월일을 제대로 입력하세요 ");
									$("#coun_birth").focus();
									return false;
								} else if ($("#coun_month").val() == "") {
									$("#counbirth").text("생년월일을 제대로 입력하세요 ");
									$("#coun_month").focus();
									return false;
								} else if ($("#coun_day").val() == "") {
									$("#counbirth").text("생년월일을 제대로 입력하세요 ");
									$("#coun_day").focus();
									return false;
								}
								if ($("#coun_birth").val() != "" && $("#coun_month").val() != "") {
									
									if (!regExpbirth($("#coun_birth").val(), $("#coun_day").val())) {
										alert("생년월일오류");
										return false;
									}
								}

								if ($("#coun_tel2").val() == "") {
									$("#countel").text("전화번호를 제대로 입력하세요 ");
									$("#coun_tel2").focus();
									return false;
								}
								if ($("#coun_tel3").val() == "") {
									$("#countel").text("전화번호를 제대로 입력하세요 ");
									$("#coun_tel3").focus();
									return false;
								}
								if ($("#coun_tel3").val() != "" && $("#coun_tel2").val() != "") {
									
									if (!regExptel($("#coun_tel2").val(), $("#coun_tel3").val())) {
										alert("전화번호 오류");
										return false;
									}
								}

								if ($("#coun_phone2").val() == "") {
									$("#counphone").text("핸드폰 번호를 제대로 입력하세요 ");
									$("#coun_phone2").focus();
									return false;
								} else if ($("#coun_phone3").val() == "") {
									$("#counphone").text("핸드폰 뒷자리 제대로 입력하세요 ");
									$("#coun_phone3").focus();
									return false;
								}
								if ($("#coun_phone3").val() != ""&& $("#coun_phone2").val() != "") {						
									if (!regExpphone($("#coun_phone3").val(), $(
											"#coun_phone2").val())) {
										alert("핸드폰 오류");
										return false;
									}
								}

								if ($("#coun_addr1").val() == "") {
									$("#counaddr").text("주소를 제대로 입력하세요 ");
									$("#coun_addr1").focus();
									return false;
								}
								if ($("#coun_addr2").val() == "") {
									$("#counaddr").text("상세주소를 제대로 입력하세요 ");
									$("#coun_addr2").focus();
									return false;
								}
								if ($("#coun_email1").val() == "") {
									$("#counemail").text("이메일을 제대로 입력하세요 ");
									$("#coun_email1").focus();
									return false;
								}
								if ($("#coun_email2").val() == "") {
									$("#counemail").text("도메인을 제대로 입력하세요 ");
									$("#coun_email2").focus();
									return false;
								}
								if ($("#coun_dept").val() == "") {
									$("#coun_dept").text("전공분야를 입력하세요");
									$("#coun_dept").focus();
									return false;
								}
								if ($("#coun_dept").val() != "") {
									alert("이름");
									if (!regExpname($("#coun_dept").val())) {
										alert("전공분야 설정 오류");
										return false;
									}
								}
							});

				}); // ready() end

// ---------------------------------------------------------------------------------------
// -----------------------유효성
// 함수----------------------------------------------------
function regExpname(name) {

	var pattern = /[^가-힣\w]$/;
	if (pattern.test(name)) {
		$("#counname").focus();
		$("#counname").text("한글과 영문 대 소문자를 사용하세요. (특수기호, 공백 사용 불가)");
		return false;
	} else {
		$("#counname").text("");
		return true;
	}
}

function regExppw(pw) {
	var str = pw;

	var pattern1 = /[\s\t]/;
	var pattern2 = /[a-zA-Z]/ig;
	var pattern3 = /[0-9]/g;
	var pattern4 = /[^a-zA-Z0-9]/

	if (!pattern2.test(str) || !pattern3.test(str) || !pattern4.test(str)
			|| str.length < 8 || str.length > 16) {
		$("#counpw").focus();
		$("#counpw").text("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
		return false;
	} else if (pattern1.test(str)) {
		$("#counpw").text("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
		return false;
	} else {
		$("#counpw").text("");
		return true;
	}
}
// https://holybell87.tistory.com/22#.Xxfu654zaUk
function regExpphone(phone, phone2) {
	var pattern = /[0-9]{4}/;
	if (pattern.test(phone) && pattern.test(phone2)) {
		$("#counphone").text("");
		return true;
	} else {
		$("#counphone").text("핸드폰 입력이 제대로 되지 않았습니다 ");
		return false;
	}

}
function regExptel(tel1, tel2) {
	var pattern = /[0-9]{3}/;
	var pattern1 = /[0-9]{4}/;
	if (pattern.test(tel1) && pattern1.test(tel2)) {
		$("#countel").text("");
		return true;

	} else {
		$("#countel").text("전화번호 입력이 제대로 되지 않았습니다 ");
		return false;
	}

}
function regExpbirth(birth1, birth2) {

	var pattern = /^(19|20)\d{2}$/;
	var pattern1 = /^(0[1-9]|[12][0-9]|3[0-1])$/;

	if (!pattern.test(birth1)) {
		$("#counbirth").text("생년월일 입력이 제대로 되지 않았습니다 ");
		return false;
	} else if (!pattern1.test(birth2)) {
		$("#counbirth").text("형식을 지켜주세요 ");
		return false;

	} else {
		$("#counbirth").text("");
		return true;
	}
}
// ---------------------------------------------------------------------------------------
// -----------------------주소----------------------------------------------------

function openDaumPostcode() {
	new daum.Postcode({
		oncomplete : function(data) {
			// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
			// 우편번호와 주소 정보를 해당 필드에 넣고, 커서를 상세주소 필드로 이동한다.
			// document.getElementById('join_zip1').value = data.postcode1;
			// document.getElementById('join_zip2').value = data.postcode2;
			document.getElementById('coun_post').value = data.zonecode;
			document.getElementById('coun_addr1').value = data.address;

		}
	}).open();
}