<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
  <nav><a href="/">На главную</a> <a href="/disciplines">Назад</a></nav>
  <div class="content">
    <c:if test="${empty discipline.id}"><h3>Для того чтобы создать дисциплину заполните все поля и нажмите кнопку "Создать"</h3></c:if>
    <c:if test="${!empty discipline.id}"><h3>Для того чтобы модифицировать дисциплину, введите новое значение поля и нажмите кнопку "Применить"</h3></c:if>
  <div class="add">
    <form:form action="addModifyDiscipline" modelAttribute="discipline" method="post">
      <form:hidden path="id" value="${discipline.id}"/>
      <form:label path="name" >Название</form:label>
      <form:input path="name" value="${discipline.name}"/><br/>

      <c:if test="${!empty discipline.id}"><input class="button submit-button" name="Применить" type="submit" value="Применить">
      </c:if>
      <br/>
      <c:if test="${empty discipline.id}"><input class="button submit-button" name="Создать" type="submit" value="Создать">
      </c:if>
      <br/>
      <br/>
      <form:errors cssClass="error" path="name"/>
    </form:form>
  </div>
  </div>
</t:template>
