package com.csi.dao;

import com.csi.pojo.Orders;

import java.util.List;

public interface OrderDao {
    int insertOrder(Orders order);
//    boolean removeOrder(String oid);
    int updateOrder(Orders order);
    Orders selectByOid(String oid);
    List<Orders> selectAll();
    List<Orders> selectByUid(int uid);
    List<Orders> select(String oid,int state);
    List<Orders> selectByUidAndState(int uid,int state);
}
