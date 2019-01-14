package com.nju.scrum.controller;
import com.nju.scrum.pojo.R;
import com.nju.scrum.service.ApplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {
    //返回的是尚未经过审批的申请者信息列表
    @RequestMapping("/login" )
    public String login() {
        System.out.println("ok");
        return "login";
    }
    @RequestMapping("/loginin")
    public String loginin(Map<String,Object> params) {
        System.out.println("login passed");
        return "addAttraction";
    }
    @PostMapping(value = "/attraction")
    public ModelAndView attraction(String name) {
        ModelAndView modelAndView=new ModelAndView("addAttraction");
        System.out.println(name);
//        String name=req.getParameter("name");
//        System.out.println(name);
//        String location=req.getParameter("location");
//        System.out.println(location);
//        String url=req.getParameter("url");
//        System.out.println(url);
//        String description=req.getParameter("description");
//        System.out.println(description);
        return modelAndView;
    }
}
