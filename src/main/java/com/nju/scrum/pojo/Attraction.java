package com.nju.scrum.pojo;

public class Attraction {

    private Integer aid;

    private String aname;

    private String location;

    private String pictureurl;

    private String description;

    public Integer getAid() {
        return aid;
    }


    public void setAid(Integer aid) {
        this.aid = aid;
    }


    public String getAname() {
        return aname;
    }


    public void setAname(String aname) {
        this.aname = aname == null ? null : aname.trim();
    }


    public String getLocation() {
        return location;
    }


    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }


    public String getPictureurl() {
        return pictureurl;
    }


    public void setPictureurl(String pictureurl) {
        this.pictureurl = pictureurl == null ? null : pictureurl.trim();
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        return "Attraction{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", location='" + location + '\'' +
                ", pictureurl='" + pictureurl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}