package com.csi.dao;

import com.csi.pojo.Admin;

import java.util.List;

public interface AdminDao {
    Admin selectByAnameAndPwd(String aname, String pwd);
    int insert(Admin admin);
    int delete(int aid);
    int update(Admin admin);
    Admin selectByAid(int aid);
    List<Admin> selectAll();
}
