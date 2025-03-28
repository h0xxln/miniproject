function search_pass(){
	//ajax 통신 해야함.
	var m_email = frm.m_email.value;
	var m_number = frm.m_number.value;
	
 var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
    if (!emailPattern.test(m_email)) {
        alert("올바른 이메일 주소를 입력해주세요.");
        return;
    }
    
    var telPattern = /^010\d{8}$/;
    if (!telPattern.test(m_number)) {
        alert("전화번호는 '010'으로 시작하는 11자리 숫자로 입력해주세요.");
        return;
    }
    if (!m_email || !m_number) {
        alert("이름과 전화번호 모두 입력해주세요.");
        return;
    }

    else{
		ajax_post(m_email,m_number);
	}
	
}

function ajax_post(m_email,m_number) {
//search_pass.do
    $.ajax({
        type: "POST",
        url: "/realty/search_pass.do",
        data: { 
            m_email: m_email, 
            m_number: m_number 
        },
        dataType: "text",
        success: function (result) {
            result = $.trim(result);
            var msg = result;
            
            if (msg == "ok") {
                if (confirm('입력하신 정보와 일치하는 계정이 있습니다. 비밀번호를 변경하시겠습니까?')) {
        		    location.href = './search_mypass.do';
       			 } 
       			 else {
           			 history.go(-1);
       			 }
    		
             } 
            else if(msg == "no") {
               alert('입력하신 정보와 일치하는 계정이 없습니다.');
             }
        },
        error: function () {
            alert("오류가 발생했습니다.");
        }
    });
}