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

Kakao.init('95b937e5daa195dee842b8d2c4f19318');	//키발급된 번호
  function kakao_login(){


	//혹시라도 일반 로그인 폼이 같이 날라올 경우 값 삭제
	document.querySelector("input[name='m_email']").value = "";
    document.querySelector("input[name='m_pass']").value = "";
	  
	  //Kakao.Auth.login : 카카오 회원가입 및 로그인 페이지를 출력하는 함수
	  Kakao.Auth.login({
		  	//성공시 출력되는 형태
		    success:function(response){	//response 결과화면
		    	
				 Kakao.API.request({	//사용자 가입정보를 요청
					 url: '/v2/user/me', // 사용자 정보 가져오기
					 success:function(response){	//API 서버에서 가입정보를 가져옴
						 let id = response["id"];	//고유값
						 //카카오에서 제공하는 별칭
					 	 let nickname = response["kakao_account"]["profile"]["nickname"];
						 frm.code.value = "2";
						 frm.kakao_id.value = id;
						 frm.kakao_nicknm.value = nickname;
						 frm.submit();
					 },
					 fail:function(error){
						 console.log("카카오 API 접속오류!!");		 
					 }
				 });
			},
			//API 키가 맞지 않을 경우 출력되는 함수
			fail:function(error){
				console.log(error);
				console.log("카카오 key 접속 오류 및 환경설정 오류!!");
			} 
	  });
}