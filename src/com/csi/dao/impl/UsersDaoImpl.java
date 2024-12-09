package com.csi.dao.impl;

import com.csi.dao.UsersDao;
import com.csi.pojo.Users;
import com.csi.utils.DBHelper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDaoImpl implements UsersDao {
    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;
    @Override
    public int insert(Users users) {
        int row=0;
        //打开连接
        conn= DBHelper.getConn();
        //编写sql
        String sql="insert into users values(null,?,?,?,?,?,1)";

        try {
            //获取ps对象
            ps=conn.prepareStatement(sql);
            //完善sql
            ps.setString(1,users.getLoginName());
            ps.setString(2,users.getPassword());
            ps.setString(3,users.getNickName());
            ps.setString(4,users.getSex());
            ps.setString(5,users.getPhone());
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public Users selectByLoginNameAndPwd(String loginName, String pwd) {
        Users users=null;
        //获取连接
        conn=DBHelper.getConn();
        //sql
        String sql="select * from users where loginName=? and password=?";
        //ps
        try {
            ps=conn.prepareStatement(sql);
            //完善
            ps.setString(1,loginName);
            ps.setString(2,pwd);
            //执行并接收
            rs=ps.executeQuery();
            //处理
            while(rs.next()){
                users=new Users();
                users.setUserId(rs.getInt("userid"));
                users.setLoginName(rs.getString("loginName"));
                users.setPassword(rs.getString("password"));
                users.setNickName(rs.getString("nickName"));
                users.setPhone(rs.getString("phone"));
                users.setSex(rs.getString("sex"));
                users.setState(rs.getInt("state"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }

        return users;
    }

    @Override
    public int update(Users users) {
        int row=0;
        conn=DBHelper.getConn();
        String sql="update users set password=?,nickName=?,sex=?,phone=?,state=? where userid=?";
        try {
            ps=conn.prepareStatement(sql);
            ps.setString(1,users.getPassword());
            ps.setString(2,users.getNickName());
            ps.setString(3,users.getSex());
            ps.setString(4,users.getPhone());
            ps.setInt(5,users.getState());
            ps.setInt(6,users.getUserId());
            row=ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(null,ps,conn);
        }
        return row;
    }

    @Override
    public Users selectById(int userId) {
        Users u=null;
        conn=DBHelper.getConn();
        String sql="SELECT * FROM users where userId="+userId;
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while (rs.next()){
                u=new Users();
                u.setUserId(rs.getInt("userId"));
                u.setLoginName(rs.getString("loginName"));
                u.setNickName(rs.getString("nickName"));
                u.setSex(rs.getString("sex"));
                u.setPassword(rs.getString("password"));
                u.setPhone(rs.getString("phone"));
                u.setState(rs.getInt("state"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return u;
    }

    @Override
    public List<Users> selectAll() {
        List<Users> list=new ArrayList<>();
        conn=DBHelper.getConn();
        String sql="select * from users";
        try {
            ps=conn.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Users u=new Users();
                u.setUserId(rs.getInt("userId"));
                u.setLoginName(rs.getString("loginName"));
                u.setNickName(rs.getString("nickName"));
                u.setSex(rs.getString("sex"));
                u.setPassword(rs.getString("password"));
                u.setPhone(rs.getString("phone"));
                u.setState(rs.getInt("state"));
                list.add(u);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DBHelper.closeAll(rs,ps,conn);
        }
        return list;
    }

    @Override
    public List<Users> selectByLoginName(String loginName) {
        return null;
    }
}
