<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
  <h3>${infoText} "${nameButton}"</h3>
  <div class="add">
    <form:form action="addModifyDiscipline" modelAttribute="discipline" method="post">
      <form:hidden path="id" value="${discipline.id}"/>
      <form:label path="name" >Название</form:label>
      <form:input path="name" value="${discipline.name}"/><br/>

      <input class="button submit-button" name="${nameButton}" type="submit" value="${nameButton}">
    </form:form>
  </div>
</t:template>
