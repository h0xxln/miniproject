
 document.querySelectorAll('.estate-item').forEach(function(item) {
    item.addEventListener('click', function() {
      var tidx = item.getAttribute('data-id'); // li 태그에 저장된 tidx을 가져옴
      window.location.href = "week_tails.do?tidx=" + tidx; // 해당 페이지로 이동
    });
  });

