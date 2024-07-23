<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>게시판 상세보기</title>
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
        .board-details, .comments, .comment-form {
            margin-bottom: 20px;
        }
        .board-details dt {
            font-weight: bold;
            margin-top: 10px;
        }
        .board-details dd {
            margin: 0;
            padding: 5px 0;
        }
        .comment-form textarea, .comment-form button, .comment-edit-form textarea, .comment-edit-form button {
            width: 100%;
            padding: 10px;
            margin-top: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }
        .comment-form button, .comment-edit-form button {
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
        }
        .comment-form button:hover, .comment-edit-form button:hover {
            background-color: #45a049;
        }
        .comment-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }
        .comment-item:last-child {
            border-bottom: none;
        }
        .comment-item dt {
            font-weight: bold;
            color: #555;
        }
        .comment-item dd {
            margin: 0;
        }
        .comment-item .date {
            font-size: 0.9em;
            color: #999;
        }
        .comment-actions {
            margin-top: 10px;
        }
        .comment-actions button {
            background-color: #d9534f;
            color: white;
            border: none;
            cursor: pointer;
            padding: 5px 10px;
            border-radius: 4px;
            margin-right: 5px;
        }
        .comment-actions button:hover {
            background-color: #c9302c;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>게시판 상세보기</h1>

    <!-- 게시글 내용 -->
    <div class="board-details">
        <div>
            <span><strong>아이디</strong></span>
            <span>${board.id}</span> /
            <span><strong>제목</strong></span>
            <span>${board.title}</span> /
            <span><strong>작성자</strong></span>
            <span>${board.username}</span>
        </div>
        <dt>내용</dt>
        <dd>${board.content}</dd>
    </div>

    <!-- 댓글 작성 폼 -->
    <div class="comment-form">
        <h2>댓글 작성</h2>
        <form action="/comment/add" method="post">
            <input type="hidden" name="boardId" value="${board.id}">
            <textarea name="content" id="content" rows="4" placeholder="댓글 내용을 입력하세요"></textarea>
            <button type="submit">댓글 달기</button>
        </form>
    </div>

    <!-- 기존 댓글 목록 -->
    <div class="comments">
        <h2>댓글 목록</h2>
        <c:forEach var="comment" items="${board.comments}">
            <div class="comment-item">
                <dl>
                    <dt>${comment.username} <span class="date">${comment.createdAt}</span></dt>
                    <dd>${comment.content}</dd>
                </dl>
                <div class="comment-actions">
                    <button onclick="toggleEditForm(${comment.id})">수정</button>
                    <form action="/comment/${comment.id}/delete" method="post" style="display:inline;">
                        <button type="submit">삭제</button>
                        <input type="hidden" value="${board.id}" name="boardId">
                    </form>
                </div>
                <div id="edit-form-${comment.id}" class="comment-edit-form" style="display:none;">
                    <form action="/comment/${comment.id}/edit" method="post">
                        <textarea name="content" rows="4">${comment.content}</textarea>
                        <button type="submit">수정 완료</button>
                        <input type="hidden" value="${board.id}" name="boardId">
                    </form>
                </div>
            </div>
        </c:forEach>
    </div>
</div>

<script>
    function toggleEditForm(commentId) {
        var form = document.getElementById('edit-form-' + commentId);
        if (form.style.display === 'none') {
            form.style.display = 'block';
        } else {
            form.style.display = 'none';
        }
    }
</script>
</body>
</html>
