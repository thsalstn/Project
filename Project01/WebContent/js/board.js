
$(function(){
	$("form").submit(function(){
		if($("#BOAR_TITLE").val()==""){
			alert("제목을 입력하세요");
			$("#BOAR_TITLE").focus();
			return false;
		}
		
		if($("#BOAR_CONT").val()==""){
			alert("내용을 입력하세요");
			$("#BOAR_CONT").focus();
			return false;
		}
		
	});
	});
