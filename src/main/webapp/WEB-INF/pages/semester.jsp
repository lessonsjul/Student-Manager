<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
  <div class="">
    <form:form name="semesterForm" action="semesters" method="get">
      <label>Выбрать семестр</label>

      <select name="idSem">
        <c:forEach items="${semesters}" var="sem">
          <c:if test="${sem.id != choiseSem}">
            <option onselect="changeSemestr(${sem.id})" value="${sem.id}">${sem.name}</option>
          </c:if>
          <c:if test="${sem.id == choiseSem}">
            <option  value="${sem.id}" selected>${sem.name}</option>
          </c:if>
        </c:forEach>
      </select>
      <input class="button choise-button" type="submit" value="Выбрать">
    </form:form>
  </div>


<div class="choises">
  <form:form name="semesterButton" action="" method="get">
    <input type="hidden" value="${choiseSem}" name="idSem">
      <input class="button multi-button" type="button" value="Создать семестр..." onclick="addSemester()">
      <input class="button multi-button" type="button" value="Модифицировать выбранную дисциплину..." onclick="editSemester()">
      <input class="button multi-button" type="button" value="Удалить выбранную дисциплину" onclick="deleteSemester()">
    </div>
  </form:form>

</t:template>
