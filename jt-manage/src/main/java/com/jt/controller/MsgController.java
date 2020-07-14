package com.jt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {
    @Value("${server.port}")
    private int port;

    @RequestMapping("/getPort")
    public int getPort() {
       return port;
    }
}
