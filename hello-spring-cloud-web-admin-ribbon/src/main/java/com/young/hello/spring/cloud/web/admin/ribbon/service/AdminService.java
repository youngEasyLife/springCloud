package com.young.hello.spring.cloud.web.admin.ribbon.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * ClassName : AdminService
 * Description :在这里我们直接用的程序名替代了具体的 URL 地址，
 *              在 Ribbon 中它会根据服务名来选择具体的服务实例，
 *              根据服务实例在请求的时候会用具体的 URL 替换掉服务名，代码如下：
 * Author : young
 * Date: 2019/1/24 17:24
 **/
@Service
public class AdminService {

    @Autowired
    private RestTemplate restTemplate;

    public String sayHi(String message) {
        return restTemplate.getForObject("http://HELLO-SPRING-CLOUD-SERVICE-ADMIN/hi?message=" + message, String.class);
    }
}