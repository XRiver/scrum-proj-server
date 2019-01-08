package com.nju.scrum.mapper;

import com.nju.scrum.pojo.Apply;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface ApplyMapper {

    @Insert("insert into apply (openid, pid, mess) values " +
            "(#{openid,jdbcType=VARCHAR}, #{pid,jdbcType=INTEGER}, #{mess,jdbcType=VARCHAR})")
    int insert(Apply record);

    //根据出行计划的pid查询所有相关的申请
    @Select({"select * from apply a join user u on a.openid = u.openid where a.pid = #{pid}"})
    @Results(id = "applyResult",value = {
            @Result(column = "applyid", property = "applyid"),
            @Result(column = "mess", property = "mess"),
            @Result(column = "uid",property = "applicant.uid"),
            @Result(column = "openid",property = "applicant.openid"),
            @Result(column = "openid",property = "openid"),
            @Result(column = "uName",property = "applicant.uname"),
            @Result(column = "school",property = "applicant.school"),
            @Result(column = "pictureUrl",property = "applicant.pictureurl"),
            @Result(column = "sex",property = "applicant.sex"),
            @Result(column = "nickName",property = "applicant.nickname"),
            @Result(column = "city",property = "applicant.city")
    })
    List<Apply> selectByPid(int pid);

    //通过或拒绝申请 0 拒绝 1 统一
    @Update("update apply set pass = #{pass} where applyid = #{applyid}")
    void confirmApply(@Param("applyid") int applyid, @Param("pass") int pass);
}