<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>

<h1>글수정</h1>
<form action="/board/update" method="post" style="display:inline;">
    <div>
        <input type="hidden" name="id" readonly value="${board.id}">
    </div>
    <div>
        <label for="title">제목</label>
        <input type="text" name="title" id="title" value="${board.title}"></input>
    </div>
    <div>
        <label for="content">내용</label>
        <input type="text" name="content" id="content" value="${board.content}"></input>
    </div>
    <div>
        <label for="username">저자</label>
        <input type="text" name="username" id="username" value="${board.writer}"></input>
    </div>
    <button type="submit">등록</button>
</form>
</body>
</html>