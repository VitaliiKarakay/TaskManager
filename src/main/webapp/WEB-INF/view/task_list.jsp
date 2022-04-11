<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
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
        <th>Description</th>
        <th>Developer</th>
        <th>Status</th>
        <th>Done</th>
        <th>Operations</th>


    </tr>
    <c:forEach var="task" items="${allTasks}">

        <c:url var="doneButton" value="/makeDone">
            <c:param name="taskID" value="${task.id}"/>
        </c:url>

        <c:url var="updateButton" value="/updateTask">
            <c:param name="taskID" value="${task.id}"/>
        </c:url>

        <c:url var="getDoneButton" value="/getTasksByDoneStatus">
            <c:param name="doneId" value="1"/>
        </c:url>

        <c:url var="getNotDoneButton" value="/getTasksByDoneStatus">
            <c:param name="doneId" value="0"/>
        </c:url>

        <tr>
            <td>${task.id}</td>
            <td>${task.shortName}</td>
            <td>${task.developer}</td>
            <td><c:choose>
                <c:when test="${task.status == 1}">
                    <p>New</p>
                </c:when>
                <c:when test="${task.status == 2}">
                    <p>WIP</p>
                </c:when>
                <c:when test="${task.status == 3}">
                    <p>Testing</p>
                </c:when>
                <c:when test="${task.status == 4}">
                    <p>Done</p>
                </c:when>
            </c:choose>
            </td>

            <td><c:choose>
                <c:when test="${task.done == 0}">
                    <p>No</p>
                </c:when>
                <c:when test="${task.done == 1}">
                    <p>Yes</p>
                </c:when>
            </c:choose>
            </td>
            <td><input type="button" value="Done"
                       onclick="window.location.href = '${doneButton}'"/>
                <input type="button" value="Update"
                       onclick="window.location.href = '${updateButton}'"/></td>
        </tr>
    </c:forEach>

</table>
<br>
<input type="button" value="Add"
       onclick="window.location.href = 'addNewTask'"/><br>
<input type="button" value="All done"
       onclick="window.location.href = '${getDoneButton}'"/>
<input type="button" value="All not done"
       onclick="window.location.href = '${getNotDoneButton}'"/>
<input type="button" value="All tasks"
       onclick="window.location.href = ''"/>

</body>
</html>
