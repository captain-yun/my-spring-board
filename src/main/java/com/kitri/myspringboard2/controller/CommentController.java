package com.kitri.myspringboard2.controller;

import com.kitri.myspringboard2.domain.Comment;
import com.kitri.myspringboard2.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    public String addComment(Comment comment) {
        commentService.addComment(comment);

        return "redirect:/board/" + comment.getBoardId();
    }

    @PostMapping("/{id}/edit")
    public String updateComment(Comment comment) {
        commentService.updateComment(comment);

        return "redirect:/board/" + comment.getBoardId();
    }

    @PostMapping("/{id}/delete")
    public String deleteComment(@PathVariable long id, @RequestParam long boardId) {
        commentService.deleteComment(id);

        return "redirect:/board/" + boardId;
    }
}
