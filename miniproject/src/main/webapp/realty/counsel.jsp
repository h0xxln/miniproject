<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>상담신청</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=2">
<link rel="stylesheet" type="text/css" href="./css/counsel.css?v=4">
</head>
<script src="./js/jquery.js?v=1"></script>
<body>
 <!--top.jsp-->
 <%@ include file="./top.jsp"%>
<main>
<form id="frm" action="./apply_counsel.do" method="post">
<section class="sub">
<p>상담신청</p>
<div>
<span class="list_title">◎ <span style="color: blue;">상담자 정보</span></span>
<ul class="sub_ul">
<li>상담자명</li>    
<li><input type="text" name="c_name" value="${sessionScope.login[0].m_name}" class="sel_input" readonly></li> 
<li>이메일</li>    
<li><input type="text" name="c_email" value="${sessionScope.login[0].m_email}" class="sel_input" readonly></li> 
<li>연락처</li>    
<li><input type="text" name="c_number" value="${sessionScope.login[0].m_number}" class="sel_input" readonly></li> 
<li>임대형태</li>    
<li>
<label><input type="checkbox" name="c_rentype" value="공공임대" class="sel_check"> 공공임대</label>
<label><input type="checkbox" name="c_rentype" value="민간임대" class="sel_check"> 민간임대</label>
<label><input type="checkbox" name="c_rentype" value="민간분양" class="sel_check"> 민간분양</label>
<label><input type="checkbox" name="c_rentype" value="기타" class="sel_check"> 기타</label>
</li>   
<li>주거형태</li>    
<li>
<label><input type="checkbox"  name="c_livetype" value="아파트" class="sel_check"> 아파트</label>
<label><input type="checkbox" name="c_livetype" value="빌라，단독주택" class="sel_check"> 빌라,단독주택</label>
<label><input type="checkbox" name="c_livetype" value="사무실.상가.빌딩" class="sel_check"> 사무실.상가.빌딩</label>
</li>       
<li>상담일시</li>    
<li>
<input type="date" class="sel_input2" name="c_counseltime" required> * 해당 일시에 맞춰서 담당자가 연락 드립니다.   
</li>    
<li>상담내용</li>    
<li style="height: 150px !important; line-height: 150px;">
<textarea class="sel_input3" name="c_content" required placeholder="구체적인 상담내용을 입력해 주세요"></textarea>
</li>
</ul>
</div>
<div><input type="button" value="상담신청" onclick="applyCounsel()"></div>
</section>
</form>
</main>
 <!-- 카피라이터 -->
 <%@ include file="./copyright.jsp" %>
</body>
<script src="./js/counsel.js?v=1"></script>
</html>