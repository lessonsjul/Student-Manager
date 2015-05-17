<%@ tag description="Template Tag" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <title>Student Progress Manager</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <script src="<c:url value="/resources/s/Actions.js"/>"></script>
    <link href="<c:url value="/resources/c/style.css"/>" rel="stylesheet">
</head>
<body>
<header><h3>Система управления студентами и их успеваемостью</h3> </header>
<main><jsp:doBody/></main>

</body>
</html>
