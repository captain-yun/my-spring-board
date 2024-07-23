package com.kitri.myspringboard2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/admin")
    public String admin() {
        return "admin 페이지";
    }

    @GetMapping("/user")
    public String user() {
        return "user 페이지";
    }

    @GetMapping("/any")
    public String any() {
        return "any 페이지";
    }

}
