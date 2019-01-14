package com.nju.scrum.service.impl;

import com.nju.scrum.mapper.ApplyMapper;
import com.nju.scrum.mapper.PlanMapper;
import com.nju.scrum.pojo.Apply;
import com.nju.scrum.pojo.Evaluation;
import com.nju.scrum.pojo.Plan;
import com.nju.scrum.pojo.User;
import com.nju.scrum.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Autowired
    private PlanMapper planMapper;
    @Autowired
    private ApplyMapper applyMapper;

    @Override
    public List<Plan> selectByAttraction(String aName, String state) {
        List<Plan> list=planMapper.selectByAttraction(aName);
        for (int j=0;j<list.size();j++){
            Plan plan=list.get(j);
            boolean flag=false;
            for (int i=0;i<state.length();i++) {
                char c=state.charAt(i);
                String s=String.valueOf(c);
                if (plan.getState().equals(s)){
                    flag=true;
                    break;
                }
            }
            if (flag==false){
                list.remove(plan);
                j--;
            }
        }
        return list;
    }

    @Override
    public List<Plan> selectByCreatorName(String name, String state) {
        List<Plan> list=planMapper.selectByCreatorName(name);
        for (int j=0;j<list.size();j++){
            Plan plan=list.get(j);
            boolean flag=false;
            for (int i=0;i<state.length();i++) {
                char c=state.charAt(i);
                String s=String.valueOf(c);
                if (plan.getState().equals(s)){
                    flag=true;
                    break;
                }
            }
            if (flag==false){
                list.remove(plan);
                j--;
            }
        }
        return list;
    }
    public List<Plan> selectByCreatorOpenid(String openid, String state) {
        List<Plan> list = planMapper.selectByCreatorOpenId(openid);
        for (int j=0;j<list.size();j++){
            Plan plan=list.get(j);
            boolean flag=false;
            for (int i=0;i<state.length();i++) {
                char c=state.charAt(i);
                String s=String.valueOf(c);
                if (plan.getState().equals(s)){
                    flag=true;
                    break;
                }
            }
            if (flag==false){
                list.remove(plan);
                j--;
            }
        }
        return list;
    }


    @Override
    public String createPlan(Plan plan) {
        if (plan.getOpenid()==null||plan.getAid()==null){
            return "1";
        }else {
            planMapper.insert(plan);
            return "0";
        }
    }

    @Override
    public String applyPlan(String openid, Integer pid, String mess) {
        if (openid==null||pid==null){
            return "1";
        }else {
            //获取这个出行计划的所有申请者opneid的applyList
            Plan chosenPlan=planMapper.selectByPid(pid);
            String string=chosenPlan.getApplylist();
            //判断此用户openid是否已经在这个plan的applyList中
            if (string!=null) {
                String[] openidList = string.trim().split(",");
                for (String s : openidList) {
                    if (s.equals(openid)) {
                        return "2";
                    }
                }
            }
            //将openid添加进pid所在Plan的applylist中
            StringBuffer stringBuffer=new StringBuffer();
            if(string!=null){
                stringBuffer.append(string);
            }
            stringBuffer.append(openid);
            stringBuffer.append(",");
            chosenPlan.setApplylist(stringBuffer.toString());
            planMapper.updateByPrimaryKey(chosenPlan);

            //在apply表中添加相关记录（openid pid mess）
            Apply apply=new Apply();
            apply.setOpenid(openid);
            apply.setPid(pid);
            apply.setMess(mess);
            applyMapper.insert(apply);
            return "0";
        }
    }

    @Override
    public String changeState(int pid, String state) {
        try {
            Plan plan=planMapper.selectByPid(pid);
            String pid1=plan.getState();
            System.out.println(pid1);
            planMapper.updateStateByPrimaryKey(pid,state);
            plan=planMapper.selectByPid(pid);
            String pid2=plan.getState();
            System.out.println(pid2);
            if (pid1.equals(pid2)){
                return "1";
            }else {
                return "0";
            }
        }catch (Exception e){
            e.getStackTrace();
            return "2";
        }
    }

    @Override
    public Plan selectByPid(int pid) {
        return planMapper.selectByPid(pid);
    }

    @Override
    public List<User> selectMembersByPid(Integer pid) {
        return planMapper.selectMembersByPid(pid);

    public void evaluatePeople(Evaluation evaluation) {
            planMapper.evaluatePeople(evaluation);
        }
}
