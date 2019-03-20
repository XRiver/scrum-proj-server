package com.nju.scrum.controller;

import com.nju.scrum.pojo.Attraction;
import com.nju.scrum.pojo.User;
import com.nju.scrum.service.AttractionService;
import com.nju.scrum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private UserService userService;
    @Autowired
    private AttractionService attractionService;

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

    @GetMapping("/modifyAttraction")
    public String modifyAttraction(Model model) {
//        String name = "jiangbei";
//        model.addAttribute("name", name);
        List<Attraction> attractions = attractionService.selectAll();
        String htmlContent = "<p style='color:red'> 红色文字</p>";
        boolean testBoolean = true;
        model.addAttribute("htmlContent", htmlContent);
        model.addAttribute("testBoolean", testBoolean);
        model.addAttribute("a",attractions);
        return "modifyAttraction";
    }
    @PostMapping("/chosenAttraction")
    public String chosenAttraction(@RequestParam("attraction") String aname, Model model) {
        List<Attraction> attractions = attractionService.selectByAname(aname);
        Attraction attraction = attractions.get(0);
        model.addAttribute("p",attraction);
        return "chosenAttraction";
    }

    @PostMapping("/modify")
    public String modify(@ModelAttribute Attraction attraction,Model model) {
        attractionService.updateAttraction(attraction);
        List<Attraction> attractions = attractionService.selectAll();
        model.addAttribute("a",attractions);
        return "modifyAttraction";
    }
}