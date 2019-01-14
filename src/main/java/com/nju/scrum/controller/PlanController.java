package com.nju.scrum.controller;
import com.nju.scrum.pojo.*;
import com.nju.scrum.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@ResponseBody
@Controller
@RequestMapping("/api/")
public class PlanController {
    @Autowired
    private PlanService planService;
    @PostMapping("/plan")
    //创建新计划
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

    @GetMapping("/plan/pid/{pid}")
    //根据openid查询计划
    public Plan2 getMembersByPid(@PathVariable("pid") Integer pid) {
        List<User> userList=planService.selectMembersByPid(pid);
        Plan plan=planService.selectByPid(pid);
        Plan2 plan2=new Plan2();
        plan2.setPid(plan.getPid());
        plan2.setAname(plan.getAname());
        plan2.setUname(plan.getUname());
        plan2.setDetail(plan.getDetail());
        plan2.setState(plan.getState());
        plan2.setTraveltime(plan.getTraveltime());
        plan2.setUserList(userList);
        return plan2;
    }

    @GetMapping("/plan/openid/{openid}")
    //根据openid查询计划
    public List<Plan> getPlansByopenid(@PathVariable("openid") String openid,String state) {
        try {

            return planService.selectByCreatorOpenid(openid, state);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/plan/uname/{uname}")
    //根据创建者姓名查询计划
    public List<Plan> getPlansByUname(@PathVariable("uname") String uname,String state){
        try {
            return planService.selectByCreatorName(uname, state);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/plan/attraction/{aname}")
    //根据景点名字查询计划
    public List<Plan> getPlansByAname(@PathVariable("aname") String aname,String state){
        try {

            return planService.selectByAttraction(aname, state);
        } catch (Exception e) {
            return null;
        }
    }

    @PostMapping("/plan/apply")
    //申请加入某计划
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

    @PutMapping("/plan/state")
    //修改某计划的状态
    public  R confirmApply(@RequestBody Map<String,Object> params) {
        R r=new R();
        int pid = (Integer) params.get("pid");
        String state = (String) params.get("state");
        String number=planService.changeState(pid,state);
        Plan plan=planService.selectByPid(pid);
        r.setCode(Integer.parseInt(number));
        if(number.equals("0")){
            r.setMsg("修改成功");
            r.setData(plan);
        } else if (number.equals("1")){
            r.setMsg("本来就是这个状态，不用修改");
            r.setData(plan);
        }else {
            r.setMsg("修改失败");
            r.setData(plan);
        }
        return r;
    }

    @PostMapping("/plan/evaluation")
    public R evaluatePeople(@RequestBody Evaluation evaluation) {
        R r = new R();
        try {
            planService.evaluatePeople(evaluation);
            r.setMsg("评价成功");
            r.setCode(0);

        } catch (Exception e) {
            r.setMsg("评价失败");
            r.setCode(1);
            return r;
        }
        return r;

    }

}