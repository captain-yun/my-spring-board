<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h2>Login Page</h2>
<form method="post" action="${pageContext.request.contextPath}/login">
    <div>
        <label>Username:</label>
        <input type="text" name="username"/>
    </div>
    <div>
        <label>Password:</label>
        <input type="password" name="password"/>
    </div>
    <div>
        <input type="submit" value="Login"/>
    </div>
</form>
<c:if test="${not empty param.error}">
    <p style="color:red;">Invalid username or password.</p>
</c:if>
</body>
</html>
