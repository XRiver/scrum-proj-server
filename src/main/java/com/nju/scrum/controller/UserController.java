package com.nju.scrum.controller;

import com.nju.scrum.pojo.R;
import com.nju.scrum.pojo.User;
import com.nju.scrum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@Controller
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @GetMapping("/login/{openid}")
    public R login(@PathVariable("openid") String openid) {
        String number;
        number=userService.login(openid);
        R r=new R();
        r.setCode(Integer.parseInt(number));
        if(number.equals("0")){
            User user=userService.selectUserByOpenId(openid);
            r.setMsg("登录成功");
            r.setData(user);
            return r;
        }else if(number.equals("2")){
            r.setMsg("无此用户,需要注册");
            return r;
        }else {
            r.setMsg("未传入openid");
            return r;
        }
    }
    @ResponseBody
    @PostMapping("/register")
    public R register(@RequestBody User user) {
        String number;
        number=userService.register(user);
        R r=new R();
        r.setCode(Integer.parseInt(number));
        if(number.equals("0")){
            r.setMsg("注册成功");
            r.setData(user);
        }else if (number.equals("1")) {
            r.setMsg("没有传入openid");
        } else {
            r.setMsg("此openid已经存在");
        }
        return r;
    }


    @PostMapping(value = "/administrator/login")
    public String adLogin(String loginname,String password,String rand) {
        if (loginname.equals("admin") && password.equals("123456") && rand.equals("123456")) {
            return "redirect:/admin.html";
        } else {
            return "redirect:/error.html";
        }
    }
}
