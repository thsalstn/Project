<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>�ּҷ� ��� ǥ���ϱ�</title>
    
</head>
<body>

<div id="map" style="width:100%;height:350px;"></div>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c6966d8b37b099ea6717e75b7a6b971e&libraries=services"></script>
<script>

// ������ �����մϴ�    
// �ּ�-��ǥ ��ȯ ��ü�� �����մϴ�
var geocoder = new kakao.maps.services.Geocoder();

// �ּҷ� ��ǥ�� �˻��մϴ�
geocoder.addressSearch('����Ư���� ������ ���ﵿ 12-20', function(result, status) {

    // ���������� �˻��� �Ϸ������ 
     if (status === kakao.maps.services.Status.OK) {

        var coords = new kakao.maps.LatLng(result[0].y, result[0].x);
        var mapContainer = document.getElementById('map'), // ������ ǥ���� div 
        

        mapOption = {
                center: new kakao.maps.LatLng(33.450701, 126.570667), // ������ �߽���ǥ
                level: 3 // ������ Ȯ�� ����
            };  
        var map = new kakao.maps.Map(mapContainer, mapOption); 


        // ��������� ���� ��ġ�� ��Ŀ�� ǥ���մϴ�

        var marker = new kakao.maps.Marker({
            map: map,
            position: coords
        });

        // ����������� ��ҿ� ���� ������ ǥ���մϴ�
        var infowindow = new kakao.maps.InfoWindow({
            content: '<div style="width:150px;text-align:center;padding:6px 0;">�츮ȸ��</div>'
        });
        infowindow.open(map, marker);

        // ������ �߽��� ��������� ���� ��ġ�� �̵���ŵ�ϴ�
        map.setCenter(coords);
    } 
});    
</script>
</body>
</html>