<%@ page import="java.util.Formatter" %>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"  language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<t:template>
<nav><a href="/">На главную</a></nav>
  <div class="content">
    <c:if test="${empty students}">
      <h4>Студенты отсутствуют</h4>
    </c:if>
  <form:form cssClass="studForm" name="studForm" method="GET" action="">
    <c:if test="${!empty students}">
    <input class="button multi-button" type="button" value="Просмотреть успеваемость выбранного студента" onclick="progress()">
    </c:if>
    <sec:authorize access="hasRole('admin')">
    <input class="button  multi-button" type="button" value="Создать студента..." onclick="addStudent()">
      <c:if test="${!empty students}">
    <input class="button  multi-button" type="button" value="Модифицировать выбранного студента..." onclick="editStudent()">
    <input class="button  multi-button" type="button" value="Удалить выбранных студентов" onclick="deleteStudent()">
      </c:if>
    </sec:authorize>
    <c:if test="${!empty students}">
<h4>Список студентов</h4>
     <table>
      <tr>
        <th></th>
        <th>Фамилия</th>
        <th>Имя</th>
        <th>Группа</th>
        <th>Дата поступления</th>
      </tr>
      <c:forEach items="${students}" var="stud">
      <tr>
        <td><input type="checkbox" value="${stud.id}" name="idStud"></td>
        <td>${stud.secondName}</td>
        <td>${stud.firstName}</td>
        <td>${stud.group}</td>
        <td><fmt:formatDate value="${stud.entranceDate}" type="date" pattern="dd/MM/yyyy"/></td>
      </tr>
      </c:forEach>
    </table>
  </c:if>
  </form:form>
  </div>
</t:template>

