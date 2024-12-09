package com.csi.biz;

import com.csi.pojo.Admin;

import java.util.List;

public interface AdminBiz {
    Admin login(String aname,String pwd);
    boolean add(Admin admin);
    boolean remove(int aid);
    boolean modify(Admin admin);
    Admin findByAid(int aid);
    List<Admin> findAll();
}
