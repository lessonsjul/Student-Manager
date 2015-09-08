<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<t:template>
  <nav><a href="/">На главную</a></nav>
  <div class="content">
  <form:form cssClass="" name="disciplForm" method="GET" action="">

  <div class="discipline">
  <c:if test="${!empty disciplines}">
    <table>
      <tr>
        <th></th>
        <th>Наименование дисциплины</th>
      </tr>
      <c:if test="${!empty disciplines}" >
      <c:forEach items="${disciplines}" var="discipl">
        <tr>
          <td><input type="checkbox" value="${discipl.id}" name="idDiscipl"></td>
          <td>${discipl.name}</td>
        </tr>
      </c:forEach>
      </c:if>

    </table>
  </c:if>
  </div>
    <sec:authorize access="hasRole('admin')">
    <div class="choises">
    <input class="button multi-button" type="button" value="Создать дисциплину..." onclick="addDiscipline()">
    <input class="button multi-button" type="button" value="Модифицировать выбранную дисциплину..." onclick="editDiscipline()">
    <input class="button multi-button" type="button" value="Удалить выбранную дисциплину" onclick="deleteDiscipline()">
    </div>
    </sec:authorize>
  </form:form>
</div>
</t:template>
