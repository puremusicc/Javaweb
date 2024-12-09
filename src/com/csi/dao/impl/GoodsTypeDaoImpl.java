package com.csi.dao.impl;

import com.csi.dao.GoodsTypeDao;
import com.csi.pojo.GoodsType;
import com.csi.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsTypeDaoImpl implements GoodsTypeDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public int insertType(GoodsType type) {
        int row=0;
        conn=DBHelper.getConn();
        String sql="insert into goodsType values(null,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,type.getTname());
            ps.setInt(2,type.getState());
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public int deleteType(int tid) {
        return 0;
    }

    @Override
    public int updateType(GoodsType type) {
        int row=0;
        conn=DBHelper.getConn();
        String sql="update goodsType set tname=?,state=? where tid=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,type.getTname());
            ps.setInt(2,type.getState());
            ps.setInt(3,type.getTid());
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public List<GoodsType> selectAll() {
        List<GoodsType> list=new ArrayList<>();
        conn= DBHelper.getConn();
        //编写sql
        String sql="select * from goodsType";
        try {
            ps=conn.prepareStatement(sql);
            //执行并接收
            rs=ps.executeQuery();
            //处理数据
            while(rs.next()){
                //如果有数据，创建对象
                GoodsType type=new GoodsType(rs.getInt("tid"),
                        rs.getString("tname"),rs.getInt("state"));
                list.add(type);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return list;
    }

    @Override
    public GoodsType selectById(int id) {
        GoodsType type=null;
        //获取连接
        conn= DBHelper.getConn();
        //编写sql
        String sql="select * from goodsType where tid=?";
        try {
            ps=conn.prepareStatement(sql);
            //完善sql
            ps.setInt(1,id);
            //执行并接收
            rs=ps.executeQuery();
            //处理数据
            while(rs.next()){
                //如果有数据，创建对象
                type=new GoodsType(rs.getInt("tid"),rs.getString("tname"),rs.getInt("state"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return type;
    }
}
