<%@ page contentType="text/html; UTF-8" pageEncoding="UTF-8" language="java" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<t:template>

  <c:if test="${disciplines!=null}">
    <table>
      <tr>
        <th>Наименование дисциплины</th>
      </tr>
      <c:forEach items="${disciplines}" var="disc">
        <tr>
          <td>${disc.name}</td>
        </tr>
      </c:forEach>
    </table>
  </c:if>

</t:template>
