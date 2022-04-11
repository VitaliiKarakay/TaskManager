<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Updating task</title>
</head>
<body>

<h2>Updating existing task</h2>
<form:form action="saveTask" modelAttribute="task">
    <form:hidden path="id"/>
    Description <form:input path="shortName"/>
    <br><br>
    Developer <form:input path="developer"/>
    <br><br>
    Status <form:input path="status"/>
    <font color="red"><form:errors path="status"/></font>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
