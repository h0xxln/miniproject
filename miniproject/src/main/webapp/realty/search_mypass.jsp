<%@page import="com.mysql.cj.Session"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>패스워드 찾기 및 변경</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/search_myinfo.css?v=2">
<script src="./js/jquery.js?v=3"></script>
</head>
<body>
<!--top.jsp-->
<%@ include file="./top.jsp" %>
 
<!-- 패스워드 변경 -->
<main>
<form id="frm" action="" method="post">
<section class="sub">
<div>
<ul>
<li>회원가입 정보에 따른 패스워드 변경</li>

</ul>
</div>

<div class="text1 repass">
<input type="hidden" id="m_email" value="${sessionScope.m_email}">
<div><input type="password" id="m_pass" name="m_pass" placeholder="최소 10 ~ 16자 (영문,숫자,특수 문자 조합)로 입력해주세요." class="passin" autocomplete="none"></div>
<div><input type="password" id="check_pass" placeholder="동일한 비밀번호를 입력하세요" class="passin" autocomplete="none"></div>
</div>
<div><input type="button" value="비밀번호 변경" class="search_submit" onclick="search_mypass()"></div>
</section>
</form>
</main>

<!-- footer.jsp -->
<%@ include file="./copyright.jsp" %>
</body>
<script src="./js/search_mypass.js?v=1"></script>
</html>