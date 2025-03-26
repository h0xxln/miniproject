<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="cr" uri="http://java.sun.com/jsp/jstl/core"%>
  <section>
    <div class="weekdays">
      <p>금주분양 매물정보<br><em>이번주 신규 매물정보!</em></p>
      <div class="week_estates">
        <ul>
        <cr:forEach var="weakList" items="${weak_infoList}">
          <li>
            <span>매매</span>
            <div>${weakList.t_name}</div>
            <aside>${weakList.t_adress}</aside>
            <span>${weakList.t_type} | ${weakInfo.t_rentype}</span>
            <label>${weakList.t_saledate} 분양 | ${weakInfo.t_indate} 입주</label>
            <div><img src="./room/${weakList.t_img}"></div>
          </li>
        </cr:forEach>
        </ul>
      </div>
    </div>
  </section>