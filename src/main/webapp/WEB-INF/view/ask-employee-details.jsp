<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New employee</title>
</head>
<body>

<h2>Add new Employee</h2>
<br>
<form:form action="saveEmployee" modelAttribute="employee">
    Name <form:input path="name"/>
    <br><br>
    Surname <form:input path="surname"/>
    <br><br>
    Username <form:input path="username"/>
    <br><br>
    <input type="submit" value="OK">
</form:form>
</body>
</html>
