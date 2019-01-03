package com.nju.scrum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
//ResponseBody注解写在类的上方，表示这个类的所有方法返回的数据直接写给浏览器，（如果是对象则转为json数据）
@ResponseBody
@Controller
//两者相叠加等价于restcontroller
public class HelloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello world a third time";
    }
}