package com.young.hello.spring.cloud.web.admin.feign.service.Hystrix;

import com.young.hello.spring.cloud.web.admin.feign.service.AdminService;
import org.springframework.stereotype.Component;

/**
 * ClassName : AdminServiceHystrix
 * Description :TODO
 * Author : young
 * Date: 2019/1/28 11:44
 **/
@Component
public class AdminServiceHystrix implements AdminService {

    @Override
    public String sayHi(String message) {
        return String.format("your message is %s ,but the feign request is bad", message);
    }
}
