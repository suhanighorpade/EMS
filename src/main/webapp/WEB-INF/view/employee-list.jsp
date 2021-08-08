<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phantom
  Date: 06/08/21
  Time: 1:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee list</title>
</head>
<body>
    Employee List

    <input type="button" value="Add Employee" onclick="window.location.href='${pageContext.request.contextPath}/admin/addEmpForm'; return false;">

    <table>
        <tr>
            <th>Employee ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>DOB</th>
            <th>Email</th>
            <th>Department ID</th>
            <th>Action</th>
        </tr>
        <c:forEach items="${employees}" var="employee">
            <c:url var="updateLink" value="/admin/editEmployee">
                <c:param name="employeeId"  value="${employee.employee_id}"/>
            </c:url>
            <c:url var="deleteLink" value="/admin/deleteEmployee">
                <c:param name="employeeId"  value="${employee.employee_id}"/>
            </c:url>
            <tr>
                <td>${employee.employee_id}</td>
                <td>${employee.firstName}</td>
                <td>${employee.lastName}</td>
                <td>${employee.dob}</td>
                <td>${employee.email}</td>
                <td>${employee.department.department_id}</td>
                <td><a href="${updateLink}">Edit</a>|
                    <a href="${deleteLink}">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</body>
<a href="${pageContext.request.contextPath}/">Return To Home</a>
</html>
