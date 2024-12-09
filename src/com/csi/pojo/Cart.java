package com.csi.pojo;

public class Cart {
    private Integer cid;
    private Users user;
    private Goods goods;
    private Integer number;
    private Double subtotal;

    public Cart() {
    }

    public Cart(Integer cid, Users user, Goods goods, Integer number) {
        this.cid = cid;
        this.user = user;
        this.goods = goods;
        this.number = number;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getSubtotal() {
        return goods.getPrice()*number;
    }

//    public void setSubtotal(Double subtotal) {
//        this.subtotal = subtotal;
//    }
}
