package com.csi.biz;

import com.csi.pojo.Users;

import java.util.List;

public interface UsersBiz {
    boolean register(Users users);
    Users login(String loginName,String pwd);
    Users findById(int userid);
    List<Users> findAll();
    boolean modify(Users users);
    List<Users> findByUname(String loginName);
}
