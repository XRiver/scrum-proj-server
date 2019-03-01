package com.nju.scrum.service;

import com.nju.scrum.pojo.Announcement;
import com.nju.scrum.pojo.Evaluation;
import com.nju.scrum.pojo.Plan;
import com.nju.scrum.pojo.User;

import java.util.List;

public interface PlanService {

    List<Plan> selectByAttraction(String aName, String state);
    List<Plan> selectByCreatorName(String name, String state);
    List<Plan> selectByCreatorOpenid(String openid, String state);
    String createPlan(Plan plan);

    String applyPlan(String openid, Integer pid, String mess);

    String changeState(int pid, String state);

    Plan selectByPid(int pid);

    List<User> selectMembersByPid(Integer pid);

    void evaluatePeople(Evaluation evaluation);

    void createAnnouncement(Announcement announcement);

}
