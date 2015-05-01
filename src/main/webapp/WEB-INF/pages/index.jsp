<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
  <form:form name="form1" method="GET" action="action">
    <input type="hidden" name="buttonName" >
    <input type="button" value="Просмотреть успеваемость выбранного студента" onclick="progress()">
    <input type="button" value="Создать студента..." onclick="addStudent()">
    <input type="button" value="Модифицировать выбранного студента..." onclick="modifyStudent()">
    <input type="button" value="Удалить выбранных студентов" onclick="deleteStudent()">

  <c:if test="${!empty students}">

    <table>
      <tr>
        <th></th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Группа</th>
        <th>Дата поступления</th>
      </tr>
      <c:forEach items="${students}" var="student">
      <tr>
        <td><input type="radio" value="${student.id}" name="idStud"></td>
        <td>${student.secondName}</td>
        <td>${student.firstName}</td>
        <td>${student.group}</td>
        <td>${student.entranceDate}</td>
      </tr>
      </c:forEach>
    </table>
  </c:if>
  </form:form>

  <a href="/getDisciplines">Просмотреть все предметы</a>

</t:template>

