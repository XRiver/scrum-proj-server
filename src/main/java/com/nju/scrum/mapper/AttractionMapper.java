package com.nju.scrum.mapper;

import com.nju.scrum.pojo.Attraction;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

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


    @Insert("insert into attraction(aName,location,pictureUrl,description) values(#{aname},#{location},#{pictureurl},#{description})")
    void addAttraction(Attraction attraction);

    @Select("select * from attraction where aname = #{aname}")
    List<Attraction> selectByAname(String aname);

    @Update("update attraction set aName=#{aname},location=#{location},pictureUrl=#{pictureurl},description=#{description} where aId=#{aid}")
    void updateByPrimaryKey(Integer aid, String aname, String location, String pictureurl, String description);
}
