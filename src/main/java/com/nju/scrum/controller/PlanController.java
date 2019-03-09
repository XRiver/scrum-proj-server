package com.nju.scrum.controller;
import com.nju.scrum.pojo.*;
import com.nju.scrum.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.xml.crypto.dsig.keyinfo.RetrievalMethod;
import java.util.*;

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
    //根据pid查询计划以及所有计划内的正式成员
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
        plan2.setAnnouncementList(plan.getAnnouncementList());
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
    //评价团队成员并进行星际评价
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

    @PostMapping("/plan/announcement")
    //活动发起人创建公告
    public R createAnnouncement(@RequestBody Announcement announcement) {
        //增加当前时间
        announcement.setCreateDate(new Date());
        R r = new R();
        try {
            planService.createAnnouncement(announcement);
            r.setCode(0);
            r.setMsg("上传公告成功");
        } catch (Exception e) {
            e.printStackTrace();
            r.setMsg("上传公告失败");
            r.setCode(1);
        }
        return r;
    }

    @PostMapping("/plan/summary")
    //活动发起人上传照片和文字总结
    public R createSummary(@RequestBody Summary summary) {
        //增加当前时间
        summary.setCreateDate(new Date());
        R r = new R();
        try {
            planService.createSummary(summary);
            r.setCode(0);
            r.setMsg("上传总结成功");
        } catch (Exception e) {
            e.printStackTrace();
            r.setMsg("上传总结失败");
            r.setCode(1);
        }
        return r;
    }

    @GetMapping("/plan/joined/openid/{openid}")
    //根据自己的openid搜索自己参加的出行计划
    public List<Plan> getJoinedPlansByOpenid(@PathVariable("openid") String openid,String state) {
        try {
            return planService.selectJoinedPlanByOpenid(openid, state);
        } catch (Exception e) {
            return null;
        }
    }

    @GetMapping("/plan/confirmed/{pid}")
    //根据pid查询某出行计划是否已经确认过参与者
    public R planConfirmedState(@PathVariable("pid") int pid) {
        R r = new R();
        //查询结果为 1 表示已经确认过了
        String state = planService.confirmState(pid);
        r.setCode(Integer.parseInt(state));
        if (state.equals("1")) {
            r.setMsg("已确认");
        } else {
            r.setMsg("未确认");
        }
        return r;

    }

    @PostMapping("/plan/confirmed/{pid}")
    public R planConfirmMembers(@PathVariable("pid") Integer pid, @RequestBody Map<String, Object> params) {
        String openid = (String)params.get("openid");
        ArrayList<String> members = (ArrayList<String>) params.get("members");
        R r = new R();
        if (planService.confirmState(pid).equals("1") || !planService.selectPlanState(pid).equals("1")) {
            //已经确认过了 或者 plan不处于正在进行状态
            r.setMsg("已确认过或活动不处于正在进行状态");
            r.setCode(1);
        } else {
            //查询该plan的所有成员(User对象形式)
            List<User> userMembers = planService.selectMembersByPid(pid);
            //转化为openid数组形式
            ArrayList<String> allMembers = new ArrayList<>();
            for (User u : userMembers) {
                allMembers.add(u.getOpenid());
            }
            //检查是否传入的members都是出行成员
            for (String id : members) {
                if (allMembers.contains(id)) {
                    allMembers.remove(id);
                }
            }
            //如果allMember还有剩余，表示没有参加
            for (String id : allMembers) {
                planService.downCredit(id);
            }
            //把Plan的confirmed字段设为1 表示已经确认过了
            planService.setConfirmedState(pid);
            r.setCode(0);
            r.setMsg("成功确认参与者");
        }
        return r;
    }

}