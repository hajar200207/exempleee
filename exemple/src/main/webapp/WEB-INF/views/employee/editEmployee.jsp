<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Employee</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h1>Edit Employee</h1>
    <form action="${pageContext.request.contextPath}/employees/edit" method="post">
        <input type="hidden" name="id" value="${employee.id}">
        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" value="${employee.name}" required><br>

        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" value="${employee.email}" required><br>

        <label for="phone">Phone:</label><br>
        <input type="text" id="phone" name="phone" value="${employee.phone}" required><br>

        <label for="department">Department:</label><br>
        <input type="text" id="department" name="department" value="${employee.department}" required><br>

        <label for="position">Position:</label><br>
        <input type="text" id="position" name="position" value="${employee.position}" required><br>

        <input type="submit" value="Save Changes">
    </form>
</body>
</html>
