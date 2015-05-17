<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
  <h3>${infoText} "${nameButton}"</h3>
  <div class="add">

    <form:form action="addModifySemester" modelAttribute="semester" method="post">
      <form:hidden path="id" value="${semester.id}"/>
      <form:label cssClass="semLab" path="duration" >Длительность(в неделях)</form:label>
      <form:input path="duration" value="${semester.duration}"/>

      <form:label cssClass="semLab" path="disciplineList">Дисциплины в семестре</form:label>
      <form:select cssClass="discList" path="disciplineList" multiple="true" size="8">
        <c:if test="${!empty choiseDiscipl}">
          <c:forEach items="${choiseDiscipl}" var="chDiscipl">
            <option value="${chDiscipl.id}" name="idDiscipl" selected>${chDiscipl.name}</option>
          </c:forEach>
        </c:if>
        <c:if test="${!empty disciplines}">
          <c:forEach items="${disciplines}" var="discipl">
            <option value="${discipl.id}" name="idDiscipl">${discipl.name}</option>
          </c:forEach>
        </c:if>
      </form:select>

      <input class="button submit-button" name="${nameButton}" type="submit" value="${nameButton}">
    </form:form>

  </div>
</t:template>
