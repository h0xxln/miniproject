$(() => {
    // 오늘 날짜 이후로만 선택 가능하도록 설정
    let today = new Date().toISOString().split("T")[0];
    $(".sel_input").attr("min", today);
}); 


function apply_reservation(){
	let form = $("#frm");
	

    // 필수 입력값 확인 (로그인 정보 자동 입력된 상태)
    if (!$("input[name='wv_name']").val().trim() || !$("input[name='wv_number']").val().trim()){
        alert("로그인 정보를 확인할 수 없습니다.");
        return;
    }
    
    // 방문예약일시 확인
    if (!$("input[name='wv_date']").val()) {
        alert("방문예약일시를 선택해야 합니다.");
        return;
    }
    
    // 방문시간선택 확인
	 if (!$("select[name='wv_time']").val()) {
        alert("방문 시간을 선택해야 합니다.");
        return;
    }

    // 모든 검증 통과 
      form.submit();
}