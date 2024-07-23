package com.kitri.myspringboard2.service;

import com.kitri.myspringboard2.domain.Comment;
import com.kitri.myspringboard2.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService {

    @Autowired
    CommentMapper commentMapper;

    public List<Comment> findCommentsByBoardId(long boardId) {
        return commentMapper.findCommentsByBoardId(boardId);
    }

    public void addComment(Comment comment) {
        comment.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        commentMapper.insert(comment);
    }

    public void updateComment(Comment comment) {
        comment.setUsername(SecurityContextHolder.getContext().getAuthentication().getName());
        commentMapper.update(comment);
    }

    public void deleteComment(long commentId) {
        commentMapper.delete(commentId);
    }
}
