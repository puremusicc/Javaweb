package com.csi.biz.impl;

import com.csi.biz.CartBiz;
import com.csi.dao.CartDao;
import com.csi.dao.impl.CartDaoImpl;
import com.csi.pojo.Cart;

import java.util.List;

public class CartBizImpl implements CartBiz {
    private CartDao cdao=new CartDaoImpl();
    @Override
    public boolean addCart(Cart cart) {
        return cdao.insert(cart)>0;
    }

    @Override
    public boolean removeCart(int id) {
        return cdao.delete(id)>0;
    }

    @Override
    public boolean modifyNum(int cid, int num) {
        return cdao.updateNum(cid,num)>0;
    }

    @Override
    public List<Cart> findByUid(int uid) {
        return cdao.selectByUid(uid);
    }

    @Override
    public Cart findById(int id) {
        return cdao.selectById(id);
    }
}
