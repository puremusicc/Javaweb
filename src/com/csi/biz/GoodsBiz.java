package com.csi.biz;

import com.csi.pojo.Goods;
import com.csi.utils.PageBean;

import java.util.List;

public interface GoodsBiz {
    //添加
    boolean addGoods(Goods goods);
    //删除商品
    boolean removeGoods(int id);
    //修改商品
    boolean modifyGoods(Goods goods);
    //查询所有商品
    List<Goods> findAll();
    //根据id查询商品
    Goods findById(int id);
    //查询首页数据
    List<Goods> toIndex(int tid);


    //后期补充
    //根据类型查询商品
    PageBean<Goods> findByTid(int tid,PageBean<Goods> page);

    //根据商品名称模糊查询
    PageBean<Goods> findByGname(String gname,PageBean<Goods> page);
}
