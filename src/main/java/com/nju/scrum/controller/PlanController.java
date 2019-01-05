package com.nju.scrum.controller;
import com.nju.scrum.pojo.Attraction;
import com.nju.scrum.pojo.Plan;
import com.nju.scrum.pojo.R;
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
    public R createPlan(Plan plan) {
        //模拟试验通过
//        plan=new Plan();
//        plan.setAname("雨花台");
//        plan.setCreatorname("Jack");
//        plan.setDetail("nice!!!");
//        plan.setTraveltime(new Date());
        String number=planService.createPlan(plan);
        R r=new R();
        r.setCode(number);
        if(number.equals("1")){
            r.setMsg("创建成功");
            r.setData(plan);
        }else {
            r.setMsg("创建失败");
        }
        return r;
    }
    @GetMapping("/plans")
    public List<Plan> attractions(String type, String aname,String uname) {
        List<Plan> list=new ArrayList<>();
        //模拟试验通过
//        type="aName";
        if(type.equals("aname")) {
//            aName="nju";
            list=planService.selectByAttraction(aname);
        }else{
//            uName="jack";
            list = planService.selectByCreator(uname);
        }
        return list;
    }
    @PostMapping("/joinPlan")
    public R joinPlan(String openid,Integer pid,String mess) {
        //模拟试验通过
        String number=planService.joinPlan(openid,pid,mess);
        R r=new R();
        r.setCode(number);
        if(number.equals("1")){
            r.setMsg("申请成功");
        }else {
            r.setMsg("申请失败");
        }
        return r;
    }
}