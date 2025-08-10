<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>User Registration Form</h2>
    
    <form action="submitUser" method="post">
        <label>Username:</label>
        <input type="text" name="username" required><br><br>
        
        <label>Email:</label>
        <input type="email" name="userEmail" required><br><br>
        
        <label>Phone:</label>
        <input type="text" name="userPhone" required><br><br>
        
        <input type="submit" value="Register">
    </form>
</body>
</html>
