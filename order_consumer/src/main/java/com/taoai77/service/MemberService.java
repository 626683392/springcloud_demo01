package com.taoai77.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.taoai77.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//指定服务的名称
@FeignClient(name = "member-server",configuration = FeignConfig.class,fallback = MemberService.MemberError.class)
public interface MemberService {

    @RequestMapping("/getAllMember")
    List<String> getAllOrder();

    @RequestMapping("/getOtherAllMember")
    List<String> getOtherAllMember();

    @Component
    class MemberError implements MemberService {
        @Override
        public List<String> getAllOrder() {
            List<String> listUser = new ArrayList<String>();
            listUser.add("服务器忙,请稍后重试...");
            return listUser;
        }

        @Override
        public List<String> getOtherAllMember() {
            return getAllOrder();
        }
    }

}
