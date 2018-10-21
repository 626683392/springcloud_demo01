package com.taoai77.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.taoai77.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private MemberService memberService;

    @GetMapping("/getAllOrder")
    public List<String> getAllOrder(@RequestParam(value = "str")int str){
        return memberService.getAllOrder();
    }


    @RequestMapping("/getOtherAllMember")
    public List<String> getOtherAllMember(){
        return memberService.getOtherAllMember();
    }

}
