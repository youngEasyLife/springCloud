package com.young.hello.spring.cloud.web.admin.ribbon.controller;

import com.young.hello.spring.cloud.web.admin.ribbon.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName : AdminController
 * Description :TODO
 * Author : young
 * Date: 2019/1/24 17:24
 **/
@RestController
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping(value = "hi")
    public String sayHi(@RequestParam String message) {
        return adminService.sayHi(message);
    }


    @GetMapping(value = "goodMorning")
    public String goodMorning(@RequestParam String message) {
        return adminService.goodMorning(message);
    }
}
