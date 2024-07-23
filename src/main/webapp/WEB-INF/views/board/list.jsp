<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>게시판 리스트</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f9;
            margin: 0;
            padding: 20px;
        }
        .container {
            max-width: 800px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
        }
        h1, h2 {
            color: #333;
            border-bottom: 2px solid #ddd;
            padding-bottom: 10px;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 20px;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        th, td {
            padding: 10px;
            border: 1px solid #ddd;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        button, a.button-link {
            display: inline-block;
            background-color: #4CAF50;
            color: white;
            padding: 10px 15px;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            cursor: pointer;
        }
        button:hover, a.button-link:hover {
            background-color: #45a049;
        }
        form {
            display: inline;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>게시판 리스트</h1>
    <button><a href="/board/add" class="button-link">글쓰기</a></button>
    <hr>
    <table>
        <thead>
        <tr>
            <th>ID</th>
            <th>제목</th>
            <th>작성자</th>
            <th>관리</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="board" items="${boards}">
            <tr>
                <td>${board.id}</td>
                <td><a href="/board/${board.id}">${board.title}</a></td>
                <td>${board.username}</td>
                <td>
                    <a href="/board/${board.id}/edit" class="button-link">Edit</a>
                    <form action="/board/${board.id}/delete" method="post">
                        <button type="submit">Delete</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
