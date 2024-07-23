package com.kitri.myspringboard2.service;

import com.kitri.myspringboard2.domain.Board;
import com.kitri.myspringboard2.domain.Comment;
import com.kitri.myspringboard2.domain.User;
import com.kitri.myspringboard2.mapper.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    BoardMapper boardMapper;
    @Autowired
    private UserService userService;
    @Autowired
    private CommentService commentService;

    public List<Board> findAll() {
        return boardMapper.findAll();
    }

    public Board findById(long id) {
        Board board = boardMapper.findById(id);
        List<Comment> comments = commentService.findCommentsByBoardId(board.getId());
        board.setComments(comments);
        return board;
    }

    public void insert(Board board) {
        boardMapper.insert(board);
    }

    public void update(Board board) {
        boardMapper.update(board);
    }

    public void delete(long id) {
        boardMapper.delete(id);
    }
}
