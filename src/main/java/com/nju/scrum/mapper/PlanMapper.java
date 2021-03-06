package com.nju.scrum.mapper;
import com.nju.scrum.pojo.*;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.ArrayList;
import java.util.List;
@Mapper
public interface PlanMapper {

    int deleteByPrimaryKey(Integer pid);

    @Insert("insert into plan (openId, aId, travelTime, detail,state,confirmed) " +
            "values ( #{openid,jdbcType=VARCHAR}, #{aid,jdbcType=INTEGER}, " +
            "#{traveltime,jdbcType=DATE}, #{detail,jdbcType=VARCHAR},0,0)")
    int insert(Plan record);

    int insertSelective(Plan record);

    Plan selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Plan record);

    @Update("update plan set applyList = #{applylist,jdbcType=VARCHAR} where pId = #{pid,jdbcType=INTEGER}")
    int updateByPrimaryKey(Plan record);

    @Select("select * from plan,attraction,user where plan.aId=attraction.aId and plan.openId = user.openId and aName=#{aName}")
    List<Plan> selectByAttraction(String aName);

    @Select("select * from plan,user,attraction where plan.openId=user.openId and attraction.aId = plan.aId and user.uName=#{uName}")
    List<Plan> selectByCreatorName(String uName);

    @Select("select * from plan,user,attraction where plan.openId=user.openId and attraction.aId = plan.aId and user.openId=#{openid}")
    List<Plan> selectByCreatorOpenId(String openid);

    @Select("select * from plan,user,attraction where plan.openId=user.openId and attraction.aId = plan.aId and pId=#{pid}")
//    @Select("select * from plan where pId=#{pid}")
    Plan selectByPid(Integer pid);

    @Update("update plan set state = #{state,jdbcType=VARCHAR} where pId = #{pid,jdbcType=INTEGER}")
    void updateStateByPrimaryKey(int pid, String state);

    @Select("select * from apply a,user u where a.openid=u.openId and a.pass=1 and a.pid= #{pid,jdbcType=INTEGER}")
    List<User> selectMembersByPid(Integer pid);

    @Insert("insert into evaluation(pid,fromid,toid,mess,star) values(#{pid},#{fromid},#{toid},#{mess},#{star})")
    void evaluatePeople(Evaluation evaluation);

    @Insert("insert into announcement(pid,openid,createDate,picUrls,content,open) values(#{pid},#{openid},#{createDate},#{picUrls},#{content},#{open})")
    void createAnnouncement(Announcement announcement);

    @Insert("insert into summary(pid,openid,createDate,picUrls,content,star) values(#{pid},#{openid},#{createDate},#{picUrls},#{content},#{star})")
    void createSummary(Summary summary);

    @Select("select * from announcement where pid=#{pid}")
    ArrayList<Announcement> selectAnnouncementsByPid(int pid);

    @Select("select * from summary where pid=#{pid}")
    ArrayList<Summary> selectSummarysByPid(int pid);

    @Select("select pid from apply where openid=#{openid} and pass = 1")
    ArrayList<Integer> selectJoinedPids(String openid);

    @Select("select confirmed from plan where pid = #{pid}")
    String confirmState(int pid);

    @Update("update user set credit = credit - 1 where openid = #{openid}")
    void downCredit(String openid);

    @Select("select state from plan where pid =#{pid}")
    String selectPlanState(Integer pid);

    @Update("update plan set confirmed = '1' where pid = #{pid}")
    void setConfirmedState(Integer pid);
}
