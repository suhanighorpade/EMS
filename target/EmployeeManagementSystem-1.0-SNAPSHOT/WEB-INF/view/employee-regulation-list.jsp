<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phantom
  Date: 07/08/21
  Time: 10:02 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employee Regulation List</title>
</head>
<body>
<table>
    <tr>
        <th>Regulation ID</th>
        <th>Regulation Type</th>
        <th>Description</th>
        <th>Creation Date</th>
        <th>Add Comment</th>
        <th>View Comments</th>
        <th>Track the status in your department!</th>

    </tr>
    <c:forEach items="${regulations}" var="regulation">
        <c:url var="addCommentLink" value="/employee/addComment">
            <c:param name="regulationId"  value="${regulation.id}"/>
        </c:url>
        <c:url var="viewCommentsLink" value="/employee/viewComments">
            <c:param name="regulationId"  value="${regulation.id}"/>
        </c:url>
        <tr>
            <td>${regulation.id}</td>
            <td>${regulation.RLType}</td>
            <td>${regulation.details}</td>
            <td>${regulation.createdate}</td>
            <td><a href="${addCommentLink}">Add a new comment</a></td>
            <td><a href="${viewCommentsLink}">See the comments entered!</a> </td>>
            <td><a href="${pageContext.request.contextPath}/employee/trackStatus">Track Status!</a></td>
        </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/">Return To Home</a>
</body>

</html>
