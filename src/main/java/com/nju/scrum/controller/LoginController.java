package com.nju.scrum.controller;
import com.nju.scrum.pojo.R;
import com.nju.scrum.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
@Controller
public class LoginController {
    //返回的是尚未经过审批的申请者信息列表
    @RequestMapping(value = "/login",method =RequestMethod.GET )
    public String login() {
        System.out.println("ok");
        return "login";
    }
    @RequestMapping("/loginin")
    public String loginin(String loginname,String passwd,String rand) {
        System.out.println("login passed");
        return "addAttraction";
    }
    @RequestMapping("/addAttraction")
    public String addAttraction(String loginname,String passwd,String rand) {
        System.out.println("add in db");
        return "addAttraction";
    }
}
