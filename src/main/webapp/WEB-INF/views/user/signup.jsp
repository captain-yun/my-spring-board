<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>
<h1>회원가입</h1>
<form action="/signup" method="post" style="display:inline;">
    <div>
        <label for="username">유저명</label>
        <input type="text" name="username" id="username"></input>
    </div>
    <div>
        <label for="password">비밀번호</label>
        <input type="password" name="password" id="password"></input>
    </div>
    <div>
        <label for="password2">비밀번호 확인</label>
        <input type="password" name="password2" id="password2"></input>
    </div>
    <button type="submit">가입하기</button>
</form>
</body>
</html>