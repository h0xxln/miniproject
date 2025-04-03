<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천분양 정보 게시판</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/md_board_view.css?v=5">
<style>
.box {
   width: 800px;
   height: 300px;
   border: 1px solid black;
   overflow: auto;
}

</style>
</head>
<body>
<!-- top.jsp  -->
 <%@ include file="./top.jsp"%>
<main>
    <section class="sub">
        <p>추천분양 정보 게시판</p>
        <div class="boards">이번주 신규 매물정보를 한눈에 확인하실 수 있습니다.</div>
        <div class="info_board">
          <ul>
            <li>제&nbsp;&nbsp;&nbsp;목</li>
            <li>${post[0].m_title}</li>
            <li>글쓴이</li>
            <li>${post[0].m_writer}</li>
            <li>등록일</li>
            <li>${post[0].m_created_at}</li>
            <li>조회수</li>
            <li>${post[0].m_views}</li>
            <li class="litext">내&nbsp;&nbsp;&nbsp;용</li>
            <li class="litext">
                <div class="textarea">
                    ${post[0].m_content}
                </div>
            </li>
          </ul>
        </div>
        <div class="board_btn">
            <input type="button" value="목&nbsp;&nbsp;&nbsp;록" onclick="window.location.href='./md_board.do'" class="btns">
        </div>
    </section>
</main>
 <!-- 카피라이터 -->
 <%@ include file="./copyright.jsp" %>

</body>
</html>