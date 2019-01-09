package com.nju.scrum.mapper;
import com.nju.scrum.pojo.Plan;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;
@Mapper
public interface PlanMapper {

    int deleteByPrimaryKey(Integer pid);

    @Insert("insert into plan (openId, aId, travelTime, detail) " +
            "values ( #{openid,jdbcType=VARCHAR}, #{aid,jdbcType=INTEGER}, " +
            "#{traveltime,jdbcType=DATE}, #{detail,jdbcType=VARCHAR})")
    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Plan record);

    @Update("update plan set applyList = #{applylist,jdbcType=VARCHAR} where pId = #{pid,jdbcType=INTEGER}")
    int updateByPrimaryKey(Plan record);

    @Select("select * from plan,attraction where plan.aId=attraction.aId and aName=#{aName}")
    List<Plan> selectByAttraction(String aName);

    @Select("select * from plan,user where plan.openId=user.openId and user.uName=#{uName}")
    List<Plan> selectByCreatorName(String uName);

    @Select("select * from plan join user on plan.openId=user.openId and user.openId=#{openid}")
    List<Plan> selectByCreatorOpenId(String openid);

    @Select("select * from plan where pId=#{pid}")
    Plan selectByPid(Integer pid);
}
