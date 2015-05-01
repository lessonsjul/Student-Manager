<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
  <table>
    <tr>
      <th>Фамилия</th>
      <th>Имя</th>
      <th>Группа</th>
      <th>Дата поступления</th>
    </tr>
    <tr>
      <td>${student.secondName}</td>
      <td>${student.firstName}</td>
      <td>${student.group}</td>
      <td>${student.entranceDate}</td>
    </tr>
  </table>
 <c:if test="${!empty progresses}">
  <table>
    <tr>
      <th>Предметы</th>
      <th>Оценка</th>
    </tr>
    <c:forEach items="${progresses}" var="elem">
      <tr>
        <td>${elem.discipline.name}</td>
        <td>${elem.value}</td>
      </tr>
    </c:forEach>
  </table>
</c:if>
  <select onchange="document.location=this.options[this.selectedIndex].value">
  <c:forEach items="${semesters}" var="sem">
    <c:if test="${semester.id==sem.id}">
      <option value="${sem.id}" selected>${sem.name}</option>
    </c:if>
    <c:if test="${semester.id!=sem.id}" >
      <option value="/progress/${sem.id}/${student.id}">${sem.name}</option>
    </c:if>
  </c:forEach>
    </select>
<div>Средняя оценка за семестр: ${avaragePoint}</div>

</t:template>