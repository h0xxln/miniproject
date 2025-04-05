<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="java.util.Date"%>
<%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
String today = sdf.format(new Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천분양 정보 게시판</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css"
	href="./css/reservation_list.css?v=5">
<style>
.box {
	width: 800px;
	height: 300px;
	border: 1px solid black;
	overflow: auto;
}
</style>

</head>
<body>
	<!--top.jsp-->
	<%@ include file="./top.jsp"%>

	<!-- main -->
	<main>
		<section class="sub">
			<p>모델 하우스 방문 예약 리스트</p>
			<div class="boards">모델 하우스 방문 예약한 정보를 한눈에 확인 하실 수 있습니다.</div>
			<div class="info_board">
				<ul>
					<li>NO</li>
					<li>아파트명</li>
					<li>방문일자</li>
					<li>방문시간</li>
					<li>인원수</li>
					<li>취소</li>
				</ul>
				<cr:if test="${m_check == 'nodata'}">
					<ul style="display: block;">
						<li class="nodata">등록된 방문 예약이 없습니다.</li>
					</ul>
				</cr:if>
				<cr:forEach var="resList" items="${all_resList}" varStatus="status">
					<ul class="data_view">
						<li>${status.count}</li>
						<li style="text-align: left;">${resList.wvt_name}</li>
						<li>${resList.wv_date}</li>
						<li>${resList.wv_time}</li>
						<li>${resList.wv_people}</li>

						<!-- 폼은 여기서부터 -->
						<li>
							<form action="./cancel_reslist.do" method="post"
								onsubmit="return cancel_reslist();">
								<input type="hidden" name="wvidx" value="${resList.wvidx}">
								<input type="hidden" name="wv_name" value="${resList.wv_name}">
								<input type="hidden" name="wv_number" value="${resList.wv_number}"> 
							    <input type="submit" value="취소" class="cancel_btn">
							</form>
						</li>
					</ul>
				</cr:forEach>
			</div>
		</section>
	</main>
	<!-- 카피라이터 -->
	<%@ include file="./copyright.jsp"%>
</body>
<script src="./js/reservation.js?v=${today}"></script>
</html>