package com.nju.scrum.mapper;
import com.nju.scrum.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
@Mapper
public interface UserMapper {

    int deleteByPrimaryKey(Integer uid);

    @Insert("insert into user (openId, uName, school, pictureUrl, sex, nickName, city) values " +
            "(#{openid,jdbcType=VARCHAR}, #{uname,jdbcType=VARCHAR}, #{school,jdbcType=VARCHAR}, #{pictureurl,jdbcType=VARCHAR}" +
            ", #{sex,jdbcType=VARCHAR}, #{nickname,jdbcType=VARCHAR}, #{city,jdbcType=VARCHAR})")
    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    @Select("select * from user where openId=#{openid}")
    List<User> selectByOpenId(String openid);
}
