package com.nju.scrum.mapper;

import com.nju.scrum.pojo.Apply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface ApplyMapper {

    int deleteByPrimaryKey(Integer applyid);

    @Insert("insert into apply (openid, pid, mess) values " +
            "(#{openid,jdbcType=VARCHAR}, #{pid,jdbcType=INTEGER}, #{mess,jdbcType=VARCHAR})")
    int insert(Apply record);

    int insertSelective(Apply record);

    Apply selectByPrimaryKey(Integer applyid);

    int updateByPrimaryKeySelective(Apply record);

    int updateByPrimaryKey(Apply record);
}