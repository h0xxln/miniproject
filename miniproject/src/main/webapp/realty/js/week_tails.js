function visit() {
    alert("방문 예약 등록 페이지로 이동합니다.");
    
    var tidx = document.getElementById("tidx").value;
    var t_name = document.getElementById("t_name").value;
    // URL에 tidx와 t_name을 파라미터로 추가
    location.href = "./reservation.do?tidx=" + encodeURIComponent(tidx) + "&t_name=" + encodeURIComponent(t_name);

}