package com.csi.biz.impl;

import com.csi.biz.AdminBiz;
import com.csi.dao.AdminDao;
import com.csi.dao.impl.AdminDaoImpl;
import com.csi.pojo.Admin;

import java.util.List;

public class AdminBizImpl implements AdminBiz {
    private AdminDao adao=new AdminDaoImpl();
    @Override
    public Admin login(String aname, String pwd) {
        return adao.selectByAnameAndPwd(aname,pwd);
    }

    @Override
    public boolean add(Admin admin) {
        return adao.insert(admin)>0;
    }

    @Override
    public boolean remove(int aid) {
        return adao.delete(aid)>0;
    }

    @Override
    public boolean modify(Admin admin) {
        return adao.update(admin)>0;
    }

    @Override
    public Admin findByAid(int aid) {
        return adao.selectByAid(aid);
    }

    @Override
    public List<Admin> findAll() {
        return adao.selectAll();
    }
}
