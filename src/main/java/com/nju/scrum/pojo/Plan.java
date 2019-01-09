package com.nju.scrum.pojo;

import java.util.Date;

public class Plan {
    private Integer pid;
    private String openid;
    private Integer aid;
    private String traveltime;
    private String detail;
    private String applylist;

    public Plan() {
    }

    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getTraveltime() {
        return traveltime;
    }

    public void setTraveltime(String traveltime) {
        this.traveltime = traveltime;
    }

    public String getDetail() {
        return this.detail;
    }

    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }

    public String getApplylist() {
        return this.applylist;
    }

    public void setApplylist(String applylist) {
        this.applylist = applylist == null ? null : applylist.trim();
    }

    @Override
    public String toString() {
        return "Plan{" +
                "pid=" + pid +
                ", openid='" + openid + '\'' +
                ", aid=" + aid +
                ", traveltime='" + traveltime + '\'' +
                ", detail='" + detail + '\'' +
                ", applylist='" + applylist + '\'' +
                '}';
    }
}
