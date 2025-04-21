//카카오 로그인(정보없음) -> 회원가입 페이지 이동 됐을때 세션값
document.addEventListener("DOMContentLoaded", function() {
	//카카오 로그인(정보없음) -> 회원가입 페이지 이동 됐을때 세션값
	let kid = sessionStorage.getItem("kid");
	let knick = sessionStorage.getItem("knick");

	if (kid != null) {
		f.code.value = "2";
		f.kakao_id.value = kid;
		f.kakao_nicknm.value = knick;
	}
});




var isEmailChecked = false;

function setAllAgree() {	//체크 박스 전체 동의 관련 메소드
	var allAgree = document.getElementById("all_agree");
	var checkboxes = document.querySelectorAll(".bottom input[type='checkbox']");

	// 전체 동의 체크박스를 클릭하면 다른 체크박스들을 모두 체크/해제
	allAgree.onclick = function() {
		checkboxes.forEach(function(cb) {
			cb.checked = allAgree.checked;
		});
	};

	// 개별 체크박스 상태가 변경되면 전체 동의 체크박스 상태를 갱신
	checkboxes.forEach(function(cb) {
		cb.onclick = function() {
			allAgree.checked = [...checkboxes].every(function(cb) {
				return cb.checked;
			});
		};
	});
}

// DOM이 로드된 후에 실행
window.onload = setAllAgree;


function member_joinok() {


	var m_email = f.m_email.value.trim();
	var m_pass = f.m_pass.value.trim();
	var m_pass_check = f.m_pass_check.value.trim();
	var m_name = f.m_name.value.trim();
	var m_number = f.m_number.value.trim();
	var m_age = f.m_age.checked;
	var m_terms = f.m_terms.checked;
	var m_privacy = f.m_privacy.checked;
	var m_marketing = f.m_marketing.checked; // 선택 항목이므로 필수 아님	

	// 이메일 정규식 (올바른 이메일 형식인지 검사)
	var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	if (!emailPattern.test(m_email)) {
		alert("올바른 이메일 주소를 입력해주세요.");
		return;
	}
	// 이메일 중복 체크 확인
	if (!isEmailChecked) {
		alert("이메일 중복 확인을 해주세요.");
		return;
	}

	// 비밀번호 정규식 (8~20자, 숫자, 문자, 특수문자 포함)
	var passPattern = /^(?=.*[A-Za-z])(?=.*\d)(?=.*[\W_])[A-Za-z\d\W_]{8,20}$/;
	if (!passPattern.test(m_pass)) {
		alert("비밀번호는 8자 이상, 숫자, 문자, 특수문자를 포함해야 합니다.");
		return;
	}

	// 비밀번호 확인
	if (m_pass !== m_pass_check) {
		alert("비밀번호가 일치하지 않습니다.");
		return;
	}

	// 전화번호 정규식 (010으로 시작하는 11자리 숫자)
	var telPattern = /^010\d{8}$/;
	if (!telPattern.test(m_number)) {
		alert("전화번호는 '010'으로 시작하는 11자리 숫자로 입력해주세요.");
		return;
	}
	document.querySelectorAll(".bottom input[type='checkbox']").forEach(cb => {
		cb.addEventListener("change", function() {
			document.getElementById("all_agree").checked =
				document.querySelectorAll(".bottom input[type='checkbox']:checked").length ===
				document.querySelectorAll(".bottom input[type='checkbox']").length;
		});
	});

	// 필수 입력값 체크 (선택 항목인 m_marketing은 제외)
	if (!m_email || !m_pass || !m_pass_check || !m_name || !m_number || !m_age || !m_terms || !m_privacy) {
		alert("모든 필수 정보를 입력해주세요.");
		return;
	}


	// 모든 검증 통과 시 폼 제출
	f.submit();
}



function checkEmail() {
	var m_emailCheck = $("#m_emailCheck").val();
	var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
	if (m_emailCheck === "" || m_emailCheck == null) {
		alert("이메일을 입력하세요.");
		return;
	}
	if (!emailPattern.test(m_emailCheck)) {
		alert("올바른 이메일 주소를 입력해주세요.");
		return;
	}

	ajax_get(m_emailCheck);
}

function ajax_get(m_emailCheck) {
	$.ajax({
		type: "GET",
		url: "/realty/email_check.do",
		data: { m_email: m_emailCheck },
		dataType: "text",
		success: function(result) {
			result = $.trim(result); // 응답값 공백 제거
			if (result == "no") {
				alert("아이디가 이미 존재합니다.");
				isEmailChecked = false; // 중복 체크 실패
			} else if (result == "ok") {
				alert("사용 가능한 아이디입니다.");
				isEmailChecked = true; // 중복 체크 성공
			}
		},
		error: function() {
			alert("오류가 발생했습니다.");
		}
	});
}


