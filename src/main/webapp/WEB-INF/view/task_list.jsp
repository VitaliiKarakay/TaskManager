<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of tasks</title>
</head>
<body>
<h2>TASK LIST</h2>
<br><br>
<table>

    <tr>
        <th>Id</th>
        <th>Shortname</th>
        <th>Developer</th>
        <th>Status</th>
        <th>Done</th>
    </tr>
    <c:forEach var="task" items="${allTasks}">
        <tr>
            <td>${task.id}</td>
            <td>${task.shortName}</td>
            <td>${task.developer}</td>
            <td>${task.status}</td>
            <td>${task.done}</td>
        </tr>
    </c:forEach>

</table>
</body>
</html>
