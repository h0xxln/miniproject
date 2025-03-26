function search_email() {
	 var m_name = frm.m_name.value.trim();
	 var m_number = frm.m_number.value.trim();
     var telPattern = /^010\d{8}$/;
       
    if (!telPattern.test(m_number)) {
        alert("전화번호는 '010'으로 시작하는 11자리 숫자로 입력해주세요.");
        return;
    }
     if (!m_name || !m_number) {
        alert("이름과 전화번호 모두 입력해주세요.");
        return;
    }

	frm.submit();
}