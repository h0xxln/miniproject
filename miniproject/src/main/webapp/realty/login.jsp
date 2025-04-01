<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/login.css?v=3">
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
<%@ include file="./top.jsp" %>
 
<!-- login_main.jsp -->
<%@ include file="./login_main.jsp" %>

<!-- footer.jsp -->
<%@ include file="./copyright.jsp" %>
 
</body>
<script src="./js/login.js?v=3"></script>
</html>