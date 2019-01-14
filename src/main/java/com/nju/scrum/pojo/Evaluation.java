package com.nju.scrum.pojo;

//出行之后对同行人的评价
public class Evaluation {
    private Integer eid;
    private Integer pid;
    private String fromid;
    private String toid;
    private String mess;
    private Integer star;

    @Override
    public String toString() {
        return "Evaluation{" +
                "eid=" + eid +
                ", pid=" + pid +
                ", fromid='" + fromid + '\'' +
                ", toid='" + toid + '\'' +
                ", mess='" + mess + '\'' +
                '}';
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getFromid() {
        return fromid;
    }

    public void setFromid(String fromid) {
        this.fromid = fromid;
    }

    public String getToid() {
        return toid;
    }

    public void setToid(String toid) {
        this.toid = toid;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }

    public Integer getStar() {
        return star;
    }

    public void setStar(Integer star) {
        this.star = star;
    }
}
