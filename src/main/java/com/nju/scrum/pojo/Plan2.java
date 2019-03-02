package com.nju.scrum.pojo;

import java.util.ArrayList;
import java.util.List;

public class Plan2 {
    private Integer pid;
    private String uname;
    private String aname;
    private String traveltime;
    private String detail;
    private String state;
    private List<User> userList;
    private ArrayList<Announcement> announcementList;
    public Plan2() {
    }
    public Integer getPid() {
        return this.pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public ArrayList<Announcement> getAnnouncementList() {
        return announcementList;
    }

    public void setAnnouncementList(ArrayList<Announcement> announcementList) {
        this.announcementList = announcementList;
    }
}
