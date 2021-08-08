<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: phantom
  Date: 06/08/21
  Time: 4:38 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Registration Form</title>
</head>
<body>
    <form:form modelAttribute="employee" action="saveEmployee">
        <form:hidden path="employee_id"/>
        First Name <form:input path="firstName"/> <form:errors path="firstName" cssClass="error"/><br>
        Last Name <form:input path="lastName"/> <form:errors path="lastName" cssClass="error"/><br>
        DOB   <form:input type="date" path="dob"/> <form:errors path="dob" cssClass="error"/> <br>
        Email   <form:input path="email"/> <form:errors path="email" cssClass="error"/><br>
        Department

            <form:select path="department_id">
            <c:forEach items="${departmentMap}" var="department">
                <form:option value="${department.value}" label="${department.key}" />
            </c:forEach>
        </form:select><br>

        <input type="submit" value="Add Employee!">
    </form:form>

</body>

<a href="${pageContext.request.contextPath}/">Return To Home</a>
</html>
