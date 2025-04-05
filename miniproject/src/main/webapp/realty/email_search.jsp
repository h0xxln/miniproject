<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>이메일 찾기</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/email_search.css?v=2">
</head>
<body>
<!--상단-->
<%@ include file="./top.jsp" %>
<!-- 이메일 찾기 메인 뷰 -->
<main>
<form action="search_email.do" method="post" id="frm">
<section class="sub">
<div>
<ul>
<li><a href="email_search.do">이메일 찾기</a></li>
<li><a href="passwd_search.do">비밀번호 찾기</a></li>
</ul>
</div>
<div class="text1">
<div><input type="text"	name="m_name" placeholder="이름을 입력하세요"></div>
<div><input type="text" name="m_number" placeholder="휴대폰 번호는 - 빼고 숫자만 입력하세요" maxlength="11"></div>
</div>
<div><input type="button" value="이메일 찾기" onclick="search_email()"></div>
</section>
</form>
</main>
<!-- 카피라이터 -->
<%@ include file="./copyright.jsp" %>
</body>
<script src="./js/search_email.js?v=1"></script>
</html>