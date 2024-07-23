package com.kitri.myspringboard2.domain;


import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class Board {
    private long id;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private String userId;
    private List<Comment> comments;

    public static Board createBoard(String title, String content, String username) {
        Board board = new Board();
        board.setTitle(title);
        board.setContent(content);
        board.setUsername(username);
        return board;
    }
}

