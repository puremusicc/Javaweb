package com.csi.biz.impl;

import com.csi.biz.GoodsTypeBiz;
import com.csi.dao.GoodsTypeDao;
import com.csi.dao.impl.GoodsTypeDaoImpl;
import com.csi.pojo.GoodsType;

import java.util.List;

public class GoodsTypeBizImpl implements GoodsTypeBiz {
    private GoodsTypeDao tdao=new GoodsTypeDaoImpl();
    @Override
    public boolean addType(GoodsType type) {
        return tdao.insertType(type)>0;
    }

    @Override
    public boolean removeType(int tid) {
        //程序中不要轻易使用delete语句，通过改变数据中的state属性，实现伪删除
        GoodsType type=tdao.selectById(tid);
        type.setState(type.getState()==1? 0:1);
        return tdao.updateType(type)>0;
    }

    @Override
    public boolean modifyType(GoodsType type) {
        return tdao.updateType(type)>0;
    }

    @Override
    public List<GoodsType> findAll() {
        return tdao.selectAll();
    }

    @Override
    public GoodsType findById(int id) {
        return tdao.selectById(id);
    }
}
