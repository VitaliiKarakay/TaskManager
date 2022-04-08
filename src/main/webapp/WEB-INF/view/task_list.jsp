<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List of tasks</title>
</head>
<body>
<h2>TASK LIST</h2>
<br><br>
<table border="1" class="data">

    <tr>
        <th>Id</th>
        <th>Shortname</th>
        <th>Developer</th>
        <th>Status</th>
        <th>Done</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="task" items="${allTasks}">

        <tr>
            <td>${task.id}</td>
            <td>${task.shortName}</td>
            <td>${task.developer}</td>
            <td>${task.status}</td>
            <td>${task.done}</td>
            <td><input type="button" value="Done"
                       onclick="window.location.href = 'makeDone'"/>
                <input type="button" value="Update"
                       onclick="window.location.href = 'makeDone'"/></td>
        </tr>
    </c:forEach>

</table>
<br>
<input type="button" value="Add"
onclick="window.location.href = 'addNewTask'"/>
</body>
</html>
