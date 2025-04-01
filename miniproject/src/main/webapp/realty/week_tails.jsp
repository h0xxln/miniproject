<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
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
            <cr:forEach var="weekList" items="${week_tailsList}">
                <input type="hidden" id="m_email" value="${sessionScope.login[0].m_email}">
                <input type="hidden" id="tidx" value="${weekList.tidx}">
                <input type="hidden" id="t_name" value="${weekList.t_name}">
			<p>${weekList.t_name}</p>  
            <ul>
                <li>종류</li>
                <li>${weekList.t_type} | ${weekList.t_rentype}</li>
                <li>주소</li>
				<li>${weekList.t_adress}</li>
                <li>규모</li>
				<li>총 ${weekList.t_unit}세대 | 총 ${weekList.t_hstr}개동</li>
                <li>시기</li>
				<li>${weekList.t_saledate} 분양 | ${weekList.t_indate} 입주</li>
                <li>난방구조</li>
				<li>${weekList.t_hs}</li>
                <li>건설사</li>
				<li>${weekList.t_ctrcomp}</li>
                <li>사진정보</li>
				<li><img src="./room/${weekList.t_img}"></li>
            </ul>
				</cr:forEach>
		</div>
		
       <cr:if test="${not empty sessionScope.login}">
            <!-- 로그인 상태일 때 방문예약 버튼 표시 -->
            <cr:if test="${cvisit_msg eq 'yes'}">
      			  <div><button type="button" class="btn_css" onclick="visit()">방문예약</button></div>
  		    </cr:if>
  		    <cr:if test="${cvisit_msg eq 'no'}">
       			  <div><button class="btn_close">방문예약완료</button></div>
   		    </cr:if>     
   	   </cr:if>
   
		</div>
</main>
<!-- footer.jsp -->
<%@ include file="./copyright.jsp" %>
</body>
<script src="./js/week_tails.js?v=1"></script>
</html>