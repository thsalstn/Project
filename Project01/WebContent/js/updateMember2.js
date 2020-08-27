var emailauth = true;
var x;
var time = 6000;
var idcheck = false;
$(document).ready(function() {
		// -------------------------------------------------------------------------------------
			// ------------------------이메일 부분
			// ----------------------------------------------------
			// 도메인 선택
			$("#mem_domain").change(
					function() {
						if ($("#mem_domain").val() == "") { // 직접 입력 선택
							// $("#domain").attr("readonly", false);
							$("#mem_email2").removeAttr("readonly");
							$("#mem_email2").val("").focus();
						} else { // 도메인명 선택
							$("#mem_email2").val(
									$("#mem_domain option:selected").val());
							$("#mem_email2").attr("readonly", "readonly");
						}
					});

			// 이메일 인증
			$("#email_auth").click(
					function() {
						var mail = $("#mem_email1").val() + "@"
								+ $("#mem_email2").val();
						if ($("#mem_email1").val() == "") {
							$("#myemail").text("이메일을 입력하셔야 합니다 ");
							$("#mem_email1").focus();
						} else if ($("#mem_email2").val() == "") {
							$("#myemail").text("도메인 입력하셔야 합니다 ");
							$("#mem_email2").focus();

						} else {
							window.open("./mailcheck.do?mail="+ mail,"이메일 인증","width=500,height=300,left=700,top=300");
										}
					});

			$("#email_code").click(function() {
				start();
				authcode();
			});

			$("#code_check").click(function() {

				var mycode = $("#code").val();
				$.ajax({
					type : "post",
					url : "codeCheck.do",
					data : {
						"mycode" : mycode
					},
					datatype : "text",
					success : function(data) {
						if (data == 1) {
							alert(data);
							$("#be").hide();
							$("#e_time").hide();
							$("#e_success").text("인증에 성공하셨습니다").show();
							$("#af").show();
							opener.$("#email_auth").hide();
							opener.$("#auth_message").text("인증된 이메일 입니다");
							opener.$("#myemail").text("");
							ok = true;
						} else {

							$("#code").focus();
							return false;
						}
					}
				});
			});
			$("#e_end").click(function() {
				window.close();
			});

			// --------------------------------------------------------------------------------------------
			// ------------------------form submit
			// 부분-----------------------------------------------------

			$("form").submit(function() {
               
					
							if ($("#mem_email1").val() == "") {
							$("#myemail").text("이메일을 제대로 입력하세요 ");
							$("#mem_email1").focus();
							return false;
						}
						if ($("#mem_email2").val() == "") {
							$("#myemail").text("도메인을 제대로 입력하세요 ");
							$("#mem_email2").focus();
							return false;
						}		
						 if($("#auth_message").text()==""){
							 $("#myemail").text("이메일 인증이 되지 않았습니다");
							 return false;
							 }
							
					});

		}); // ready() end


function start() {
	if (emailauth == true) {
		x = setInterval("timers()", 1000);
		emailauth = false;
	} else if (emailauth == false) {
		clearInterval(x);
		//time = 30;
		x = setInterval("timers()", 1000);
	}
}
function timers() {
	var min = "";
	var sec = "";
	if (time > 0) {
		min = parseInt(time / 60);
		sec = time % 60;
		$("#e_time").text(min + "분" + sec + "초");
		time--;
	} else if (time <= 0) {
		clearInterval(x);
		$("#e_success").text("시간이 초과되었습니다").show();
		$("#af").show();
	}
};

// ---------------------------------------------------------------------------------------
// -----------------------이메일 인증
// 유효성----------------------------------------------------

function authcode() {
	var mail = $("#email_code").val();
	$.ajax({
		type : "post",
		url : "mailCode.do",
		data : {
			"mail" : mail
		},
		datatype : "text",
		success : function() {
			alert("이메일을 확인해주세요");
			$("#email_code").text("재전송");
		}
	});
};
