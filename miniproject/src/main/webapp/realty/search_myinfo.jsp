<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 찾기</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/search_myinfo.css?v=2">
</head>
<body>
<!--top.jsp-->
<%@ include file="./top.jsp" %>
 
<!-- 이메일 확인 -->
<main>
<section class="sub">
<div>
<ul>
<li>회원가입된 이메일 확인</li>
</ul>
</div>
<div class="text1">
<div>가입하신 이메일 정보 : ${msg} </div>
</div>
<div><input type="button" value="정보확인" class="search_submit" onclick="goToLogin()"></div>
</section>
</main>

<!-- footer.jsp -->
<%@ include file="./copyright.jsp" %>
</body>
<script>
function goToLogin() {
	alert("로그인 페이지로 이동 합니다.");
    location.href = "/realty/login.jsp"; // 로그인 페이지 URL로 변경
}
</script>
</html>