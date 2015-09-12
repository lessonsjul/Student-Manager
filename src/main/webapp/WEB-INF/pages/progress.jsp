<%@ page import="java.util.Formatter" %>
<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8"  language="java" %>
<%@ taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>



<t:template>
  <nav><a href="/">На главную</a> <a href="/students">Назад</a></nav>
  <div class="content">
      <c:if test="${!empty student}">
          <h4>Отображена успеваемость для следующего студента:</h4>
          <table>
              <tr>
                  <th>Фамилия</th>
                  <th>Имя</th>
                  <th>Группа</th>
                  <th>Дата поступления</th>
              </tr>
              <tr>
                  <td>${student.secondName}</td>
                  <td>${student.firstName}</td>
                  <td>${student.group}</td>
                  <td><fmt:formatDate value="${student.entranceDate}" type="date" pattern="dd/MM/yyyy"/></td>
              </tr>

          </table>
      </c:if>
    <c:if test="${empty progress}">
      <h4>Информация об успеваемости данного студента отсутсвует</h4>
    </c:if>
    <c:if test="${!empty progress}">
    <div class="discipline">
        <table>
            <tr>
              <th>Дисциплина</th>
              <th>Оценка</th>
            </tr>
            <c:forEach items="${progress}" var="prog">
              <tr>
                <td>${prog.key.name}</td>
                <td>${prog.value}</td>
              </tr>
            </c:forEach>
        </table>
    </div>
    <div class="choises">
      <form:form name="semesterForm" action="progress" method="get">
      <%--<input type="text" name="idStud" value="${student.id}">--%>
        <input type="hidden" name="idStud" value="${student.id}">
        <label>Выбрать семестр</label>
        <select name="idSem">
          <c:forEach items="${semesters}" var="sem">
            <c:if test="${sem.id != choiseSem}">
              <option onselect="changeSemestr(${sem.id})" value="${sem.id}">${sem.name}</option>
            </c:if>
            <c:if test="${sem.id == choiseSem}">
              <option  value="${sem.id}" selected>${sem.name}</option>
            </c:if>
          </c:forEach>
        </select>
        <input class="button choise-button" type="submit" value="Выбрать">
      </form:form>
      <h5>Средняя оценка за семестр: ${avaragePoint} балла</h5>
    </div>
  </c:if>
  </div>
    <a href="/addProgress">addProgress</a>
</t:template>