package com.nju.scrum.pojo;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User.uId
     *
     * @mbg.generated
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User.openId
     *
     * @mbg.generated
     */
    private String openid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User.uName
     *
     * @mbg.generated
     */
    private String uname;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column User.school
     *
     * @mbg.generated
     */
    private String school;
    private String pictureurl;
    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User.uId
     *
     * @return the value of User.uId
     *
     * @mbg.generated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User.uId
     *
     * @param uid the value for User.uId
     *
     * @mbg.generated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User.openId
     *
     * @return the value of User.openId
     *
     * @mbg.generated
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User.openId
     *
     * @param openid the value for User.openId
     *
     * @mbg.generated
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User.uName
     *
     * @return the value of User.uName
     *
     * @mbg.generated
     */
    public String getUname() {
        return uname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User.uName
     *
     * @param uname the value for User.uName
     *
     * @mbg.generated
     */
    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column User.school
     *
     * @return the value of User.school
     *
     * @mbg.generated
     */
    public String getSchool() {
        return school;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column User.school
     *
     * @param school the value for User.school
     *
     * @mbg.generated
     */
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getPictureurl() {
        return pictureurl;
    }

    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }
}