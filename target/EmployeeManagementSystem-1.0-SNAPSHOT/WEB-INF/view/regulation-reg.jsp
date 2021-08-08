<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phantom
  Date: 07/08/21
  Time: 4:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Regulation Form</title>
</head>
<body>
    <form:form modelAttribute="regulation" action="saveRegulation">
        Regulation Type <form:input path="RLType"/> <form:errors path="RLType" cssClass="error"/><br>
        RL Details <form:input type="textarea" path="details"/> <form:errors path="details" cssClass="error"/><br>
        Creation Date <form:input type="date" path="createdate"/> <form:errors path="createdate" cssClass="error"/> <br>
        Department
        <form:select path="dept_id">
            <c:forEach items="${departmentMap}" var="department">
                <form:option value="${department.value}" label="${department.key}" />
            </c:forEach>
        </form:select><br>

        <input type="submit" value="Add Regulation!">
    </form:form>
    <a href="${pageContext.request.contextPath}/">Return To Home</a>
</body>

</html>
