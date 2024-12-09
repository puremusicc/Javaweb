package com.csi.biz;

import com.csi.pojo.Orders;

import java.util.List;

public interface OrderBiz {
    boolean createOrder(Orders order);
    boolean removeOrder(String oid);
    boolean modifyOrder(Orders order);
    Orders findByOid(String oid);
    List<Orders> findAll();
    List<Orders> findByUid(int uid);
    List<Orders> search(String oid,int state);
    List<Orders> findByUidAndState(int uid,int state);
}
