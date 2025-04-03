<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>추천분양 정보 게시판</title>
<link rel="stylesheet" type="text/css" href="./css/index.css?v=1">
<link rel="stylesheet" type="text/css" href="./css/md_board.css?v=5">
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
            <li>NO</li>
            <li>제목</li>
            <li>글쓴이</li>
            <li>조회수</li>
            <li>등록일</li>
          </ul>
            <!-- 등록된 게시물이 없을 경우 -->
            <cr:if test="${m_check == 'nodata'}">
              <ul>
                <li class="nodata">등록된 게시물이 없습니다.</li>
              </ul>
            </cr:if>         
              <cr:forEach var="mdbList" items="${mdboard}" varStatus="status">
                <ul class="data_view">
                  <li>${(currentPage - 1) * pageSize + status.count}</li>
                  <li style="text-align: left;"> 
                    <a href="md_board_view.do?midx=${mdbList.midx}">
                      ${mdbList.m_title}
                    </a>
                  </li>
                  <li>${mdbList.m_writer}</li> 
                  <li>${mdbList.m_views}</li> 
                  <li>${mdbList.m_created_at}</li>
                </ul>
              </cr:forEach>
        </div>

        <!-- 페이징 -->
        <div class="info_pageing">
          <ol>
            <cr:forEach var="i" begin="1" end="${totalPages}">
              <li>
                <a href="./md_board.do?page=${i}&m_search=${m_search}"
                   style="<c:if test='${i == currentPage}'>font-weight:bold;</c:if>">
                  ${i}
                </a>
              </li>
            </cr:forEach>
          </ol>
        </div>

        <!-- 검색 기능 -->
        <form action="./md_board.do" method="GET">
          <div class="info_search">
            <input type="text" name="m_search" class="search_text" 
                   placeholder="검색어를 입력하세요" value="${m_search}">
            <input type="submit" value="검색" class="search_btn">
          </div>
        </form>

    </section>
</main>
<!-- 카피라이터 -->
<%@ include file="./copyright.jsp" %>
</body>
</html>
