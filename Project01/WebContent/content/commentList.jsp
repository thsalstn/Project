<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
<title>Insert title here</title>

<script type="text/javascript">

// 댓글 클릭시 입력, 리스트 보이기
$(document).ready(function(){
	btn = $('#btn');
	list = $('#list');
	
	btn.click(function(){
		list.toggle(
			function(){list.addClass('show')}
			
			
			
		);
	});
});


//댓글 유효성 검사
$(function (){
	$("form").submit(function(){
		if($("#COMM_CONT").val()==""){
		alert("댓글을 입력하세요.");
		$("#COMM_CONT").focus();
		return false;
	}
	});
});

//댓글 수정
$(function(){
	$('.edit').click(function(){
		var id = $(this).attr('id');
		var text = $('#td_'+id).text();
		$('#td_'+id).html("<textarea rows='3' cols='50' id='tt_"+id+"'>"+text+"</textarea>");
		$('#btn_'+id).html(
		  "<input type='button' value='등록' onclick='up("+id+")'>"
		  +"<input type='button' value='취소' onclick='lst()'>");
	});
});

function up(id){
	var COMM_CONT = $('#tt_'+id).val();
	var formData = "COMM_NO="+id+'&COMM_CONT='+COMM_CONT+"&CBOAR_NO=${BOAR_NO}&page=${page}";
	$.post('CommModify.do',formData, function(data){
		$('#slist').html(data);
	});
}

function lst(){
	$('#slist').load("BoardDetail.do?BOAR_NO=${BOAR_NO}&page=${page}")
}

//댓글 삭제
function del(COMM_NO,BOAR_NO){
	var formData="&COMM_NO="+COMM_NO+"&BOAR_NO="+BOAR_NO+"&page=${page}";
	$.post("CommDelete.do",formData, function(data) {
		$('#slist').html(data);
	});
}
</script>
</head>
<body>

	<!-- 댓글창(누르면 밑에 댓글입력창과 댓글목록 출력하기) -->
	<div id="btn">
	<input type="hidden" name="listcount" value="${comm_listcount}">
	<button type="button" class="btn btn-dark">댓글(${comm_listcount})</button>
	</div>
	<br>
	
	<!-- 댓글쓰는칸 -->
	<div id="list" style="display:none">
	<form name="fm" id="fm" action="CommInsert.do" method="post">
	<input type="hidden" name="MEM_ID" value="${sessionScope.id}">
	<input type="hidden" name="CBOAR_NO" value="${BOAR_NO}">
	<input type="hidden" name="page" value="${page}">
		<textarea rows="3" cols="50" name="COMM_CONT" id="COMM_CONT"
			placeholder="댓글을 입력해주세요.(비방이나 욕설은 삼가해주시기바랍니다.)" style="width: 100%;"></textarea>
		<button type="submit" class="btn btn-dark" id="insert">등록</button>
	</form>
	
	<!-- 댓글 리스트 -->
	<c:if test="${empty comm_list}">
		작성된 댓글이 없습니다.
	</c:if>
	<table>
		<c:forEach var="comm" items="${comm_list}">
			<tr>
				<td>${comm.MEM_ID}</td>
				<td>(${comm.COMM_DATE})</td>
				<td id="td_${comm.COMM_NO}"><pre>${comm.COMM_CONT}</pre></td>
				<td id="btn_${comm.COMM_NO}">
				<c:if test="${comm.MEM_ID == sessionScope.id}">
					<input type="button" value="수정" class="edit" id="${comm.COMM_NO}">
					<input type="button" value="삭제" onClick="del(${comm.COMM_NO},${BOAR_NO})">
				</c:if>
				</td>
			</tr>
		</c:forEach>
	</table>
		</div>

</body>
</html>