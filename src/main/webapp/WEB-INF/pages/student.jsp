<%@ page import="java.util.Formatter" %>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"  language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<t:template>
<nav><a href="/">На главную</a></nav>
  <div class="content">
  <form:form cssClass="studForm" name="studForm" method="GET" action="">
    <input type="hidden" name="idSem" value="${idSem}"/>
    <input class="button multi-button" type="button" value="Просмотреть успеваемость выбранного студента" onclick="progress()">
    <input class="button  multi-button" type="button" value="Создать студента..." onclick="addStudent()">
    <input class="button  multi-button" type="button" value="Модифицировать выбранного студента..." onclick="editStudent()">
    <input class="button  multi-button" type="button" value="Удалить выбранных студентов" onclick="deleteStudent()">
<h4>Список студентов</h4>
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
        <td><input type="checkbox" value="${student.id}" name="idStud"></td>
        <td>${student.secondName}</td>
        <td>${student.firstName}</td>
        <td>${student.group}</td>
        <td><fmt:formatDate value="${student.entranceDate}" type="date" pattern="dd/MM/yyyy"/></td>
      </tr>
      </c:forEach>
    </table>
  </c:if>
  </form:form>
  </div>
</t:template>

