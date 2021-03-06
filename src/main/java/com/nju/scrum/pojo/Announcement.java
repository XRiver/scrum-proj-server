package com.nju.scrum.pojo;

import java.util.Date;

//Plan的公告实体类，包括上传图片、文字评价、公开与否
public class Announcement {
    private Integer announcementId;
    private Integer pid;
    private Date createDate;
    private String openid;
    private String picUrls;//url之间按逗号，分隔
    private String content;//公告的内容
    private Integer open;//表示公告是否愿意公开 1表示愿意 0表示不愿意公开


    public Integer getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.announcementId = announcementId;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getOpen() {
        return open;
    }

    public void setOpen(Integer open) {
        this.open = open;
    }


    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId='" + announcementId + '\'' +
                ", pid='" + pid + '\'' +
                ", createDate=" + createDate +
                ", openid='" + openid + '\'' +
                ", picUrls='" + picUrls + '\'' +
                ", content='" + content + '\'' +
                ", open=" + open +
                '}';
    }
}
