package com.kitri.myspringboard2.controller;

import com.kitri.myspringboard2.domain.User;
import com.kitri.myspringboard2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    public UserService userService;

    @GetMapping("/signup")
    public String signup() {
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signup(User user) {
        userService.signup(user);
        return "redirect:/login";
    }

}
