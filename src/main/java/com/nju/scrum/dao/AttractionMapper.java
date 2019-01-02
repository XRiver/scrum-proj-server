package com.nju.scrum.dao;

import com.nju.scrum.bean.Attraction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AttractionMapper {
    @Select("select * from attraction")
    public List<Attraction> selectAll();

}
