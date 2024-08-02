package com.kitri.myspringboard2.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

public class ServerController {
    @Value("${server.id}")
    private String serverId;

    @GetMapping("/server-id")
    public String getServerId() {
        return "This is " + serverId;
    }
}
