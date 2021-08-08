<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phantom
  Date: 05/08/21
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home Page</title>
</head>
<body>
<form:form action="${pageContext.request.contextPath}/logout" method="post">
    <input type="submit" value="Logout">
</form:form>
  <h2>Hello! <security:authentication property="principal.username"/></h2>
    <security:authorize access="hasRole('ADMIN')">
    <br>
        <p> What do you want to do today?</p>
        <ul>
            <li><a href="${pageContext.request.contextPath}/admin/getDepartments">View all departments</a></li>
            <li><a href="${pageContext.request.contextPath}/admin/getEmployees">View all employees</a> </li>
            <li><a href="${pageContext.request.contextPath}/admin/getRegulations">View all regulations</a> </li>
        </ul>
    </security:authorize>

  <security:authorize access="hasRole('EMPLOYEE')">
      <br>
      <p> What do you want to do today?</p>
      <ul>
          <li><a href="${pageContext.request.contextPath}/employee/getRegulations">View all regulations assigned to you</a></li>
      </ul>
  </security:authorize>



</body>
</html>
