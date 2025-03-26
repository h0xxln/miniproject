<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <link rel="stylesheet" type="text/css" href="./css/index.css?v=8">
  <link rel="stylesheet" type="text/css" href="./css/member_join.css?v=4">
<style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}
</style>
<title>회원가입</title>
<script src="./js/jquery.js?v=3"></script>
</head>
<body>
	<!-- top.jsp -->
  <%@ include file="./top.jsp"%>
  
<main>
<%@ include file="./member_join_main.jsp" %>
</main>

<!-- 카피라이터 -->
<%@ include file="./copyright.jsp" %>
 
</body>
<script src="./js/member_join.js?v=3"></script>
</html>