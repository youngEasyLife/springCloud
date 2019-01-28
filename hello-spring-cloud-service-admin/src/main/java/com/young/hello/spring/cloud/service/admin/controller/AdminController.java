package com.young.hello.spring.cloud.service.admin.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : AdminController
 * Description :服务的注册与发现
 * Author : young
 * Date: 2019/1/24 15:23
 **/
@RestController
public class AdminController {

    @Value("${server.port}")
    private String port;


    @GetMapping("/hi")
    public String Hi(String message) {
        return String.format("your message is %s ,port is %s", message, port);
    }


    @GetMapping("/goodMorning")
    public String goodMorning(String message) {
        return String.format("your message is %s ,port is %s ,and goodMorning", message, port);
    }
}


