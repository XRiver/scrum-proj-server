package com.nju.scrum.service;

import com.nju.scrum.pojo.Plan;
import com.nju.scrum.pojo.User;

import java.util.List;

public interface PlanService {

    List<Plan> selectByAttraction(String aName);
    List<Plan> selectByCreatorName(String name);
    List<Plan> selectByCreatorOpenid(String openid);
    String createPlan(Plan plan);

    String applyPlan(String openid, Integer pid, String mess);
}
