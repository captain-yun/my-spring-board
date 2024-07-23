package com.kitri.myspringboard2.controller;

import com.kitri.myspringboard2.domain.Board;
import com.kitri.myspringboard2.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        List<Board> boards = boardService.findAll();

        model.addAttribute("boards", boards);
        return "board/list";
    }

    @GetMapping("/{id}")
    public String boardDetail(Model model, @PathVariable long id) {
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/detail";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("username",
                SecurityContextHolder.getContext().getAuthentication().getName());
        return "board/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute Board board) {
        boardService.insert(board);
        return "redirect:/board/list";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable long id, Model model) {
        Board board = boardService.findById(id);
        model.addAttribute("board", board);
        return "board/edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute Board board) {
        boardService.update(board);
        return "redirect:/board/list";
    }

    @PostMapping("/{id}/delete")
    public String delete(Model model, @PathVariable long id) {
        boardService.delete(id);
        return "redirect:/board/list";
    }

}
