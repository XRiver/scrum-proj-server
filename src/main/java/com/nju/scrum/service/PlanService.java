package com.nju.scrum.service;

import com.nju.scrum.pojo.Plan;
import com.nju.scrum.pojo.User;

import java.util.List;

public interface PlanService {

    List<Plan> selectByAttraction(String aName);
    List<Plan> selectByCreator(String uName);
    String createPlan(Plan plan);

    String joinPlan(User user, Plan plan, String mess);
}
