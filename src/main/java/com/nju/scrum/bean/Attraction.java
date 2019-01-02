package com.nju.scrum.bean;

public class Attraction {
    private String aId;
    private String aName;
    private String location;
    private String pictureUrl;
    private String description;

    @Override
    public String toString() {
        return "Attraction{" +
                "aId='" + aId + '\'' +
                ", aName='" + aName + '\'' +
                ", location='" + location + '\'' +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public String getaId() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
