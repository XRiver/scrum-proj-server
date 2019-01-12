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
    @RequestMapping("/login")
    public String selectByPid() {
        System.out.println("ok");
        return "login";
    }
}
