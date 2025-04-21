<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
<form id="f" method="post" action="member_joinok.do">
    <p>이메일로 회원가입</p>
    <div>
    	<input type="hidden" name="code" value="1">
    	<input type="hidden" name="kakao_id" value="">
    	<input type="hidden" name="kakao_nicknm" value="">
        <a>이메일</a> 
        <input type="text" id="m_emailCheck"  name="m_email" placeholder=" 이메일 주소를 입력해주세요." autocomplete="none" style="width:400px; float:left;"> 
        <input type="button" value="중복체크" class="mail_btn" onclick="checkEmail()">
    </div>
    <div>
        <a>비밀번호</a> 
        <input type="password" name="m_pass" placeholder=" 10~16자(영문,숫자,특수 문자 조합)로 입력해주세요." autocomplete="none">
    </div>
    <div>
        <a>비밀번호 확인</a> 
        <input type="password" name="m_pass_check" placeholder=" 비밀번호를 다시 한 번 입력해주세요." autocomplete="none">
    </div>
    <div>
        <a>이름</a> 
        <input type="text" name="m_name" placeholder=" 이름을 입력해주세요." autocomplete="none">
    </div>
    <div>
        <a>휴대폰번호</a> 
        <input type="text" name="m_number" placeholder=" -없이 숫자만 입력해주세요." autocomplete="none" maxlength="11">
    </div>
    <div>
        <input type="checkbox" name="all_agree" id="all_agree"> 
        <span>전체 동의</span>
    </div>
    
    <div class="line"></div>
    
    <div class="bottom">    
        <div class="box1"><input type="checkbox" name="m_age" value="Y" id="age_check"><a class="a1">(필수) <span>만 14세 이상입니다.</span></a></div>
        <div class="box2"><input type="checkbox" name="m_terms" value="Y" id="terms_check"><a class="a2">(필수) <span><u>이용약관</u>에 동의</span></a></div>
        <div class="box3"><input type="checkbox" name="m_privacy" value="Y" id="privacy_check"><a class="a3">(필수) <span><u>개인정보 수집 및 이용</u>에 동의</span></a></div>
        <section id="text1" class="text1">   </section>
        <div class="box4"><input type="checkbox" name="m_marketing" value="Y" id="marketing_check"><span>(선택) 마케팅 수신에 동의</span></div>
        <section id="text2" class="text2">   </section>
    </div> 
    <div><input type="button" value="가입 하기" onclick="member_joinok()"></div>
</form>

