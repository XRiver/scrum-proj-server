package com.how2java.mapper;

import com.how2java.pojo.Apply;
import com.how2java.pojo.ApplyExample;
import java.util.List;

public interface ApplyMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer applyid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply
     *
     * @mbg.generated
     */
    int insert(Apply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply
     *
     * @mbg.generated
     */
    int insertSelective(Apply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply
     *
     * @mbg.generated
     */
    List<Apply> selectByExample(ApplyExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply
     *
     * @mbg.generated
     */
    Apply selectByPrimaryKey(Integer applyid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(Apply record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table apply
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(Apply record);
}