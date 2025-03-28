<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>온라인 부동산 중개</title>
  <link rel="stylesheet" type="text/css" href="./css/index.css?v=9">
</head>
<body>
 <!--top.jsp-->
 <%@ include file="./top.jsp"%>
 <!-- main view -->
 <main>
 <!--카테고리 및 배너-->
 <%@ include file="./banner.jsp" %>
 <!-- 퀵메뉴 -->
 <%@ include file="./quickmenu.jsp" %>
 <!--금주 분양 매물 정보 시작-->
 <%@ include file="./weekinfo.jsp" %>
 <!--추천 분양 정보-->
 <%@ include file="./mdchoice.jsp" %>
 </main>
 <!-- 카피라이터 -->
 <%@ include file="./copyright.jsp" %>
</body>
</html>