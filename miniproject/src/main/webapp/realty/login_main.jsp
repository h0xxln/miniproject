<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<main>
		<form id="frm" action="loginok.do" method="post">
	<aside class="login_pg">	
		<p>이메일로 시작하기</p>
		<div><input type="text" name="m_email" placeholder="이메일 주소"></div>
		<div><input type="password" name="m_pass" placeholder="비밀번호" ></div>
		<div><input type="button" value="로그인" onclick="logincheck()"></div>
		<div><input type="button" value="카카오로그인" class="kakao_btn"></div>
		<div>
			<span><a href="member_join.jsp">회원가입</a></span>
			<span><a href="email_search.jsp">이메일 찾기</a></span>
			<span><a href="passwd_search.jsp">비밀번호 찾기</a></span>
		</div>
	</aside>
		</form>
	
</main>
