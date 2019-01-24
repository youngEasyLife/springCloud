package com.young.hello.spring.cloud.web.admin.ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ClassName : WebAdminRibbonApplication
 * Description :通过 @EnableDiscoveryClient 注解注册到服务中心
 * Author : young
 * Date: 2019/1/24 17:12
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class WebAdminRibbonApplication {
    public static void main(String[] args) {
        SpringApplication.run(WebAdminRibbonApplication.class, args);
    }
}
