<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-Latest.js"></script>
<script src="//developers.kakao.com/sdk/js/kakao.min.js"></script>
<script src="<%=request.getContextPath()%>/js/js.js"></script>

<style>
#m_p_img{
  width:500px;
 
  }

</style>
<title>Insert title here</title>
</head>
<body>
	<!-- header -->
	<div>
		<%@ include file="/header/header.jsp"%>
	</div>
	<!-- header -->

		<div id="m_point" class="m_point" align="center">
			<div id="m_p_img">
				<img src="<%=request.getContextPath()%>/image/m_doctor.jpg" />
			</div>

			<div id="m_p_trial">
				<p>심리검사는 사람들의 행동(사고, 감정, 행위)을 표본추출을 통해 얻어진 결과를 표준화시켜 비교하는 체계적
					과정이다.</p>
				<p>임상심리학(clinical psychology) 및 심리평가(psychological assessment)
					분야에서 담당하고 있다.</p>
				<p>다양한 검사도구들을 상호 보완적으로 사용하여 수검자의 데이터를 수집하기도 하는데, 오늘날에는 이처럼 다수의
					검사도구들을 동원하는 것이 대다수이다. 이를 "총집"(full battery)이라고도 한다.</p>
			</div>
		</div>
	

</body>	<!-- footer -->
<div  id="foot">
		<%@include file="/footer/footer.jsp"%>
	</div>
	<!-- footer -->
</html>