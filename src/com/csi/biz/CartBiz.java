package com.csi.biz;

import com.csi.pojo.Cart;

import java.util.List;

public interface CartBiz {
    boolean addCart(Cart cart);
    boolean removeCart(int id);
    boolean modifyNum(int cid,int num);
    List<Cart> findByUid(int uid);
    Cart findById(int id);
}
