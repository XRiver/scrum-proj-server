package com.nju.scrum.controller;

import com.nju.scrum.pojo.Attraction;
import com.nju.scrum.pojo.Plan;
import com.nju.scrum.pojo.User;
import com.nju.scrum.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@ResponseBody
@Controller
@RequestMapping("/api/")
public class PlanController {
    @Autowired
    private PlanService planService;
    @PostMapping("/createPlan")
    public String createPlan(Plan plan) {
        //模拟试验通过
//        plan=new Plan();
//        plan.setAname("雨花台");
//        plan.setCreatorname("Jack");
//        plan.setDetail("nice!!!");
//        plan.setTraveltime(new Date());
        String number=planService.createPlan(plan);
        return number;
    }
    @GetMapping("/plans")
    public List<Plan> attractions(String type, String aName,String uName) {
        List<Plan> list=new ArrayList<>();
        //模拟试验通过
//        type="aName";
        if(type.equals("aName")) {
//            aName="nju";
            list=planService.selectByAttraction(aName);
        }else{
//            uName="jack";
            list = planService.selectByCreator(uName);
        }
        return list;
    }
    @PostMapping("/joinPlan")
    public String joinPlan(User user,Plan plan,String mess) {
        //模拟试验通过
        String number=planService.joinPlan(user,plan,mess);
        return number;
    }
}
