package com.csi.pojo;

public class Admin {
    private Integer aid;
    private String aname;
    private String pwd;
    private Integer level;
    private Integer state;

    public Admin() {
    }

    public Admin(Integer aid, String aname, String pwd, Integer level, Integer state) {
        this.aid = aid;
        this.aname = aname;
        this.pwd = pwd;
        this.level = level;
        this.state = state;
    }

    public Admin(int aid, String pwd, int state) {
        this.aid = aid;
        this.pwd = pwd;
        this.state = state;
    }

    public Admin(String aname, String pwd) {
        this.aname = aname;
        this.pwd = pwd;
        this.state = 1;
        this.level=1;
    }

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
        this.aname = aname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
