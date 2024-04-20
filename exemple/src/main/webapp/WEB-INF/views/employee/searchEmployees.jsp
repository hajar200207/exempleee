<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Search Employees</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
    <h1>Search Employees</h1>
    
    <form action="${pageContext.request.contextPath}/employees/search" method="get">
        <label for="keyword">Search Keyword:</label>
        <input type="text" id="keyword" name="keyword" required>
        <input type="submit" value="Search">
    </form>
    
    <hr>
    
    <h2>Search Results:</h2>
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Department</th>
            <th>Position</th>
            <th>Action</th>
        </tr>
        <c:forEach var="employee" items="${searchResults}">
            <tr>
                <td>${employee.id}</td>
                <td>${employee.name}</td>
                <td>${employee.email}</td>
                <td>${employee.phone}</td>
                <td>${employee.department}</td>
                <td>${employee.position}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/employees/edit?id=${employee.id}">Edit</a>
                    <a href="${pageContext.request.contextPath}/employees/delete?id=${employee.id}" onclick="return confirm('Are you sure you want to delete this employee?')">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    
</body>
</html>
