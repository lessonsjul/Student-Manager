<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>


<t:template>
    <nav><a href="/">На главную</a> <a href="/semesters">Назад</a></nav>
    <div class="content">
        <c:if test="${empty semester.id}"><h3>Для создания семестра заполните следующие данные и нажмите кнопку "Создать"</h3></c:if>
        <c:if test="${!empty semester.id}"><h3>Для модификации семестра отредактируйте данные и нажмите кнопку "Применить"</h3></c:if>
  <div class="add">

    <form:form action="addModifySemester" modelAttribute="semester" method="post">

      <form:hidden path="id" value="${semester.id}"/>
        <form:label cssClass="semLab" path="name" >Название семестра</form:label>
        <form:input path="name" value="${semester.name}" />

      <form:label cssClass="semLab" path="duration" >Длительность(в неделях)</form:label>
      <form:input path="duration" value="${semester.duration}" />

      <form:label cssClass="semLab" path="disciplineList">Дисциплины в семестре</form:label>
      <form:select cssClass="discList" path="disciplineList" multiple="true" size="8" >
          <c:forEach items="${disciplines}" var="d">
              <c:if test="${fn:contains(selected, d.name)}">
                  <form:option value="${d.id}" selected="selected">${d.name}</form:option>
              </c:if>
              <c:if test="${!fn:contains(selected, d.name)}">
                  <form:option value="${d.id}">${d.name}</form:option>
              </c:if>
          </c:forEach>
      </form:select>
        <c:if test="${!empty semester.id}"><input class="button submit-button" name="Применить" type="submit" value="Применить">
        </c:if>
        <br/>
        <c:if test="${empty semester.id}"><input class="button submit-button" name="Создать" type="submit" value="Создать">
        </c:if>
        <br/>
        <br/>
        <form:errors cssClass="error" path="name"/>
        <form:errors cssClass="error" path="duration"/>
        <form:errors cssClass="error"  path="disciplineList"/><br/>
    </form:form>

  </div>
    </div>
</t:template>
