<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phantom
  Date: 06/08/21
  Time: 12:40 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department Registration</title>
</head>
<body>
    Enter the name of new department:
    <form:form action="saveDept" modelAttribute="department">
        <form:input path="department_name"/>
        <input type="submit" value="Add!">
    </form:form>
</body>

<a href="${pageContext.request.contextPath}/">Return To Home</a>
</html>
