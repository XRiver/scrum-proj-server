package com.nju.scrum.pojo;

import java.util.Date;

//Plan的总结的实体类，包括上传图片、文字评价、对旅行景点的星级评价
public class Summary {
    private Integer summaryId;
    private Integer pid;
    private Date createDate;
    private String openid;
    private String picUrls;//url之间按逗号，分隔
    private String content;//总结体会的文字
    private Integer star;//星级评价，分为0-5，5星为最优评价

    public Integer getAnnouncementId() {
        return summaryId;
    }

    public void setAnnouncementId(Integer announcementId) {
        this.summaryId = announcementId;
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

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }

    @Override
    public String toString() {
        return "Announcement{" +
                "announcementId='" + summaryId + '\'' +
                ", pid='" + pid + '\'' +
                ", createDate=" + createDate +
                ", openid='" + openid + '\'' +
                ", picUrls='" + picUrls + '\'' +
                ", content='" + content + '\'' +
                ", open=" + star +
                '}';
    }
}
