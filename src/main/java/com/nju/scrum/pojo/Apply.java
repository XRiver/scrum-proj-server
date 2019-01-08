package com.nju.scrum.pojo;

public class Apply {

    private Integer applyid;

    private String openid;

    private Integer pid;

    private String mess;

    //这是申请人的信息
    private User applicant;

    public Integer getApplyid() {
        return applyid;
    }

    public void setApplyid(Integer applyid) {
        this.applyid = applyid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid=pid;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess == null ? null : mess.trim();
    }

    public User getApplicant() {
        return applicant;
    }

    public void setApplicant(User applicant) {
        this.applicant = applicant;
    }

    @Override
    public String toString() {
        return "Apply{" +
                "applyid=" + applyid +
                ", openid='" + openid + '\'' +
                ", pid=" + pid +
                ", mess='" + mess + '\'' +
                ", applicant=" + applicant +
                '}';
    }
}