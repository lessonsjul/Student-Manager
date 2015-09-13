<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
    <nav><a href="/">На главную</a> <a href="/progress">Назад</a></nav>
    <div class="content">
        <c:if test="${!empty studentList}">
        <form:form action="setProgress" modelAttribute="progress" method="post">
                <form:hidden path="id" value="${progress.id}"/>
                <table class="addProgress">
                    <tr><td><form:label path="student.id">Выберите студента</form:label></td>
                        <td><form:select path="student.id" multiple="false" size="1" >
                            <c:forEach items="${studentList}" var="stud">
                                <%--<form:option value="${stud.value}">${stud.key}</form:option>--%>
                                <form:option value="${stud.id}">${stud.secondName} ${stud.firstName}</form:option>
                            </c:forEach>
                        </form:select></td>
                    </tr>
                    <tr>
                        <td><form:label path="discipline.id">Выберите дисциплину</form:label></td>
                        <td><form:select path="discipline.id" multiple="false" size="1" >
                            <c:forEach items="${disciplineList}" var="disc">
                                <%--<form:option value="${disc.value}">${disc.key}</form:option>--%>
                                <form:option value="${disc.id}">${disc.name}</form:option>
                            </c:forEach>
                        </form:select></td>
                    </tr>
                    <tr>
                        <td><form:label path="value">Укажите оценку</form:label></td>
                        <td><form:select path="value">
                                <form:option value="5">отлично</form:option>
                                <form:option value="4">хорошо</form:option>
                                <form:option value="3">удовлитворительно</form:option>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="Добавить"/></td>
                    </tr>

                </table>
        </form:form>
    </c:if>
    </div>
</t:template>