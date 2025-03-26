function logincheck(){
	var m_email = frm.m_email.value;
	var m_pass = frm.m_pass.value;
	
 var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(m_email)) {
        alert("올바른 이메일 주소를 입력해주세요.");
        return;
    }
    // 비밀번호 확인 (8자 이상, 숫자, 문자, 특수문자 포함)
    var passPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[\W_])[A-Za-z\d\W_]{8,20}$/;
    if (!passPattern.test(m_pass)) {
        alert("비밀번호는 8자 이상, 숫자, 문자, 특수문자를 포함해야 합니다.");
        return;
    }

    else{
		frm.submit();
	}
	
}
