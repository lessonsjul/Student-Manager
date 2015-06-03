<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
  <div class="">
    <form:form name="semesterForm" action="" method="get">
      <label>Выбрать семестр</label>

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
      <input class="button choise-button" type="button" onclick="choiseSemestr()" value="Выбрать">
  </div>


        <div class="discipline">
            <c:if test="${!empty semester.disciplineList}">
                <table>
                    <tr>
                        <th>Дисциплина</th>
                    </tr>
                    <c:forEach items="${semester.disciplineList}" var="disc">
                        <tr>
                            <td>${disc.name}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>



<div class="choises">
      <input class="button multi-button" type="button" value="${addButton}" onclick="addSemester()">
      <input class="button multi-button" type="button" value="${modifButton}" onclick="editSemester()">
      <input class="button multi-button" type="button" value="${deleteButton}" onclick="deleteSemester()">
    </div>
  </form:form>

</t:template>
