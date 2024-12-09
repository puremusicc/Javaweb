package com.csi.dao;

import com.csi.pojo.Users;

import java.util.List;

public interface UsersDao {
    int insert(Users users);
    Users selectByLoginNameAndPwd(String loginName,String pwd);
    int update(Users users);
    Users selectById(int userId);
    List<Users> selectAll();
    List<Users> selectByLoginName(String loginName);
}
