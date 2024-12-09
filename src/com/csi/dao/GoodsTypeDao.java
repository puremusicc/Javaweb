package com.csi.dao;

import com.csi.pojo.GoodsType;

import java.util.List;

public interface GoodsTypeDao {
    //添加
    int insertType(GoodsType type);
    //删除
    int deleteType(int tid);
    //修改
    int updateType(GoodsType type);
    //查询所有
    List<GoodsType> selectAll();
    //根据id查询
    GoodsType selectById(int id);
}
