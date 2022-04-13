<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
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
    Developer <form:input path="employeeByDeveloperId.id"/>
    <br><br>
    Status <form:radiobuttons path="status.id" items="${task.statusList}"/>
<%--    <font color="red"><form:errors path="status"/></font>--%>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
