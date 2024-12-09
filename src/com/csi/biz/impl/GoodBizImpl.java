package com.csi.biz.impl;

import com.csi.biz.GoodsBiz;
import com.csi.dao.GoodsDao;
import com.csi.dao.impl.GoodsDaoImpl;
import com.csi.pojo.Goods;
import com.csi.utils.PageBean;

import java.util.List;

public class GoodBizImpl implements GoodsBiz {
    private GoodsDao gdao=new GoodsDaoImpl();
    @Override
    public boolean addGoods(Goods goods) {
        return gdao.insertGoods(goods)>0;
    }

    @Override
    public boolean removeGoods(int id) {
        Goods goods=gdao.selectById(id);
        goods.setState(0);
        return gdao.updateGoods(goods)>0;
    }

    @Override
    public boolean modifyGoods(Goods goods) {
        return gdao.updateGoods(goods)>0;
    }

    @Override
    public List<Goods> findAll() {
        return gdao.selectAll();
    }

    @Override
    public Goods findById(int id) {
        return gdao.selectById(id);
    }

    @Override
    public List<Goods> toIndex(int tid) {
        return gdao.selectTop8(tid);
    }

    @Override
    public PageBean<Goods> findByTid(int tid, PageBean<Goods> page) {
        return gdao.selectByTid(tid,page);
    }

    @Override
    public PageBean<Goods> findByGname(String gname, PageBean<Goods> page) {
        return gdao.selectByGname(gname,page);
    }


}
