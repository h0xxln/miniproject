function search_mypass(){
	//var m_email = frm.m_email.

	//ajax 통신 해야함.
	var m_email = $("#m_email").val();
	var m_pass = $("#m_pass").val();
	var check_pass = $("#check_pass").val();
	
  var passPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[\W_])[A-Za-z\d\W_]{8,20}$/;

    if (!passPattern.test(m_pass)) {
        alert("비밀번호는 8자 이상, 숫자, 문자, 특수문자를 포함해야 합니다.");
        return;
    }
    // 비밀번호 확인
    if (m_pass !== check_pass) {
        alert("비밀번호가 일치하지 않습니다.");
        return;
    }

    if (!m_email || !m_pass ||  !check_pass) {
        alert("비밀번호 모두 입력해주세요.");
        return;
    }

    else{
	ajax_post(m_email,m_pass);
	}
	
}

function ajax_post(m_email,m_pass) {

	console.log(m_pass);
    $.ajax({
        type: "POST",
        url: "/realty/update_pass.do",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        data: { 
            m_email: m_email, 
          	m_pass: m_pass 
        },
        dataType: "text",
        success: function (result) {
            result = $.trim(result);
            var msg = result;
            
            if (msg == "ok") {
                	alert('비밀번호가 정상적으로 변경 되었습니다. \n 로그인 페이지로 이동합니다.')
        		    location.href = './login.jsp';  		
             } 
            else if(msg == "no") {
               alert('비밀번호가 정상적으로 삭제되지 못하였습니다.');
             }
        },
        error: function () {
            alert("오류가 발생했습니다.");
        }
    });
}