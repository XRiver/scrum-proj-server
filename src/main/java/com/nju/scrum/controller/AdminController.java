package com.nju.scrum.controller;

import com.nju.scrum.pojo.User;
import com.nju.scrum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;

    @GetMapping("/unCredit.html")
    public String unCredit(Model model) {
        long timeStamp = new Date().getTime();
        List<User> userList = userService.selectUncreditUser(timeStamp);
        model.addAttribute("userList", userList);
        return "unCredit";
    }

    @GetMapping("/api/lock")
    public String lockYear(@RequestParam("openid") String openid,@RequestParam("length") String length) {
        Calendar now = Calendar.getInstance();
        if (length.equals("month")) {
            now.add(Calendar.MONTH, 1);
        } else if (length.equals("year")) {
            now.add(Calendar.YEAR, 1);
        }
        long unlockTime = now.getTime().getTime()  ;
        //更新封禁时间
        userService.updateUnlockTime(unlockTime,openid);
        return "redirect:/unCredit.html";
    }
}
