<%@ page contentType="text/html; UTF-8"  pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>
    <nav><a href="/">На главную</a> <a href="/progress">Назад</a></nav>
    <div class="content">
        <form:form action="" modelAttribute="progress" method="post">
            <form:select path="student" multiple="false" size="10" >
                <c:forEach items="${studentList}" var="stud">
                    <form:option value="${stud.value}">${stud.key}</form:option>
                </c:forEach>
            </form:select>
        </form:form>
    </div>
</t:template>