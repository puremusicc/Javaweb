package com.csi.biz.impl;

import com.csi.biz.OrderBiz;
import com.csi.dao.OrderDao;
import com.csi.dao.impl.OrderDaoImpl;
import com.csi.pojo.Orders;

import java.util.List;

public class OrderBizImpl implements OrderBiz {
    private OrderDao odao=new OrderDaoImpl();
    @Override
    public boolean createOrder(Orders order) {
        return odao.insertOrder(order)>0;
    }

    @Override
    public boolean removeOrder(String oid) {
        return false;
    }

    @Override
    public boolean modifyOrder(Orders order) {
        return odao.updateOrder(order)>0;
    }

    @Override
    public Orders findByOid(String oid) {
        return odao.selectByOid(oid);
    }

    @Override
    public List<Orders> findAll() {
        return odao.selectAll();
    }

    @Override
    public List<Orders> findByUid(int uid) {
        return odao.selectByUid(uid);
    }

    @Override
    public List<Orders> search(String oid, int state) {
        return odao.select(oid,state);
    }


    @Override
    public List<Orders> findByUidAndState(int uid, int state) {
        return odao.selectByUidAndState(uid,state);
    }
}
