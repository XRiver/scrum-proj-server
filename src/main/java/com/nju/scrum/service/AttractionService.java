package com.nju.scrum.service;

import com.nju.scrum.pojo.Attraction;
import java.util.List;

public interface AttractionService {
    List<Attraction> selectAll();
    Attraction selectByPrimaryKey(Integer aid);

    void addAttraction(Attraction attraction);

    List<Attraction> selectByAname(String aname);

    void updateAttraction(Attraction attraction);
}
