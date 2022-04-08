<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New task</title>
</head>
<body>

<h2>Add new task</h2>
<br>
<form:form action="saveTask" modelAttribute="task">
    Shortname <form:input path="shortName"/>
    <br><br>
    Developer <form:input path="developer"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
