package com.csi.biz;

import com.csi.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeBiz {
    //添加
    boolean addType(GoodsType type);
    //删除
    boolean removeType(int tid);
    //修改
    boolean modifyType(GoodsType type);
    //查询所有
    List<GoodsType> findAll();
    //根据id查询
    GoodsType findById(int id);
}
