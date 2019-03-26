package com.nju.scrum.pojo;
public class User {
    private Integer uid;
    private String openid;
    private String uname;
    private String school;
    private String pictureurl;
    private String sex;
    private String nickname;
    private String city;
    private Integer credit;//表示没有参与活动的次数 初始为0
    private Long unlockTime;//解封时间 初始化为0 即时间戳的初始时间1970年1月1日
    public Integer getUid() {
        return uid;
    }
    public void setUid(Integer uid) {
        this.uid = uid;
    }
    public String getOpenid() {
        return openid;
    }
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }
    public String getUname() {
        return uname;
    }
    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }
    public String getSchool() {
        return school;
    }
    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }
    public String getPictureurl() {
        return pictureurl;
    }
    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl;
    }
    public String getSex() {
        return sex;
    }
    public void setSex(String sex) {
        this.sex = sex;
    }
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Long getUnlockTime() {
        return unlockTime;
    }

    public void setUnlockTime(Long unlockTime) {
        this.unlockTime = unlockTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", openid='" + openid + '\'' +
                ", uname='" + uname + '\'' +
                ", school='" + school + '\'' +
                ", pictureurl='" + pictureurl + '\'' +
                ", sex='" + sex + '\'' +
                ", nickname='" + nickname + '\'' +
                ", city='" + city + '\'' +
                ", credit=" + credit +
                ", unlockTime=" + unlockTime +
                '}';
    }
}