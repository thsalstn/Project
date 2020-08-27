<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/check.css">
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="<%=request.getContextPath()%>/js/check.js"></script>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
</head>
<body>
	<form action = "./Stresscheck.do" method = "post" class = "stressresult">
		<table>
			<tr>
				<th id = "question">문항</th>
				<th id = "contents">내용</th>
				<th id = "never">전혀없었다</th>
				<th id = "sometimes">때때로있었다</th>
				<th id = "often">자주있었다</th>
			</tr>
		
			<c:forEach var="stress" items="${stresslist}">
				<tr>
					<th>${stress.EXAM_NO}</th>
					<td>${stress.EXAM_CONT}</td>
					<th><input type = "radio" name = "select${stress.EXAM_NO}" class = "select${stress.EXAM_NO}" value = "1"></th>
					<th><input type = "radio" name = "select${stress.EXAM_NO}" class = "select${stress.EXAM_NO}" value = "2"></th>
					<th><input type = "radio" name = "select${stress.EXAM_NO}" class = "select${stress.EXAM_NO}" value = "3"></th>
				</tr>
			</c:forEach>
			
			<tr>
				<th colspan = "7"><input type = "submit" id = "alcoholresult" class = "btn btn-primary" value = "결과 확인"/>
								<input type = "reset" class = "btn btn-warning" value = "리셋"/>
								<input type = "button" id = "cancel" class = "cancel btn btn-danger" value = "취소"/></th>
			</tr>
		</table>
	</form>
</body>
</html>