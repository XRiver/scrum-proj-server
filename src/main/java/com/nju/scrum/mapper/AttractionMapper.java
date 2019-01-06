package com.nju.scrum.mapper;

import com.nju.scrum.pojo.Attraction;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface AttractionMapper {

    int deleteByPrimaryKey(Integer aid);

    int insert(Attraction record);

    int insertSelective(Attraction record);

    @Select("select * from attraction")
    List<Attraction> selectAll();

    @Select("select * from attraction where aId = #{aid}")
    Attraction selectByPrimaryKey(Integer aid);

    int updateByPrimaryKeySelective(Attraction record);

    int updateByPrimaryKey(Attraction record);
}
