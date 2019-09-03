package com.young.hello.spring.cloud.web.admin.feign.controller;

import com.young.hello.spring.cloud.web.admin.feign.service.AdminService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * ClassName : AdminController
 * Description :TODO
 * Author : young
 * Date: 2019/1/25 17:46
 **/
@RestController
public class AdminController {

    @Resource
    private AdminService adminService;

    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam String message) {
        return adminService.sayHi(message);
    }
}
