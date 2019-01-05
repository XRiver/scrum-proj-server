package com.nju.scrum.pojo;
public class User {
    private Integer uid;
    private String openid;
    private String uname;
    private String school;
    private String pictureurl;
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
}