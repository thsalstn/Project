var emailauth = true;
var x;
var time = 6000;
var idcheck = false;
$(document).ready(function() {
					// 비밀번호 유효성 체크
					$("#mem_pw").change(function() {

						regExppw($("#mem_pw").val());
					});
					// 비밀번호 체크
					$("#mem_pw2").change(function() {

						if ($("#mem_pw").val() != $("#mem_pw2").val()) {
							$("#mypw2").text("비밀번호가 일치하지 않습니다.");
						} else {
							$("#mypw2").text("비밀번호가 일치 합니다");
						}

					});

					$("form").submit(
							function() {															
								if ($("#mem_pw").val() == "") {
									$("#mypw").text("비밀번호를 입력하세요");
									$("#mem_pw").focus();
									return false;
								} else if ($("#mem_pw2").val() == "") {
									$("#mypw2").text("비밀번호를 입력하세요");
									$("#mem_pw2").focus();
									return false;
								}
								if (($("#mem_pw").val() != "" && ($("#mem_pw2").val() != ""))) {
									
									if (!regExppw($("#mem_pw").val())) {
										alert("생년월일 오류");
										return false;
									}
								}

								if ($("#mem_pw").val() != $("#mem_pw2").val()) {
									$("#mypw2").text("비밀번호가 일치하지 않습니다.");
									$("#mem_pw2").focus();
									return false;
								}

								

				
							});

				}); // ready() end
function regExppw(pw) {
	var str = pw;

	var pattern1 = /[\s\t]/;
	var pattern2 = /[a-zA-Z]/ig;
	var pattern3 = /[0-9]/g;
	var pattern4 = /[^a-zA-Z0-9]/

	if (!pattern2.test(str) || !pattern3.test(str) || !pattern4.test(str)
			|| str.length < 8 || str.length > 16) {
		$("#mypw").focus();
		$("#mypw").text("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
		return false;
	} else if (pattern1.test(str)) {
		$("#mypw").text("8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.");
		return false;
	} else {
		$("#mypw").text("");
		return true;
	}
}

