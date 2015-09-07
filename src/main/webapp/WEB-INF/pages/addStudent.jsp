<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<t:template>
  <nav><a href="/">На главную</a> <a href="/students">Назад</a></nav>
  <div class="content">
  <c:if test="${empty student.id}"><h3>Для создания студента заполните все поля и нажмите кнопку "Создать"</h3></c:if>
  <c:if test="${!empty student.id}"><h3>Для модификации, введите новые значения и нажмите кнопку "Применить"</h3></c:if>
  <div class="add">
  <form:form action="addModifyStudent" modelAttribute="student" method="post">
    <form:hidden path="id" value="${student.id}"/>
    <form:label path="secondName" >Фамилия</form:label>
    <form:input path="secondName" value="${student.secondName}"/><br/>

    <form:label path="firstName">Имя</form:label>
    <form:input path="firstName" value="${student.firstName}"/><br/>

    <form:label path="group">Группа</form:label>
    <form:input path="group" value="${student.group}"/><br/>

    <form:label path="entranceDate">Дата поступления</form:label>
    <fmt:formatDate var="dateEntr" value='${student.entranceDate}' type='date' pattern='dd/MM/yyyy'/>
    <form:input path="entranceDate" value="${dateEntr}" /><br/>

    <c:if test="${!empty student.id}"><input class="button submit-button" name="Применить" type="submit" value="Применить">
    </c:if>
  <br/>
    <c:if test="${empty student.id}"><input class="button submit-button" name="Создать" type="submit" value="Создать">
    </c:if>
    <br/>
    <br/>
    <form:errors cssClass="error" path="secondName"/>
    <form:errors cssClass="error" path="firstName"/>
    <form:errors cssClass="error"  path="group"/>
    <form:errors cssClass="error"  path="entranceDate"/><br/>

  </form:form>
  </div>
  </div>
</t:template>
