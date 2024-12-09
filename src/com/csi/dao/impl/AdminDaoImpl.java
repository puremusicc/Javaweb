package com.csi.dao.impl;

import com.csi.dao.AdminDao;
import com.csi.pojo.Admin;
import com.csi.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public Admin selectByAnameAndPwd(String aname, String pwd) {
        Admin a=null;
        conn= DBHelper.getConn();
        String sql="select * from admin where aname=? and pwd=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,aname);
            ps.setString(2,pwd);
            rs=ps.executeQuery();
            while(rs.next()){
                a=new Admin();
                a.setAid(rs.getInt("aid"));
                a.setAname(rs.getString("aname"));
                a.setPwd(rs.getString("pwd"));
                a.setLevel(rs.getInt("level"));
                a.setState(rs.getInt("state"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return a;
    }

    @Override
    public int insert(Admin admin) {
        int row=0;
        conn=DBHelper.getConn();
        String sql="insert into admin values(null,?,?,?,?)";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,admin.getAname());
            ps.setString(2,admin.getPwd());
            ps.setInt(3,admin.getLevel());
            ps.setInt(4,admin.getState());
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public int delete(int aid) {
        int row=0;
        conn=DBHelper.getConn();
        String sql="delete from admin where aid="+aid;
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
    public int update(Admin admin) {
        int row=0;
        conn=DBHelper.getConn();
        String sql="update admin set state=?,pwd=? where aid=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setInt(1,admin.getState());
            ps.setString(2,admin.getPwd());
            ps.setInt(3,admin.getAid());
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public Admin selectByAid(int aid) {
        Admin a=null;
        conn= DBHelper.getConn();
        String sql="select * from admin where aid="+aid;
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                a=new Admin();
                a.setAid(rs.getInt("aid"));
                a.setAname(rs.getString("aname"));
                a.setPwd(rs.getString("pwd"));
                a.setLevel(rs.getInt("level"));
                a.setState(rs.getInt("state"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return a;
    }

    @Override
    public List<Admin> selectAll() {
        List<Admin> list=new ArrayList<>();
        conn=DBHelper.getConn();
        String sql="select * from admin";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Admin a=new Admin();
                a.setAid(rs.getInt("aid"));
                a.setAname(rs.getString("aname"));
                a.setPwd(rs.getString("pwd"));
                a.setLevel(rs.getInt("level"));
                a.setState(rs.getInt("state"));
                list.add(a);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return list;
    }
}
