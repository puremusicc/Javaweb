package com.csi.pojo;

public class Users {
    private Integer userId;
    private String loginName;
    private String password;
    private String nickName;
    private String sex;
    private String phone;
    private Integer state;

    public Users() {
    }

    public Users(Integer userId, String loginName, String password,
                 String nickName, String sex, String phone, Integer state) {
        this.userId = userId;
        this.loginName = loginName;
        this.password = password;
        this.nickName = nickName;
        this.sex = sex;
        this.phone = phone;
        this.state = state;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
