package com.nju.scrum.controller;
import com.nju.scrum.pojo.Attraction;
import com.nju.scrum.pojo.Plan;
import com.nju.scrum.pojo.R;
import com.nju.scrum.pojo.User;
import com.nju.scrum.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
@RequestMapping("/api/")
public class PlanController {
    @Autowired
    private PlanService planService;
    @PostMapping("/plan")
    public R createPlan(@RequestBody Plan plan) {
        String number=planService.createPlan(plan);
        R r=new R();
        r.setCode(Integer.parseInt(number));
        if(number.equals("0")){
            r.setMsg("创建成功");
            r.setData(plan);
        }else {
            r.setMsg("创建失败,未传入aid或openid");
        }
        return r;
    }

    @GetMapping("/plan/openid/{openid}")
    public List<Plan> getPlansByopenid(@PathVariable("openid") String openid) {
        return planService.selectByCreatorOpenid(openid);
    }

    @GetMapping("/plan/uname/{uname}")
    public List<Plan> getPlansByUname(@PathVariable("uname") String uname){
        return planService.selectByCreatorName(uname);
    }

    @GetMapping("/plan/attraction/{aname}")
    public List<Plan> getPlansByAname(@PathVariable("aname") String aname){
        return planService.selectByAttraction(aname);
    }

    @PostMapping("/plan/apply")
    public R applyPlan(@RequestBody Map<String,Object> params) {
        String openid=(String)params.get("openid");
        Integer pid=(Integer) params.get("pid");
        String mess=(String)params.get("mess");
        String number=planService.applyPlan(openid,pid,mess);
        R r=new R();
        r.setCode(Integer.parseInt(number));
        if(number.equals("0")){
            r.setMsg("申请成功");
        } else if (number.equals("1")){
            r.setMsg("申请失败,未传入openid或pid");
        }else {
            r.setMsg("该用户已申请过此出行计划");
        }
        return r;
    }
}