<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>모댈 하우스 사전 방문예약</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/reservation.css?v=4">
</head>
<script src="./js/jquery.js?v=1"></script>
<body>

<!--top.jsp-->
<%@ include file="./top.jsp" %>
<main>
<section class="sub">
<p>모델 하우스 사전 방문예약</p>
<form id="frm" action="./apply_reservation.do" method="post">
<div>
<span class="list_title">
<span style="color: blue;">분양정보</span>
<span style="color: red;">${t_name}</span> <!-- 컨트롤러에서 세션값 받아야 함. -->
<input type="hidden" name="wvt_name" value="${t_name}"> <!-- 컨트롤러에서 세션값 받아야 함. -->
</span>
<ul class="sub_ul">
<li>방문일시</li>    
<li><input type="date" name="wv_date" class="sel_input" required></li> 
<li>방문시간</li>    
<li>
<input type="hidden" name="wtidx" value="${tidx}"> <!-- 컨트롤러에서 세션값 받아야 함. -->
<select name="wv_time" class="sel_input2">
    <option value="">방문시간선택</option>
    <option value="09:00">09:00</option>
    <option value="11:00">11:00</option>
    <option value="13:00">13:00</option>
    <option value="15:00">15:00</option>
    <option value="17:00">17:00</option>
</select> * 해당 시간에 맞춰서 방문해 주셔야 합니다.
</li> 
<li>방문자명</li>    
<li><input type="text" name="wv_name" value="${sessionScope.login[0].m_name}" class="sel_input" readonly></li> 
<li>방문인원</li>    
<li>
<label><input type="radio" name="wv_people" value="1" class="sel_check" checked> 1명</label>
<label><input type="radio" name="wv_people" value="2" class="sel_check"> 2명</label> ※ 방문인원은 최대 2명까지 입니다.
</li>   
<li>연락처</li>    
<li><input type="text" name="wv_number" value="${sessionScope.login[0].m_number}" class="sel_input" readonly></li>       
</ul>
</div>
<div>
<input type="button" value="방문 예약등록" onclick="apply_reservation()">
</div>
</form>
</section>
</main>
<!-- footer.jsp -->
<%@ include file="./copyright.jsp" %>
</body>
<script src="./js/reservation.js?v=1"></script>
</html>



