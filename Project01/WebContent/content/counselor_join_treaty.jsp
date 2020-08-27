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
<script src="<%=request.getContextPath()%>/js/join_treaty2.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/form.css">
</head>
<body>
	<div class="container" id="hed">
		<div>
			<input type="checkbox" id="all_checkbox" name="all_checkbox"onClick="allCheck()"> <label>전체 동의</label>
		</div>
		<div class="content" id="content">Lorem ipsum, dolor sit amet consectetur
			adipisicing elit. Enim modi in exercitationem explicabo, at rem
			officia autem non porro soluta dolorum officiis ipsa repellat,
			laudantium ea unde labore, temporibus quas?Lorem ipsum dolor sit
			amet, consectetur adipisicing elit. Eveniet eius totam quam pariatur
			ratione, in voluptatem dignissimos laboriosam sint aut! Repudiandae
			consectetur odit quo corrupti quidem perferendis aut dolores
			quis?Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat
			nam optio dolore recusandae fuga voluptatibus. Ea quam deserunt
			consectetur quo aut eligendi, molestiae incidunt molestias ullam?
			Repellendus ratione repellat</div>
		<div>
			<input type="checkbox" id="checkbox-1" onClick="fun()"> <label
				for="scales">개인정보 동의</label>
		</div>
		<div class="content" id="content">Lorem ipsum, dolor sit amet consectetur
			adipisicing elit. Enim modi in exercitationem explicabo, at rem
			officia autem non porro soluta dolorum officiis ipsa repellat,
			laudantium ea unde labore, temporibus quas?Lorem ipsum dolor sit
			amet, consectetur adipisicing elit. Eveniet eius totam quam pariatur
			ratione, in voluptatem dignissimos laboriosam sint aut! Repudiandae
			consectetur odit quo corrupti quidem perferendis aut dolores
			quis?Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat
			nam optio dolore recusandae fuga voluptatibus. Ea quam deserunt
			consectetur quo aut eligendi, molestiae incidunt molestias ullam?
			Repellendus ratione repellat</div>
		<div>
			<input type="checkbox" id="checkbox-2" onClick="fun()"> <label
				for="scales">이용약관 동의</label>
		</div>
		<div class="content" id="content">Lorem ipsum, dolor sit amet consectetur
			adipisicing elit. Enim modi in exercitationem explicabo, at rem
			officia autem non porro soluta dolorum officiis ipsa repellat,
			laudantium ea unde labore, temporibus quas?Lorem ipsum dolor sit
			amet, consectetur adipisicing elit. Eveniet eius totam quam pariatur
			ratione, in voluptatem dignissimos laboriosam sint aut! Repudiandae
			consectetur odit quo corrupti quidem perferendis aut dolores
			quis?Lorem ipsum dolor sit amet consectetur adipisicing elit. Placeat
			nam optio dolore recusandae fuga voluptatibus. Ea quam deserunt
			consectetur quo aut eligendi, molestiae incidunt molestias ullam?
			Repellendus ratione repellat</div>
		<div>
			<input type="checkbox" id="checkbox-3" onClick="fun()"> <label
				for="scales">추가</label>
		</div>
		<div id="checkbox_message"></div>
		<div align="center">
			<button type="button" class="btn btn-info" id="check">확인</button>
			<button type="button" class="btn btn-info">취소</button>
		</div>
	</div>
</body>
</html>