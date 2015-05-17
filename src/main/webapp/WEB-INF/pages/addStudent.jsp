<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<t:template>
  <h3>${infoText} "${nameButton}"</h3>
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
    <form:input path="entranceDate" value="${dataEntr}" /><br/>

    <input class="button submit-button" name="${nameButton}" type="submit" value="${nameButton}">
  </form:form>
  </div>
</t:template>
