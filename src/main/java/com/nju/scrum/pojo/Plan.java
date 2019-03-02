package com.nju.scrum.pojo;

import java.util.ArrayList;
import java.util.Date;

public class Plan {
    private Integer pid;
    private String openid;
    private String uname;
    private Integer aid;
    private String aname;
    private String traveltime;
    private String detail;
    private String applylist;
    private String state;
    private ArrayList<Announcement> announcementList;
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

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ArrayList<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public void setAnnouncementList(ArrayList<Announcement> announcementList) {
        this.announcementList = announcementList;
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
