<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core" %>    
  <section>
    <div class="recommend">
      <p>추천분양정보<br><em>실시간 추천 분양정보를 한곳에!</em></p>
      <div class="md_estates">
        <ul>
        <cr:forEach var="mdList" items="${md_choiceList}">
          <li>
            <div><img src="./md_room/${mdList.md_img}"></div>
            <span>${mdList.md_title}</span>
            <div>${mdList.md_detail}</div>
          </li>
        </cr:forEach>
        </ul>
      </div>
    </div>
  </section>