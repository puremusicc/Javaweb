package com.csi.dao.impl;

import com.csi.dao.CartDao;
import com.csi.pojo.Cart;
import com.csi.pojo.Goods;
import com.csi.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CartDaoImpl implements CartDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public int insert(Cart c) {
        int row =0;
        conn= DBHelper.getConn();
        String sql="insert into cart VALUES(null,?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,c.getUser().getUserId());
            ps.setInt(2,c.getGoods().getGid());
            ps.setInt(3,c.getNumber());
            ps.setDouble(4,c.getSubtotal());
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public int delete(int cid) {
        int row=0;
        conn=DBHelper.getConn();
        String sql="delete from cart where cid="+cid;
        try {
            ps=conn.prepareStatement(sql);
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public int updateNum(int cid, int num) {
        int row=0;
        conn=DBHelper.getConn();
        String sql="update cart set number=? where cid=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,num);
            ps.setInt(2,cid);
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public List<Cart> selectByUid(int uid) {
        List<Cart> list=new ArrayList<>();
        conn=DBHelper.getConn();
        String sql="select * from cart where userid="+uid;
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Cart c=new Cart();
                c.setCid(rs.getInt("cid"));
                c.setUser(new UsersDaoImpl().selectById(rs.getInt("userId")));
                c.setGoods(new GoodsDaoImpl().selectById(rs.getInt("gid")));
                c.setNumber(rs.getInt("number"));
                list.add(c);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return list;
    }

    @Override
    public Cart selectById(int id) {
        Cart c=null;
        conn=DBHelper.getConn();
        String sql="select * from cart where cid="+id;
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                c=new Cart();
                c.setCid(rs.getInt("cid"));
                c.setUser(new UsersDaoImpl().selectById(rs.getInt("userId")));
                c.setGoods(new GoodsDaoImpl().selectById(rs.getInt("gid")));
                c.setNumber(rs.getInt("number"));

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return c;
    }
}
