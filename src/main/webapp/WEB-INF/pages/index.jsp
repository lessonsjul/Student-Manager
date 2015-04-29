<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Progress Manager</title>
</head>
<body>

<c:if test="${students!=null}">

  <table>
    <tr>
      <th>Фамилия</th>
      <th>Имя</th>
      <th>Группа</th>
      <th>Дата поступления</th>
    </tr>
    <c:forEach items="${students}" var="student">
    <tr>
      <td>${student.secondName}</td>
      <td>${student.firstName}</td>
      <td>${student.group}</td>
      <td>${student.entranceDate}</td>
    </tr>
    </c:forEach>
  </table>
</c:if>

</body>
</html>
