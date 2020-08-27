$(document).ready(function() {

		$("#check").click(function() {
			if (!$("#checkbox-1").prop("checked")) {
				$("#checkbox_message").text("동의가 필요합니다");
				return false;
			} else if (!$("#checkbox-2").prop("checked")) {
				$("#checkbox_message").text("동의가 필요합니다");
				return false;
			} else if (!$("#checkbox-3").prop("checked")) {
				$("#checkbox_message").text("동의가 필요합니다");
				return false;
			} else {
				location.href = "memberform.do";
			}

		});
	});

	function allCheck() {
		if (!$("#all_checkbox").prop("checked")) {
			$("#checkbox-1").prop("checked", false);
			$("#checkbox-2").prop("checked", false);
			$("#checkbox-3").prop("checked", false);
		} else {
			$("#checkbox-1").prop("checked", true);
			$("#checkbox-2").prop("checked", true);
			$("#checkbox-3").prop("checked", true);
		}
	}

	function fun() {
		if (!$("#checkbox-1").prop("checked")
				|| !$("#checkbox-2").prop("checked")
				|| !$("#checkbox-3").prop("checked")) {
			$("#all_checkbox").prop("checked", false);
		} else if ($("#checkbox-1").prop("checked")
				&& $("#checkbox-2").prop("checked")
				&& $("#checkbox-3").prop("checked")) {
			$("#all_checkbox").prop("checked", true);
		}
	}