<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<t:template>
  <nav><a href="/">На главную</a></nav>
  <div class="content">
    <c:if test="${empty disciplines}">
      <h4>Дисциплины отсутствуют</h4>
    </c:if>
  <form:form cssClass="" name="disciplForm" method="GET" action="">
  <div class="discipline">
    <c:if test="${!empty disciplines}" >
    <table>
      <tr>
        <sec:authorize access="hasRole('admin')">
        <th></th>
        </sec:authorize>
        <th>Наименование дисциплины</th>
      </tr>
      <c:forEach items="${disciplines}" var="discipl">
        <tr>
          <sec:authorize access="hasRole('admin')">
          <td><input type="checkbox" value="${discipl.id}" name="idDiscipl"></td>
          </sec:authorize>
          <td>${discipl.name}</td>
        </tr>
      </c:forEach>
      </c:if>

    </table>
  </div>
    <sec:authorize access="hasRole('admin')">
    <div class="choises">
    <input class="button multi-button" type="button" value="Создать дисциплину..." onclick="addDiscipline()">
      <c:if test="${!empty disciplines}">
    <input class="button multi-button" type="button" value="Модифицировать выбранную дисциплину..." onclick="editDiscipline()">
    <input class="button multi-button" type="button" value="Удалить выбранную дисциплину" onclick="deleteDiscipline()">
      </c:if>
    </div>
    </sec:authorize>
  </form:form>
</div>
</t:template>
