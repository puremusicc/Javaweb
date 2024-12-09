package com.csi.dao;

import com.csi.pojo.Cart;

import java.util.List;

public interface CartDao {
    int insert(Cart c);
    int delete(int cid);
    int updateNum(int cid,int num);
    List<Cart> selectByUid(int uid);
    Cart selectById(int id);
}
