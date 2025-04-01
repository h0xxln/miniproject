$(document).ready(function() {
    // 텍스트 파일을 불러오는 함수
    function loadAgreeInfo(fileName, elementId) {
        $.ajax({
            url: fileName,        // 텍스트 파일 경로 (같은 폴더에 있으므로 단순히 파일명)
            type: "GET",          // GET 요청
            dataType: "text",     // 텍스트 데이터
            success: function(data) {
                $("#" + elementId).html(data);  // 성공하면 해당 요소에 내용 삽입
            },
            error: function(xhr, status, error) {
                console.error("파일 불러오기 실패: " + error);  // 에러가 발생하면 로그 출력
            }
        });
    }

    // 페이지 로딩 후 파일 불러오기
    loadAgreeInfo("agree1.txt", "text1");  // agree1.txt를 text1에 삽입
    loadAgreeInfo("agree2.txt", "text2");  // agree2.txt를 text2에 삽입
});
