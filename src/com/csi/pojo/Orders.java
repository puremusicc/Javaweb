package com.csi.pojo;

public class Orders {
    private String oid;
    private Users users;
    private Goods goods;
    private Double price;
    private Integer number;
    private String consigneeName;
    private String consigneeAddress;
    private String consigneePhone;
    private String createTime;
    private Double total;
    //0用户删除 1 未付款 2 已付款 3 已发货 4已完成
    private Integer state;

    public Orders() {
    }

    public Orders(String oid, Users users, Goods goods, Double price,
                  Integer number, String consigneeName, String consigneeAddress,
                  String consigneePhone, String createTime, Integer state) {
        this.oid = oid;
        this.users = users;
        this.goods = goods;
        this.price = price;
        this.number = number;
        this.consigneeName = consigneeName;
        this.consigneeAddress = consigneeAddress;
        this.consigneePhone = consigneePhone;
        this.createTime = createTime;
        this.state = state;
    }


    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeAddress() {
        return consigneeAddress;
    }

    public void setConsigneeAddress(String consigneeAddress) {
        this.consigneeAddress = consigneeAddress;
    }

    public String getConsigneePhone() {
        return consigneePhone;
    }

    public void setConsigneePhone(String consigneePhone) {
        this.consigneePhone = consigneePhone;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Double getTotal() {
        return price*number;
    }

//    public void setTotal(Double total) {
//        this.total = total;
//    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
