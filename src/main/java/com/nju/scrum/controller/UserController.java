package com.nju.scrum.controller;

import com.nju.scrum.pojo.User;
import com.nju.scrum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@ResponseBody
@Controller
@RequestMapping("/api/")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public Object login(String openid) {
        String number;
        //模拟试验通过
//        openid="111";
        number=userService.login(openid);
        if(number.equals("1")){
            User user=userService.selectUserByOpenId(openid);
            return user;
        }else if(number.equals("2")){
            return "2";
        }else {
            return "0";
        }
    }
    @PostMapping("/signon")
    public String signon(User user) {
        String number;
        //模拟试验通过
//        user=new User();
//        user.setOpenid("222");
//        user.setUname("lisi");
//        user.setSchool("pekingUniversity");
        number=userService.register(user);
        return number;
    }
}
