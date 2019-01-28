package com.young.hello.spring.cloud.web.admin.feign.service;

import com.young.hello.spring.cloud.web.admin.feign.service.Hystrix.AdminServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName : AdminService
 * Description :通过 @FeignClient("服务名") 注解来指定调用哪个服务
 * Author : young
 * Date: 2019/1/25 17:43
 **/
@FeignClient(value = "hello-spring-cloud-service-admin", fallback = AdminServiceHystrix.class)
public interface AdminService {
    @RequestMapping(value = "hi", method = RequestMethod.GET)
    public String sayHi(@RequestParam(value = "message") String message);
}
