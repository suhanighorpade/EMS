<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: phantom
  Date: 08/08/21
  Time: 11:16 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Comment Form</title>
</head>
<body>
    <form:form modelAttribute="comment" action="saveComment">
        <form:hidden path="statusrptid"/>
        <form:input path="comments"/>
        <form:input type="date" path="createDate"/>
        <form:hidden path="regulation_id" value="${regulation.id}"/>
        <input type="submit" value=Submit!">
    </form:form>

    <a href="${pageContext.request.contextPath}/">Return To Home</a>
</body>
</html>
