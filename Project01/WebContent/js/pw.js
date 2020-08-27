$(document).ready(function() {					
					// 비밀번호 유효성 체크
					$("#mem_pw").change(function() {
						regExppw($("#mem_pw").val());
					});					
					$("form").submit(
							function() {							
								if ($("#mem_pw").val() == "") {
									$("#mypw").text("비밀번호를 입력하세요");
									$("#mem_pw").focus();
									return false;
								}else{						
									if (!regExppw($("#mem_pw").val())) {
										
										return false;
									}								
								}				
							});

				}); // ready() end



function regExppw(pw) {
	var str = pw;

	var pattern1 = /[\s\t]/;
	var pattern2 = /[a-zA-Z]/ig;
	var pattern3 = /[0-9]/g;
	var pattern4 = /[^a-zA-Z0-9]/

	if (!pattern2.test(str) || !pattern3.test(str) || !pattern4.test(str)|| str.length < 8 || str.length > 16) {
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

