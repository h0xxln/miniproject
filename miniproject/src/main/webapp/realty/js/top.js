function goindex() {
	location.href = "./index.do";
}

function reserve_page() {
	location.href = "./reservation_list.do";
}
function myinfo_menu(part) {
	var log_menu = document.getElementById("login_info");
	if (part == 1) {
		if (log_menu.style.display == "none") {
			log_menu.style.display = "block";
		}
		else {
			log_menu.style.display = "none";
		}
	}
	else {
		log_menu.style.display = "none";
	}
}
