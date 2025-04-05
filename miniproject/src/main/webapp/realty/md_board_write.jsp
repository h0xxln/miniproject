<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천분양 정보 게시판</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/md_board_view.css?v=6">
<script src="./ckeditor/ckeditor.js"></script>
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
 <!--top.jsp-->
 <%@ include file="./top.jsp"%>
 
 <!-- main  -->
<main>
    <section class="sub">
        <p>추천분양 정보 게시판</p>
        <form id="frm" action="./md_board_writeok.do" method="post" enctype="multipart/form-data">
            <div class="info_board">
              <ul>
                <li>제&nbsp;&nbsp;&nbsp;목</li>
                <li><input type="text" name="m_title" class="board_in2" required></li>
                <li>글쓴이</li>
                <li><input type="text" name="m_writer" class="board_in1" value="관리자" readonly></li>
                <li>썸네일 이미지</li>
                <li><input name="mdb_image" type="file"  accept="image/*" required></li>
                <li class="litext">내&nbsp;&nbsp;&nbsp;용</li>
                <li class="litext">
                    <textarea name="m_content" id="m_content" required></textarea>
                </li>
              </ul>
            </div>
            <div class="board_btn">
                <input type="button" value="등&nbsp;&nbsp;&nbsp;록" class="btns" onclick="check_witer()">
            </div>
        </form>
    </section>
    <script src="./js/md_board_write.js?v=1"></script>
</main>
 <!-- 카피라이터 -->
 <%@ include file="./copyright.jsp" %>

</body>
</html>