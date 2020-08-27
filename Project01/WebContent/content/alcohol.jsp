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
	<form action = "./Alcoholcheck.do" method = "post" class = "alcoholresult" >
		<table>
			<c:forEach var="alcohol" items="${alcohollist}">
				<c:if test = "${alcohol.EXAM_NO == 1}">
					<tr>
						<th id = "question">문항</th>
						<th id = "contents">내용</th>
						<th id = "never">전혀 안마심</th>
						<th id = "almost">월 1회 이하</th>
						<th id = "sometimes">월 2~4회</th>
						<th id = "often">주 2~4회</th>
						<th id = "extremely">주 4회 초과</th>
					</tr>
					
					<tr>
						<th id = "question">${alcohol.EXAM_NO}</th>
						<td id = "contents">${alcohol.EXAM_CONT}</td>
						<th id = "never"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "1"></th>
						<th id = "almost"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "2"></th>
						<th id = "sometimes"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "3"></th>
						<th id = "often"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "4"></th>
						<th id = "extremely"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "5"></th>
					</tr>
				</c:if>
				
				<c:if test = "${alcohol.EXAM_NO == 2}">
					<tr>
						<th id = "question">문항</th>
						<th id = "contents">내용</th>
						<th id = "never">전혀 안마심</th>
						<th id = "almost">소주 1~2잔</th>
						<th id = "sometimes">소주 3~4잔</th>
						<th id = "often">소주 5~6잔</th>
						<th id = "extremely">소주 7~9잔</th>
					</tr>
					
					<tr>
						<th id = "question">${alcohol.EXAM_NO}</th>
						<td id = "contents">${alcohol.EXAM_CONT}</td>
						<th id = "never"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "1"></th>
						<th id = "almost"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "2"></th>
						<th id = "sometimes"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "3"></th>
						<th id = "often"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "4"></th>
						<th id = "extremely"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "5"></th>
					</tr>
				</c:if>
				
				<c:if test = "${alcohol.EXAM_NO == 3}">
					<tr>
						<th id = "question">문항</th>
						<th id = "contents">내용</th>
						<th id = "never">없음</th>
						<th id = "almost">월 1회 미만</th>
						<th id = "sometimes">월 1회</th>
						<th id = "often">주 1회</th>
						<th id = "extremely">거의 매일</th>
					</tr>
					
					<tr>
						<th id = "question">${alcohol.EXAM_NO}</th>
						<td id = "contents">${alcohol.EXAM_CONT}</td>
						<th id = "never"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "1"></th>
						<th id = "almost"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "2"></th>
						<th id = "sometimes"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "3"></th>
						<th id = "often"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "4"></th>
						<th id = "extremely"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "5"></th>
					</tr>
				</c:if>
				
				<c:if test = "${alcohol.EXAM_NO == 4}">
					<tr>
						<th id = "question">문항</th>
						<th id = "contents">내용</th>
						<th id = "never">없음</th>
						<th id = "almost">월 1회 미만</th>
						<th id = "sometimes">월 1회</th>
						<th id = "often">주 1회</th>
						<th id = "extremely">거의 매일</th>
					</tr>
					
					<tr>
						<th id = "question">${alcohol.EXAM_NO}</th>
						<td id = "contents">${alcohol.EXAM_CONT}</td>
						<th id = "never"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "1"></th>
						<th id = "almost"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "2"></th>
						<th id = "sometimes"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "3"></th>
						<th id = "often"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "4"></th>
						<th id = "extremely"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "5"></th>
					</tr>
				</c:if>
				
				<c:if test = "${alcohol.EXAM_NO == 5}">
					<tr>
						<th id = "question">문항</th>
						<th id = "contents">내용</th>
						<th id = "never">없음</th>
						<th id = "almost">월 1회 미만</th>
						<th id = "sometimes">월 1회</th>
						<th id = "often">주 1회</th>
						<th id = "extremely">거의 매일</th>
					</tr>
					
					<tr>
						<th id = "question">${alcohol.EXAM_NO}</th>
						<td id = "contents">${alcohol.EXAM_CONT}</td>
						<th id = "never"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "1"></th>
						<th id = "almost"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "2"></th>
						<th id = "sometimes"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "3"></th>
						<th id = "often"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "4"></th>
						<th id = "extremely"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "5"></th>
					</tr>
				</c:if>
				
				<c:if test = "${alcohol.EXAM_NO == 6}">
					<tr>
						<th id = "question">문항</th>
						<th id = "contents">내용</th>
						<th id = "never">없음</th>
						<th id = "almost">월 1회 미만</th>
						<th id = "sometimes">월 1회</th>
						<th id = "often">주 1회</th>
						<th id = "extremely">거의 매일</th>
					</tr>
					
					<tr>
						<th id = "question">${alcohol.EXAM_NO}</th>
						<td id = "contents">${alcohol.EXAM_CONT}</td>
						<th id = "never"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "1"></th>
						<th id = "almost"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "2"></th>
						<th id = "sometimes"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "3"></th>
						<th id = "often"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "4"></th>
						<th id = "extremely"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "5"></th>
					</tr>
				</c:if>
				
				<c:if test = "${alcohol.EXAM_NO == 7}">
					<tr>
						<th id = "question">문항</th>
						<th id = "contents">내용</th>
						<th id = "never">없음</th>
						<th id = "almost">월 1회 미만</th>
						<th id = "sometimes">월 1회</th>
						<th id = "often">주 1회</th>
						<th id = "extremely">거의 매일</th>
					</tr>
					
					<tr>
						<th id = "question">${alcohol.EXAM_NO}</th>
						<td id = "contents">${alcohol.EXAM_CONT}</td>
						<th id = "never"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "1"></th>
						<th id = "almost"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "2"></th>
						<th id = "sometimes"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "3"></th>
						<th id = "often"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "4"></th>
						<th id = "extremely"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "5"></th>
					</tr>
				</c:if>
				
				<c:if test = "${alcohol.EXAM_NO == 8}">
					<tr>
						<th id = "question">문항</th>
						<th id = "contents">내용</th>
						<th id = "never">없음</th>
						<th id = "almost">월 1회 미만</th>
						<th id = "sometimes">월 1회</th>
						<th id = "often">주 1회</th>
						<th id = "extremely">거의 매일</th>
					</tr>
					
					<tr>
						<th id = "question">${alcohol.EXAM_NO}</th>
						<td id = "contents">${alcohol.EXAM_CONT}</td>
						<th id = "never"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "1"></th>
						<th id = "almost"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "2"></th>
						<th id = "sometimes"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "3"></th>
						<th id = "often"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "4"></th>
						<th id = "extremely"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "5"></th>
					</tr>
				</c:if>
				
				<c:if test = "${alcohol.EXAM_NO == 9}">
					<tr>
						<th id = "question">문항</th>
						<th id = "contents">내용</th>
						<th id = "never">없음</th>
						<th id = "almost"></th>
						<th id = "sometimes">있지만 지난 1년간 없었음</th>
						<th id = "often"></th>
						<th id = "extremely">지난 1년간 있었음</th>
					</tr>
					
					<tr>
						<th id = "question">${alcohol.EXAM_NO}</th>
						<td id = "contents">${alcohol.EXAM_CONT}</td>
						<th id = "never"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "1"></th>
						<th id = "almost"></th>
						<th id = "sometimes"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "3"></th>
						<th id = "often"></th>
						<th id = "extremely"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "5"></th>
					</tr>
				</c:if>
				
				<c:if test = "${alcohol.EXAM_NO == 10}">
					<tr>
						<th id = "question">문항</th>
						<th id = "contents">내용</th>
						<th id = "never">없음</th>
						<th id = "almost"></th>
						<th id = "sometimes">있지만 지난 1년간 없었음</th>
						<th id = "often"></th>
						<th id = "extremely">지난 1년간 있었음</th>
					</tr>
					
					<tr>
						<th id = "question">${alcohol.EXAM_NO}</th>
						<td id = "contents">${alcohol.EXAM_CONT}</td>
						<th id = "never"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "1"></th>
						<th id = "almost"></th>
						<th id = "sometimes"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "3"></th>
						<th id = "often"></th>
						<th id = "extremely"><input type = "radio" name = "select${alcohol.EXAM_NO}" class = "select${alcohol.EXAM_NO}" value = "5"></th>
					</tr>
				</c:if>
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