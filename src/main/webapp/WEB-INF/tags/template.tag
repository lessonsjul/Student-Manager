<%@ tag description="Template Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Student Progress Manager</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="<c:url value="/resources/s/Actions.js"/>"></script>
    <link href="<c:url value="/resources/c/style.css"/>" rel="stylesheet">
</head>
<body>
<header class="clearfix"><p class="capture">Система управления студентами и их успеваемостью</p>
    <sec:authorize access="isAnonymous()">
        <a href="/spring_security_login">LogIn</a>
    </sec:authorize>
    <sec:authorize access="isAuthenticated()">
        <a href="/j_spring_security_logout">LogOut</a>
    </sec:authorize>
</header>

<main>
    <jsp:doBody/>
</main>
</body>
</html>
