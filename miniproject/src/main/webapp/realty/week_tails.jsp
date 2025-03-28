<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>금주 분양 매물 정보</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/week_tails.css?v=1">
</head>
<body>
<!--top.jsp-->
<%@ include file="./top.jsp" %>
<!-- 분양정보 상세 페이지 메인 뷰 --> 
 <main>
	<div class="weektails">
		<p>분양정보</p>
		<div id="weektails">
			<p>LH센트럴힐(공공임대)</p>  
            <ul>
                <li>종류</li>
                <li>아파트 | 공공임대 </li>
                <li>주소</li>
				<li>서울시 송파구 문정동 12-2</li>
                <li>규모</li>
				<li>총 104세대 | 총 2개동</li>
                <li>시기</li>
				<li>2025.04 분양 | 2027.02 입주</li>
                <li>난방구조</li>
				<li>개별난방,도시가스</li>
                <li>건설사</li>
				<li>GS건설㈜</li>
                <li>사진정보</li>
				<li><img src="./room/room1.jpg"></li>
            </ul>
		</div>
        <div><button class="btn_css">방문예약</button></div>
        <div><button class="btn_close">방문예약완료</button></div>
	</div>
</main>

<!-- footer.jsp -->
<%@ include file="./copyright.jsp" %>
</body>
</html>