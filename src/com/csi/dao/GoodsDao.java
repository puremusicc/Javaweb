package com.csi.dao;

import com.csi.pojo.Goods;
import com.csi.utils.PageBean;

import java.util.List;

public interface GoodsDao {
    //添加
    int insertGoods(Goods goods);
    //删除商品
    int deleteGoods(int id);
    //修改商品
    int updateGoods(Goods goods);
    //查询所有商品
    List<Goods> selectAll();
    //根据id查询商品
    Goods selectById(int id);
    //查询首页数据
    List<Goods> selectTop8(int tid);

    //查询总数量
    int selectTotal(String sql);
    //后期补充
    //根据类型查询商品
    PageBean<Goods> selectByTid(int tid,PageBean<Goods> page);

    //根据商品名称模糊查询
    PageBean<Goods> selectByGname(String gname,PageBean<Goods> page);
}
