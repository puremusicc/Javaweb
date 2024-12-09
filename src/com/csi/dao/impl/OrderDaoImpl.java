package com.csi.dao.impl;

import com.csi.dao.OrderDao;
import com.csi.pojo.Orders;
import com.csi.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public int insertOrder(Orders order) {
        int row=0;
        conn= DBHelper.getConn();
        String sql="insert into orders values(?,?,?,?,?,'','','',?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,order.getOid());
            ps.setInt(2,order.getUsers().getUserId());
            ps.setInt(3,order.getGoods().getGid());
            ps.setDouble(4,order.getGoods().getPrice());
            ps.setInt(5,order.getNumber());
            ps.setString(6,order.getCreateTime());
            ps.setDouble(7,order.getTotal());
            ps.setInt(8,order.getState());
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public int  updateOrder(Orders order) {
        int row=0;
        conn= DBHelper.getConn();
        String sql="update Orders set ConsigneeName=?,userid=?,gid=?,price=?," +
                "number=?,createTime=?,total=?,state=?,ConsigneeAddress=?,ConsigneePhone=? where oid=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,order.getConsigneeName());
            ps.setInt(2,order.getUsers().getUserId());
            ps.setInt(3,order.getGoods().getGid());
            ps.setDouble(4,order.getGoods().getPrice());
            ps.setInt(5,order.getNumber());
            ps.setString(6,order.getCreateTime());
            ps.setDouble(7,order.getTotal());
            ps.setInt(8,order.getState());
            ps.setString(9,order.getConsigneeAddress());
            ps.setString(10,order.getConsigneePhone());
            ps.setString(11,order.getOid());
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public Orders selectByOid(String oid) {
        Orders o=null;
        conn=DBHelper.getConn();
        String sql="select * from Orders where oid='"+oid+"'";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                o=new Orders();
                o.setOid(oid);
                o.setUsers(new UsersDaoImpl().selectById(rs.getInt("userid")));
                o.setGoods(new GoodsDaoImpl().selectById(rs.getInt("gid")));
                o.setPrice(rs.getDouble("price"));
                o.setNumber(rs.getInt("number"));
                o.setConsigneeName(rs.getString("ConsigneeName"));
                o.setConsigneeAddress(rs.getString("ConsigneeAddress"));
                o.setConsigneePhone(rs.getString("ConsigneePhone"));
                o.setCreateTime(rs.getString("createTime"));
                o.setState(rs.getInt("state"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return o;
    }

    @Override
    public List<Orders> selectAll() {
        List<Orders> list=new ArrayList<>();
        conn=DBHelper.getConn();
        String sql="select * from Orders order by createTime desc";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Orders o=new Orders();
                o.setOid(rs.getString("oid"));
                o.setUsers(new UsersDaoImpl().selectById(rs.getInt("userid")));
                o.setGoods(new GoodsDaoImpl().selectById(rs.getInt("gid")));
                o.setPrice(rs.getDouble("price"));
                o.setNumber(rs.getInt("number"));
                o.setConsigneeName(rs.getString("ConsigneeName"));
                o.setConsigneeAddress(rs.getString("ConsigneeAddress"));
                o.setConsigneePhone(rs.getString("ConsigneePhone"));
                o.setCreateTime(rs.getString("createTime"));
                o.setState(rs.getInt("state"));
                list.add(o);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return list;
    }

    @Override
    public List<Orders> selectByUid(int uid) {
        List<Orders> list=new ArrayList<>();
        conn=DBHelper.getConn();
        String sql="select * from Orders  where userid="+uid+" and state != 0 order by createTime desc";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Orders o=new Orders();
                o.setOid(rs.getString("oid"));
                o.setUsers(new UsersDaoImpl().selectById(rs.getInt("userid")));
                o.setGoods(new GoodsDaoImpl().selectById(rs.getInt("gid")));
                o.setPrice(rs.getDouble("price"));
                o.setNumber(rs.getInt("number"));
                o.setConsigneeName(rs.getString("ConsigneeName"));
                o.setConsigneeAddress(rs.getString("ConsigneeAddress"));
                o.setConsigneePhone(rs.getString("ConsigneePhone"));
                o.setCreateTime(rs.getString("createTime"));
                o.setState(rs.getInt("state"));
                list.add(o);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return list;
    }

    @Override
    public List<Orders> select(String oid, int state) {
        List<Orders> list=new ArrayList<>();
        conn=DBHelper.getConn();
        String sql="select * from Orders where 1=1 ";
        if(oid!=null&&!oid.equals("")){
            sql+=" and oid='"+oid+"'";
        }
        if(state!=9){
            sql+=" and state="+state;
        }
        sql+=" order by createTime desc";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Orders o=new Orders();
                o.setOid(rs.getString("oid"));
                o.setUsers(new UsersDaoImpl().selectById(rs.getInt("userid")));
                o.setGoods(new GoodsDaoImpl().selectById(rs.getInt("gid")));
                o.setPrice(rs.getDouble("price"));
                o.setNumber(rs.getInt("number"));
                o.setConsigneeName(rs.getString("ConsigneeName"));
                o.setConsigneeAddress(rs.getString("ConsigneeAddress"));
                o.setConsigneePhone(rs.getString("ConsigneePhone"));
                o.setCreateTime(rs.getString("createTime"));
                o.setState(rs.getInt("state"));
                list.add(o);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return list;
    }


    @Override
    public List<Orders> selectByUidAndState(int uid, int state) {
        return null;
    }
}
