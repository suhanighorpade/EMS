<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phantom
  Date: 06/08/21
  Time: 12:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Department List</title>
</head>
<body>
    Department List

    <input type="button" value="Add Department" onclick="window.location.href='${pageContext.request.contextPath}/admin/addDeptForm'; return false;">

    <table>
        <tr>
            <th>Department ID</th>
            <th>Department Name</th>
        </tr>
        <c:forEach items="${departments}" var="department">

        <tr>
            <td>${department.department_id}</td>
            <td>${department.department_name}</td>
        </tr>
        </c:forEach>
    </table>

    <a href="${pageContext.request.contextPath}/">Return To Home</a>
</body>
</html>
