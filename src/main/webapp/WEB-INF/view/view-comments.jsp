<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: phantom
  Date: 08/08/21
  Time: 1:05 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View Comments Page</title>
</head>
<body>
<table>
    <tr>
        <th>Comment Id</th>
        <th>Comment desc</th>
        <th>Edit comment</th>
    </tr>
    <c:forEach items="${myComments}" var="comment" >
        <c:url var="updateLink" value="/employee/editComment">
            <c:param name="commentId"  value="${comment.statusrptid}"/>
        </c:url>
      <tr>
          <td>${comment.statusrptid}</td>
          <td>${comment.comments}</td>
          <td><a href="{updateLink}">Edit</a> </td>
      </tr>
    </c:forEach>
</table>
<a href="${pageContext.request.contextPath}/">Return To Home</a>
</body>
</html>
