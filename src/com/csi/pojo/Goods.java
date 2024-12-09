package com.csi.pojo;

public class Goods {
    private Integer gid;
    private String gname;
    private String pic;
    private Double price;
    private GoodsType tid;
    private String details;
    private Integer state;
    private String createDate;
    public Goods() {
    }

    public Goods(Integer gid, String gname, String pic, Double price,
                 GoodsType tid, String details, Integer state,String createDate) {
        this.gid = gid;
        this.gname = gname;
        this.pic = pic;
        this.price = price;
        this.tid = tid;
        this.details = details;
        this.state = state;
        this.createDate=createDate;
    }

    public Goods(int gid) {
        this.gid=gid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public GoodsType getTid() {
        return tid;
    }

    public void setTid(GoodsType tid) {
        this.tid = tid;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
