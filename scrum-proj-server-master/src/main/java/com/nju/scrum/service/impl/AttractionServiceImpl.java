package com.nju.scrum.service.impl;

import com.nju.scrum.pojo.Attraction;
import com.nju.scrum.service.AttractionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import com.nju.scrum.mapper.*;
@Service
public class AttractionServiceImpl implements AttractionService {
    @Autowired
    private AttractionMapper attractionMapper;
    @Override
    public List<Attraction> selectAll() {
        return attractionMapper.selectAll();
    }
    @Override
    public Attraction selectByPrimaryKey(Integer aid) {
        return attractionMapper.selectByPrimaryKey(aid);
    }
}
