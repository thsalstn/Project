<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/style1.css">
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/responsive.css">
<script type="text/javascript">
	$(document).ready(function() {

						Kakao.init('c6966d8b37b099ea6717e75b7a6b971e');
						Kakao.Link
								.createDefaultButton({
									container : '#create-kakao-link-btn',
									objectType : 'feed',
									content : {
										title : '여러 심리 검사 및 상담',
										description : '#검사 #MBTI #성격 #상담',
										imageUrl : 'http://k.kakaocdn.net/dn/Q2iNx/btqgeRgV54P/VLdBs9cvyn8BJXB3o7N8UK/kakaolink40_original.png',
										link : {
											mobileWebUrl : 'https://developers.kakao.com',
											webUrl : 'https://developers.kakao.com',
										},
									},
									social : {
										likeCount : 286,
										commentCount : 45,
										sharedCount : 845,
									},
									buttons : [
											{
												title : '웹으로 보기',
												link : {
													mobileWebUrl : 'http://15.164.165.19:8080/Project01',
													webUrl : 'http://15.164.165.19:8080/Project01',
												},
											},
											{
												title : '앱으로 보기',
												link : {
													mobileWebUrl : 'http://15.164.165.19:8080/Project01',
													webUrl : 'http://15.164.165.19:8080/Project01',
												},
											}, ],
								});
					});
		
</script>
</head>
<body>
	<!-- footer 정보 -->

	<div class="footer">

		<div class="container">

			<div class="row">

				<div class="col-md-4 col-sm-4">

					<div class="single-widget">

						<h2 class="widget-title">About Us</h2>

						<div class="widget-inner">

							<p>회사 이름 : 중앙정보기술인재개발원</p>
							<p>주소 : 서울특별시 마포구 대흥동 12-20</p>
							<p>전화번호 : 02-313-1711</p>
							<p>고객센터 번호 : 02-0000-0000</p>
						</div>

					</div>

				</div>


				<div class="col-md-4 col-sm-4">

					<div class="single-widget">

						<h2 class="widget-title">Team5</h2>

						<div class="widget-inner">

							<ul>
								<li><a href="">서월성</a></li>

								<li><a href="">손민수</a></li>

								<li><a href="">권미진</a></li>

								<li><a href="">백영민</a></li>

								<li><a href="">이성호</a></li>

							</ul>

						</div>

					</div>
	                 <a id="create-kakao-link-btn" href="javascript:;"> 
					<img src="<%=request.getContextPath()%>/image/kakaotalk_logo_icon_147272.png" id="social_b" />
					</a>
					<a href="https://twitter.com/intent/tweet?via=MBTI&text=너무 잘 맞는 심리 검사 테스트&url=http://15.164.165.19:8080/Project01">			
					<img src="<%=request.getContextPath()%>/image/Twitter_Social_Icon_Circle_Color.png" id="social_b" />				
					</a> 
				
				
			
	    <a target="_blank"	href="https://www.facebook.com/sharer/sharer.php?u=http%3A%2F%2F15.164.165.19%3A8080%2FProject01&amp;src=sdkpreparse" class="fb-xfbml-parse-ignore">
        <img src="<%=request.getContextPath()%>/image/facebook_icon-icons.com_59205.png" id="social_b"/>	
		</a>
		</div>

				<div class="col-md-4 col-sm-4">
					
					<div class="single-widget">
			
					<h2 class="widget-title">Local</h2>
						<div>
							<div id="map" style="width:100%;height:300px;"></div>
						</div>

					</div>

				</div>

			</div>

		</div>

	</div>
</body>
<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c6966d8b37b099ea6717e75b7a6b971e&libraries=services"></script>
<script>

// 지도를 생성합니다    
// 주소-좌표 변환 객체를 생성합니다
var geocoder = new kakao.maps.services.Geocoder();

// 주소로 좌표를 검색합니다
geocoder.addressSearch('서울특별시 마포구 대흥동 12-20', function(result, status) {

    // 정상적으로 검색이 완료됐으면 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        var mapContainer = document.getElementById('map'), // 지도를 표시할 div 
        

        mapOption = {
                center: coords, // 지도의 중심좌표
                level: 3 // 지도의 확대 레벨
            };  
        var map = new kakao.maps.Map(mapContainer, mapOption); 


        // 결과값으로 받은 위치를 마커로 표시합니다

        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // 인포윈도우로 장소에 대한 설명을 표시합니다
        

    } 
  // 일반 지도와 스카이뷰로 지도 타입을 전환할 수 있는 지도타입 컨트롤을 생성합니다
		var mapTypeControl = new kakao.maps.MapTypeControl();

		// 지도에 컨트롤을 추가해야 지도위에 표시됩니다
		// kakao.maps.ControlPosition은 컨트롤이 표시될 위치를 정의하는데 TOPRIGHT는 오른쪽 위를 의미합니다
		map.addControl(mapTypeControl, kakao.maps.ControlPosition.TOPRIGHT);

		// 지도 확대 축소를 제어할 수 있는  줌 컨트롤을 생성합니다
		var zoomControl = new kakao.maps.ZoomControl();
		map.addControl(zoomControl, kakao.maps.ControlPosition.RIGHT);
});    
</script>
</html>