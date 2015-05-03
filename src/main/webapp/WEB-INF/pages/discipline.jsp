<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
  <form:form name="discForm" method="GET" action="action">

  <div class="discipline">
  <c:if test="${disciplines!=null}">
    <table>
      <tr>
        <th></th>
        <th>Наименование дисциплины</th>
      </tr>
      <c:forEach items="${disciplines}" var="disc">
        <tr>
          <td><input type="radio" value="" name="idDisc"></td>
          <td>${disc.name}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>
  </div>
    <div class="choises">
    <input type="hidden" name="buttonName" >
    <input class="button" type="button" value="Создать дисциплину..." onclick="addDiscipline()">
    <input class="button" type="button" value="Модифицировать выбранную дисциплину..." onclick="modifyDiscipline()">
    <input class="button" type="button" value="Удалить выбранную дисциплину" onclick="deleteDiscipline()">
    </div>
  </form:form>

</t:template>
