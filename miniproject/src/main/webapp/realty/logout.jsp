<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    session.invalidate(); // 세션 무효화 (로그아웃 처리)
%>
<script>
    alert('로그아웃 되셨습니다.');
    location.href = "./index.do"; // 로그아웃 후 메인 페이지로 이동
</script>