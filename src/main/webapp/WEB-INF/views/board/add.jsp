<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>

<h1>글쓰기</h1>
<form action="/board/add" method="post" style="display:inline;">
    <div>
        <label for="title">제목</label>
        <input type="text" name="title" id="title"></input>
    </div>
    <div>
        <label for="content">내용</label>
        <input type="text" name="content" id="content"></input>
    </div>
    <div>
        <label for="username">저자</label>
        <input type="text" name="username" id="username" value="${username}"></input>
    </div>
    <button type="submit">등록</button>
</form>
</body>
</html>