<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Employee</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h1>Add Employee</h1>
    
    <form action="${pageContext.request.contextPath}/employees/add" method="post">
        <label for="name">Name:</label>
        <input type="text" id="name" name="name">
        
        <label for="email">Email:</label>
        <input type="email" id="email" name="email">
        
        <label for="phone">Phone:</label>
        <input type="text" id="phone" name="phone">
        
        <label for="department">Department:</label>
        <input type="text" id="department" name="department">
        
        <label for="position">Position:</label>
        <input type="text" id="position" name="position">
        <input type="submit" value="Add Employee">
    </form>
    
</body>
</html>

