<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>	
<header>
	<div class="top_banner"></div>
</header>
<nav>
	<div class="menus">
		<ul class="menus_ul">
			<li><img src="./logo/e_click_logo.png" onclick="goindex()"></li>
			<li>일반매물</li>
			<li><a href="./md_board.do">추천매물</a></li>
			<li>중계의뢰</li>
			<li><a href="./counsel.jsp">상담신청</a></li>
			<li>업체의뢰</li>
			<li>의뢰현황</li>
			<li class="logins" onmouseleave="myinfo_menu(2)">
     		   <span title="회원정보" onclick="myinfo_menu(1)">
    	  	   <img src="./ico/login.svg">
        	   <ul class="login_info" id="login_info" style="display: none;">
            		<cr:if test="${sessionScope.login[0].m_name == null}">
            		<li><a href="./login.jsp">로그인</a> / <a href="./member_join.jsp">회원가입</a></li>
            		</cr:if>
            		<cr:if test="${sessionScope.login[0].m_name != null}">
            		<li>${sessionScope.login[0].m_name} 님<a href="./logout.jsp"> [로그아웃]</a></li>
            		</cr:if>
        	  	
        	   </ul>
        	   </span>
        	   <span title="모델 하우스 사전예약 리스트" onclick="reserve_page()"><img src="./ico/reserve_list.svg"></span>
    	   </li>
		</ul>
	</div>
</nav>
<script src="./js/top.js?v=3"></script>
