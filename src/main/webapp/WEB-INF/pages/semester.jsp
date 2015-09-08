<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<t:template>
    <nav><a href="/">На главную</a></nav>
    <div class="content">
  <div class="">
    <form:form name="semesterForm" action="" method="get">
      <label>Выбрать семестр</label>


        <c:if test="${semesters.size() == 0}">
        <select>
                <option>------------</option>
        </select>
        </c:if>


        <c:if test="${!empty semesters}">
            <select name="idSem">

                <c:forEach items="${semesters}" var="sem">

                  <c:if test="${sem.id != semester.id}">
                    <option onselect="changeSemestr(${sem.id})" value="${sem.id}">${sem.name}</option>
                  </c:if>

                  <c:if test="${sem.id == semester.id}">
                    <option  value="${sem.id}" selected>${sem.name}</option>
                  </c:if>

                </c:forEach>
            </select>
        </c:if>

      <input class="button choise-button" type="button" onclick="choiseSemestr()" value="Выбрать">
  </div>

        <h4>Длительность семестра: ${semester.duration} ${nedeli}</h4>
        <h4>Сисок дисциплин семестра</h4>

        <div class="discipline">
            <c:if test="${!empty semester.disciplineList}">
                <table>
                    <tr>
                        <th>Наименование дисциплины</th>
                    </tr>
                    <c:forEach items="${semester.disciplineList}" var="disc">
                        <tr>
                            <td>${disc.name}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>


        <sec:authorize access="hasRole('admin')">
<div class="choises">
      <input class="button multi-button" type="button" value="Создать семестр..." onclick="addSemester()">
      <input class="button multi-button" type="button" value="Модифицировать выбранный семестр..." onclick="editSemester()">
      <input class="button multi-button" type="button" value="Удалить выбранный семестр" onclick="deleteSemester()">
    </div>
        </sec:authorize>
  </form:form>
    </div>

</t:template>
