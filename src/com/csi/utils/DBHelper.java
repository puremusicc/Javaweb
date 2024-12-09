package com.csi.utils;

import java.sql.*;

/**
 * 数据库工具类
 */
public class DBHelper {
    private static final String driverStr="com.mysql.jdbc.Driver";
    private static final String url="jdbc:mysql://localhost:3306/tsshoppingsystem";
    private static final String user="root";
    private static final String pwd="123456";
    //静态初始化块
    static{
        //加载驱动
        try {
            Class.forName(driverStr);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //获取连接
    public static Connection getConn(){
        Connection conn=null;
        //获取连接
        try {
            conn= DriverManager.getConnection(url,user,pwd);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }
    //关闭资源
    public static void closeAll(ResultSet rs, PreparedStatement ps,Connection conn){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(ps!=null){
            try {
                ps.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(conn!=null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
