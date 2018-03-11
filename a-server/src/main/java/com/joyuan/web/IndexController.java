package com.joyuan.web;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/index1")
    public String index1(){
        return "index1";
    }

    @HystrixCommand(fallbackMethod = "error")
    @RequestMapping("/index2")
    public String index2(){
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "index2";
    }

    private String error(){
        return "error";
    }
}
