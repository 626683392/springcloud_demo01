package com.taoai77.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class MemberController {
    @Value("${server.port}")
    private String port;

    @RequestMapping("/getAllMember")
    public List<String> getAllMember(){
        log.info("正在查询"+port+"端口号的接口...");
        return Arrays.asList("张三",
                "李四",
                "赵武",
                "server.port:"+port);
    }

    @RequestMapping("/getOtherAllMember")
    public List<String> getOtherAllMember(){
        log.info("正在延迟"+port+"端口号的接口...");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return Arrays.asList("张三",
                "李四",
                "赵武",
                "server.port:"+port);
    }

}
