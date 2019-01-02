package com.nju.scrum.controller;

import com.nju.scrum.bean.Attraction;
import com.nju.scrum.dao.AttractionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {
    @Autowired
    AttractionMapper attractionMapper;
    @ResponseBody
    @RequestMapping("/hello")
    public String hello() {
        List<Attraction> list = attractionMapper.selectAll();
        return "hello world a third time";
    }

}
