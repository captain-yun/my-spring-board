package com.kitri.myspringboard2.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Comment {
    private long id;
    private String content;
    private String username;
    private long boardId;
    private LocalDateTime createdAt;

    public static Comment createComment(String content, String username, long boardId) {
        Comment comment = new Comment();
        comment.setContent(content);
        comment.setUsername(username);
        comment.setBoardId(boardId);
        return comment;
    }
}
