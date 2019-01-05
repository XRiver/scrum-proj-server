package com.nju.scrum.service.impl;

import com.nju.scrum.mapper.PlanMapper;
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

    @Override
    public List<Plan> selectByAttraction(String aName) {
        List<Plan> list=planMapper.selectByAttraction(aName);
        return list;
    }

    @Override
    public List<Plan> selectByCreator(String uName) {
        List<Plan> list=planMapper.selectByCreator(uName);
        return list;
    }

    @Override
    public String createPlan(Plan plan) {
        if (plan.getCreatorname()==null){
            return "0";
        }else {
            planMapper.insert(plan);
            return "1";
        }
    }

    @Override
    public String joinPlan(String openid, Integer pid, String mess) {
        if (openid==null||pid==null){
            return "0";
        }else {
            Plan chosenPlan=planMapper.selectByPid(pid);
            String string=chosenPlan.getApplylist();
            StringBuffer stringBuffer=new StringBuffer();
            if(string!=null){
                stringBuffer.append(string);
            }
            stringBuffer.append(openid).append(",");
            chosenPlan.setApplylist(stringBuffer.toString());
            planMapper.updateByPrimaryKey(chosenPlan);
            return "1";
        }
    }
}
