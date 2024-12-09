package com.csi.pojo;

public class GoodsType {
    private Integer tid;
    private String tname;
    private Integer state;

    public GoodsType() {
    }

    public GoodsType(Integer tid, String tname, Integer state) {
        this.tid = tid;
        this.tname = tname;
        this.state = state;
    }

    public GoodsType(String tname) {
        this.tname = tname;
        this.state = 1;
    }

    public GoodsType(int tid) {
        this.tid=tid;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
