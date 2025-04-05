window.onload = function() {
	CKEDITOR.replace('m_content', {
		height: 360
	});
};

function check_witer() {

	var image = frm.mdb_image.files[0]; // 파일 가져오기
	var title = frm.m_title.value.trim();
	
	// CKEditor 내용 가져오기
	var content = CKEDITOR.instances.m_content.getData().trim();

	if (!title) {
		alert("제목을 입력하세요.");
		return;
	}

	if (!image) {
		alert("썸네일 이미지를 업로드하세요.");
		return;
	}

	if (image.size > 2 * 1024 * 1024) {
		alert("이미지 크기는 2MB 이하로 업로드해주세요.");
		return;
	}

	if (!content) {
		alert("내용을 입력하세요.");
		return;
	}

	// 실제 textarea에 입력값 반영
	CKEDITOR.instances.m_content.updateElement();

	frm.submit(); // 폼 제출
}