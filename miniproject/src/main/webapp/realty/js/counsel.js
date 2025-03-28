$(() => {
    // 오늘 날짜 이후로만 선택 가능하도록 설정
    let today = new Date().toISOString().split("T")[0];
    $(".sel_input2").attr("min", today);
});

// 상담신청 버튼 클릭 시 실행할 함수
function applyCounsel() {
	
	console.log("test");
    let form = $("#frm");

    // 필수 입력값 확인 (로그인 정보 자동 입력된 상태)
    if (!$("input[name='c_name']").val().trim() ||
        !$("input[name='c_email']").val().trim() ||
        !$("input[name='c_number']").val().trim()) {
        alert("로그인 정보를 확인할 수 없습니다.");
        return;
    }

    // 체크박스 최소 1개 선택 확인
    if ($("input[name='c_rentype']:checked").length === 0) {
        alert("임대형태를 최소 1개 선택해야 합니다.");
        return;
    }
    if ($("input[name='c_livetype']:checked").length === 0) {
        alert("주거형태를 최소 1개 선택해야 합니다.");
        return;
    }

    // 상담일시 확인
    if (!$("input[name='c_counseltime']").val()) {
        alert("상담일시를 선택해야 합니다.");
        return;
    }


    // 상담내용 길이 검증 (최소 10자 이상)
    if ($("textarea[name='c_content']").val().trim().length < 10) {
        alert("상담내용을 최소 10자 이상 입력해 주세요.");
        return;
    }

    // 모든 검증 통과 → 폼 제출
      form.submit();
}