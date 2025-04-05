<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/passwd_search.css?v=2">
<script src="./js/jquery.js?v=3"></script>
</head>
<body>
<!--top.jsp-->
<%@ include file="./top.jsp" %>
 
<!-- 이메일 찾기, 비밀번호 -->
<main>
<form id="frm">
<section class="sub">
<div>
<ul>
<li><a href="./email_search.do">이메일 찾기</a></li>
<li><a href="./passwd_search.do">비밀번호 찾기</a></li>
</ul>
</div>
<div class="text1">	
<div><input type="text" name="m_email" placeholder="가입하신 이메일을 입력하세요"></div>
<div><input type="text" name="m_number" placeholder="휴대폰 번호는 - 빼고 숫자만 입력하세요" maxlength="11"></div>
</div>
<div><input type="button" value="비밀번호 찾기" onclick="search_pass()"></div>
</section>
</form>
</main>

<!-- footer.jsp -->
<%@ include file="./copyright.jsp" %>
</body>
<script src="./js/search_pass.js?v=1"></script>
</html>




