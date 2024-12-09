package com.csi.biz.impl;

import com.csi.biz.UsersBiz;
import com.csi.dao.UsersDao;
import com.csi.dao.impl.UsersDaoImpl;
import com.csi.pojo.Users;

import java.util.List;

public class UsersBizImpl implements UsersBiz {
    UsersDao udao=new UsersDaoImpl();
    @Override
    public boolean register(Users users) {
        return udao.insert(users)>0;
    }

    @Override
    public Users login(String loginName, String pwd) {
        return udao.selectByLoginNameAndPwd(loginName,pwd);
    }

    @Override
    public Users findById(int userid) {
        return udao.selectById(userid);
    }

    @Override
    public List<Users> findAll() {
        return udao.selectAll();
    }

    @Override
    public boolean modify(Users users) {
        return udao.update(users)>0;
    }

    @Override
    public List<Users> findByUname(String loginName) {
        return udao.selectByLoginName(loginName);
    }
}
