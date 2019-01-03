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
        return planMapper.selectByAttraction(aName);
    }

    @Override
    public List<Plan> selectByCreator(String uName) {
        return planMapper.selectByCreator(uName);
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
    public String joinPlan(User user, Plan plan, String mess) {
        if (user.getUid()==null||plan.getPid()==null){
            return "0";
        }else {
            String string=plan.getApplylist();
            StringBuffer stringBuffer=new StringBuffer(string);
            stringBuffer.append(user.getUid()).append(",");
            plan.setApplylist(stringBuffer.toString());
            planMapper.updateByPrimaryKey(plan);
            return "1";
        }
    }
}
